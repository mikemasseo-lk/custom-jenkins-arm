# custom-jenkins-arm

This is a test for me to build a working jenkins system to perform operations and testing locally on my Linux Virtual Machine running Ubuntu-ARM64 with Docker.
The container that gets built will have some plugins installed, the zscaler root ca, and some other packages.

# How to build:

## Clone this repository

    git clone git@github.com:mikemasseo-lk/custom-jenkins-arm.git

 cd into the folder custom-jenkins-arm

## Build the image

   

    cd custom-jenkins
    docker build-t customjenkins1 .

After the Image is built
## Create folder for persisting jenkins data
This folder will be used to store any data that may change for your jenkins instance

    mkdir ~/jenkins_home


## Start your custom Jenkins container
In the command line, start your container as follows:

    docker run -p 8080:8080 -p 50000:50000 -v ~/jenkins_home:/var/jenkins_home jenkins-custom1

This will start the container on your system and map port 8080 on your local host to port 8080 in the container, and local host port 50000 to port 50000 on the container. 

We are using “-v” to map the folder “jenkins_home” in your localhost home folder to the container’s directory /var/jenkins_home , which is used to store Jenkins data. This ensures any data changed will persist and not be deleted when you stop the container, things like plugins and job configurations will remain intact.


# Use Jenkins
Point a web browser on your local system to http://localhost:8080
Login with 

    user: admin 
    password: justmyadminpassword

