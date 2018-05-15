pipeline {
	agent any
	tools { maven 'Maven'}
	stages {
		stage('Build') {
			steps {
				echo 'Building...'
				sh 'export JAVA_HOME=/usr/lib/jvm/java-8-openjdk/'
				sh 'cd technical-challenge && pwd && mvn -B -DskipTests clean package'
			}
		}
		stage('')
	}
}