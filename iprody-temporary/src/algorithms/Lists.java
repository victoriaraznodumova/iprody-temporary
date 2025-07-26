package algorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class Lists {
    public static void main(String[] args) {
        LinkedList<Integer> integers = new LinkedList<>();
        integers.add(123);
        integers.removeLast();
        integers.remove(123);

        System.out.println(first());

        integers.push(1);
        integers.pop();

        integers.poll();


        HashSet<Integer> numbers = new HashSet<>();
        numbers.add(123);
        numbers.remove(12);
        numbers.contains(123);


        TreeSet<Integer> elements = new TreeSet<>();
//        for (var element: elements) {
//
//        }
    }

    public static int first(){
        return second() + 5;
    }

    public static int second(){
        return third() + 1;
    }

    public static int third(){
        return 2;
    }
}