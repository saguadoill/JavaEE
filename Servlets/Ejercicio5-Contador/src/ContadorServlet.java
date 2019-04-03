import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet que contiene un contador el cual va sumando o restando segun el request que reciva del usuario
 */
@WebServlet("/contador")
public class ContadorServlet extends HttpServlet {

    private int contador;

    public void init() throws ServletException {

        this.contador = 0;

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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

        if (req.getParameter("operacion").equals("aumentar")){
            contador++;
        }else if (req.getParameter("operacion").equals("disminuir")){
            contador--;
        }

        printWriter.println("<h2>El contador vale: "+contador+"</h2>");
        printWriter.println("<br>");
        printWriter.println("<a href = \""+req.getContextPath()+"\">Inicio</a>");

        printWriter.println("</body>");
        printWriter.println("</html>");

    }


}
