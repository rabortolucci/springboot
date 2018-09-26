package springcourse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;


public class DrawingApp {

    private Triangle triangle;

    public static void main(String[] args){
        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("springcourse.xml");
        applicationContext.registerShutdownHook();

        Shape shape = (Shape) applicationContext.getBean("circle");
        shape.draw();

        String message = applicationContext.getMessage("greeting", null, "Default greeting", null);
        System.out.println(message);




    }
}
