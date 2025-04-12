package enums;

import java.util.Arrays;

public enum UserCode {
    SUM(1, "sum array"),
    AVERAGE(2, "get an average value"),
    SORT(3, "sort array"),
    EXIT(4, "exit");

    private final String description;
    private final int code;

    UserCode(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }

    public static UserCode valueOf(int code){
        UserCode[] values = values();
        for (UserCode userCode: values) {
            if (userCode.code == code){
                return userCode;
            }
        }
        int[] codes = new int[values.length];
        for(int i = 0; i < codes.length; i++) {
            codes[i] = values[i].code;
        }
        throw new RuntimeException("Error! Allowed codes: " + Arrays.toString(values));
    }
}