pipeline {
	agent any
	tools { maven 'Maven'}
	stages {
		stage('build') {
			steps {
				echo 'Building...'
				sh 'export JAVA_HOME=/usr/lib/jvm/java-8-openjdk/'
				sh 'cd technical-challenge && mvn -B -DskipTests clean package'
			}
		}
	}
}