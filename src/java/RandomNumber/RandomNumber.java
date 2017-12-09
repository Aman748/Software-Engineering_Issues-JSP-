package RandomNumber;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aman
 */
@WebServlet(urlPatterns = {"/RandomNumber"})
public class RandomNumber extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RandomNumber</title>");            
            out.println("</head>");
            out.println("<body style=\"padding:100px 15%;font-size: 20px;\">");
            out.println("<table><tr><td><Strong>Random numbers: </Strong></td><td>");
            int total = 0;
            Random r = new Random();
            for(int i=0;i<10;i++){
                int rn = r.nextInt((200 - 100) + 1) + 100;
                out.println(rn);
                if(i!=9)out.print(", ");else out.print(".");
                total+=rn;
            }
            out.println("</td></tr><tr><td><Strong>Total: </Strong></td><td>"+total+". </td></tr></table>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
