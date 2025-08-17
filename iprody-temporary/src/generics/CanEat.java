package generics;

public interface CanEat {
    default void canEat(){
        System.out.println("eat");
    }

//    void someMethod(T animal);
}