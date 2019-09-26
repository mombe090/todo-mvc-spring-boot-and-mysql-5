pipeline {
  agent any
  stages {
    stage('stage') {
      steps {
        bat 'mvn clean'
      }
    }
    stage('test') {
      steps {
        bat 'mvn test'
      }
    }
    stage('deploy') {
      steps {
        bat 'mvn package'
      }
    }
  }
}