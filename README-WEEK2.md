- What are the benefits of using a RESTful API
RESTFUL API is easy to use and set up because it uses standard http methods. It is able to use notation languages like JSON, HTML and more which are very simple to understand both for the user and the program.

- What is JSON, and why does JSON fit so well with REST?
JSON (JavaScript Object Notation) fits well because REST uses these standard HTTP methods. Using JSON is very simple for the user, and is also very easy for the program to understand. These requests and responses using http requests can easily be set up the way the developer wants it to. 

- How you have designed simple CRUD endpoints using spring boot and DTOs to separate api from data  -> Focus on your use of DTO's
The RestController that has the CRUD endpoints, only communicate with the correlating service class. The controller receives the JSON body and places it in the format of a Request using @RequestBody
This is sent to the correlating serviceclass, which uses this information to whatever is needed, and can then return a Response to the RestController. 
Any work on the database is isolated to the service class, as it is the only class using the repositories. 

-  What is the advantage of using DTOs to separate api from data structure when designing rest endpoints
It allows you to choose exactly the information you want to send out, and the exact data the program will receive. 
It therefor increases security and performance, as you don't have any useless data sent back and forth.

- Explain shortly the concept mocking in relation to software testing
A method used to give the program some "fake" data to work with. Example found in testAddCar or testAddMember_UserDoesNotExist. A "fake" request is built and given to the methods.
The same is done in the @BeforeEach before every test. 

- How did you mock database access in your tests, using an in-memory database and/or mockito → Refer to your code
Using h2 which is an in-memory database, we added some test data for the memberService class to use.
In the test classes they are named m1, m2 and c1,c2. This mock database is created in the @BeforeEach of each test.

- Explain the concept Build Server and the role Github Actions play here
Github actions is used as a build server, which automates the build process of the project. The term building includes compiling and testing the code into something runnable by a computer.

- Explain maven, relevant parts in maven, and how maven is used in our CI setup. Explain where maven is used by your GitHub Actions Script(s)
Maven is used to build our project into a runnable jar file with the needed dependencies. Maven is used to build, as soon as we commit into the main branch on the Github project

- Understand and chose cloud service models (IaaS, PaaS, SaaS, DBaaS)for your projects -> Just explain what you have used for this handin
For managing application runtime and deployment of the project we've used the PaaS cloud service model by using Github and Azure in combination to deploy the project
DBaaS cloud service model has also been used for the Online SQL Database on Azure.
