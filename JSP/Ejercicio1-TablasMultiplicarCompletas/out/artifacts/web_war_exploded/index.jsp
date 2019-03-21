<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>Tablas de multiplicar del 1 al 10</h1>
<% for (int i = 1; i <= 10; i++) {
    for (int j = 1; j <= 10; j++) {%>
        <br> <%=i%> x <%=j%> = <%=i*j%>
    <%}
    %><br> -------------------------- <%
}%>
</body>
</html>