# messaging-rabbitmq

Running RabbitMQ

`
docker-compose up
`

You can also run rabbitmq by using the following command
```
docker run -d -p 5672:5672 -p 15672:15672 --name my-rabbit rabbitmq:management
```

Options to run the Spring Boot Aplication
 - ./gradlew bootRun
 - or a jar
    - java -jar build/libs/gs-messaging-rabbitmq-0.1.0.jar