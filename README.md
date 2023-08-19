Week 1 exercise notes:

-The idea with, and reasons for why to use, a ORM-mapper
It simplifies database "commands" and operations, and therefor makes it easier to insert and receive data from the database.
   
-The meaning of the terms JPA, Hibernate and Spring Data JPA and how they are connected
   JPA is an interface for java apps to interact with the database using different annotations. Examples: @Id, @Entity
   Hibernate is an implementation of the JPA interface. It helps mapping java data types to SQL data types that of course can be used with your database
   Spring Data JPA uses JPA, Hibernate and the Spring Framework in combination to allow repositories, entities and controller to work together. 
   These are used to create SQL queries for the repositories as well.
   
-How to create simple Java entities and map them to a database via the Spring Data API
   By using the annotations @Entity on the class and using @Id to define the primary key for that class. With the entity annotation it creates a table with the same name as the class, as a "standard". 
   Other annotations can of course be used to rename it. 
   
-How to control the mapping between individual fields in an Entity class and their matching columns in the database
   @Columns on each variable that needs an individual column in the database and @CreationTimeStamp/@UpdateTimeStamp.
   The different annotations on each variable allows the API to correlate a variable to a column.
   
-How to auto generate IDs, and how to ensure we are using  a specific database's preferred way of doing it (Auto Increment in our case for  MySQL)
   I used @GeneratedValue(strategy = GenerationType.SEQUENCE) and @Id in the Car class which creates a random id that is then given a column as primary key in the database
   
-How to use and define repositories and relevant query methods using Spring Data JPAs repository pattern
   I have created a repository for each entity and extended those repositories with the JpaRepository. When you extend it, you need to give the JpaRepository the Entity you will create objects out of, and the datatype of the primary key. 
   Example from my code: public interface CarRepository extends JpaRepository<Car, Long>{}
   The auto-incremented id of the class Car is a Long. After dependency injecting the "CarRepository" into my Controller i can now use the different methods from Spring       Data API to add these objects to my database


-How to write simple "integration" tests, using H2 as a mock-database instead of MySQL & how you did that in your code
   In the file "RepositoryTests" i have written a few tests for my repositories. It still seems to use mySQL as i could not figure out how to set up the mock H2 database yet.
  
-How to add (dev) connection details for you local MySQL database
   Spring.datasource variables are added to the "application.properties" file. After that you can edit the environment variables locally on your machine, so they match your connection credentials to your database. 
