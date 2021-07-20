# schoolmanagement
Install docker on desktop

Steps to install mysql on docker
---------------------------------

1. create docker image using command below

    docker pull mysql

2. docker images
 
    ![image](https://user-images.githubusercontent.com/72868475/126320401-b8117700-97ef-453a-812c-d8527b34e7b0.png)

3. run docker image mysql already created.

    docker run --detach --name=myschool --env="MYSQL_ROOT_PASSWORD=password" --publish 6603:3306 mysql

    ![image](https://user-images.githubusercontent.com/72868475/126320991-9903f27d-f3bf-4e7c-a529-a346e577a2af.png)

4.  List all containers:

    docker container ls

   ![image](https://user-images.githubusercontent.com/72868475/126321086-ff2d4613-36cc-4f08-bd95-2ca6e6511e81.png)

5. Mysql is successfully configured to run on docker container myschool.

steps to configure project:
---------------------------

1. Ensure your mysql container is up: 

 docker container ls

  ![image](https://user-images.githubusercontent.com/72868475/126322154-19f30a61-fa5a-46d4-828e-f68f0ad9aff2.png)

2. create schema on your running mysql container myschool

3. convert your container terminal to mysql interactive terminal by below command

   docker exec -it myschool mysql -uroot -p

4. Please enter password prompted.

   ![image](https://user-images.githubusercontent.com/72868475/126324010-c6236127-210c-4726-b537-cc93b3a7a156.png)

5. Create schema by below command

    create schema myschool

   ![image](https://user-images.githubusercontent.com/72868475/126324149-4a60ac89-5030-4302-a1f9-152cde94a5b3.png)

6. update your application.properties of jdbc url in your project resources file 
                             
     jdbc:mysql://docker-mysql-containername:3306/schema-name

7.  In my case it is:

     spring.datasource.url=jdbc:mysql://myschool:3306/myschool

8. create a docker image of project

9. execute below maven goal to create docker image

    spring-boot:build-image -Dspring-boot.build-image.imageName=saikumar4231/smboot

   ![image](https://user-images.githubusercontent.com/72868475/126321892-86691978-01ea-457c-95c1-cb37c1b17680.png)

10. once created you can check your docker image created by command: docker images

   ![image](https://user-images.githubusercontent.com/72868475/126322046-114b17c1-0486-4cf5-bed3-8d4cba936c0c.png)

11. You need to link your project docker container with mysql and run project docker image.

    docker run -p 8080:8080 --link myschool:mysql -t saikumar4231/smboot

   ![image](https://user-images.githubusercontent.com/72868475/126322613-cb88cb44-c817-4711-99a4-740062689439.png)

12. You should have by now up and running you project docker running with mysql container.

    ![image](https://user-images.githubusercontent.com/72868475/126322899-18aa7350-c7d4-4161-a453-543d6c0ad1a7.png) 
