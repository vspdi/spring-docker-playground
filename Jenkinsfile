pipeline {

    environment {
        registry = "owemode/spring-jenkins-test"
        registryCredential = 'docker_registry_server'
    }

    agent any

    stages {
        stage('Build') {
            steps {
                sh './gradlew docker'
            }
        }

        stage('Publish') {
            steps {
                docker.build registry + ":$BUILD_NUMBER"
            }
        }
    }
}
