<h1>In this Project we are learing About MVC Architecture on Standalone console Application:</h1>

<h3> Create multiple package to manage your application in MVC Architecutre</h3>
<ol>
  <li><b>in.ineuron.controller:</b> The controller is responsible for handling user input, processing requests, and coordinating interactions between the model and the view in an application.</li>
  
  <li><b>in.ineuron.service:</b> "Service layer" is a software architectural component or design pattern that provides a set of services or functionalities to an application.</li>
  
  <li><b>in.ineuron.dao:</b> "DAO" stands for "Data Access Object." It is a design pattern that is used to abstract and encapsulate the interaction with a data source or database.</li>
  
  <li><b>in.ineuron.dto:</b> "DTO" stands for "Data Transfer Object." A DTO is a design pattern used to transfer data between different layers or components of an application.</li>
  
  <li><b>in.ineuron.util:</b> This package contains a collection of utility classes or functions that provide common, reusable functionality and tools that can be used across different parts of an application.</li>
  
  <li><b>in.ineuron.factory:</b> Provides an interface for creating objects but allows subclasses to alter the type of objects that will be created. It is one of the most commonly used design patterns in object-oriented programming. The Factory Design Pattern promotes loose coupling by abstracting the process of object creation and centralizing it in a dedicated factory class or method.</li>
  
  <li><b>in.ineuron.properties:</b> Typically refers to a package or module that deals with configuration or property files. It is used to read, write, and manage configuration settings, properties, or parameters for an application.</li>
  
  <li><b>in.ineuron.main:</b> This package or module may contain the main entry point of the application or serve as a starting point for the application's execution.</li>
</ol>

<h2>Database</h2>
<p>For our database operations, we are using MySQL and SQL query language.</p>
<ol>
  <li>
    <strong>Driver Loading:</strong>
    <p>We load the MySQL driver using the following code:</p>
    <pre>Class.forName("com.mysql.cj.jdbc.Driver"); // Load the driver</pre>
  </li>
  <li>
    <strong>PreparedStatement:</strong>
    <p>We utilize PreparedStatement to precompile SQL queries for improved efficiency.</p>
  </li>
  <li>
    <strong>External JARs:</strong>
    <p>We include the following external JAR libraries for our database operations:</p>
    <ul>
      <li>mysql-connector-j-8.0.33.jar: MySQL Connector/J library.</li>
      <li>HikariCP-3.4.5.jar: HikariCP connection pooling library.</li>
      <li>slf4j-api-2.0.1.jar: SLF4J (Simple Logging Facade for Java) API.</li>
      <li>slf4j-simple-2.0.1.jar: SLF4J simple implementation for logging.</li>
    </ul>
  </li>
  <li>
    <strong>Connection Establishment:</strong>
    <p>We establish a connection between MySQL and Java using the external JAR mysql-connector-j-8.0.33.jar.</p>
  </li>
  <li>
    <strong>Connection Pooling: HikariCP is a fast and lightweight JDBC connection pooling framework</strong>
    <p>For efficient connection pooling, we utilize the external JAR HikariCP-3.4.5.jar.</p>
  </li>
</ol>

<h2>HikariCP Connection Pooling Configuration</h2>

<p><strong>jdbcUrl:</strong></p>
<p><em>Description:</em> The `jdbcUrl` property specifies the JDBC URL that defines the location of the database. In this example, it points to a MySQL database named "gla."</p>
<p><em>Example:</em> <code>jdbc:mysql:///gla</code></p>

<p><strong>dataSource.user:</strong></p>
<p><em>Description:</em> The `dataSource.user` property specifies the username used to authenticate to the database. In this case, it is set to "root."</p>
<p><em>Example:</em> <code>dataSource.user=root</code></p>

<p><strong>dataSource.password:</strong></p>
<p><em>Description:</em> The `dataSource.password` property specifies the password used for database authentication. It is set to "root" in this configuration.</p>
<p><em>Example:</em> <code>dataSource.password=root</code></p>

<p><em>Note:</em> These properties are part of the HikariCP configuration and are used to establish a connection to the database efficiently. The `jdbcUrl` specifies the database location, and `dataSource.user` and `dataSource.password` provide the authentication credentials for accessing the database.</p>

<hr>
<h2>Student DAO Implementation</h2>

 <p>This README provides details about the implementation of the Student DAO (Data Access Object), which is responsible for interacting with the database to perform CRUD (Create, Read, Update, Delete) operations on student records.</p>

   <h3>1. Connection Setup</h3>
    <p>The DAO establishes a database connection using HikariCP, a lightweight and efficient connection pooling library. The connection configuration includes:</p>
    <li><strong>Username:</strong> The username used for database authentication (e.g., "root").</li>
        <li><strong>Password:</strong> The password used for database authentication (e.g., "root").</li>
    </ul>    
       <li><strong>Username:</strong> The username used for database authentication (e.g., "root").</li>
        <li><strong>Password:</strong> The password used for database authentication (e.g., "root").</li>
    </ul>   
    <h3>2. Save Student</h3>
    <p>The <code>save</code> method allows for the insertion of a new student record into the database. It precompiles an SQL insert query and sets the student's details (name, city, email, country) as parameters.</p>  
<h3>3. Find Student by ID</h3>
    <p>The <code>findById</code> method retrieves a student record from the database based on the provided student ID. It prepares a SQL select query and fetches the student's details into a Student DTO (Data Transfer Object).</p>
 <h3>4. Update Student</h3>
    <p>The <code>updateByStudent</code> method allows for the modification of an existing student record. It prepares an SQL update query and sets the new details (name, city, email, country) based on the provided student object and ID.</p>    
<h3>5. Delete Student by ID</h3>
    <p>The <code>deleteById</code> method removes a student record from the database using the student's ID. It first checks if the student exists and then performs a delete operation.</p>
<h3>6. Exception Handling</h3>
    <p>The DAO handles exceptions such as SQLException and IOException to ensure proper error management during database operations.</p>
   <h3>7. Usage</h3>
    <p>The Student DAO can be used in conjunction with other layers of your application, such as controllers and services, to interact with the database and manage student data efficiently.</p>
