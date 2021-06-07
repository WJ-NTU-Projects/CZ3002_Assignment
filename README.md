# CZ3002 Lab Assignment

Application is developed in [IntelliJ IDEA](https://www.jetbrains.com/idea).

Testing was done using the following setup:
* Web application running in [Tomcat on Docker](https://hub.docker.com/_/tomcat)
* [MySQL Community Server](https://dev.mysql.com/downloads/mysql) hosted locally on Mac OSX

**Take note that the database configuration may need to be changed if you are not using Docker.** 

## WAR Application Package

**[The WAR package has been moved here (if you don't want to self-build).](https://github.com/WJ-NTU-Projects/CZ3002_Assignment/releases/tag/0)**

## Setting up 

### Tomcat 

**If you are using IntelliJ IDEA and want an easy time:**

1. [Download and install Docker.](https://www.docker.com/why-docker)

2. [Follow this guide to run Tomcat on Docker in IDEA.](https://www.jetbrains.com/help/idea/deploying-a-web-app-into-an-app-server-container.html)

**Else (not tested, I gathered these from various sites):**

1. [Download and install Tomcat.](https://tomcat.apache.org/) The latest version should be fine.

2. Make sure Tomcat is not running (kill it).

3. Drop the [WAR application](https://github.com/WJ-NTU-Projects/CZ3002_Assignment/releases/tag/0) (or found in the 'target' folder if you self-build) in `[tomcat root folder]\webapps`. 

### MySQL

When installing, make sure you **DO NOT** choose **legacy mode** (MySQL connector 5.x and below), unless you plan to use a legacy connector.

## Accessing the site

If all goes well, the site should be accessible at `[IP_address]:[port]/[name of WAR application]`.

Assuming you are hosting on localhost, port 8080, and using `ase.war`: <http://127.0.0.1:8080/ase>

## Screenshots

### Index
![Index](https://github.com/WJ-NTU-Projects/CZ3002_Assignment/blob/master/screenshots/index.png)

### Login Fail
![Login Fail](https://github.com/WJ-NTU-Projects/CZ3002_Assignment/blob/master/screenshots/login_fail.png)

### Login Success
![Login Fail](https://github.com/WJ-NTU-Projects/CZ3002_Assignment/blob/master/screenshots/login_success.png)

## Known Issues

### Persistent error messages (due to caching)
Assume this flow: INDEX --> LOGIN_FAIL --> LOGIN_SUCCESS

Going back from LOGIN_SUCCESS to LOGIN_FAIL (browser back button) **will not reset** the error message displayed due to the initial unsuccessful login.

### History spam
One 'Login' button press = one browser history.

![History Spam](https://github.com/WJ-NTU-Projects/CZ3002_Assignment/blob/master/screenshots/history_spam.png)
