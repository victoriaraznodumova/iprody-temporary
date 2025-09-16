package streams;

public class Walker implements WalkInterface{
    @Override
    public void walk(int meters) {
        System.out.println("walk " + meters + " value: " + 15);
    }

    public static void print(String name) {
        System.out.println(name);
    }



}