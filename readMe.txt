Instructions For Project Use:

Program Description:
On my side I created the program with Netbeans 12.5 with Java 8. I utilizes and MySQL database which was done with phpMyAdmin (you could use something else like MySQL Workbench, just adjust the connection details).

1. Download whole file from Github: https://github.com/ryanlanzstu/3rd-Year-Project
2. Notice Libraries folder as well as 'project (1).sql' files.
3. Install Netbeans & myPhpAdmin if needed and open project.
4. Add libraries as needed. (Netbeans: Tools -> Libraries -> New Library (Name Of Library) -> Add Jar Files -> OK & Close Window -> Right Click Libraries In Project Folder In Netbeans & 'Add Library'.
5. In Project go to source package and open 'databaseConnection.java' class. Amend the following to your own needs: 
	
	static final String DB_URL = "jdbc:mysql://localhost:3307/project";
    	static final String USER = "root";
    	static final String PASS = "";

6. Import Database Schema and execute.
7. With 'databaseConnection.java' fields updated run the class to initiate the connection.
8. Clean and Build project.
9. Run 'startMain.java' or execute as .jar file in 'dist' folder in Project.
