pipeline {
	agent any
	tools { maven 'Maven'}
	stages {
		stage('build') {
			steps {
				echo 'Building...'
				sh 'cd technical-challenge && mvn -B -DskipTests clean package'
			}
		}
	}
}