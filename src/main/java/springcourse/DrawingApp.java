package springcourse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class DrawingApp {

    private Triangle triangle;

    public static void main(String[] args){
        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("springcourse.xml");
        applicationContext.registerShutdownHook();

        Triangle triangle = (Triangle) applicationContext.getBean("triangle");
        triangle.draw();

        TrianglePoint trianglePoint = (TrianglePoint) applicationContext.getBean("trianglePoint");
        trianglePoint.draw();

    }

}
