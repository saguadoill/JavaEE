import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Servlet que registra una lista de nombres y telefonos y los muestra en pantalla
 */
@WebServlet("/gestion")
public class GestionAgenda extends HttpServlet {

    ArrayList<Registro> listaRegistros = new ArrayList<>();

    @Override
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

        printWriter.println("<table>");
        printWriter.println("<tr>");
        printWriter.println("<th> Nombre </th>");
        printWriter.println("<th> Teléfono </th>");
        printWriter.println("</tr>");

        for (Registro registro: listaRegistros) {
            printWriter.println("<tr>");
            printWriter.println("<td>"+registro.getNombre()+"</td>");
            printWriter.println("<td>"+registro.getTelefono()+"</td>");
            printWriter.println("</td>");
        }
        printWriter.println("</table>");

        printWriter.println("<p>");
        printWriter.println("<a href=\"index.jsp\">Inicio</a>");
        printWriter.println("</p>");

        printWriter.println("</body>");
        printWriter.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nombre = req.getParameter("nombre");
        String telefono = req.getParameter("telefono");

        Registro registro =new Registro(nombre,telefono);

        listaRegistros.add(registro);

        resp.sendRedirect("index.jsp");

    }
}
