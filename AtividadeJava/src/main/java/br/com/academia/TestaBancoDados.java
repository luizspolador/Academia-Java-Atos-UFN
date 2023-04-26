package br.com.academia;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestaBancoDados {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Instancia um objeto da classe BancoDados
        BancoDados bd = new BancoDados();

        // Conecta ao banco de dados
        bd.conectar("jdbc:mysql://localhost:3306/cadastro", "luiz", "1234");

        // Insere 3 registros em uma tabela chamada "pessoas"
        String query = "INSERT INTO pessoas (id, nome, idade) VALUES (?, ?, ?)";

        System.out.print("ID: ");
        int id = sc.nextInt();
        System.out.print("Nome: ");
        String nome = sc.next();
        System.out.print("Idade: ");
        int idade = sc.nextInt();

        try {
            PreparedStatement stmt = bd.conn.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.setString(2, nome);
            stmt.setInt(3, idade);
            stmt.executeUpdate();
            System.out.print("Registro inserido com sucesso! /n");
            System.out.println();
            System.out.println();
        } catch (SQLException e) {
            System.out.print("Erro ao inserir registro no banco de dados: " + e.getMessage());
        }

        // Consulta os registros inseridos na tabela "pessoas"
        String selectQuery = "SELECT * FROM pessoas";
        bd.consultar(selectQuery);

        System.out.println("Qual id deseja deletar?");
        int idDelete = sc.nextInt();
        bd.deletar(idDelete);



        // Desconecta do banco de dados
        bd.desconectar();
    }
}

