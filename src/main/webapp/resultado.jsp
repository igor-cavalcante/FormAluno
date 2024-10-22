
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Resultado Pova</title>
    <link rel="stylesheet" type="text/css" href="StyleResult.css" media="screen">
</head>
<body>

<%String aluno =(String) request.getAttribute("aluno");  %>
<%Integer acertos = (Integer) request.getAttribute("acertos"); %>
<%  String notaFormatada = (String) request.getAttribute("nota"); %>
<%   String resultado = (String) request.getAttribute("resultado"); %>


<div class="ConteinerResult">

<h1>Resultado da Prova</h1>
<h2>Aluno: <%= aluno %></h2>
<h2>Você acertou <%= acertos %> de 5 questões.</h2>
<h2>Sua nota: <%= notaFormatada %></h2>
<h2>Resultado: <%=resultado %></h2>

</div>



</body>
</html>
