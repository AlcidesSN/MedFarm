<% Date Date; %>
<%@ page import="java.util.Date" %>
<%@ page import="com.example.medfarm.Models.Paciente" %>
<%--
  Created by IntelliJ IDEA.
  User: alcid
  Date: 21/05/2024
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Criar Receita</title>

</head>
<body>
<form>

    <label>Paciente:</label>
    <select id="lista" name="paciente">

    </select><br>
    <label>Médico:</label>
    <label>${nome}</label><br>
    <label>Remedio:</label>
    <select multiple="multiple" name="remedios">
        <option value="">${remedio.nome}</option>
    </select>
    <br>
    <label>Farmacia:</label>
    <select nome="farmacia">
            <option value=""></option>
    </select><br>
    <input type="hidden" value="<%=Date = new Date()%>">
    <script src="/js/new.js"></script>
</form>
</body>
</html>
