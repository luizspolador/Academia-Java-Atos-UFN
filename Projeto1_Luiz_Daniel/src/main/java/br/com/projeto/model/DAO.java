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
    public void inserirDados(JavaBeans contato) {
        String create = "insert into produto (codigo, nome, categoria, valor, quantidade) values (?,?,?,?,?)"; // query
        try {
            Connection con = conectar(); // abrindo a conexão
            PreparedStatement pst = con.prepareStatement(create); // preparando a query create
            pst.setInt(1, contato.getCodigo());   // trocando os ? pelo conteudo das variaveis
            pst.setString(2, contato.getNome());
            pst.setString(3, contato.getCategoria());
            pst.setFloat(4, contato.getValor());
            pst.setInt(5, contato.getQuantidade());

            pst.executeUpdate();
            con.close(); // encerrando o banco
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // read
    public ArrayList<JavaBeans> listarDados() {
        ArrayList<JavaBeans> produtos = new ArrayList<>(); // objeto para acessar JavaBeans
        String read = "select * from produto order by id";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {  // laço para exibição dos dados
                Integer id = rs.getInt(1);
                Integer codigo = rs.getInt(2);
                String nome = rs.getString(3);
                String categoria = rs.getString(4);
                float valor = rs.getFloat(5);
                Integer quantidade = rs.getInt(6);
                produtos.add(new JavaBeans(id, codigo, nome, categoria, valor, quantidade));    // adiciona o conteudo das variaveis
            }
            con.close();
            return produtos;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    //update
    public void selecionarDados(JavaBeans produto) {
        String read2 = "select * from produto where id = ?";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read2);
            pst.setInt(1, produto.getId());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) { // setando variaveis JavaBeans
                produto.setId(rs.getInt(1));
                produto.setCodigo(rs.getInt(2));
                produto.setNome(rs.getString(3));
                produto.setCategoria(rs.getString(4));
                produto.setValor(rs.getFloat(5));
                produto.setQuantidade(rs.getInt(6));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // edit
    public void alterarDado(JavaBeans produto) {
        String create = "update produto set codigo=?,nome=?,categoria=?,valor=?,quantidade=? where id=?";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(create);
            pst.setInt(1, produto.getId());
            pst.setInt(2, produto.getCodigo());
            pst.setString(3, produto.getNome());
            pst.setString(4, produto.getCategoria());
            pst.setFloat(5, produto.getValor());
            pst.setInt(6, produto.getQuantidade());
            pst.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // remove
    public void deletarDados(JavaBeans produto) {
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
