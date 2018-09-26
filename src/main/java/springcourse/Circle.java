package springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.Locale;

@Component
public class Circle implements Shape, ApplicationEventPublisherAware {

    private Point center;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private ApplicationEventPublisher publisher;

    public void draw(){
        System.out.println(messageSource.getMessage("drawing.circle", null, "Default greeting", null));
        System.out.println(messageSource.getMessage("drawing.point", new Object[]{center.getX(), center.getY()}, "Default greeting", null));
        System.out.println(messageSource.getMessage("greeting", null, "Default greeting", null));
        publisher.publishEvent(new DrawEvent(this));
    }

    public Point getCenter() {
        return center;
    }

//    @Resource
    @Autowired
    @Qualifier("circleRelated")
    public void setCenter(Point center) {
        this.center = center;
    }

    @PostConstruct
    public void initializeCircle(){
        System.out.println("Init circle");
    }

    @PreDestroy
    public void destroyCircle(){
        System.out.println("Destroy circle");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
}
