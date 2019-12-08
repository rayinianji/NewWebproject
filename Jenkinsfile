node('master')
{
   def Mvnhome
   Mvnhome= tool 'maven3.6'
   def server = '52.15.141.185'
   stage ('SCM Checking out')
   {
      print "Checking out in progress...."
      git 'https://github.com/rayinianji/NewWebproject.git'
   }
   
   stage ('Cleaning')
   {
       print "Cleaning started..."
       //def Mvnhome= tool name: 'maven3.6', type: 'maven'
       sh "${Mvnhome}/bin/mvn clean"
   } 
   stage ('Comipling')
   {
       print "Cleaning started..."
       //def Mvnhome= tool name: 'maven3.6', type: 'maven'
       sh "${Mvnhome}/bin/mvn compile"
   } 
   stage ('Installation')
   {
       print "Cleaning started..."
       //def Mvnhome= tool name: 'maven3.6', type: 'maven'
       sh "${Mvnhome}/bin/mvn install"
   } 

   stage ('Build image')
   {

        print " Builing image started ... "
        sh 'docker build -t anjidockerid/my_app:1.0 .'
   }

   stage ('Push Image to Docker Hub')
   {
      print " Pushing images......"
      withCredentials([string(credentialsId: 'dockerhub_pwd', variable: 'docker_hubacc')]) {
         sh "docker login -u anjidockerid -p ${docker_hubacc}"
      }
      
      sh 'docker push anjidockerid/my_app:1.0'
   }
   
  /* stage ('Deplyoing to tomcat server..')
   {
       //sh "ssh -T 'ubuntu@${server}' /opt/"
       
       sshagent(['web_tom']) {
 
                    sh 'scp -o StrictHostKeyChecking=no target/*.war ubuntu@172.31.21.120:/usr/local/apache-tomcat9/webapps/'
 
             }*/
       
}
