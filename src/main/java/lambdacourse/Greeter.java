package lambdacourse;

public class Greeter {

    public void greet(Greeting greeting){
        greeting.perform();
    }

    public static void main(String args[]){
        Greeter greeter = new Greeter();
        HelloWordGreeting helloWordGreeting = new HelloWordGreeting();

        Greeting myLambidaFunction = () -> System.out.println("Hello lambda");

        Greeting innerClassGreeting = new Greeting() {
            @Override
            public void perform() {
                System.out.println("Hello lambda");
            }
        };

        greeter.greet(myLambidaFunction);
        greeter.greet(innerClassGreeting);

    }
}

