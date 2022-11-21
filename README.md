
# About the project

An automation testing framework for TMDB APIs using RestAssured.
## Built With
Java

Maven

TestNG

RestAssured (Java Library)

## Documentation

[Requirements](https://drive.google.com/file/d/1kAWLISD6mtOEM6BNzXuq7frbym-2Df_B/view?usp=share_link)

[Test Scenarios](https://docs.google.com/spreadsheets/d/1UpN8XXuDIobgw9o0bAZu_seD8tl0Ty9Rlp5mZDKB778/edit?usp=share_link) 


## Project Structure

```
├───allure-report
│  
├───allure-results
├───src
│   ├───main
│   │   ├───java
│   │   │   └───com
│   │   │       └───tmdb
│   │   │           ├───constants
│   │   │           ├───payloads
│   │   │           ├───pojos
│   │   │           └───utils
│   │   └───resources
│   └───test
│       └───java
│           └───com
│               └───tmdb
│                   └───tests
├───Dockerfile
├───pom.xml
└───TestNG.xml
```

## 1. src/main/java:
This package has multiple classes to define endpoints , test data , payloads etc. The purpose is to isloate the test data with the actual tests.

### 1.1 com.tmdb.contants.endpoints
This class cotains all the endpoints to be used.

### 1.2 com.tmdb.payloads
This package as multiple classes (one for every API to be tested) and contains the actual payload to be sent with each test.

### 1.3 com.tmdb.pojos
This package contains all the pojo classes fro API request/response which helps is serializing and deserializing of the request/response JSON.

### 1.4 com.tmdb.utils
This package is for common utilities such as a class to maintain request-response specifications and to load the config.properties file.

## 2. src/test/java:
This package has classes which contains the actual test asserttions . There will be one class for each API to be tested.
## Getting Started

### Prerequisites
Java

Maven
### Installation
Clone the repo
```
https://github.com/deekochar92/TMDB_BYNDER.git
```


## Running Tests

```
mvn clean test
```


## Docker Setup

The tests can also be executed in a docker container without having to install all the dependencies.

### Installing Docker

Download and install docker engine from this url : https://docs.docker.com/engine/install/

### Getting Docker Image
To run tests, you can build your own docker image from Dockerfile or pull the image from docker hub.

Building your own Docker image:
```
docker build -t <image_name>:<tag_name>
```
Verify that the built image is available by running:
```
docker images 
```
To run tests, run the following command
```
docker run <imagename>:<tagname>
```
