package springaopcourse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springaopcourse.service.ShapeService;

public class AppMain {

    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("springaop.xml");
        ShapeService shapeService = ctx.getBean("shapeService", ShapeService.class);
        System.out.println(shapeService.getCircle().getName());
    }
}
