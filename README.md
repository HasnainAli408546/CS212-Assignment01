# CS212-Assignment01
So this project works on a Library Management System in Java language.The application is designed to automate the process of managing books and users in a library. It allows users to add books and users to the system, borrow books, return books. The system also includes error handling mechanisms to manage exceptions during file operations and user inputs.

 Instructions for Setting Up and Running the Project Locally:
To set up and run the project locally, follow these steps:

Prerequisites:
Java Development Kit (JDK) installed on your machine.
An integrated development environment (IDE) such as VS CODE or NetBeans.
Steps:

Clone or download the project repository from GitHub.
Open the project in your preferred IDE.
Build the project to ensure all dependencies are resolved.
Run the Main.java file to start the application.
Follow the on-screen instructions to interact with the Library Management System.
c. Explanation of Key Features and Functionalities Implemented:

Add User: Users can be added to the system by providing their details such as ID, name, and contact information.
Add Book: Books can be added to the system by specifying their details including ID, title, author, and genre.
Borrow Book: Users can borrow books from the library by providing their ID and the ID of the book they wish to borrow. If the book is available, it will be loaned to the user.
Return Book: Users can return borrowed books by specifying their ID and the ID of the book they are returning. The book's availability status is updated accordingly.
Search Books by Title or Author: Users can search for books by their title or author. The system returns a list of books matching the search criteria.
Save/Load Library State: The application allows users to save the current state of the library to a file and load it back later. This feature ensures that data is persisted between sessions.
File and Error Handling: The system includes error handling mechanisms to manage exceptions that may occur during file operations (e.g., saving/loading library state) and user inputs (e.g., invalid data entered by the user). Error messages are displayed to guide users in resolving issues.
These features collectively provide a comprehensive solution for managing library resources efficiently while ensuring data integrity and user convenience.




