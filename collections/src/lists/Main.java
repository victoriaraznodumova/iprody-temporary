package lists;

import java.nio.BufferOverflowException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
//        ArrayList<Integer> ints = new ArrayList<>();
        LinkedList<Integer> ints = new LinkedList<>();
        ints.add(2);
        ints.add(3);
        ints.add(5);
        ints.add(6);
        ints.add(7);
        ints.contains(4);
//        ints.remove(4);
        System.out.println(ints);

        for (int i = 0; i < ints.size(); i++) {
            Integer int1 = ints.get(i);
            int int2 = ints.get(i);
        }
        for (int value : ints) {
            System.out.println(value);
        }


        LinkedList<Integer> linkedInts = new LinkedList<>();


//        ArrayDeque<>


        //реализация цикла foreach под капотом
        Iterator<Integer> iterator = ints.iterator();
        while (iterator.hasNext()) {
            int value = iterator.next();
        }


        //анонимные классы
        Iterator<Integer> integer = new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Integer next() {
                return null;
            }
        };


        //пробуем менять коллекцию на ходу
//        for (int value: ints) {
//            ints.remove(value);
//            System.out.println(value);
//        }
//


//        другой вариант рабочего удаления
//        ListIterator<Integer> iterator2 = (ListIterator<Integer>) ints.iterator();
//        while (iterator2.hasNext()){
//            int value = iterator2.next();
//            iterator2.remove();
//            System.out.println(ints.size());
//        }
//        System.out.println(ints);


        //написали свой класс с реализацией итератора, проверяем
        Storage storage = new Storage(List.of("name1", "name2", "name3"), "storageName");
        Iterator<String> iterator1 = storage.iterator();
        while (iterator1.hasNext()) 
            System.out.println(iterator1.next());
        for (String name: storage)
            System.out.println(name);


        //вторая часть урока про типизацию
        Object[] array = ints.toArray();

        ArrayList<ArrayList<Integer>> ints2 = new ArrayList<>();

        Integer[] ints3 = ints.toArray(new Integer[]{});
        System.out.println(Arrays.toString(ints3));


        //про сортировку
//        ints.sort();
        ints.add(4);
        ints.add(6);
        ints.add(2);
        ints.add(1);
        ints.add(6);
        ints.sort(Comparator.naturalOrder());
        System.out.println(ints);
        ints.sort(Comparator.reverseOrder());
        ints.remove(1);
        System.out.println(ints);


        //реализация собственного компаратора
        System.out.println("\nреализация собственного компаратора");
        ArrayList<Person> persons = new ArrayList<>(){
            {
                add(new Person("first", 8));
                add(new Person("second", 9));
                add(new Person("next", 10));
                add(new Person("last", 11));
                add(new Person("optional", 13));
                add(new Person("first", 6));

            }
        };

        //сортировали по именам
        persons.sort(new PersonComparator());
        System.out.println(persons);

        persons.sort(Comparator.naturalOrder());
        System.out.println(persons);

        //сортировали по возрасту
        persons.sort(new PersonComparator());
        System.out.println(persons);

        //копирование листа
        ArrayList<Person> clone = (ArrayList<Person>)persons.clone();
        System.out.println(clone);
    }
}