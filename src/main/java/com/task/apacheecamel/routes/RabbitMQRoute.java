package com.task.apacheecamel.routes;

import com.fasterxml.jackson.core.JsonParseException;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQRoute extends RouteBuilder {

        @Override
        public void configure() throws Exception {


            from("rabbitmq:testExchange?queue=testQueue&autoDelete=false&declare=false&connectionFactory=#rabbitConnectionFactory" )
                    .routeId("RabbitMqConsumer")
                    .unmarshal().json()
                    .log("Unmarshalled JSON body: ${body}")
                    .marshal().json()
                    .log("Marshalled JSON body: ${body}");

        }

}
