package strings;

import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        char a = '\0';
        char b = '\\';
        char c = 123;
        System.out.println(a + " " + b + " " + c);

        String line = "";

        String first = "line";
        String second = "line";
        //Ссылки совпадут
        System.out.println(first == second);
        String third = new String("line").intern();
        String fourth = new String("line");
        String fifth = "line";
        System.out.println(first == third);
        //Ссылки не совпадут
        System.out.println(third == fourth);
        System.out.println(fourth == fifth);
        System.out.println(fourth.equals(fifth));
        System.out.println(first == fifth);
        fifth = null;
        System.out.println(Objects.equals(fourth, fifth));


        String[] arr = "some new words".split("\\s");
        System.out.println(Arrays.toString(arr));
        String[] arr2 = "some new words".split(" n");
        System.out.println(Arrays.toString(arr2));

        String[] arr3 = "some; different wor;d ds".split("\\s", 2);
        System.out.println(Arrays.toString(arr3));

        String line1 = "London %d %s";
        System.out.println(line1.formatted(12, "some"));

        // STOPSHIP: 05.08.2025
        String line2 = line1.repeat(5);
        System.out.println(line2);

        String line3 = first.replace('e', 'o');
        System.out.println("first: " + first);
        System.out.println("result: " + line3);

        String line4 = first.replaceAll("in", "on");
        System.out.println(line4);
        String line5 = first.replaceFirst("in", "on");

        String unStripped = "             ";
        String stripped = unStripped.strip();
        System.out.println("first: " + unStripped + "a");
        System.out.println("final: " + stripped + "a");

        String unTrimmed = "    login    ";
        String trimmed = unTrimmed.trim();
        System.out.println("first: " + unTrimmed);
        System.out.println("final: " + trimmed);

        System.out.println(first.substring(1));


        char char1 = trimmed.charAt(2);
        System.out.println(char1);
        System.out.println();

        int result1 = trimmed.indexOf(2);
        System.out.println(result1);

        int result2 = trimmed.indexOf("gin");
        System.out.println(result2);

        boolean matches = first.matches("\\w+");
        System.out.println(matches);
        System.out.println();


        String builder = "StringBuilder";
        StringBuilder stringBuilder = new StringBuilder(builder);
//        StringBuffer;


        String abc = "abc";
        String abcde = "abcde";
        System.out.println(abc.compareTo(abcde));
        System.out.println(abcde.compareTo(abc));


        String[] values = new String[] {"one", "two", "three"};
        Arrays.sort(values);
//        System.out.println(values);
        System.out.println(Arrays.toString(values));

    }
}
