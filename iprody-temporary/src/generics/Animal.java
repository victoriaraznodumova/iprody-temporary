package generics;

public class Animal implements Comparable<Animal>{
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void walk(){
        System.out.println(getName() + " walks");
    }

    public void wash(){
        System.out.println(getName() + " washes");
    }

    @Override
    public int compareTo(Animal o) {
        return 0;
    }
}