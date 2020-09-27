node {
	def allJob = env.JOB_NAME.tokenize('/') as String[]
	def projectName = allJob[0]
	def projectDir = projectName+(new Date()).format('/yyyyMMddHHmm')
    def mvnHome
    stage('Checkout code') { // for display purposes
        // Get some code from a GitHub repository
		//CHANGE THE REPOSITORY PATH
        //git 'https://github.com/vardansavarde/SimpleJavaWebApp.git'
		//USE FOLLOWING IF YOUR REPOSITORY REQUIRES AUTHENTICATION
		//YOU WILL HAVE TO CONFIGURE USERNAME/PASSWORD CREDENTIALS
		//IN 'MANAGE CREDENTIALS' SECTION OF JENKINS
		git credentialsId: 'vardangit', poll: false, url: 'https://github.com/vardansavarde/SimpleJavaWebApp.git'
        // Get the Maven tool.
		//THE MAVEN TOOL MUST BE CONFIGURED IN SYSTEM TOOLS CONFIGURATION
		//OF JENKINS
        mvnHome = tool 'Maven 3.3.3'
    }
    stage('Build') {
        // Run the maven build
        withEnv(["MVN_HOME=$mvnHome"]) {
            if (isUnix()) {
                sh '"$MVN_HOME/bin/mvn" -Dmaven.test.failure.ignore clean package'
            } else {
                bat(/"%MVN_HOME%\bin\mvn" -Dmaven.test.failure.ignore clean package/)
            }
        }
    }
    stage('Archive Results') {
        junit allowEmptyResults: true,testResults: '**/target/surefire-reports/TEST-*.xml'
		//CHANGE THE ARCHIVE EXTENSION IF REQUIRED
        archiveArtifacts 'target/*.war'
    }
}