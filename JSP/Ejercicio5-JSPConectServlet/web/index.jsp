<%--
    Página para hacer login de la aplicación de mensajes
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
  </head>
  <body>
  <form action="login" method="get">
    Usuario:<br>
    <input type="text" name="usuario" placeholder="Nombre de usuario">
    <br>
    Contraseña:<br>
    <input type="password" name="passwd" placeholder="Contraseña">
    <br><br>
    <input type="submit" value="Submit">
  </form>
  </body>
</html>
