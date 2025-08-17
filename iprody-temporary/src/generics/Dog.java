package generics;

public class Dog extends Animal implements CanEat{

    public Dog(String name) {
        super(name);
    }


    @Override
    public int compareTo(Animal o) {
        return 0;
    }
}