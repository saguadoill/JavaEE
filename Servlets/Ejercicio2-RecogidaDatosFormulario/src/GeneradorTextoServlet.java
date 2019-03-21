import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet que genera un encabezado y un texto con el formato seleccionado por el usuario
 */
@WebServlet(name = "generar")
public class GeneradorTextoServlet extends HttpServlet {

    private String encabezado;
    private int nivel;
    private StringBuilder texto;
    private String[] estilos;
    private String color;

    /*
        Como la llamada se hace a traves de un formulario con el método POST, la gestion se hace en el doPost
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        recogidaDatos(req);

        ponerEstilo();

        ponerColor();

        imprimirPorPantalla(resp);
    }

    /*
        Con este método solo recogemos los datos y los almacenamos en variables de clase para que puedan ser
        manipulados por el resto de los métodos
     */
    private void recogidaDatos(HttpServletRequest req) {
        encabezado = req.getParameter("encabezado");
        nivel = Integer.parseInt(req.getParameter("nivel-encabezado"));
        texto = new StringBuilder(req.getParameter("texto"));
        estilos = req.getParameterValues("estilo");
        color = req.getParameter("color");
    }

    /*
        Este método se encarga de añadir las etiquetas HTML correspondientes a cada estilo que haya seleccionado
        el usuario, al principio y al final del texto
     */
    private void ponerEstilo(){
        if (estilos != null){
            for (String estilo : estilos) {
                if (estilo.equalsIgnoreCase("negrita")) {
                    texto.insert(0, "<strong>");
                    texto.insert(texto.length(), "</strong>");
                }
                if (estilo.equalsIgnoreCase("cursiva")) {
                    texto.insert(0, "<i>");
                    texto.insert(texto.length(), "</i>");
                }
            }
        }
    }

    /*
        Este método se encarga de añadir las etiquetas HTML correspondientes al color que haya seleccionado
        el usuario, al principio y al final del texto
     */
    private void ponerColor(){
        switch (color) {
            case "negro":
                texto.insert(0, "<p style=\"color: black;\">");
                texto.insert(texto.length(), "</p>");
                break;
            case "verde":
                texto.insert(0, "<p style=\"color: green;\">");
                texto.insert(texto.length(), "</p>");
                break;
            case "azul":
                texto.insert(0, "<p style=\"color: blue;\">");
                texto.insert(texto.length(), "</p>");
                break;

        }
    }

    /*
        Método que imprime por pantalla el contenido HTML
     */
    private void imprimirPorPantalla(HttpServletResponse resp)throws IOException{

        PrintWriter printWriter = resp.getWriter();

        printWriter.println("<!DOCTYPE html><html>");
        printWriter.println("<head>");
        printWriter.println("<meta charset=\"UTF-8\" />");
        printWriter.println("<title>Texto Autogenerado</title>");
        printWriter.println("</head>");
        printWriter.println("<body>");

        printWriter.println("<h" + nivel + ">" + encabezado + "</h" + nivel + ">");

        printWriter.write("\n" + texto);

        printWriter.println("</body>");
        printWriter.println("</html>");
    }
}
