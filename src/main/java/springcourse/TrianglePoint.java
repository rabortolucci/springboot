package springcourse;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.List;

public class TrianglePoint implements Shape, ApplicationContextAware, BeanNameAware, InitializingBean, DisposableBean {

    private Point pointA;
    private Point pointB;
    private Point pointC;

    private ApplicationContext applicationContext;


    public void draw() {
        System.out.println("Point A (" + getPointA().getX() + "," + getPointA().getY() + ")");
        System.out.println("Point B (" + getPointB().getX() + "," + getPointB().getY() + ")");
        System.out.println("Point C (" + getPointC().getX() + "," + getPointC().getY() + ")");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println(beanName);
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean init melhod called");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean, any clean up code comes inside this method");
    }

    public void myInit(){
        System.out.println("MyInit method");
    }

    public void myDestroy(){
        System.out.println("MyDestroy method");
    }
}
