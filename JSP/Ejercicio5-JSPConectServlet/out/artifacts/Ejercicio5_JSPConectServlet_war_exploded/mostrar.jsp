<%@ page import="java.util.ArrayList" %>
<%@ page import="com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack" %><%--
  Created by IntelliJ IDEA.
  User: sergi
  Date: 07/04/2019
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mostrar mensajes</title>
</head>
<body>
<h3>Mensajes recibidos:</h3>
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
