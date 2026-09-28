# Task Tracker (CLI)

Task Tracker is a command-line application for managing tasks through basic CRUD operations. Tasks are stored locally in a JSON file using the Jackson library.

The main purpose of this project is to get a better understanding of Jackson and how it works under the hood. Jackson is commonly used behind the scenes in Spring Boot applications for converting Java objects to and from JSON, so I wanted to work with it directly rather than only interacting with it through Spring Boot.

I'm also using this as a small project to practice file persistence, JSON serialization and deserialization, and building a command-line application in Java.

# Features

The application currently supports:

- Creating new tasks

- Updating existing tasks

- Deleting tasks

- Marking tasks as in progress

- Marking tasks as done

- Listing all tasks

- Filtering tasks by status

- Saving tasks locally to a JSON file

# Example Usage
```
# Adding a new task
add "Buy groceries"
# Output: Task Saved (ID: id)

# Updating and deleting tasks
update 1 "Buy groceries and cook dinner"
delete 1

# Marking tasks as in progress or done
mark-in-progress 1
mark-done 1

# Listing all tasks
list

# Listing tasks by status
list done
list todo
list in-progress
```

# How It Works

Tasks are stored locally in a tasks.json file. Jackson handles the conversion between the Java task objects and their JSON representation.

When tasks are saved, Jackson serializes the Java objects into JSON. When the application starts or needs to load the tasks, Jackson deserializes that JSON back into Java objects.

One of the main goals of this project is to understand this process more clearly. In a Spring Boot application, much of this JSON conversion happens automatically when working with REST controllers and request/response bodies. By working with Jackson directly here, I can see what is happening behind that abstraction.

# Built With

Java 17+ — application logic

Jackson — JSON serialization and deserialization

Maven — project and dependency management

# Getting Started
Prerequisites

- Java 17+

- Maven

- An IDE such as IntelliJ IDEA, Eclipse, or VS Code (optional)

# Running the Application

- Clone the repository:
```
git clone <repository_url>
cd taskTrackerCLI
```
if using an IDE: 
- Open the project in your IDE

- Run the main application from src/Main.java.
