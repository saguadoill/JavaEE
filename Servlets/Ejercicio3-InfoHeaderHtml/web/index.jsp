<%--
    Página de inicio que redirecciona al Servlet
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <style ></style>
  </head>
  <body>
  <%--Para redireccionar directamente al Servlet--%>
  <%
    response.sendRedirect("view");
  %>
  </body>
</html>
