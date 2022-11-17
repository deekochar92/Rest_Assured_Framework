# TMDB_BYNDER

# TMDB API Tests

This project has a RestAssured based API testing framework. It uses :
1. RestAssured -API testing library
2. TestNG - Third-party free library for Running tests
3. Maven - To manage dependencies
3. Reporting - Extent Reports (library for interactive and detailed reports for tests).

This framework can be used for any Restful application to create API tests.

## Framework Details
The framework has 2 major components :
1. src/main/java
2. src/test/java

### 1. src/main/java:
This package has multiple classes to define endpoints , test data , payloads etc. The purpose is to isloate the test data with the actual tests.

#### 1.1 com.tmdb.contants.endpoints

This class cotains all the endpoints to be used.

#### 1.2 com.tmdb.payloads

This package as multiple classes (one for every API to be tested) and contains the actual payload to be sent with each test.

#### 1.3 com.tmdb.pojos

This package contains all the pojo classes fro API request/response which helps is serializing and deserializing of the request/response JSON.

#### 1.4 com.tmdb.utils

This package is for common utilities such as a class to maintain request-response specifications and to load the config.properties file.

### 2. src/test/java:
This package has classes which contains the actual test asserttions . There will be one class for each API to be tested.
## Pre-requisites

### Installing Docker
Download and install docker engine from this url : https://docs.docker.com/engine/install/

### Getting Docker Image
To run tests, you can build your own docker image from Dockerfile or pull the image from docker hub.

1. Building your own Docker image

```bash
docker build -t <image_name>:<tag_name> . 
```

2. Pull the image from Docker hub


```bash
docker pull deekochar/assignment:1
```

Once you build/pull the image , verify that you can see the image by running :

```bash
docker images
```
## Running Tests

To run tests, run the following command

For custom image
```bash
  docker run <imagename>:<tagname>
```

For image pulled from docker hub
```bash
  docker run assignment:1
```
