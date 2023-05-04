package br.com.academia;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;

public class TestaBancoDados {
    public static void main(String[] args) throws IOException {

        Log meuLog = new Log("Log.txt");
        try{
            meuLog.logger.setLevel(Level.FINE);
            meuLog.logger.info("Log de informação");
            meuLog.logger.warning("Log de aviso");
            meuLog.logger.severe("Log severo");
        } catch (Exception e){
            meuLog.logger.info("Exception: " + e.getMessage());
            e.printStackTrace();
        }
        meuLog.logger.info("\n Banco iniciado!");

        Scanner sc = new Scanner(System.in);
        // Instancia um objeto da classe BancoDados
        BancoDados bd = new BancoDados();

        // Conecta ao banco de dados
        bd.conectar("jdbc:mysql://localhost:3306/cadastro", "luiz", "");


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
        meuLog.logger.info("\n id deletado: " + idDelete);

        bd.exibirDados();
        // Desconecta do banco de dados

        bd.desconectar();

    }
}

