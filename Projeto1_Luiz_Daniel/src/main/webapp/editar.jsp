<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Produto do Luiz e Daniel</title>
    <link rel="icon" href="imagens/icon.jpg">
    <link rel="stylesheet" href="editar.css">
</head>
<body>
<h1>Editar produto</h1>
<form name="frmProduto" action="update" class="form-comercial">
    <h2 class="titulo-form">Editar Produto</h2>
    <div class="form-group">
        <label for="codigo">Código:</label>
        <input type="number" name="codigo" id="codigo" class="form-control" value="<%out.print(request.getAttribute("codigo"));%>">
    </div>
    <div class="form-group">
        <label for="nome">Nome:</label>
        <input type="text" name="nome" id="nome" class="form-control" value="<%out.print(request.getAttribute("nome"));%>">
    </div>
    <div class="form-group">
        <label for="categoria">Categoria:</label>
        <input type="text" name="categoria" id="categoria" class="form-control" value="<%out.print(request.getAttribute("categoria"));%>">
    </div>
    <div class="form-group">
        <label for="valor">Preço:</label>
        <input type="number" name="valor" id="valor" class="form-control" value="<%out.print(request.getAttribute("valor"));%>">
    </div>
    <div class="form-group">
        <label for="quantidade">Quantidade:</label>
        <input type="number" name="quantidade" id="quantidade" class="form-control" value="<%out.print(request.getAttribute("quantidade"));%>">
    </div>
<%--    <div class="form-group">--%>
<%--        <input type="number" name="id" id="caixa3" readonly--%>
<%--               value="<%out.print(request.getAttribute("id"));%>" style="display:none;">--%>
<%--    </div>--%>
    <div class="form-group">
        <input type="button" value="Salvar" class="btn btn-primary" onclick="validar()">
    </div>
</form>
<footer>
    <p>© Daniel e Luiz 2023</p>
</footer>

<script src="scripts/validador.js"></script>
</body>
</html>