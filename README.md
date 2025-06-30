# 🎓 University Management System – Java Swing + MySQL

A desktop application built using Java Swing and MySQL that helps manage a university's core administrative activities — including student and teacher records, exams, fees, and leave management.

This system provides a complete GUI-based interface with modules to:
- Add, view, and update student and teacher records
- Manage leave forms for both students and faculty
- Enter and view exam results
- Handle fee structures and payments
- Authenticate users through a login system
- Access built-in utilities like Notepad and Calculator directly from the dashboard

The application is designed using object-oriented principles and modular class structure. It connects to a MySQL database to persist all academic and administrative data.

Developed using:
- Java (JDK 17+)
- Java Swing (GUI)
- MySQL (with `.sql` script included)
- IntelliJ IDEA

To run the project:
1. Clone the repository
2. Import the MySQL `.sql` file into your database (e.g., using MySQL Workbench or command line)
3. Update database connection credentials in your Java code if needed
4. Open the project in IntelliJ IDEA
5. Run `Main_class.java` to launch the application interface

> Note: Ensure MySQL service is running before launching the app

```

src/
└── com/
└── ganesh/
└── university/
└── management/
├── AddStudent.java
├── AddTeacher.java
├── Login.java
├── StudentLeave.java
├── FeesStructure.java
├── Examination.java
├── Main_class.java
└── ... (15+ classes total)

Future enhancements planned:
- Add Spring Boot backend for REST API
- Create a React web frontend
- Add PDF export and reporting functionality

**Author**  
Ganesh Nalla  
[GitHub Profile](https://github.com/Ganesh460-hub)
```