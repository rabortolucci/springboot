package lambdacourse;

public class ClousuresExample {

    public static void main(String[] args){
        int a = 10;
        int b = 20;
        doProcess(a, value -> System.out.println(value + b));
    }

    public static void doProcess(int i, Process p){
        p.process(i);
    }
}

interface Process{
    void process(int i);
}
