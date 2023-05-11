package br.com.projeto.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
    //parâmetros de conexão
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3306/projeto1?useTimezone=true&serverTimezone=UTC";
    private String user = "root";
    private String password = "";

    // métodos conexão
    private Connection conectar() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    // create
    public void inserirDados(Produtos contato) {
        String create = "insert into produto (codigo, nome, categoria, valor, quantidade) values (?,?,?,?,?)"; // query
        try {
            Connection con = conectar(); // abrindo a conexão
            PreparedStatement pst = con.prepareStatement(create); // preparando a query create
            pst.setString(1, contato.getCodigo());   // trocando os ? pelo conteudo das variaveis
            pst.setString(2, contato.getNome());
            pst.setString(3, contato.getCategoria());
            pst.setString(4, contato.getValor());
            pst.setString(5, contato.getQuantidade());

            pst.executeUpdate();
            con.close(); // encerrando o banco
        } catch (Exception e) {
            System.out.println(e + "burro do caralho");
        }
    }

    // read
    public ArrayList<Produtos> listarDados() {
        ArrayList<Produtos> produtos = new ArrayList<>(); // objeto para acessar JavaBeans
        String read = "select * from produto order by id";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {  // laço para exibição dos dados
                Integer id = rs.getInt(1);
                String codigo = rs.getString(2);
                String nome = rs.getString(3);
                String categoria = rs.getString(4);
                String valor = rs.getString(5);
                String quantidade = rs.getString(6);
                produtos.add(new Produtos(id, codigo, nome, categoria, valor, quantidade));    // adiciona o conteudo das variaveis
            }
            con.close();
            return produtos;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    //update
    public void selecionarDados(Produtos produto) {
        String read2 = "select * from produto where id = ?";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read2);
            pst.setInt(1, produto.getId());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) { // setando variaveis JavaBeans
                produto.setId(rs.getInt(1));
                produto.setCodigo(rs.getString(2));
                produto.setNome(rs.getString(3));
                produto.setCategoria(rs.getString(4));
                produto.setValor(rs.getString(5));
                produto.setQuantidade(rs.getString(6));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // edit
    public void alterarDado(Produtos produto) {
        String create = "update produto set codigo=?,nome=?,categoria=?,valor=?,quantidade=? where id=?";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(create);
            pst.setString(1, produto.getCodigo());
            pst.setString(2, produto.getNome());
            pst.setString(3, produto.getCategoria());
            pst.setString(4, produto.getValor());
            pst.setString(5, produto.getQuantidade());
            pst.setInt(6, produto.getId());
            pst.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // remove
    public void deletarDados(Produtos produto) {
        String delete = "delete from produto where id=?";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(delete);
            pst.setInt(1, produto.getId());
            pst.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
