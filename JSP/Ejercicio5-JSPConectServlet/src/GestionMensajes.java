import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * Servlet encargado de enviar los mensajes juento con su destinatario y remitente a la base de datos, asi como recibirlos.
 */
@WebServlet("/gestion")
public class GestionMensajes extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String usuario = req.getSession().getAttribute("usuarioLogado").toString();

        // Creamos un arrayList para guardar todos los mensajes y mostrarlos postariormente
        ArrayList<String> listaMensajes = new ArrayList<>();

        // Creamos la conexion a la BBDD
        Connection connection = new CrearConexion().conectar();

        // Creamos la sentencia SQL que vamos a utilizar para recuperar todos los mensajes enviados al usuario.
        String sql = "SELECT texto FROM mensajes WHERE destinatario = ?";

        // Realizamos la consulta a la BBDD y guardamos la respuesta en un ResultSet y asu vez en el arrayList
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,usuario);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                listaMensajes.add(resultSet.getString("texto"));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Creamos un atributo de sesion para enviar la lista de mensajes a la página jsp para que se muestren
        HttpSession session = req.getSession();
        session.setAttribute("listaMensajes",listaMensajes);
        resp.sendRedirect("mostrar.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Recogemoso los datos del formulario
        String destinatario = req.getParameter("destinatario");
        String mensaje = req.getParameter("mensaje");
        String remitente = req.getSession().getAttribute("usuarioLogado").toString();

        // Creamos la conexion
        Connection connection = new CrearConexion().conectar();

        // Creamos la sentencia SQL para la inserción de los datos
        String sql = "INSERT INTO mensajes VALUES (null,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,destinatario);
            preparedStatement.setString(2,remitente);
            preparedStatement.setString(3,mensaje);

            preparedStatement.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("principal.jsp");
    }
}
