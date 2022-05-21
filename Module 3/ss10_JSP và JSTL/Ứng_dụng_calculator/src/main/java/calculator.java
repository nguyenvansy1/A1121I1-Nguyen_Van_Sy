import java.io.IOException;
import java.io.PrintWriter;

@javax.servlet.annotation.WebServlet(name = "calculator", urlPatterns = "/calculator")
public class calculator extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        float first_operand = Float.parseFloat(request.getParameter("first-operand"));
        float second_operand = Float.parseFloat(request.getParameter("second-operand"));
        char operator = request.getParameter("operator").charAt(0);
        float result =0;
        switch (operator){
            case '+':
                result = first_operand + second_operand;
                break;
            case '-':
                result = first_operand - second_operand;
                break;
            case '*':
                result = first_operand * second_operand;
                break;
            case '/':
                try {
                    result = first_operand / second_operand;
                }catch (Exception e){
                    System.out.println("Error dividing by 0:");
                }
                break;
            
        }
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("Result: ");
        writer.println(first_operand + " " + operator + " " + second_operand + " = " + result);
        writer.println("</html>");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
