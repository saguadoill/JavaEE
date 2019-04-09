<%--
  Página que muestra una lista de la agenda
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.Registro" %>
<html>
<head>
    <title>Lista de Teléfonos</title>
    <link rel="stylesheet" type="text/css" href="style.css">

</head>
<body>

<table>
    <tr>
        <th>Nombre</th>
        <th>Teléfono</th>
    </tr>
<%--    Recogemos el arraylist del servlet que previamente hemos añadido como atributo de sesion--%>
    <%
        ArrayList<Registro> lista = (ArrayList<Registro>) request.getSession().getAttribute("lista");
        // Con un bucle foreach recorremos el array e imprimimos todos los registros
        for (Registro registro : lista) {%>
    <tr>
    <td><%=registro.getNombre()%></td>
    <td><%=registro.getTelefono()%></td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>