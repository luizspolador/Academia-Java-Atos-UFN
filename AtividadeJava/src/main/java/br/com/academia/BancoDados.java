package br.com.academia;

import java.sql.*;

public class BancoDados implements InterfaceBancoDados {
    Connection conn; // variável conn do tipo Connection que armazena a conexão com DB

    // método para receber os parâmetros necessários para a conexão ao DB. Antes de executar, foi necessário criar
    // um DB chamado atividade_jdbc pelo php my admin.. logando no workbench, fiz apenas o refresh para atualizar o DB
    @Override
    public void conectar(String db_url, String db_user, String db_password) {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/atividade_jdbc", "root", "");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    // método para desconectar do DB
    @Override
    public void desconectar() {
        try {
            if (conn != null) { // verificar se a conexão está aberta. Se ela a conexão foi diferente de null, será fechada
                conn.close();
                System.out.println("DB desconectado! ");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao desconectar do banco de dados: " + e.getMessage());
        }
    }

    // Utlizado o PrepareStatement para preparar a consulta e o ResultSet para armazenar o resultado da consulta
    @Override
    public void consultar(String db_query) {
        try {
            PreparedStatement stmt = conn.prepareStatement(db_query);
            ResultSet rs = stmt.executeQuery();
            // para percorrer a consulta passando pelos 3 atributos
            while (rs.next()) {
                // Exibe cada registro retornado na consulta
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Idade: " + rs.getInt("idade"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar o banco de dados: " + e.getMessage());
        }
    }

    // aqui posso solicitar a inserção, alteração ou exclusão. Utiliza PreparedStatement para preparar
    // a consulta e um inteiro para armazenar o resultado da execução da consulta (que será o número de
    // registros afetados pela operação)
    @Override
    public int inserirAlterarExcluir(String db_query) {
        int result = 0;

        try {
            PreparedStatement stmt = conn.prepareStatement(db_query);
            result = stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir/alterar/excluir no banco de dados: " + e.getMessage());
        }
        return result;
    }

    public void deletar(Integer id) {
        String sql = "DELETE FROM pessoas WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.execute();
            ps.close();
            conn.close();
            System.out.println("deletado");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
