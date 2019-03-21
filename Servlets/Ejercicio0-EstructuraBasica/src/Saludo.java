import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Servlet  que genera el codigo HTML e indica la fecha y la hora
 */
@WebServlet(name = "/saludo")
public class Saludo extends HttpServlet {


    /*
     * Este método se usaria mas para recoger datos de Formularios. HTTP POST
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /*
     * En este caso solo usamos el método doGet porque la peticion que hacemos HTTP es GET
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        // Se genera un objeto PrintWriter para "escribir" en la pantall del navegador
        try (PrintWriter writer = response.getWriter()) {

            // Hay que escribir todas las etiquetas html
            writer.println("<!DOCTYPE html><html>");
            writer.println("<head>");
            writer.println("<meta charset=\"UTF-8\" />");
            writer.println("<title>Servlet Basico</title>");
            writer.println("</head>");
            writer.println("<body>");

            writer.println("<h1>Hola amigo, hoy es "+ LocalDate.now()+" y son las "+LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))+"</h1>");

            writer.println("</body>");
            writer.println("</html>");
        }
    }
}
