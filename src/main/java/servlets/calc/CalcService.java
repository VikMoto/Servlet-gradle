package servlets.calc;

public class CalcService {
    public CalcResponse calculate(CalcRequest request) {
        int result = 0;
        String operation = request.getOperation();
        switch (operation){
            case "+" ->  result = request.getParam1() + request.getParam2();
            case "-" ->  result = request.getParam1() - request.getParam2();
            case "*" ->  result = request.getParam1() * request.getParam2();
            case "/" ->  result = request.getParam1() / request.getParam2();
            default -> throw new IllegalStateException("Unexpected value: " + request.getOperation());
        }
        CalcResponse calcResponse = new CalcResponse();
        calcResponse.setRequest(request);
        calcResponse.setResult(result);
       return calcResponse;
    }
}
