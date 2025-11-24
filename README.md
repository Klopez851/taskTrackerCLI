# Task Tracker (CLI)
A simple command-line interface application for managing tasks with basic CRUD operations. Uses JSON and Jackson to store and read tasks.

## Getting Started
### Prerequisites

- Java 17+  
- Maven or Gradle  
- IDE (IntelliJ IDEA, Eclipse, VS Code, etc.)

### Running the Application

1. Clone the repository:

```bash
git clone <repository_url>
cd taskTrackerCLI
```
2. Run directly from the IDE by running "src/Main.java"

## Example Usage
```
# Adding a new task
task-cli add "Buy groceries"
# Output: Task Saved (ID: id)

# Updating and deleting tasks
task-cli update 1 "Buy groceries and cook dinner"
task-cli delete 1

# Marking a task as in progress or done
task-cli mark-in-progress 1
task-cli mark-done 1

# Listing all tasks
task-cli list

# Listing tasks by status
task-cli list done
task-cli list todo
task-cli list in-progress
```

## Technologies
- Java 17+
- Jackson library
- Maven

## Notes
Tasks are saved locally in tasks.json

