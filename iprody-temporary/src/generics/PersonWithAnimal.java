package generics;

//public class PersonWithAnimal<T extends Animal & CanEat> implements  CanEat {
public class PersonWithAnimal<T extends Comparable<T>> implements  CanEat {
    private int id;
    private T animal;

    public PersonWithAnimal(int id, T animal) {
        this.id = id;
        this.animal = animal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public T getAnimal() {
        return animal;
    }

    public void setAnimal(T animal) {
        this.animal = animal;
    }
}