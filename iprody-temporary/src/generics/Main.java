package generics;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("One");
        arrayList.add("Two");
        arrayList.add("Three");
        Object o = arrayList.get(0);
        if (o instanceof String oString){
            oString.charAt(2);
        }



        String value = new String ("some value");
        String some = printValue(value, "some", 2);
        System.out.println(some);




        Person<String, String, String> person = new Person<>(1, "some");
        Object data = person.getData();
        var o1 = person.getO();


//      PersonWithAnimal<Animal> chel  = new PersonWithAnimal<>(3, new Dog("meow"));
//      PersonWithAnimal<CanEat> chel2  = new PersonWithAnimal<>(3, new Dog("meow"));
//      System.out.println(chel2.getAnimal());

//      PersonWithAnimal<PersonWithAnimal<Dog>> chel3 = new PersonWithAnimal<>(1, new PersonWithAnimal<>(1, new Dog("bark")));







        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(new Cat("cat1"));
        cats.add(new Cat("cat2"));
        cats.add(new Cat("cat3"));
        cats.add(new Cat("cat4"));
        washCats(cats);


//        var animals = getAnimals();



        List<? super Animal> animal = new ArrayList<>();
        animal.add(new Animal("some"));


        Tuple<Integer, String, String> tuple = new Tuple<>(1, "some", "next");
    }

    static <T, K> T printValue(T object, K next, int value){
        System.out.println(object);
        return object;
    }

    static void washCats(List<? extends Animal> animals){
        for (var animal : animals) {
            animal.wash();
        }
    }

    static List<? super Animal> getAnimals(List<? super Animal> animals){
        animals.add(new Cat("some"));
        animals.add(new Dog("some"));
        animals.add(new Tiger("some"));
        animals.add(new Cat("some"));
        return animals;
    }

    public static <T> void print (T ints){

    }
}