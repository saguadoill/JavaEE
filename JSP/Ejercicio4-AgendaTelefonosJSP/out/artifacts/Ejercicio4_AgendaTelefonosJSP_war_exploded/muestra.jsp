<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: sergi
  Date: 03/04/2019
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <%
        ArrayList<Registro> lista = (ArrayList<Registro>) request.getSession().getAttribute("lista");
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