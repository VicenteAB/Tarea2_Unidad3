#imagen que vamos a ocupar
FROM maven:3.8.5-openjdk-17-slim AS builder

WORKDIR /build

COPY . .

EXPOSE 8080

RUN mvn clean package

FROM maven:3.8.5-openjdk-17-slim

EXPOSE 8080

COPY --from=builder /build/target/*.jar /app/apicar.jar

CMD ["java","-jar","/app/apicar.jar"]