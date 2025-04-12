package enums;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int size = 10;
        Random random = new Random();
        int[] numbers = new int[size];
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(10);
        }
        System.out.println(Arrays.toString(numbers));

        while(true) {
            System.out.println("What to do? Enter: ");

            for (var userCode : UserCode.values()) {
                System.out.println(userCode.getCode() + " to " + userCode.getDescription());
            }
//        System.out.println("2 to get an average value");
//        System.out.println("3 to sort array");

            int code = new Scanner(System.in).nextInt();
            UserCode userCode = UserCode.valueOf(code);
            switch (userCode) {
                case SUM:
                    System.out.println("Sum = " + sumArray(numbers));
                    break;
                case AVERAGE:
                    System.out.println("Average = " + averageArray(numbers));
                    break;
                case SORT:
                    System.out.println("Sorted = " + Arrays.toString(sort(numbers)));
                    break;
                case EXIT:
                    return;
            }
        }
    }


    private static int sumArray(int[] array){
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum;
    }

    private static double averageArray(int[] array){
        int sum = sumArray(array);
        return (double) sum/array.length;
    }

    private static int[] sort(int[] array){
        Arrays.sort(array);
        return array;
    }
}