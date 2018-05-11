pipeline {
	agent any
	tools { maven 'Maven'}
	stages {
		stage('build') {
			steps {
				echo 'Building...'
				sh 'export JAVA_HOME=/usr/lib/jvm/java-8-openjdk/'
				dir('technical-challenge')
				sh 'mvn -B -DskipTests clean package'
			}
		}
	}
}