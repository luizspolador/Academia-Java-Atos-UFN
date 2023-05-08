package br.com.projeto.controller;

import br.com.projeto.model.DAO;
import br.com.projeto.model.JavaBeans;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/Controller", "/main", "/insert", "/select", "/update", "/delete"})
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;

    DAO dao = new DAO();
    JavaBeans produto = new JavaBeans();

    public Controller() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        System.out.println(action);
        if (action.equals("/main")) {
            produtos(request, response);
        } else if (action.equals("/insert")) {
            novoProduto(request, response);
        } else if (action.equals("/select")) {
            listarProduto(request, response);
        } else if (action.equals("/update")) {
            editarProduto(request, response);
        } else if (action.equals("/delete")) {
            removerProduto(request, response);
        } else {
            response.sendRedirect("index.html");
        }
    }

    // listar produtos
    protected void produtos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<JavaBeans> lista = dao.listarDados();   // obj que recebe os dados de JavaBeans
        request.setAttribute("produto", lista); // VERIFICAR!!!!!!!
        RequestDispatcher rd = request.getRequestDispatcher("produto.jsp");
        rd.forward(request, response);
    }


    protected void novoProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // setando os parâmetros
        produto.setCodigo(Integer.parseInt(request.getParameter("codigo")));
        produto.setNome(request.getParameter("nome"));
        produto.setCategoria(request.getParameter("categoria"));
        produto.setValor(Float.parseFloat(request.getParameter("valor")));
        produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));

        dao.inserirDados(produto);

        response.sendRedirect("main");
    }

    protected void listarProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id"); // recebe o id do contato que será editado
        produto.setId(Integer.parseInt(id));
        dao.selecionarDados(produto);
        request.setAttribute("id", produto.getId());
        request.setAttribute("codigo", produto.getCodigo());
        request.setAttribute("nome", produto.getNome());
        request.setAttribute("categoria", produto.getCategoria());
        request.setAttribute("valor", produto.getValor());
        request.setAttribute("quantidade", produto.getQuantidade());
        RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
        rd.forward(request, response);
    }

    protected void editarProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        produto.setId(Integer.parseInt(request.getParameter("id")));
        produto.setCodigo(Integer.parseInt(request.getParameter("codigo")));
        produto.setNome(request.getParameter("nome"));
        produto.setCategoria(request.getParameter("categoria"));
        produto.setValor(Float.parseFloat(request.getParameter("valor")));
        produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
        dao.alterarDado(produto);
        // redireciona para produto.jsp e atualiza as alterações
        response.sendRedirect("main");
    }

    protected void removerProduto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        produto.setId(Integer.parseInt(request.getParameter("id")));
        dao.deletarDados(produto);
        response.sendRedirect("main");
    }
}
