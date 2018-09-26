package lambdacourse;

public class TypeInterfaceExample {

    public static void main(String[] args){

        StringLenghLambida myLambida = s -> s.length();
        System.out.println(myLambida.getLengh("Hello lambda"));

        printLambda(s -> s.length());
    }

    public static void printLambda(StringLenghLambida s){
        System.out.println(s.getLengh("Hello lambda"));
    }

    interface StringLenghLambida{
        int getLengh(String s);
    }
}
