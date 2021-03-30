# Screenspace

 Screenspace is a java based web application that acts as a central repository for the content being displayed on a digital screen. Once, the application is installed and connected over a network, you can then upload images to it via a built-in dashboard. These images will directly be displayed on your digital screen from our application using Raspberry Pi. This project was completed as part of a graduate level course taken at Carleton University. 

## How to run the application

1. In order to get this application up and running quickly, you will need to have `docker run-time` and `docker-compose` installed on your computer. 
2. On a local computer where you have a docker runtime and docker-compose installed, clone this repository and go to `Deployment` folder. 
3. Now, run the following docker commands one by one:<br />
   a) `docker-compose up`<br />
4. The application should be up and running on the following `URL: http://localhost:8090/Screenspace/`


 ## How to use Screenspace

1. On the welcome screen, fill up the details in the sign-up section to create a new user.
2. Once, you have registered successfully, you will be redirected to a welcome-dashboard. 
3. On the dashboard, upload some images which you would like to display on your digital screen. 
4. After successful upload, click on the Screenplay from sidebar panel to preview your digital signage content slideshow.  

 ## User Stories

- Multiple user can sign up and create their own digital screens. 
- Images are directly saved in the MYSQL database. which increases portability of the application. 
- User can order a Raspberry Pi directly from the website. 
- User can preview the live screenplay of their digital screen. 
- User can reset the dashboard in one click. 

 ## Features

 - Leverages Hibernate and MySQl for all website operations. Hence, increasing the portability of the application. 
 - Easy to understand code which is built following MVC design pattern.
 - Simple and straightforward User Interface. 
 - Can be hosted as a micro-service in a container. Making it easier to deploy the app over cloud. 

 ## Future features

 - Code refactoring (Minimizing the workload in controllers).
 - Implement support module. 
 - Write an automation script to view the dashboard on a screen via Raspberry Pi.

 ## Dependencies 

 - Docker
 - Docker Compose
 - MySQL
 - Bootstrap 4
 - JSTL 
 - Enterprise Java
 - JSP and Servlets

## What the app looks like

![screenshot1](https://raw.githubusercontent.com/Damans227/Screenspace/main/screenshots/screen1.png)
![screenshot2](https://raw.githubusercontent.com/Damans227/Screenspace/main/screenshots/screen2.png)
![screenshot3](https://raw.githubusercontent.com/Damans227/Screenspace/main/screenshots/screen3.gif)
