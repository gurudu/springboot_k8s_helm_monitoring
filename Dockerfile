FROM openjdk:17-jdk-alpine
CMD ["./gradlew", "clean", "bootJar"]
COPY  ./build/libs/*.jar /demo-k8s/order_management.jar
WORKDIR /demo-k8s
EXPOSE 8081
ENTRYPOINT ["java","-jar","order_management.jar" ]