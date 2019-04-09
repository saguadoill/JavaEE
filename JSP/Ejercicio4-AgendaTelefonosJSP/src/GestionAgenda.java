import bean.Registro;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet que registra una lista de nombres y telefonos y los muestra en pantalla
 */
@WebServlet("/gestion")
public class GestionAgenda extends HttpServlet {

    ArrayList<Registro> listaRegistros = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nombre = req.getParameter("nombre");
        String telefono = req.getParameter("telefono");

        Registro registro =new Registro(nombre,telefono);

        listaRegistros.add(registro);

        // Creamos un atributo de sesion con la lista de registros y asi poder recuperarla desde el jsp
        HttpSession httpSession = req.getSession(true);
        httpSession.setAttribute("lista", listaRegistros);

        resp.sendRedirect("index.jsp");

    }
}
