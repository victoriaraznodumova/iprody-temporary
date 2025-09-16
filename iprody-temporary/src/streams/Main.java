package streams;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    private static int value = 20;
    public static void main(String[] args) {
        var doSomething = new DoSomething() {
            @Override
            public void doSome() {
                System.out.println("some");
            }
        };
        process(doSomething);

        var walkSome = new WalkInterface(){
            @Override
            public void walk(int meters) {
                System.out.println("Walk " + meters);
            }
        };
        int value = 20;
//        value += 10;
        WalkInterface doSomeNext = (meters) -> {
            System.out.println("Walk " + meters + " " + value);
        };

//        processWalk(doSomeNext);
        processWalk((meters) -> System.out.println("walk " + meters));







        List<String> names = List.of("first", "second", "third");
        for (var name : names) {
            System.out.println(name);
        }

//        names.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        });
        names.forEach(s -> System.out.println(s));

        //для нестатического метода
//        var walker = new Walker();
//        names.forEach(walker::print);
        //для статического метода
        names.forEach(Walker::print);


//        Stream<String> stream = names.stream();
        Stream<String> first = Stream.of("first", "second", "third");
        int[] values = new int[] {1, 2, 3};
        IntStream stream1 = Arrays.stream(values);


        System.out.println("Способ вывода слов на букву f через стрим");
        names.stream()
                .filter(name -> name.startsWith("f"))
                .forEach(System.out::println);
        List<String> f = names.stream()
                .filter(name -> name.startsWith("f"))
                .toList();
        names.stream()
                .filter(name -> name.startsWith("f"))
                .map(firstF -> firstF.toUpperCase())
                .forEach(System.out::println);
        names.stream()
                .filter(name -> name.startsWith("f"))
                .map(String::toUpperCase)
                .forEach(System.out::println);
        names.stream()
                .filter(name -> name.startsWith("f"))
                .forEach(firstF -> System.out.println(firstF.toUpperCase()));


        Stream<Integer> evenNumbers = Stream.iterate(0, number -> number + 2);
        evenNumbers.limit(10)
                .forEach(System.out::println);


        System.out.println("Числа Фибоначчи");
//        Stream<Integer> fibonacci = Stream.iterate(1, );
        Stream<Pair> fibonacci = Stream.iterate(new Pair(1, 1), pair -> {
            int temp = pair.getPrevious();
            pair.setPrevious(pair.getNext());
            pair.setNext(pair.getNext() + temp);
            return pair;
        });
        fibonacci.limit(10).forEach(pair -> System.out.println(pair.getPrevious()));




        //обычный вариант сравнения двух чисел
        var somePair = new Pair(2, 5);
        if (somePair.getNext() < 5){
            System.out.println("//");
        }
        //та же задача, но используется парадигма стримов
        Stream.of(somePair)
                .filter(pair -> pair.getNext() < 5)
                .forEach(pairValue -> System.out.println("//"));



        //разница между Stream<Integer> и IntStream
        int[] ints = new int[] {1, 2, 3, 4, 5};
        IntStream intStream = Arrays.stream(ints);
        OptionalDouble average = intStream.average();
        average.isEmpty();
//        intStream.boxed();
//        IntSummaryStatistics intSummaryStatistics = intStream.summaryStatistics();


        System.out.println("преобразование типов стримов");
        Stream<Pair> pairStream = Stream.of(new Pair(1, 1), new Pair(2, 3), new Pair(3, 4));
//        pairStream.map(Pair::toString) //можно использовать pair -> pair.toString(), а можно - ссылку на метод
//                .filter(value1 -> value1.startsWith("f"))
//                .forEach(System.out::println);

        //выкинет исключение ClassCastException
//        pairStream.sorted()
//                .forEach(System.out::println);

        System.out.println("Сортировка через собственный компаратор");
        pairStream.sorted(Comparator.comparingInt(Pair::getPrevious)).forEach(System.out::println);
        //чтобы вывелся результат сортировки, придется закомментировать строки 127-129


        System.out.println("смотрим, что представляет из себя метод distinct");
        Arrays.stream(new int[]{1, 2, 33, 3, 3, 4, 5})
                .distinct()
                .forEach(System.out::println);

        List<Integer> list = Arrays.stream(new int[]{1, 2, 33, 3, 3, 4, 5})
                .distinct()
                .boxed()
                .collect(Collectors.toList());

        System.out.println("сумма целых чисел через агрегацию");
        int result = Arrays.stream(new int[]{1, 2, 33, 3, 3, 4, 5})
                .distinct()
                .reduce(0, Integer::sum);
        System.out.println(result);

        System.out.println("агрегация на типе Pair");

        Stream<Pair> pairStream1 = Stream.of(new Pair(2, 4), new Pair(6, 3), new Pair(1, 4));
        System.out.println(pairStream1.reduce(new Pair(-1, -1), (pair, pair2) -> pair2.getPrevious() > pair.getPrevious() ? pair2 : pair));


        System.out.println("поиск количества различных слов в тексте");
        String text = "some next word some next next some value";
        long count = Arrays.stream(text.split(" "))
                .distinct()
                .count();
        System.out.println(text + " " + count);

        System.out.println("выводим слова и число их повторений в строке");
        Map<String, Long> frequency = Arrays.stream(text.split(" "))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        System.out.println(frequency);



        System.out.println("\nрешаем задачу на подсчет количества людей с заданными именами");
        var personList = new ArrayList<Person>(){
            {
                add(new Person(1, "fedor", 11));
                add(new Person(2, "peter", 14));
                add (new Person(3, "fedor", 17));
                add(new Person(4, "ivan", 16));
            }};
        Map<String, Long> collect = personList.stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.counting()));
        System.out.println(collect);


    }

    public static void process (DoSomething doSomething){
        doSomething.doSome();
    }
    public static void processWalk (WalkInterface walk){
        walk.walk(12);
        System.out.println("Hello");
    }
}
