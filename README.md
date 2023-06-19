# SoftwareMindApp

This is a simple web application for managing to-do tasks.

## Technologies Used

- Java
- Spring Boot
- Angular
- HTML
- CSS

## Backend

The backend of the application is developed using Java and Spring Boot. It follows a RESTful architecture and provides API endpoints for managing to-do tasks.

### Endpoints

- `GET /api/todos`: Get all to-do tasks.
- `GET /api/todos/{id}`: Get a specific to-do task by ID.
- `POST /api/todos`: Create a new to-do task.
the json file could be used with content like this as body

{
"title" : "testTitle",
"description" : "testDescription",
"completed":false
},]
- `PUT /api/todos/{id}`: Update an existing to-do task.
- `DELETE /api/todos/{id}`: Delete a to-do task.

### Model

The main model used in the application is the `ToDo` class, which represents a to-do task. It has the following properties:

- `id` (Long): The unique identifier of the task.
- `title` (String): The title or name of the task.
- `description` (String): The description or details of the task.
- `completed` (boolean): Indicates whether the task is completed or not.
- `createdDate` (LocalDate): The date when the task was created.

### Service

The `ToDoService` class is responsible for handling the business logic related to to-do tasks. It communicates with the `ToDoRepository` to perform CRUD operations on the tasks.

### Repository

The `ToDoRepository` interface extends the Spring Data JPA `JpaRepository` interface. It provides methods for interacting with the database and performing CRUD operations on the `ToDo` entities.

## Frontend

The frontend of the application is developed using Angular. It provides a user interface for viewing, creating, updating, and deleting to-do tasks.

### Components

- `TodoComponent`: The main component that displays the list of tasks and provides the functionality for creating, updating, and deleting tasks.

### HTML Template

The HTML template of the `TodoComponent` displays a table with the list of tasks. It provides input fields for creating new tasks and checkboxes for marking tasks as completed. Buttons are provided to delete tasks.

### CSS Styling

The CSS styling is applied to the HTML template to enhance the visual appearance of the application.

## Testing

The `ToDoServiceTest` class is a JUnit test class that tests the functionality of the `ToDoService` class. It includes test methods for creating a task with and without a title, and updating a task.

## How to Run

1. Clone the repository to your local machine.
2. Create database and set connection in application.properties
3. Navigate to the project directory.
4. Build and run the backend using Maven: `mvn spring-boot:run`.
5. Navigate to the `frontend/AngularApp` directory: `cd frontend/AngularApp`.
5. Install the dependencies: `npm install`.
6. Start the frontend server: `ng serve`.
7. Access the application in your browser at `http://localhost:4200`.

Note: Make sure you have Java, Maven, Node.js, and Angular CLI installed on your machine and your DB connected.

Feel free to explore and use this application to manage your to-do tasks!