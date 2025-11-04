package br.com.fiap.main;
import br.com.fiap.conexoes.ConexaoFactory;
import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection c = ConexaoFactory.conexao();
        System.out.println("Conectado com sucesso: " + (c!=null));
    }
}
