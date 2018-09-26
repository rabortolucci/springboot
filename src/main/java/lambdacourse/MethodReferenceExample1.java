package lambdacourse;

public class MethodReferenceExample1 {

    public static void main(String[] args){

        Thread thread = new Thread(() -> printMessage());
        Thread threadMethodReference = new Thread(MethodReferenceExample1::printMessage);

        thread.start();
        threadMethodReference.start();

    }

    public static void printMessage(){
        System.out.println("Hello");
    }
}
