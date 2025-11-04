package br.com.fiap.dao;

import br.com.fiap.beans.Medico;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAO {

    public Connection minhaConexao;

    public MedicoDAO() throws ClassNotFoundException, SQLException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public void inserir(Medico m) throws SQLException {
        String sql = "INSERT INTO MEDICO (NOME, CRM, ESPECIALIDADE) VALUES (?,?,?)";
        PreparedStatement ps = minhaConexao.prepareStatement(sql);
        ps.setString(1, m.getNome());
        ps.setString(2, m.getCrm());
        ps.setString(3, m.getEspecialidade());
        ps.execute(); ps.close();
    }

    public void atualizar(int id, Medico m) throws SQLException {
        String sql = "UPDATE MEDICO SET NOME=?, CRM=?, ESPECIALIDADE=? WHERE ID=?";
        PreparedStatement ps = minhaConexao.prepareStatement(sql);
        ps.setString(1, m.getNome());
        ps.setString(2, m.getCrm());
        ps.setString(3, m.getEspecialidade());
        ps.setInt(4, id);
        ps.execute(); ps.close();
    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM MEDICO WHERE ID=?";
        PreparedStatement ps = minhaConexao.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute(); ps.close();
    }

    public Medico selecionarPorId(int id) throws SQLException {
        String sql = "SELECT ID, NOME, CRM, ESPECIALIDADE FROM MEDICO WHERE ID=?";
        PreparedStatement ps = minhaConexao.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Medico m = null;
        if (rs.next()) {
            m = new Medico(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4)
            );
        }
        rs.close(); ps.close();
        return m;
    }

    public List<Medico> selecionarTodos() throws SQLException {
        String sql = "SELECT ID, NOME, CRM, ESPECIALIDADE FROM MEDICO ORDER BY ID";
        PreparedStatement ps = minhaConexao.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Medico> lista = new ArrayList<>();
        while (rs.next()) {
            lista.add(new Medico(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4)
            ));
        }
        rs.close(); ps.close();
        return lista;
    }
}
