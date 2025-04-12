package enums;

public enum DayOfWeek {
    MONDAY ("monday"),
    TUESDAY ("tuesday"),
    WEDNESDAY ("wednesday"),
    THURSDAY("thursday");

    private final String name;

    DayOfWeek(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void doSomething(){
        System.out.println("so sth");
    }

}