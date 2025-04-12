import enums.DayOfWeek;

public class Main {
    public static void main(String[] args) {
//        Sub sub = new Sub();
//        var aSuper = new Super();
//        System.out.println(aSuper.getValue());
//        sub.setValue(2);
//        System.out.println(sub.getValue());
//        System.out.println(aSuper.getValue());


        DayOfWeek dayOfWeek = DayOfWeek.THURSDAY;
        switch (dayOfWeek){
            case MONDAY -> System.out.println("monday");

        }
        int id = switch (dayOfWeek){
            case MONDAY -> 1;
            case TUESDAY -> 2;
            case WEDNESDAY -> 3;
            default -> 4;
        };

        dayOfWeek.ordinal();
        for (DayOfWeek value: DayOfWeek.values()) {
            
        }

        DayOfWeek dayOfWeek1 = DayOfWeek.valueOf("TUESDAY");
        System.out.println(dayOfWeek1.getName());
        System.out.println(dayOfWeek1.name());


    }
}
