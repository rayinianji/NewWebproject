FROM tomcat:jdk8-openjdk
MAINTAINER anjaneyulu195@gmail.com
ADD target/*.war /usr/local/apache-tomcat9/webapps/