pipeline {

    environment {
        registry = "owemode/spring-jenkins-test"
        registryCredential = 'docker_registry_server'
    }

    agent any

    stages {
        stage('Build') {
            steps {
                sh './gradlew docker --stacktrace --debug'
            }
        }

        stage('Publish') {
            steps {
                script {
                    docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }
    }
}
