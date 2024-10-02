FROM maven:3.8.2-openjdk-17 AS  build
COPY . .
RUN mvn clean package
FROM openjdk:17.0.2-slim
COPY --from=build /target/wallet-1.jar wallet.jar
ENV NAME="Wallet"
ENTRYPOINT ["java","-jar","/wallet.jar"]