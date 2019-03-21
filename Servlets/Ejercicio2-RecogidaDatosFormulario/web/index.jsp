<%--
  Página web que recoge un encabezado, texto y posibles formatos de los mismos para enviar a un Servlet
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TextGenerator</title>
</head>
<body>
<hr width="75%" size="2" noshade="noshade" style="color: black">
<form style="text-align: center" action="generar" method="post">
    <p>
        <label>Introducir encabezado:</label> <input type="text" size="50" name="encabezado">
    </p>
    <p>
        <label>Eliga nivel del encabezado:</label>
        <%--Autogeneramos con JSP los niveles de encabezados que hay en HTML--%>
        <select name="nivel-encabezado">
            <%
                for (int i = 1; i <= 6; i++) {%>
            <option value="<%=i%>"><%=i%>
            </option>
            <%
                }
            %>
        </select>
    </p>
    <p>
        <label>Introduce texto:</label>
        <br>
        <textarea name="texto" rows="7" cols="40" placeholder="Contenido del artículo.."></textarea>
    </p>
    <p>
        <label>Estilos de texto:</label>
        <br>
        <input type="checkbox" name="estilo" value="negrita">Negrita
        <br>
        <input type="checkbox" name="estilo" value="cursiva">Cursiva
    </p>
    <p>
        <label>Color del texto:</label>
        <br>
        <input type="radio" name="color" value="negro" checked>Negro
        <br>
        <input type="radio" name="color" value="verde">Verde
        <br>
        <input type="radio" name="color" value="azul">Azul
    </p>
    <p>
        <input type="submit" value="Generar">
    </p>
</form>

</body>
</html>
