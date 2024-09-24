FROM openjdk:11
ARG JAR_FILE=target/*.jar
WORKDIR /app
COPY ${JAR_FILE} /app/bank.jar
EXPOSE 8080
CMD ["java","-jar","-Dspring.profiles.active=cloud2","bank.jar"]
#ENTRYPOINT ["java","-jar","-Dspring.profiles.active=cloud1","bank.jar"]
#CMD ["java","-jar","bank.jar"]
