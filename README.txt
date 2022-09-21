<================================= DOCUMENTATION ==========>

made by Pavel Sulga (21.09.2022)
email: pavelaizen@gmail.com
linkedin: https://www.linkedin.com/in/psulga/
goal: demonstrate technical skills and approach while completing assignment

<======== Set up ===========>
back-end part is listening to 8080 port
front-end part is listening to 3000 port

Back-end (developed in IntellijIDE): => run  from snapshot or from the IDE
Front-end (developed in WebStorm): => terminal => npm start

<========Technologies, libraries and frameworks used ===========>

Gradle
Spring Data JPA
Spring Data REST
Spring Web
Spring Boot
Hibernate
Mustache
Spring Security
H2 Embedded Database
Lombok
JUnit
Mockito
jQuery

ReactJS and its diff libs on a front-end part

<========== Front-End Part ==============>

https://github.com/snakeaiz/hansab-front

On a front-end part simple Bootstrap is implemented, added a UI and functionality for triggering Database data
Added "Add user" button functionality
Added "Delete user" button functionality
Added "Edit user" button functionality
Added sorting by Ascending/Descending based on User ID
Added searching by Firstname

!!! Sometimes buttons does not refresh the page and redirect automatically so have to F5 it manually after some action !!!

<========== REST APIs ==============>

host: localhost
port: 8080

by defaault some initial data is being pre-saved into H2 database

[POST] - /car/cars - Create a car manually using API by providing JSON thru @Requestbody param
[POST] - /user/users - Create a user manually using API by providing JSON thru @Requestbody param
[GET] - /user/users - Get all Users from the H2 Database
[GET] - /car/cars - Get all Cars from the Database
[GET] - /user/users/{id} - Get User from the Database by specifying User Id
[GET] - /car/cars/{id} - Get Car from the Database by specifying Car Id
[GET] - /user/users/{id}/cars - Get Cars from the Database by specifying User Id
[PUT] - /car/cars/{id} - updating Car by its ID
[PUT] - /user/users/{id} - updating User by its ID
[DELETE] - /user/users/{id} - deleting User by ID
[DELETE] - /car/cars/{id} - deleting Car by ID


<========== Searching, Filtering and Pagination =============>

/api/users?page=0 - Return first(0) page with a capacity of 10 objects
/api/users?find=Allik - Returns all users with name LIKE %Allik%
/api/users?sort=id&order=asc - Return first page of users, sorted by Id in the Ascending order
/api/users?find=Allik&sort=name&order=desc - Return first page users with names LIKE %Allik%, sorted by name in the descending order

/api/cars?page=0 - Return first(0) page with a capacity of 10 objects
/api/cars?find=Lambo - Returns all cars with make LIKE %Lambo%
/api/cars?sort=id&order=asc - Return first page of cars, sorted by Id in the Ascending order
/api/cars?find=337AAA - Return car with numberplate LIKE %337AAA%

Syntax:

page={variable}
size={variable}
findByNumberPlate={variable} - for Cars
findByName={variable} - for Users


<==================== H2 Database =======================================>

Data is being presented from static variables
Database is being initialized on the program start from schema.sql file

<============================== Unit Tests =============================>

Unit tests are covering entire service layer

<========================== Spring Security ============================>

username: user
password: password

By default its turned off by commeting the security part in a build.gradle file

<======================= THE END ========================================>
