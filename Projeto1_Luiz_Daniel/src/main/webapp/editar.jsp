<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Produto do Luiz e Daniel</title>
    <link rel="icon" href="imagens/icon.jpg">
    <link rel="stylesheet" href="style.css">
</head>
<body>
<h1>Editar produto</h1>
<form name="frmProduto" action="update">
    <table>
        <tr>
            <td><input type="number" name="id" id="caixa3" readonly
                       value="<%out.print(request.getAttribute("id"));%>"></td>
        </tr>
        <tr>
            <td><input type="number" name="codigo" class="caixa1" value="<%out.print(request.getAttribute("codigo"));%>"></td>
        </tr>
        
        <tr>
            <td><input type="text" name="nome" class="caixa1" value="<%out.print(request.getAttribute("nome"));%>"></td>
        </tr>
        
        <tr>
            <td><input type="text" name="categoria" class="caixa2" value="<%out.print(request.getAttribute("categoria"));%>"></td>
        </tr>
        
        <tr>
            <td><input type="number" name="valor" class="caixa1" value="<%out.print(request.getAttribute("valor"));%>">
            </td>
        </tr>
        
        <tr>
            <td><input type="number" name="quantidade" class="caixa1" value="<%out.print(request.getAttribute("quantidade"));%>"></td>
        </tr>
    </table>
    <input type="button" value="Salvar" class="botao1" onclick="validar()">
</form>
<script src="scripts/validador.js"></script>
</body>
</html>
