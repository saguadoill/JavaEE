import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Servlet que imprime por pantalla todos los datos de las cabeceras enviadas e informacion del origen de la peticion
 */
@WebServlet("/view")
public class ViewHeaders extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Enumeration<String> listaHeaders = req.getHeaderNames();
        PrintWriter printWriter = resp.getWriter();

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        printWriter.println("<!DOCTYPE html><html>");
        printWriter.println("<head>");
        printWriter.println("<meta charset=\"UTF-8\" />");
        printWriter.println("<title>Encabezados</title>");
        printWriter.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
        printWriter.println("</head>");
        printWriter.println("<body>");

        printWriter.println("<table style=\"border: 1px solid\">");

        printWriter.println("<tr>");
        printWriter.println("<th>Host de la llamada</th>");
        printWriter.println("<td>" + req.getRemoteHost() + "</td>");
        printWriter.println("</tr>");

        printWriter.println("<tr>");
        printWriter.println("<th>Direccion IP</th>");
        printWriter.println("<td>" + req.getRemoteAddr() + "</td>");
        printWriter.println("</tr>");

        printWriter.println("<tr>");
        printWriter.println("<th>Protocolo</th>");
        printWriter.println("<td>" + req.getProtocol() + "</td>");
        printWriter.println("</tr>");

        printWriter.println("<tr>");
        printWriter.println("<th>Metodo</th>");
        printWriter.println("<td>" + req.getMethod() + "</td>");
        printWriter.println("</tr>");

        while (listaHeaders.nextElement() != null) {
            printWriter.println("<tr>");
            printWriter.println("<th>" + listaHeaders.nextElement() + "</th>");
            printWriter.println("<td>" + req.getHeader(listaHeaders.nextElement()) + "</td>");
            printWriter.println("</tr>");
        }
        printWriter.println("</table>");

        printWriter.println("</body>");
        printWriter.println("</html>");

    }
}
