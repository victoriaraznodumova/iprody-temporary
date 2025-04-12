package enums;

public enum UserCode {
    SUM("sum array"), AVERAGE("get an average value"), SORT("sort array");

    private final String description;

    UserCode(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static UserCode valueOf(int index){
        UserCode[] values = values();
        if (index < 0 || index >= values.length){
            throw new RuntimeException("Error! Allowed codes from " + 1 + " to " + values.length);
        }
        else{
            return values[index];
        }
    }


}
