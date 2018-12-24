# FROM openjdk:8-jdk-alpine
# FROM java:8
# VOLUME /tmp
# EXPOSE 8080
# ARG DEPENDENCY=/build/dependency
# COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
# COPY ${DEPENDENCY}/META-INF /app/META-INF
# COPY ${DEPENDENCY}/BOOT-INF/classes /app
# ENTRYPOINT ["java","-cp","app:app/lib/*","com.razorpay.batch.BatchApplication"]


FROM java:8
COPY ./build/libs/* ./app.jar
EXPOSE 8080

CMD java -Xdebug -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8081 -jar app.jar
# ADD batch-docker-1.0.jar batch-docker-1.0.jar
# ENTRYPOINT ["java","-jar","batch-docker-1.0.jar"]
#ENTRYPOINT ["java","--version"]
