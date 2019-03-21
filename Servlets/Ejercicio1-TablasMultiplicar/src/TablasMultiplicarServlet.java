import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "/tablas")
public class TablasMultiplicarServlet extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        try (PrintWriter writer = resp.getWriter()) {

            writer.println("<!DOCTYPE html><html>");
            writer.println("<head>");
            writer.println("<meta charset=\"UTF-8\" />");
            writer.println("<title>Tablas Multiplicar</title>");
            writer.println("</head>");
            writer.println("<body>");

            writer.println("<h1>Tablas de multiplicar del 1 al 10</h1>");

            for (int i = 1; i <=10 ; i++) {
                writer.println("<br/><strong>Tabla del "+i+"</strong>");
                for (int j = 1; j <=10 ; j++) {

                    writer.println("<br/>"+i+" x "+j+" = "+(i*j));

                }
                writer.println("<br/>");
            }

            writer.println("</body>");
            writer.println("</html>");
        }

    }
}
