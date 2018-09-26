package lambdacourse;

public class RunnableExample {

    public static void main(String[] args){

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Printed inside runnable");
            }
        });

        thread.run();

        Thread myLambdaThread = new Thread(() -> System.out.println("Printed my Lambda inside runnable"));
        myLambdaThread.run();
    }

}
