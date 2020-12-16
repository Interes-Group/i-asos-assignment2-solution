package sk.stuba.fei.uim.asos.assignment2;

import lombok.extern.java.Log;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.ws.Endpoint;

@Log
public class Assignment2Application {

    public static ApplicationContext applicationContext;

    public static void main(String[] args) {
        applicationContext = new ClassPathXmlApplicationContext("config.xml");
        Endpoint.publish("http://localhost:8080/user", applicationContext.getBean("userServicePort"));

        log.info("Application has started...");
    }

}
