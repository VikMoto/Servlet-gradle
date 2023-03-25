package servlets.calc;

import lombok.Data;

@Data
public class CalcResponse {
    private CalcRequest request;
    private  int result;

    public void setRequest(CalcRequest request) {
        this.request = request;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
