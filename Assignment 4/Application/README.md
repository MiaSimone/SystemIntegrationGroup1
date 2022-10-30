# How to run

Please note that gRPC can't run because of h2 database connection with spring.

- Run the file "Assignment 4/Application/src/main/java/com/example/demo/rest/Application.java"
- Run the file "Assignment 4/Application/src/main/java/com/example/demo/grpc2/server/BuyBookServer.java"

The Application file has REST endpoints and BuyBookServer has gRPC. 

### REST:
You can add a new student, see students osv.

### gRPC:
You can check if a student has enough money to buy a specific book. 


### You are free to decide on
- <ins>The functional and non-functional requirements specification</ins>
<br/>Functional:
  - A student can buy books from the library related to their study programme
  - Recommend specific books depending on the study programme
  - Show availability of the books
  - Show book price
  - View how much money the student has before and after purchase
  
  Non-functional:
  - The system should be fast
  - The system should be a single page application
  - The system should be able to handle 500-3000 users
  - The system should be easy to navigate through for a user

- <ins>The architectural design of the application</ins>
  - 3 layer architecture
  - Microservice architecture - loosely coupled

- <ins>The choice of the types of the APIs, used to enable efficient communication between the services.</ins>
  - Public API’s for books and login (but if this should be real it should probably be a PArtner API because a student should be validated as a student and only access the library if the student goes to that specific school). 
  - We are gonna use REST API’s and gRPC API’s



