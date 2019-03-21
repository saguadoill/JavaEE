<%--
    Página JSP que recoge el request del index y muestra la tabla de
    multiplicar de ese numero.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="error.jsp" %>
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
<>
</body>
</html>
