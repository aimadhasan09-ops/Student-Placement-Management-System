# Student Placement Management System

A simple console-based Java project for managing student placement activities.

This project helps manage student records, company details, job opportunities, job applications, interview details, and placement results. It includes a basic admin login system and stores data temporarily while the application is running.

## Features

1. Admin Login
2. Register Student
3. View Student Details
4. Update Student Information
5. Register Company
6. View Company Details
7. Add Placement Drive
8. View Available Jobs
9. Apply for a Job
10. Manage Interview Details
11. Record Placement Result
12. Search Student Record
13. Generate Placement Report
14. Exit Application

## Admin Login

Use the following login details to access the system:

```text
Username: admin
Password: 1234
```

> These are fixed login details for this student project.

## Technologies Used

- Java
- Java Standard Library
- Object-Oriented Programming
- ArrayList
- Scanner
- Console Input and Output

## Project Structure

```text
StudentPlacementManagementSystem/
│
├── Admin.java
├── Student.java
├── Company.java
├── PlacementDrive.java
├── JobApplication.java
├── Interview.java
├── InputHelper.java
├── PlacementManager.java
├── Main.java
├── README.md
└── .gitignore
```

## How to Run

### 1. Clone the repository

```bash
git clone [https://github.com/aimadhasan09-ops/student-placement-management-system.git](https://github.com/your-username/student-placement-management-system.git)
```

### 2. Open the project folder

```bash
cd student-placement-management-system
```

### 3. Compile all Java files

```bash
javac *.java
```

If you are using Windows PowerShell and the above command does not work, use:

```powershell
javac Admin.java Student.java Company.java PlacementDrive.java JobApplication.java Interview.java InputHelper.java PlacementManager.java Main.java
```

### 4. Run the application

```bash
java Main
```

## Application Flow

Use the application in this order for proper testing:

1. Log in using the admin username and password.
2. Register one or more students.
3. Register one or more companies.
4. Add a placement drive for a registered company.
5. View available jobs.
6. Apply for a job using the student ID and placement drive ID.
7. Schedule an interview using the application ID.
8. Record the placement result.
9. Generate the placement report.

## Important Note

This project does not use a database.

The project uses `ArrayList` to store records while the program is running. When the application is closed, all student, company, job, application, and interview records are removed.

## Java Concepts Used

- Classes and Objects
- Constructors
- Encapsulation
- Getter and Setter Methods
- Methods
- ArrayList
- Loops
- Conditional Statements
- Switch Case
- Scanner Class
- Input Validation
- Object-Oriented Programming

## Future Improvements

- Add file handling to save records permanently
- Add MySQL database support
- Add separate student and admin login
- Add delete student and company features
- Add job application deadlines
- Add more detailed interview results
- Add a graphical user interface using Java Swing or JavaFX

## Author

**Aimad Hasan**

Student from Lucknow, Uttar Pradesh, India.

## License

This project is created for educational purposes.
