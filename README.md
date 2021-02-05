# Stone-Challenge
Challenge - Shopping list application

## Tecnologies

- [Spring Boot](https://spring.io/projects/spring-boot) - Development tool for Java language.
- [Swagger](https://swagger.io/) - Essential in an interface description language to describe RESTful APIs expressed using JSON.

## To compile the project, it is necessary to have installed:

- [Maven](https://maven.apache.org/) - Build automation tool used primarily in Java projects.

## Installation

- Clone the project- git@github.com:paluan-batista/Stone-Challenge.git
- Access the project root through a terminal, and download the dependencies with the following command: `$mvn clean package`.

## Features

* Calculate the sum of the values, that is, multiply the price of each item by its quantity and add up all the items.
* Divide the amount evenly between the number of emails.
* Return a map / dictionary where the key will be the email and the amount will be how much he must pay on that account.

## How to test the application?

`Well, there are two ways to test this app. I will exemplify.`

* First way: start the application and test via Insomnia or Postman.
  - Import the application into a development environment (IDE) of your choice (SpringTool Suite, Intelliji).
  - To get started, access the package `com.stone.challenge` and open `StoneChallengeApplication.java` class.
  - Execute main method : run as -> Spring Boot App
  - Now, access this Insomnia or Postman for test.
  
  
  
  
* Testing find all return

![alt text](https://github.com/paluan-batista/Stone-Challenge/blob/master/screenshots/findAll.png)

  
* Testing find by ID return 

![alt text](https://github.com/paluan-batista/Stone-Challenge/blob/master/screenshots/findById.png)

* Testing find by name (email) return

![alt text](https://github.com/paluan-batista/Stone-Challenge/blob/master/screenshots/findByName(email).png)

* Testing get balance payable per person return

![alt text](https://github.com/paluan-batista/Stone-Challenge/blob/master/screenshots/getBalancePayablePerPerson.png)


* Second way: Testing application with heroku server.
  - This application was deployed to the Heroku server.
  - Note: The first request may take a while as Heroku needs to upload the application.
  - To test, just use the same endpoints used in Insomnia / Postman.
  
  * Examples:
    - [Find All](https://stone-challenge-app.herokuapp.com/api/all)
    - [Find by ID](https://stone-challenge-app.herokuapp.com/api/id/1)
    - [Find by Name (email)](https://stone-challenge-app.herokuapp.com/api/email/lenildson_quebraosso@muaythai.com)
    - [Get balance payable per person](https://stone-challenge-app.herokuapp.com/api/amount/payable/email/lenildson_quebraosso@muaythai.com)
  
