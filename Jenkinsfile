node {
	def allJob = env.JOB_NAME.tokenize('/') as String[]
	def projectName = allJob[0]
	def projectDir = projectName+(new Date()).format('/yyyyMMddHHmm')
    def mvnHome
    stage('Checkout code') { // for display purposes
        // Get some code from a GitHub repository
		//CHANGE THE REPOSITORY PATH
        //git 'https://github.com/vardansavarde/spring-boot-rest-example.git'
		//USE FOLLOWING IF YOUR REPOSITORY REQUIRES AUTHENTICATION
		//YOU WILL HAVE TO CONFIGURE USERNAME/PASSWORD CREDENTIALS
		//IN 'MANAGE CREDENTIALS' SECTION OF JENKINS
		git credentialsId: 'vardangit', poll: false, url: 'https://github.com/vardansavarde/spring-boot-rest-example.git'
        // Get the Maven tool.
		//THE MAVEN TOOL MUST BE CONFIGURED IN SYSTEM TOOLS CONFIGURATION
		//OF JENKINS
        mvnHome = tool 'Maven 3.3.3'
    }
    stage('Build') {
        // Run the maven build
        withEnv(["MVN_HOME=$mvnHome"]) {
            if (isUnix()) {
                sh '"$MVN_HOME/bin/mvn" -Dmaven.test.failure.ignore -Djacoco.haltOnFailure=false clean verify package'
            } else {
                bat(/"%MVN_HOME%\bin\mvn" -Dmaven.test.failure.ignore -Djacoco.haltOnFailure=false clean verify package/)
            }
        }
    }
		stage('SonarQube analysis') {
	    def scannerHome = tool name: 'SonarScanner-PermNode', type: 'hudson.plugins.sonar.SonarRunnerInstallation';
	    withSonarQubeEnv(credentialsId: 'f76cad53-7e51-4403-b70f-3c3446d23a7b',installationName:'OnHost-SonarQubeServer') { // If you have configured more than one global server connection, you can specify its name
	      sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=spring-boot-app1 -Dsonar.java.source=1.8 -Dsonar.java.binaries=target/classes -Dsonar.coverage.jacoco.xmlReportPaths=target/site/**/*.xml -Dsonar.junit.reportPaths=target/surefire-reports"
	    }
	  }
}
// No need to occupy a node
stage("Quality Gate"){
  timeout(time: 1, unit: 'HOURS') { // Just in case something goes wrong, pipeline will be killed after a timeout
    def qg = waitForQualityGate() // Reuse taskId previously collected by withSonarQubeEnv
    if (qg.status != 'OK') {
      error "Pipeline aborted due to quality gate failure: ${qg.status}"
    }
  }
}
node{
	stage('Archive Results') {
			junit allowEmptyResults: true,testResults: '**/target/surefire-reports/TEST-*.xml'
	//CHANGE THE ARCHIVE EXTENSION IF REQUIRED
			archiveArtifacts 'target/*.war'
	}
}
