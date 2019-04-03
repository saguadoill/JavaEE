import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet que verifica si el usuario y contraseña son correctos. En caso afirmativo muestra en pantalla un mensaje de bienvenida.
 * Por el contrario si no son correctos, redirige de nuevo a la página principal
 */
@WebServlet("/control")
public class ControlServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter printWriter = resp.getWriter();

        Boolean usuario = req.getParameter("usuario").equals("pepe");

        Boolean passwd = req.getParameter("passwd").equals("1234");


        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        printWriter.println("<!DOCTYPE html><html>");
        printWriter.println("<head>");
        printWriter.println("<meta charset=\"UTF-8\" />");
        printWriter.println("<title>Home</title>");
        printWriter.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
        printWriter.println("</head>");
        printWriter.println("<body>");

        if (usuario & passwd){
            printWriter.println("<h1> Bienvenido Señor "+req.getParameter("usuario")+"</h1>");
        }else {
            resp.sendRedirect("index.jsp");
        }

        printWriter.println("</body>");
        printWriter.println("</html>");

    }
}
