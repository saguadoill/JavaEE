import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Servlet que devuelve un listado de los libros de la BBDD y saluda al usuario
 */
@WebServlet("/listado")
public class ListadoLibros extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Recuperamos el nombre del usuario desde el atributo de sesión
        String usuario = req.getSession().getAttribute("login").toString();

        // Sentencia para buscar todos los libros
        String sql = "SELECT * FROM libros";

        PrintWriter printWriter = resp.getWriter();

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        printWriter.println("<!DOCTYPE html><html>");
        printWriter.println("<head>");
        printWriter.println("<meta charset=\"UTF-8\" />");
        printWriter.println("<title>Home</title>");
        printWriter.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
        printWriter.println("</head>");
        printWriter.println("<body>");

        printWriter.println("<h2> Hola "+usuario+"</h2>");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/biblioteca", "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            printWriter.println("<table>");
            printWriter.println("<tr>");
            printWriter.println("<th>");
            printWriter.println("Titulo");
            printWriter.println("</th>");
            printWriter.println("<th>");
            printWriter.println("Autor");
            printWriter.println("</th>");
            printWriter.println("<th>");
            printWriter.println("Precio");
            printWriter.println("</th>");
            printWriter.println("</tr>");
            while (resultSet.next()) {
                printWriter.println("<tr>");
                printWriter.println("<td>");
                printWriter.println(""+resultSet.getString(3));
                printWriter.println("</td>");
                printWriter.println("<td>");
                printWriter.println(""+resultSet.getString(5));
                printWriter.println("</td>");
                printWriter.println("<td>");
                printWriter.println(""+resultSet.getString(4));
                printWriter.println("</td>");
                printWriter.println("</tr>");
            }
            printWriter.println("</table>");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        printWriter.println("</body>");
        printWriter.println("</html>");

    }
}
