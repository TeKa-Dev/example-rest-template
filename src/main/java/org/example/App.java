package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RestConfig.class);
        RestService service = context.getBean(RestService.class);

        System.out.println(service.getListEntity());
    }
}
