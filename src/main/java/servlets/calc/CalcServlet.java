package servlets.calc;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

@WebServlet(value = "/calc")
public class CalcServlet extends HttpServlet {
    private CalcService calcService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        calcService = new CalcService();
        super.init(config);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CalcRequest calcRequest = mapToCalcRequest(req);
        CalcResponse calcResponse = calcService.calculate(calcRequest);

        resp.setContentType("application/json");

        try (var writer = resp.getWriter()) {

            writer.write(new Gson().toJson(calcResponse));

        }
    }



    private CalcRequest mapToCalcRequest(HttpServletRequest request) throws IOException {
        String body = "";
        CalcRequest result ;

        try {
            body = request
                    .getReader()
                    .lines()
                    .collect(Collectors.joining("\n"));
        }catch (IOException e) {
            e.printStackTrace();
        }


        Type type = new TypeToken<CalcRequest>(){}.getType();

        result = new Gson().fromJson(body, CalcRequest.class);
        return result;

    }




    @Override
    public void destroy() {
        super.destroy();
    }
}
