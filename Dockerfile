FROM maven:3.6.3-jdk-11 AS builder

COPY ./src/ /root/src
COPY ./pom.xml /root/
COPY ./checkstyle.xml /root/
WORKDIR /root
RUN mvn package
RUN java -Djarmode=layertools -jar target/energy-utility-backend.jar list
RUN java -Djarmode=layertools -jar target/energy-utility-backend.jar extract
RUN ls -l /root

FROM openjdk:11.0.6-jre


ENV DB_IP=energy-utility-backend-bori00.germanywestcentral.azurecontainer.io
ENV DB_PORT=5432
ENV DB_USER=postgres-user
ENV DB_PASSWORD=postgres-password
ENV DB_DBNAME=energy-utility-db


COPY --from=builder /root/dependencies/ ./
COPY --from=builder /root/snapshot-dependencies/ ./

RUN sleep 10
COPY --from=builder /root/spring-boot-loader/ ./
COPY --from=builder /root/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher","-XX:+UseContainerSupport -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XX:MaxRAMFraction=1 -Xms512m -Xmx512m -XX:+UseG1GC -XX:+UseSerialGC -Xss512k -XX:MaxRAM=72m"]

