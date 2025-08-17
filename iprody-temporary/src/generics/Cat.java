package generics;

public class Cat extends Animal{


    public Cat(String name) {
        super(name);
    }

    @Override
    public int compareTo(Animal o) {
        return 0;
    }

    public void wash(){
        System.out.println(getName() + " washes");
    }
}