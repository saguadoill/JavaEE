<%--
  Created by IntelliJ IDEA.
  User: sergi
  Date: 07/04/2019
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Enviar mensaje</title>
    <style>
        div {
            height: 200px;
            width: 25%;
            border: 1px solid black;
            overflow-y: scroll;
        }
    </style>
</head>
<body>
<%
    if (session.getAttribute("usuarioLogado") == null){
        response.sendRedirect("index.jsp");
    }
%>
<h4>Envio de mensaje:</h4>

<form method="post" action="gestion">
    <textarea name="mensaje" rows="10" cols="40" placeholder="Texto del mensaje.."></textarea>
    <br>
    <label>Destinatario: </label><input type="text" width="60px" name="destinatario">
    <input type="submit" value="Enviar">
</form>
</body>
</html>
