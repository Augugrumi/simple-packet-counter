FROM openjdk:8-jdk-alpine as builder
RUN mkdir -p /srv/
WORKDIR /srv/
COPY TCPServer.java /srv/
RUN javac TCPServer.java

FROM openjdk:8-jre-alpine
RUN mkdir -p /srv/
WORKDIR /srv/
COPY --from=builder /srv/TCPServer.class /srv/
EXPOSE 80
ENTRYPOINT [ "java", "TCPServer" ]