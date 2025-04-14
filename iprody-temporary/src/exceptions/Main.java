package exceptions;

import static exceptions.Test.test;

public class Main {
    public static void main(String[] args) {
        try {
            test();
        } catch (UserCodeException e) {
            System.out.println(e.getMessage());
        }
    }
}
