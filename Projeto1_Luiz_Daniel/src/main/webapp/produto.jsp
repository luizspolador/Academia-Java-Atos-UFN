<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="br.com.projeto.model.JavaBeans" %>
<%@ page import="java.util.ArrayList" %>

<%
    ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("produto"); // recebendo o obj lista
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="utf-8">
    <title>Produtos do Luiz e Daniel</title>
    <link rel="icon" href="imagens/icon.jpg">
    <link rel="stylesheet" href="style.css">
</head>
<body>
<h1>Produtos LD</h1>
<a href="novo.html" class="botao1">Novo produto</a>
<table class="tabela">
    <thead>
    <tr>
        <th>Id</th>
        <th>Código</th>
        <th>Nome</th>
        <th>Categoria</th>
        <th>Valor</th>
        <th>Quantidade</th>
    </tr>
    </thead>
    <tbody>
    <% for (int i = 0; i < lista.size(); i++) {%>
    <tr>
        <td><%=lista.get(i).getId()%>
        </td>
        <td><%=lista.get(i).getCodigo()%>
        </td>
        <td><%=lista.get(i).getNome()%>
        </td>
        <td><%=lista.get(i).getCategoria()%>
        </td>
        <td><%=lista.get(i).getValor()%>
        </td>
        <td><%=lista.get(i).getQuantidade()%>
        </td>
        <td><a href="select?id=<%=lista.get(i).getId()%>" class="botao1">Editar</a>
            <a href="javascript: confirmar(<%=lista.get(i).getId()%>)" class="botao2">Excluir</a>
        </td>
    </tr>
    <%} %>
    </tbody>
</table>
<script src="scripts/confirmador.js"></script>
</body>
</html>
