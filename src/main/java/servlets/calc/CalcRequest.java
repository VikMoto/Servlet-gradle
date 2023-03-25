package servlets.calc;

import lombok.Data;
import lombok.Getter;

@Data
public class CalcRequest {

    public int getParam1() {
        return param1;
    }

    public int getParam2() {
        return param2;
    }

    public String getOperation() {
        return operation;
    }

    private String operation;
    private int param1;
    private int param2;
}
