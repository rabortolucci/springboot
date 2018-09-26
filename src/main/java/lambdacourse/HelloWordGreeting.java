package lambdacourse;

public class HelloWordGreeting implements Greeting {

    @Override
    public void perform() {
        System.out.println("Hello lambda");
    }
}
