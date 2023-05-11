<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="br.com.projeto.model.Produtos" %>
<%@ page import="java.util.ArrayList" %>

<%
    ArrayList<Produtos> lista = (ArrayList<Produtos>) request.getAttribute("produto"); // recebendo o obj lista
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="utf-8">
    <title>Produtos do Luiz e Daniel</title>
    <link rel="icon" href="imagens/icon.jpg">
    <link rel="stylesheet" href="produto.css">
</head>
<body>
<h1>Produtos LD</h1>
<a href="novo.html" class="botaoCriar">Novo produto</a>
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
        <td class="lista"><%=lista.get(i).getId()%>
        </td>
        <td class="lista"><%=lista.get(i).getCodigo()%>
        </td>
        <td class="lista"><%=lista.get(i).getNome()%>
        </td>
        <td class="lista"><%=lista.get(i).getCategoria()%>
        </td>
        <td class="lista"><%=lista.get(i).getValor()%>
        </td>
        <td class="lista"><%=lista.get(i).getQuantidade()%>
        </td>
        <td><a href="select?id=<%=lista.get(i).getId()%>" class="botao1">Editar</a>
            <a href="javascript: confirmar(<%=lista.get(i).getId()%>)" class="botao2">Excluir</a>
        </td>
    </tr>
    <%} %>
    </tbody>
    <footer>
        <p>© Daniel e Luiz 2023</p>
    </footer>
</table>
<script src="scripts/confirmador.js"></script>
</body>
</html>
