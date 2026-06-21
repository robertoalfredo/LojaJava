<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="cadastroee.model.Produto"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Produtos</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- (Opcional) Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body class="container">

<h1 class="mt-4">Lista de Produtos</h1>

<!-- BOTÃO INCLUIR -->
<a href="ServletProdutoFC?acao=formIncluir" class="btn btn-primary m-2">
    Novo Produto
</a>

<table class="table table-striped">

    <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Quantidade</th>
            <th>Preço</th>
            <th>Ações</th>
        </tr>
    </thead>

    <tbody>

    <%
        List<Produto> lista = (List<Produto>) request.getAttribute("lista");

        if (lista != null && !lista.isEmpty()) {
            for (Produto p : lista) {
    %>

        <tr>
            <td><%= p.getId() %></td>
            <td><%= p.getNome() %></td>
            <td><%= p.getQuantidade() %></td>
            <td><%= p.getPrecoVenda() %></td>

            <td>
                <!-- ALTERAR -->
                <a href="ServletProdutoFC?acao=formAlterar&id=<%= p.getId() %>"
                   class="btn btn-primary btn-sm">
                    Alterar
                </a>

                <!-- EXCLUIR -->
                <a href="ServletProdutoFC?acao=excluir&id=<%= p.getId() %>"
                   class="btn btn-danger btn-sm">
                    Excluir
                </a>
            </td>
        </tr>

    <%
            }
        } else {
    %>

        <!-- Caso não tenha dados -->
        <tr>
            <td colspan="5" class="text-center">
                Nenhum produto cadastrado.
            </td>
        </tr>

    <%
        }
    %>

    </tbody>

</table>

</body>
</html>
