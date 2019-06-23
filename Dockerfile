FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","de.owemo.server.ServerApplication"]

# info
EXPOSE 8080
ENV DB_ADDR="localhost"
ENV DB_SCHEMA="spring-test"
ENV DB_PORT=3306
ENV DB_USER="root"
ENV DB_PASS=""
