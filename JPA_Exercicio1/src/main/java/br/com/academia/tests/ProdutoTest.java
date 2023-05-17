package br.com.academia.tests;

import br.com.academia.model.Categoria;
import br.com.academia.model.Produto;
import br.com.academia.model.dao.CategoriaDAO;
import br.com.academia.model.dao.ProdutoDAO;

public class ProdutoTest {
    public static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAO();
        CategoriaDAO catdao = new CategoriaDAO();

        Produto produto = new Produto();
        Categoria categoria = new Categoria();


        // SALVADO e/ou alterando o objeto produto
        categoria.setId(2); //--> para update
        categoria.setDescricao("Análise do polimorfismo genético Delta 32");
        catdao.save(categoria);

        produto.setId(2); //--> para update
        produto.setDescricao("Tubo de ensaio");
        produto.setQuantidade(20);
        produto.setValor(30.00);
        produto.setCategoria(categoria);
        dao.save(produto);

        //pesquisando pelo ID
//        Produto produto1 = dao.findById(2);
//        System.out.println(produto1);


        //pesquisando todos os produtos
//        for (Produto produto2 : dao.findAll()){
//            System.out.println(produto2);
//        }


        //deletando um produto e uma categoria pelo id
        //dao.remove(3); // remove o produto
        //catdao.remove(1); // remove a categoria

    }
}
