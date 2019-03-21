<%--
  Created by IntelliJ IDEA.
  User: sergi
  Date: 18/03/2019
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Resultado</title>
</head>
<body>

<%int numero = Integer.parseInt(request.getParameter("numero")); %>

<h1>Tabla de multiplicar del <%=numero%> </h1>
<%for (int i = 1; i <= 10; i++) {%>

    <br> <%=numero %> x <%=i%> = <%=numero * i%>

    <%}%>

</body>
</html>
