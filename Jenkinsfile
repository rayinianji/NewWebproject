node('master')
{
   stage ('SCM Checking out')
   {
      print "Checking out in progress...."
      git 'https://github.com/rayinianji/NewWebproject.git'
   }
   
   stage ('Building')
   {
       print "Building started..."
       def Mvnhome= tool name: 'maven3.6', type: 'maven'
       sh "${Mvnhome}/bin/mvn clean install"
   } 
   
   stage ('Deplyoing to tomcat server..')
   {
       sshagent(['Tomcat_dev']) {
 
                    sh 'scp -o StrictHostKeyChecking=no target/*.war ubuntu@172.31.44.227:/opt/tomcat/apache-tomcat-8.5.45/webapps'
 
             }
       
   }
}
