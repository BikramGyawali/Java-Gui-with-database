
# 📌 Java GUI with MySQL Integration (VS Code)

This project demonstrates how to build a simple Java Swing-based registration form and connect it to a MySQL database using JDBC — all set up and executed in Visual Studio Code. A great starting point for understanding database operations like insertions using Java GUI.



## Installation





---

## ✅ Steps to Connect MySQL with Java in VS Code

### 1️⃣ Install MySQL JDBC Driver
- Download the latest `mysql-connector-java-x.x.xx.jar` from the official MySQL site.
- Place the `.jar` file inside your project folder.

### 2️⃣ Add the JDBC Driver to Classpath
- In VS Code, go to your project settings or configure the `.classpath` file (if using).
- Or, if running from terminal, compile & run like this:
  ```bash
  javac -cp .;mysql-connector-java-x.x.xx.jar YourFile.java
  java -cp .;mysql-connector-java-x.x.xx.jar YourFile
  ```

### 3️⃣ Setup MySQL Database
- Create a database (e.g., `javamark`)
- Create a table (e.g., `register`) with appropriate fields:
  ```sql
  CREATE TABLE register (
    id INT AUTO_INCREMENT PRIMARY KEY,
    UserName VARCHAR(255),
    pass VARCHAR(255)
  );
  ```

### 4️⃣ Write Java Code
- Use `DriverManager.getConnection()` to connect:
  ```java
  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javamark", "root", "");
  ```

### 5️⃣ Execute SQL Queries
- Use `Statement` to insert or retrieve data:
  ```java
  String query = "INSERT INTO register(UserName, pass) VALUES ('username', 'password')";
  st.execute(query);
  ```

### 6️⃣ Run and Test
- Compile and run your Java program from VS Code.
- Check your MySQL database to confirm the data was inserted.

---




![Logo](https://i.imghippo.com/files/YZBq8302lFo.jpg)