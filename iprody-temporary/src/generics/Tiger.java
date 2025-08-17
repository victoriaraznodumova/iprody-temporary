package generics;

public class Tiger extends Cat{
    public Tiger(String name) {
        super(name);
    }

    public void hunt(){
        System.out.println("Tiger " + getName() + " hunts");
    }
}