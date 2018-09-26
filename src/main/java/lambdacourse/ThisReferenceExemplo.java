package lambdacourse;

public class ThisReferenceExemplo {

    public void doProcess(int i, Process p){
        p.process(i);
    }

    public void execute(){
        doProcess(10, i -> {
            System.out.println(i);
            System.out.println(this); // This work becouse its insite an instance
        });
    }


    public static void main(String[] args){
        ThisReferenceExemplo thisReferenceExemplo = new ThisReferenceExemplo();
        thisReferenceExemplo.doProcess(10, i -> {
            System.out.println(i);
            // System.out.println(this); This not work becouse its insite static method
        });

        thisReferenceExemplo.execute();
    }
}
