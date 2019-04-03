
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

/**
 * Servlet que consulta a la Base de Datos el login del usuario. Si es correcto le redirecciona a la página con el listado de libros,
 * en caso de ser erróneo devuelve a la página principal.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

        /*
            Aunque los datos vengan de un formulario, como lo que vamos a hacer es rediriguir a otra pñagina,
            se tiene que hacer desde el doGet(), ya que en el doPost() no se puede usar sendRedirect().
         */

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Guardamos en dos variables el nombre de usuario y la constraseña
        String usuario = req.getParameter("usuario");
        String passwd = req.getParameter("passwd");

        // Sentencia SQL para buscar al usuario en la BBDD
        String sql = "SELECT * FROM clientes WHERE usuario=? AND passwd=?";

        // Creamos un atributo de sesion con el nombre del usuario
        HttpSession httpSession = req.getSession(true);
        httpSession.setAttribute("login", usuario);

        // realizamos conexion a la BBDD y la consulta
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/biblioteca", "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, passwd);

            // El ResultSet es donde se guardará el resultado de la consulta
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                resp.sendRedirect("listado");
            } else {
                resp.sendRedirect("/index.jsp");
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
