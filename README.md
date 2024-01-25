## Springboot-web app deployed to Kubernetes Cluster
## Requirements:
   * Java 17 Installed
   * Gradle (or any other build tool for Java)
   * Any Java IDE
   * Docker or Rancher desktop installed and running
   * Testing (Optional): Postman and Tableplus to follow along, but any testing tool will work

## Features
 1. Sample Springboot web app using REST API, JPA, Hibernate
 2. Used Hexagonal architecture for the project
 3. Used techonologies : 
       * JAVA 17
       * Gradle as Build tool
       * Springboot version: 3.1.4
       * PostgreSQL 14
       * Kubernetes
       * Helm
       * Monitoring tools : Promotheus and Grafana
 4. To deploy application to Kubernetes cluster (used minikube):
    * commands to use to run the project:
        *  gradle build
        *  docker build -t order_management .
        *  To push the image to docker hub registry or we can also push to minikube registry.
        *  Use kubernetes manifest yml files for deployment of app and database and services.
        *  The services are exposed outside the cluster using LoadBalancer.

