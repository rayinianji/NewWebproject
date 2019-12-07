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

	}
    publishers{

    publishOverSsh{
        alwaysPublishFromMaster(boolean alwaysPublishFromMaster = true)
        failOnError(boolean failOnError = true)
        server(String '3.135.228.184')
        {
            credentials('Tomcat_dev')
            transferSet
            {
                sourceFiles('target/*.war')
                remoteDirectory('/opt/tomcat/apache-tomcat-8.5.45/webapps')
            }
        }


    }
    }
}
