package algorithmquestions;

import java.util.*;

public class Algorithm {

    public static void main(String args[]) {


        System.out.println("************ Swapping string");

        String valor = "rafael antonio";
        System.out.println(valor);
        for (int i = 1; i <= valor.length(); i++) {

            System.out.print(valor.charAt(valor.length() - i));
        }
        System.out.println();
        String string = "whatever";
        String reverse = new StringBuffer(string).reverse().toString();
        System.out.println(reverse);

        System.out.println("************ Fibonacci ");

        int proximo = 0, atual = 0, anterior = 1;

        while (proximo <= 100) {
            proximo = atual + anterior;
            System.out.print(proximo + ",");
            anterior = atual;
            atual = proximo;
        }

        System.out.println();
        System.out.println("************ Prime number ");
        int count = 0;
        for (int i = 2; i < 100; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count < 2)
                System.out.print(i + ",");
            count = 0;
        }

        System.out.println();
        System.out.println("************ Swap number ");

        int swapN1 = 30;
        int swapN2 = 20;
        int tempSwap = swapN1;
        swapN1 = swapN2;
        swapN2 = tempSwap;

        System.out.println("Number1 swap " + swapN1);
        System.out.println("Number2 swap " + swapN2);

        System.out.println();
        System.out.println("************ Reverse array ");

        int[] arrayReverse = {1, 2, 3, 4, 5};

        for (int i = 0; i < arrayReverse.length / 2; i++) {

            int tempValueArray = arrayReverse[(arrayReverse.length - 1) - i];
            arrayReverse[(arrayReverse.length - 1) - i] = arrayReverse[i];
            arrayReverse[i] = tempValueArray;
        }

        System.out.println(Arrays.toString(arrayReverse));

        System.out.println();
        System.out.println("************ Reverse number ");

        int numberReverse = 125;
        int numberReverseTemp = 0;

        while (numberReverse != 0) {
            numberReverseTemp = (numberReverseTemp * 10) + (numberReverse % 10);
            numberReverse = numberReverse / 10;
        }
        System.out.println(numberReverseTemp);


        System.out.println();
        System.out.println("************ Bubble Sorting integer ordenar int array ");

        int[] inArrayNumbers = {3,60,35,2,45,320,5};
        int auxInt;

        for(int i = 0; i < inArrayNumbers.length; i++){
            for(int j = 0; j < inArrayNumbers.length; j++){
                if(inArrayNumbers[i] < inArrayNumbers[j]){
                    auxInt = inArrayNumbers[i];
                    inArrayNumbers[i] = inArrayNumbers[j];
                    inArrayNumbers[j] = auxInt;
                }
            }
        }

        int sweets = 0;
        int bonus = 0;
        int higherScore = 0;
        for(int i = 0; i < inArrayNumbers.length; i++){
            if(inArrayNumbers[i] > higherScore && i != 0){
                bonus++;
            }
            higherScore = inArrayNumbers[i];
            sweets = sweets + 1 + bonus;
        }

        System.out.println(Arrays.toString(inArrayNumbers));
        System.out.println("Sweets " + sweets);


        System.out.println();
        System.out.println("************ Bubble Sorting String array ");

        String[] inArrayString = {"Z", "D", "A", "W", "B", "Y", "C", "X"};
        String auxString;

        for(int i = 0; i < inArrayString.length; i++){
            for(int j = 0; j < inArrayString.length; j++){
                if(inArrayString[i].compareTo(inArrayString[j]) < 0){
                    auxString = inArrayString[i];
                    inArrayString[i] = inArrayString[j];
                    inArrayString[j] = auxString;
                }
            }
        }
        System.out.println(Arrays.toString(inArrayString));


        System.out.println();
        System.out.println("************ Print string from behind ");

        //        given: "Rafael Antonio Bortolucci";
        //        print: "Bortolucci Antonio Rafael";

        String name = "Rafael Antonio Bortolucci";
        System.out.println(name);

        String[] nameSplit = name.split(" ");
        for(int i = 0; i < nameSplit.length; i++){
            System.out.print(nameSplit[(nameSplit.length - 1) - i] + " ");
        }

        System.out.println();
        System.out.println("************ Sorting a map by key");

        Map<String, String> mapUnsorted = new HashMap<String, String>();
        mapUnsorted.put("1","Joao");
        mapUnsorted.put("2","Maria");
        mapUnsorted.put("3","Antonio");
        for(Map.Entry<String,String> v : mapUnsorted.entrySet()){
            System.out.println(v.getKey() + " " +  v.getValue());
        }

        System.out.println();
        System.out.println("************ Sorting a map by value");

        List<Map.Entry<String, String>> listEntry = new LinkedList<Map.Entry<String, String>>(mapUnsorted.entrySet());
        Collections.sort(listEntry, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for(Map.Entry<String, String> entry : listEntry){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        System.out.println();
        System.out.println("************ Perfect number");

        int perfectNumber = 6;
        int sumPerfectNumber = 0;
        for (int i = 1; i < perfectNumber; i++){
            if (perfectNumber % i == 0){
                sumPerfectNumber = sumPerfectNumber + i;
            }
        }
        if(sumPerfectNumber == perfectNumber){
            System.out.println("Number is perfect");
        }else{
            System.out.println("Number is not perfect");
        }

        System.out.println();
        System.out.println("************ Binary number");

        int binaryNumber = 100012;
        boolean status = true;
        while(true){
            if(binaryNumber == 0)
                break;
            else{
                if(binaryNumber % 10 > 1){
                    status = false;
                    break;
                }
                binaryNumber = binaryNumber / 10;
            }
        }
        if(status){
            System.out.println("Is binary number ");
        }else {
            System.out.println("Is not binary number ");
        }

        System.out.println();
        System.out.println("************ Common elements between two arrays");

        int myArray[] = { 2, 2, 7, 7, 2, 1, 5, 4, 5, 1, 1 };
        int myArray2[] = { 2, 3, 4, 7, 10 };

        for(int i = 0; i < myArray.length; i++){
            for(int j = 0; j < myArray2.length; j++){
                if(myArray[i] == myArray2[j]){
                    System.out.print(myArray[i] + ",");
                }
            }
        }

        System.out.println();
        System.out.println("************ Deadlock in thread");

        final String resource1 = "Hi";
        final String resource2 = "Hello";

        Thread thread1 = new Thread(){
            public void run() {
                synchronized (resource1) {
                    System.out.println("Thread 1 locked resource 1");
                    try {
                        Thread.sleep(100);
                    } catch (Exception exe) {}

                    synchronized (resource2) {
                        System.out.println("Thread 1 locked resource 2");
                    }
                }
            }
        };

        Thread thread2 = new Thread(){
            public void run() {
                synchronized (resource2) {
                    System.out.println("Thread 2 locked resource 2");
                    try {
                        Thread.sleep(100);
                    } catch (Exception exe) {}

                    synchronized (resource1) {
                        System.out.println("Thread 2 locked resource 1");
                    }
                }
            }
        };

//        thread1.start();
//        thread2.start();

        System.out.println();
        System.out.println("************ Reversing string with recursion");

        System.out.println(reverse("Rafael"));


        System.out.println();
        System.out.println("************ Find a factors of a number");

        int factorsNumber = 6;
        for(int i = 1; i <= factorsNumber; i++){
            if(factorsNumber % i == 0){
                System.out.print(i);
            }
        }

        System.out.println();
        System.out.println("************ Find a second largest element in a Array");

        int[] secondLargestArray = {10,2,8,66,7,1,0,99};
        Arrays.sort(secondLargestArray);
        int valueArray = 0;
        for(int i = secondLargestArray.length - 1; i >= 0; i--){
            if(secondLargestArray[i] < valueArray){
                System.out.println("Second largest element " + secondLargestArray[i]);
                break;
            }
            valueArray = secondLargestArray[i];
        }

        System.out.println();
        System.out.println("************ Printing numbers without using loop");

        printNexNumber(1);


        System.out.println();
        System.out.println("************ Find a missing number");

        int[] numbers = {1,2,3,5};
        int totalNumbers = numbers.length;
        int missingNumber  = (totalNumbers + 1) * (totalNumbers + 2) / 2;

        for(int i = 0; i < totalNumbers; i++){
            missingNumber -= numbers[i];
        }
        System.out.println("Missing number " + missingNumber);

        System.out.println();
        System.out.println("************ Find duplicate number in a array");

        int[] duplicateNumber = {1,2,3,3,4,5,1};
        for(int i = 0; i < duplicateNumber.length; i++){
            for(int j = i + 1; j < duplicateNumber.length; j++){
                if(duplicateNumber[i] == duplicateNumber[j]){
                    System.out.print(duplicateNumber[i] + ",");
                }
            }
        }

        System.out.println();
        System.out.println("************ Factorial number");

        int factorialNumber = 4;
        int factorialResult = 1;
        for(int i = 0; i < factorialNumber; i++){
            factorialResult = factorialResult * (factorialNumber - i);
        }
        System.out.println("Factorial number " + factorialResult);


        System.out.println();
        System.out.println("************ Find duplicate in a string in Java");

        String stringDuplicate = "fadefadluyy";
        char[] duplicateChar = stringDuplicate.toCharArray();
        Set<Character> duplicateSetChar = new LinkedHashSet<Character>();
        for(char c : duplicateChar){
            if(duplicateSetChar.contains(c)){
                System.out.print(c + ",");
            }
            duplicateSetChar.add(c);
        }

        System.out.println();
        System.out.println("************ Remove duplicate in a string in Java");

        String removeStringDuplicate = "fadefadluyy";
        char[] removeDuplicateChars = removeStringDuplicate.toCharArray();
        Set<Character> setRemoveString = new LinkedHashSet<Character>();
        for(char c : removeDuplicateChars){
            setRemoveString.add(c);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(Character c : setRemoveString){
            stringBuilder.append(c);
        }
        System.out.println(stringBuilder);


        System.out.println();
        System.out.println("************ Find a number is even or odd");

        int evenOddNumber = 2;
        if(evenOddNumber % 2 == 0){
            System.out.println("Number even " + evenOddNumber);
        }else{
            System.out.println("Number odd " + evenOddNumber);
        }


        System.out.println();
        System.out.println("************ Binary search implementation");
//        Constist of in a sorted array, you divide in the half and check if the number you
//           wanna is greater or smaller than half, if smaller, discard the up half

        int[] binarySearch = {1,2,3,4,5,6,7,8,9,10};
        int index = Arrays.binarySearch(binarySearch, 3);

        int key = 4;
        int high = binarySearch.length;
        int low = 0;
        int indexIterativeSearch = 0;

        while(low <= high){
            int mid = (low + high) / 2;
            if(binarySearch[mid] < key){
                low = mid + 1;
            }else if(binarySearch[mid] > key){
                high = mid - 1;
            }else if(binarySearch[mid] == key){
                indexIterativeSearch = mid;
                break;
            }
        }

        System.out.println(binarySearch[indexIterativeSearch]);


        System.out.println();
        System.out.println("************ String anagram");

        String str1 = "rafael".toUpperCase();
        String str2 = "lefara".toUpperCase();

        char[] charStr1 = str1.toCharArray();
        char[] charStr2 = str2.toCharArray();

        Arrays.sort(charStr1);
        Arrays.sort(charStr2);

        if(Arrays.equals(charStr1, charStr2)){
            System.out.println("Strings are anagrams");
        }else{
            System.out.println("Strings are not anagrams");
        }






    }








    public static void printNexNumber(int number){
        if(number < 100){
            System.out.print(number + ",");
            number++;
            printNexNumber(number);
        }
    }


    public static String reverse(String str){
        if(str == null || str.length() <= 1){
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }


}
