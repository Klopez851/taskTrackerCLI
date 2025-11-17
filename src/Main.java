import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import tools.jackson.databind.ObjectMapper;

public class Main {
    public static void writeToJson(Task task, ObjectMapper mapper){
        File file = new File("src/tasks.json");
        try{
            FileWriter writer = new FileWriter(file, true);
            String jsonString = mapper.writeValueAsString(task);
            writer.write(jsonString);
            writer.write("\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void writeToJson(ObjectMapper mapper, ArrayList tasklist){
        File file = new File("src/tasks.json");
        try {
            //clear file
            FileWriter fileClearer =  new FileWriter(file);
            fileClearer.write("");
            fileClearer.close();

            //begin writing process
            FileWriter writer = new FileWriter(file, true);
            for(Object task: tasklist){
                String jsonString = mapper.writeValueAsString(task);
                writer.write(jsonString);
                writer.write("\n");
            }
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Task> loadData(ObjectMapper mapper){
        File file = new File("src/tasks.json");
        ArrayList<Task> taskList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String jsonString = scanner.nextLine();
                Task task = mapper.readValue(jsonString, Task.class);
                taskList.add(task);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return taskList;
    }

    public static void main(String[] args){
        //Check if input is valid
        if(args.length<1){
            System.out.print("No argumets given");
        }
        //load all existing tasks
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Task> taskList = loadData(mapper);

        switch(args[0]){
            case "add":
                if(taskList.size()>=1){
                    Task task = new Task(taskList.getLast().id+1, args[1]);
                    System.out.println("Saving task...");
                    writeToJson(task, mapper);
                    System.out.printf("Task Saved (ID: %d)",task.id);
                }else{
                    Task task = new Task(0,args[1]);
                    System.out.println("Saving task...");
                    writeToJson(task, mapper);
                    System.out.printf("Task Saved (ID: %d)",task.id);
                    System.out.println("refreshing task list...");
                    taskList = loadData(mapper);
                    System.out.println("Task list refreshed!");
                }
                break;
            case "delete":
                //Because this is a small program, ill use a O(n) algorithm, else i would have opted for binary search
                for(Task task: taskList){
                    if(task.id == Integer.valueOf(args[1])){
                        taskList.remove(task);
                        System.out.println("Task deleted.");
                        break;
                    }
                }
                writeToJson(mapper, taskList);
                System.out.println("task deleted!");
                System.out.println("refreshing task list...");
                taskList = loadData(mapper);
                System.out.println("Task list refreshed!");
                break;
            case "update":
                for(Task task: taskList){
                    if(task.id == Integer.valueOf(args[1])){
                        task.description = args[2];
                        System.out.println("Task Updated!");
                        break;
                    }
                }
                writeToJson(mapper, taskList);
                System.out.println("refreshing task list...");
                taskList = loadData(mapper);
                System.out.println("Task list refreshed!");
                break;
            case "mark-in-progress":
                for(Task task: taskList){
                    if(task.id == Integer.valueOf(args[1])){
                        task.status = "in-progress";
                        System.out.println("Task Updated!");
                        break;
                    }
                }
                writeToJson(mapper, taskList);
                System.out.println("Changes will reflect next time u open the app!");
                break;
            case "mark-done":
                for(Task task: taskList){
                    if(task.id == Integer.valueOf(args[1])){
                        task.status = "done";
                        System.out.println("Task Updated!");
                        break;
                    }
                }
                writeToJson(mapper, taskList);
                System.out.println("Changes will reflect next time u open the app!");
                break;
            case "list":
                if(args.length >1) {
                    if (args[1].equals("done")) {
                        for (Task task : taskList) {
                            if (task.status.equals("done")) {
                                System.out.printf("ID: %d%nDESCRIPTION: %s%nSTATUS: %s%nCREATED AT: %s%nLAST UPDATED: %s%n%n",
                                        task.id, task.description, task.status, task.createdAt, task.updatedAt);
                            }
                        }
                    } else if (args[1].equals("todo")) {
                        for (Task task : taskList) {
                            if (task.status.equals("todo")) {
                                System.out.printf("ID: %d%nDESCRIPTION: %s%nSTATUS: %s%nCREATED AT: %s%nLAST UPDATED: %s%n%n",
                                        task.id, task.description, task.status, task.createdAt, task.updatedAt);
                            }
                        }
                    } else if (args[1].equals("in-progress")) {
                        for (Task task : taskList) {
                            if (task.status.equals("in-progress")) {
                                System.out.printf("ID: %d%nDESCRIPTION: %s%nSTATUS: %s%nCREATED AT: %s%nLAST UPDATED: %s%n%n",
                                        task.id, task.description, task.status, task.createdAt, task.updatedAt);
                            }
                        }
                    }
                }
                else{
                    for(Task task: taskList){
                        System.out.printf("ID: %d%nDESCRIPTION: %s%nSTATUS: %s%nCREATED AT: %s%nLAST UPDATED: %s%n%n",
                                task.id, task.description, task.status, task.createdAt, task.updatedAt);
                    }
                }
        }


    }

}