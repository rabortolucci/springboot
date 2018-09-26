package lambdacourse;

import java.util.function.BiConsumer;

public class ExceptionHandlingGenericsExample {

    public static void main(String[] args){

        int[] numbers = {1,2,3,4};
        int key = 2;


        process(numbers, key);
        processBiConsumer(numbers, key, wapperLambda((v, k) -> System.out.println(v / k)));
        processBiConsumer(numbers, key, wapperLambdaWithGenerics((v, k) -> System.out.println(v / k)));

    }

    public static void process(int[] someNumbers, int key){
        for(int i : someNumbers){
            System.out.println(i + key);
        }
    }

    public static void processBiConsumer(int[] someNumbers, int key, BiConsumer<Integer, Integer> biConsumer) {
        for (int i : someNumbers) {
            biConsumer.accept(i, key);
        }
    }

    public static BiConsumer<Integer, Integer> wapperLambda(BiConsumer<Integer, Integer> biConsumer){
       return (v, k) -> {
           try {
               biConsumer.accept(v, k);
           }catch(ArithmeticException exe){
               System.out.println("Exception cought in wrapper lambda");
           }
       };
    }

    public static <T> BiConsumer<T, T> wapperLambdaWithGenerics(BiConsumer<T, T> biConsumer){
        return (T v, T k) -> {
            try {
                biConsumer.accept(v, k);
            }catch(ArithmeticException exe){
                System.out.println("Exception cought in generics wrapper lambda");
            }
        };
    }
}
