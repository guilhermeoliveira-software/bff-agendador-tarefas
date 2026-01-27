FROM maven:3.8-amazoncorretto-17 AS build
WORKDIR /app

COPY . .


RUN mvn clean package -DskipTests


FROM amazoncorretto:17-alpine
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8083
CMD ["java", "-jar", "/app/bff-agendador-tarefas.jar"]

#FROM amazoncorretto:17-alpine
#WORKDIR /app
#
#COPY target/bff-agendador-tarefas-0.0.1-SNAPSHOT.jar /app/bff-agendador-tarefas.jar
#
#EXPOSE 8083
#
#CMD ["java", "-jar", "/app/bff-agendador-tarefas.jar"]
