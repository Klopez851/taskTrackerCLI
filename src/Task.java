import java.time.LocalDate;
import java.util.HashMap;

public class Task{
    //instance variables
    public int id;
    public String description;
    public String status;
    public String createdAt;
    public String updatedAt;

    /// /////////////
    ///CONSTRUCTORS//
    /////////////////
    public Task(){}
    public Task(int id, String description){
        this.id = id;
        this.status = "todo";
        this.description = description;
        this.createdAt = String.valueOf(LocalDate.now());
        this.updatedAt= String.valueOf(LocalDate.now());
    }

    ///////////
    //SETTERS//
    ///////////
    void setStatus(String status){
        this.status = status;
    }
    public void setDescription(String description) {
        this.description = description;
        this.updatedAt = String.valueOf(LocalDate.now());
    }
}
