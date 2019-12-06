folder('Webprojects') {
    displayName('ABC WebProject')
    description('Folder for project ABC')
}

job('SampleWebapp') {
    scm {
        git {
		
            remote {
                url('https://github.com/rayinianji/NewWebproject.git')
				
                }
			branch('master')	
        }
    }
	
	steps
	{
		maven
		{
			goals('clean')
			goals('install')
		}
		
		sshagent(['Tomcat_dev']) {
 
                    sh 'scp -o StrictHostKeyChecking=no target/*.war ubuntu@172.31.44.227:/opt/tomcat/apache-tomcat-8.5.45/webapps'
 
             }
	
	}
}
