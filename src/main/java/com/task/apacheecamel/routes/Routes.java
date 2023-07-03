package com.task.apacheecamel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class Routes extends RouteBuilder {

//
//    private final AnotherBean anotherBean;

    @Override
    public void configure () throws Exception {
      from("timer://helloTimer?period=1000")
////                .setBody().constant("Hello World")
////               .setBody().method(anotherBean, "sayHelloWorld")
             .bean("anotherBean","sayHelloWorld")
////                .log("${body}")
             .to("log:HelloWorld");
    }
}
    @Component
    class AnotherBean {
        public String sayHelloWorld(){
            return "Hello world1!";
        }
        public String sayGoodMorning(){
            return "GoodMorning!";
        }
    }

