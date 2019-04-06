FROM java:8
VOLUME /tmp
ADD reactive-programming-mongo-0.0.1-SNAPSHOT.jar reactive-programming-mongo.jar
RUN bash -c 'touch /reactive-programming-mongo.jar'
EXPOSE 9303
ENTRYPOINT exec java $JAVA_OPTS -jar /reactive-programming-mongo.jar

# ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar","/reactive-programming-mongo.jar"]