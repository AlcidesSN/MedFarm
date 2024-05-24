<%--
  Created by IntelliJ IDEA.
  User: alcid
  Date: 20/05/2024
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Tratamento de variaveis-->


<html>
<head>
    <title></title>
    <script src="/js/loginaceito.js"></script>
</head>
    <body>
    <h3>Dados Médico</h3>
    <p><strong>Nome:</strong>${nome = nome.replace("-", " ")}</p>
    <p><strong>crm:</strong>${crm}</p>
    <h3>Receitas</h3>
    <a href="/Medico/nova-receita">Criar nova receita</a>



</body>
</html>
