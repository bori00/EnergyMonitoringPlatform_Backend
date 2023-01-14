FROM mcr.microsoft.com/mssql/server:2017-latest

ENTRYPOINT ["./entrypoint.sh"]

FROM maven:3.6.3-jdk-11 AS builder

COPY ./src/ /root/src
COPY ./pom.xml /root/
COPY ./checkstyle.xml /root/
COPY ./setup.sql /root/
COPY ./setup_database.sh /root/
COPY ./entrypoint.sh /root/
WORKDIR /root
RUN mvn package
RUN java -Djarmode=layertools -jar target/energy-utility-backend.jar list
RUN java -Djarmode=layertools -jar target/energy-utility-backend.jar extract
RUN ls -l /root

FROM openjdk:11.0.6-jre

ENV DB_IP=db
ENV DB_PORT=1433
ENV DB_USER=sa
ENV DB_PASSWORD=db-password11
ENV DB_DBNAME=energyutilitydb

ENV GRPC_PORT=9090
ENV SERVER_PORT=8443

ENV KEYSTORE_FILEPATH=classpath:keystore/hedza06.p12

COPY --from=builder /root/dependencies/ ./
COPY --from=builder /root/snapshot-dependencies/ ./

RUN sleep 10
COPY --from=builder /root/spring-boot-loader/ ./
COPY --from=builder /root/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher","-XX:+UseContainerSupport -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XX:MaxRAMFraction=1 -Xms512m -Xmx512m -XX:+UseG1GC -XX:+UseSerialGC -Xss512k -XX:MaxRAM=72m"]