package springcourse;

import org.springframework.beans.factory.annotation.Required;

public class Circle implements Shape  {

    private Point center;

    public void draw(){
        System.out.println("Drawing circle");
    }

    public Point getCenter() {
        return center;
    }

    @Required
    public void setCenter(Point center) {
        this.center = center;
    }
}
