<%--
   Página encargada de mostrar los mensajes revibidos
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>Mostrar mensajes</title>
</head>
<body>
<h3>Mensajes recibidos:</h3>
<%--Recuperamos el atributo de sesión con el arrayList. Lo recorremos y mostramos todos los mensajes--%>
<%
    if (session.getAttribute("usuarioLogado") == null){
        response.sendRedirect("index.jsp");

    }else {
        for (String mensaje: (ArrayList<String>)session.getAttribute("listaMensajes")) {

            out.print(mensaje+"<br/>");

        }
    }
%>

</body>
</html>
