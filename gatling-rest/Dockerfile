FROM openjdk:8-jre
MAINTAINER Stuart Saltzman <stuart@livesafemobile.com>

ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/gatling-rest/gatling-rest.jar"]

# Add Maven dependencies (not shaded into the artifact; Docker-cached)
# ADD target/lib           /usr/share/myservice/lib

# Add the service itself
ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/gatling-rest/gatling-rest.jar

