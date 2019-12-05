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
}
