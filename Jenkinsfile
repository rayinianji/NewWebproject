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

   /*stage ('Build image')
   {

        print " Builing image started ... "
        sh 'docker build -t '
   }*/
   
   stage ('Deplyoing to tomcat server..')
   {
       //sh "ssh -T 'ubuntu@${server}' /opt/"
       
       sshagent(['web_tom']) {
 
                    sh 'scp -o StrictHostKeyChecking=no target/*.war ubuntu@172.31.44.227:/opt/tomcat/apache-tomcat-8.5.45/webapps'
 
             }
       
   }
}
