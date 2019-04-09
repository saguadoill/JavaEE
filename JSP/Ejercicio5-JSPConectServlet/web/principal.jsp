<%--
    Página que saluda al usuario y le permite elegir entre dos opciones, enviar o ver los mensajes recibidos
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Menu</title>
</head>
<body>
<%--Comprobamos si ya hay una sesion activa, es decir si se ha hecho login. Si no es asi, se redirige al index--%>
<%
    if (session.getAttribute("usuarioLogado") == null){
        response.sendRedirect("index.jsp");
    }
    out.print("Hola "+session.getAttribute("usuarioLogado"));
%>
<p>
    <a href="enviar.jsp">Enviar mensaje</a>
</p>
<p>
    <a href="gestion">Mostrar mensajes</a>
</p>
</body>
</html>
