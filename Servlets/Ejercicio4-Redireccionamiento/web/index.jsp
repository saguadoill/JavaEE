<%--
    Página que recoge un usuario y contraseña y los envia al Servlet apra su comproibación
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Redireccionamiento</title>
  </head>
  <body>
  <form action="control">
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
