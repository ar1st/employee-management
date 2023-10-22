FROM openjdk:11-jre-slim

WORKDIR /app

COPY target/employee.management.api-0.0.1-SNAPSHOT.jar employee-management-api.jar

EXPOSE 8080

CMD ["java", "-jar", "employee-management-api.jar"]