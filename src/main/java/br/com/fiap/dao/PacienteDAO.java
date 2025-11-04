package br.com.fiap.dao;

import br.com.fiap.beans.Paciente;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {

    public Connection minhaConexao;

    public PacienteDAO() throws ClassNotFoundException, SQLException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public void inserir(Paciente p) throws SQLException {
        String sql = "INSERT INTO PACIENTE (NOME, CPF, NASCIMENTO, TELEFONE) VALUES (?,?,TO_DATE(?, 'YYYY-MM-DD'),?)";
        PreparedStatement ps = minhaConexao.prepareStatement(sql);
        ps.setString(1, p.getNome());
        ps.setString(2, p.getCpf());
        ps.setString(3, p.getNascimento());
        ps.setString(4, p.getTelefone());
        ps.execute();
        ps.close();
    }

    public void atualizar(int id, Paciente p) throws SQLException {
        String sql = "UPDATE PACIENTE SET NOME=?, CPF=?, NASCIMENTO=TO_DATE(?, 'YYYY-MM-DD'), TELEFONE=? WHERE ID=?";
        PreparedStatement ps = minhaConexao.prepareStatement(sql);
        ps.setString(1, p.getNome());
        ps.setString(2, p.getCpf());
        ps.setString(3, p.getNascimento());
        ps.setString(4, p.getTelefone());
        ps.setInt(5, id);
        ps.execute();
        ps.close();
    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM PACIENTE WHERE ID=?";
        PreparedStatement ps = minhaConexao.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
        ps.close();
    }

    public Paciente selecionarPorId(int id) throws SQLException {
        String sql = "SELECT ID, NOME, CPF, TO_CHAR(NASCIMENTO, 'YYYY-MM-DD'), TELEFONE FROM PACIENTE WHERE ID=?";
        PreparedStatement ps = minhaConexao.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Paciente p = null;
        if (rs.next()) {
            p = new Paciente(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5)
            );
        }
        rs.close(); ps.close();
        return p;
    }

    public List<Paciente> selecionarTodos() throws SQLException {
        String sql = "SELECT ID, NOME, CPF, TO_CHAR(NASCIMENTO, 'YYYY-MM-DD'), TELEFONE FROM PACIENTE ORDER BY ID";
        PreparedStatement ps = minhaConexao.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Paciente> lista = new ArrayList<>();
        while (rs.next()) {
            lista.add(new Paciente(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5)
            ));
        }
        rs.close(); ps.close();
        return lista;
    }
}
