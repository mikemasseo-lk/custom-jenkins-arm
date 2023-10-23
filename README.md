# custom-jenkins-arm

This is a test for me to build a working jenkins system to perform operations and testing locally.
It is a dockerfile geared for systems with arm64.
The container that gets built will have some plugins installed, the zscaler root ca, and some other packages.



How to build:

Clone this repository
cd into the folder custom-jenkins-arm

Build the image

 docker build -t custom-jenkins1 .


Create a folder locally that gets shared with the container
mkdir ~/jenkins_home

Start the Jenkins container
docker run -p 8080:8080 -p 50000:50000 -v ~/jenkins_home:/var/jenkins_home jenkins/jenkins

Here we are mapping port 8080 on your local host to port 8080 in the container, and local host port 50000 to port 50000 on the container. We are using “-v” to map the folder “jenkins_home” in your localhost home folder to the container’s directory /var/jenkins_home , which is used to store Jenkins data. This ensures any data changed will persist and not be deleted when you stop the container, things like plugins and job configurations will remain intact.
