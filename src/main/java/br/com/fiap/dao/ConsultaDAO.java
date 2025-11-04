package br.com.fiap.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Consulta;
import br.com.fiap.conexoes.ConexaoFactory;

public class ConsultaDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    // 🔹 Inserir uma nova consulta
    public void inserir(Consulta consulta) throws ClassNotFoundException, SQLException {
        con = ConexaoFactory.conexao();

        String sql = """
            INSERT INTO CONSULTA (
                PACIENTE_ID,
                MEDICO_ID,
                DATA_CONSULTA,
                HORA_CONSULTA,
                OBSERVACOES
            ) VALUES (?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?)
        """;

        ps = con.prepareStatement(sql);
        ps.setInt(1, consulta.getPacienteId());
        ps.setInt(2, consulta.getMedicoId());
        ps.setString(3, consulta.getData());
        ps.setString(4, consulta.getHora());
        ps.setString(5, consulta.getObservacoes());

        ps.executeUpdate();

        ps.close();
        con.close();
    }

    // 🔹 Listar todas as consultas
    public List<Consulta> selecionar() throws ClassNotFoundException, SQLException {
        List<Consulta> lista = new ArrayList<>();
        con = ConexaoFactory.conexao();

        String sql = """
            SELECT
                ID,
                PACIENTE_ID,
                MEDICO_ID,
                TO_CHAR(DATA_CONSULTA, 'YYYY-MM-DD') AS DATA,
                HORA_CONSULTA AS HORA,
                OBSERVACOES
            FROM CONSULTA
            ORDER BY ID
        """;

        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()) {
            Consulta c = new Consulta();
            c.setId(rs.getInt("ID"));
            c.setPacienteId(rs.getInt("PACIENTE_ID"));
            c.setMedicoId(rs.getInt("MEDICO_ID"));
            c.setData(rs.getString("DATA"));
            c.setHora(rs.getString("HORA"));
            c.setObservacoes(rs.getString("OBSERVACOES"));
            lista.add(c);
        }

        rs.close();
        ps.close();
        con.close();

        return lista;
    }

    // 🔹 Atualizar uma consulta
    public void atualizar(Consulta consulta) throws ClassNotFoundException, SQLException {
        con = ConexaoFactory.conexao();

        String sql = """
            UPDATE CONSULTA SET
                PACIENTE_ID = ?,
                MEDICO_ID = ?,
                DATA_CONSULTA = TO_DATE(?, 'YYYY-MM-DD'),
                HORA_CONSULTA = ?,
                OBSERVACOES = ?
            WHERE ID = ?
        """;

        ps = con.prepareStatement(sql);
        ps.setInt(1, consulta.getPacienteId());
        ps.setInt(2, consulta.getMedicoId());
        ps.setString(3, consulta.getData());
        ps.setString(4, consulta.getHora());
        ps.setString(5, consulta.getObservacoes());
        ps.setInt(6, consulta.getId());

        ps.executeUpdate();

        ps.close();
        con.close();
    }

    // 🔹 Deletar uma consulta
    public void deletar(int id) throws ClassNotFoundException, SQLException {
        con = ConexaoFactory.conexao();

        String sql = "DELETE FROM CONSULTA WHERE ID = ?";
        ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();

        ps.close();
        con.close();
    }
}
