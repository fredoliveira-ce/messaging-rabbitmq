# messaging-rabbitmq

Running RabbitMQ

Check if application is runnnig
`
http://localhost:8082/api/message/greeting
`

`
docker-compose up
`

Just in case you want to create a network by using docker-compose
```
docker network create messaging
```

You can also run rabbitmq by using the following command
```
docker run -d -p 5672:5672 -p 15672:15672 --name my-rabbit rabbitmq:management
```

You can also run mongodb by using the following command
```
docker run -p 27017:27017 -d mongo
```

Options to run the Spring Boot Aplication
 - ./gradlew bootRun
 - or a jar
    - java -jar build/libs/gs-messaging-rabbitmq-0.1.0.jar

Testing
curl --request POST \
  --url http://localhost:8082/api/message/ \
  --header 'content-type: application/json' \
  --data '{"message": "Hello from producer"}'