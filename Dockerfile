FROM registry.dev.codefactory.sh/banking-platform/tooling-docker-images/ubi8-java-11-openjdk:1.0.3
EXPOSE 8081

ADD build/libs/demo-0.0.1-all.jar /opt/demo.jar

CMD ["java", "-jar", "/opt/demo.jar", "-Xmx2G"]
