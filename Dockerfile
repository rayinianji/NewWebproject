FROM tomcat:jdk8-openjdk
MAINTAINER anjaneyulu195@gmail.com
COPY target/*.war /usr/local/apache-tomcat9/webapps/