import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "calculator" , urlPatterns = "/calculator")
public class calculator extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        int price = Integer.parseInt(request.getParameter("price"));
        float percent = Float.parseFloat(request.getParameter("percent"));

        float amount =(float)  (price*percent*0.01);
        int dis_price = (int) (price-amount);

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Description: "+description+"</h1>");
        writer.println("<h1>Price: "+price+"</h1>");
        writer.println("<h1>Percent: "+percent+"</h1>");
        writer.println("<h1>Amount: "+amount+"</h1>");
        writer.println("<h1>Dis_Price: "+dis_price+"</h1>");
        writer.println("</html>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
