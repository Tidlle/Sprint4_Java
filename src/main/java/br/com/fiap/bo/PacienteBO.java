package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Paciente;
import br.com.fiap.dao.PacienteDAO;

public class PacienteBO {

    PacienteDAO pacienteDAO;

    // Selecionar
    public ArrayList<Paciente> selecionarBo() throws ClassNotFoundException, SQLException {
        pacienteDAO = new PacienteDAO();
        // Regra de negocios

        return (ArrayList<Paciente>) pacienteDAO.selecionarTodos();
    }

    // Inserir
    public void inserirBo(Paciente paciente) throws ClassNotFoundException, SQLException {
        PacienteDAO pacienteDao = new PacienteDAO();
        // Regra de negocios
        pacienteDao.inserir(paciente);
    }

    // Atualizar
    public void atualizarBo(Paciente paciente) throws ClassNotFoundException, SQLException {
        PacienteDAO pacienteDao = new PacienteDAO();
        // Regra de negocios
        pacienteDao.atualizar(paciente.getId(), paciente);
    }

    // Deletar
    public void deletarBo(int id) throws ClassNotFoundException, SQLException {
        PacienteDAO pacienteDao = new PacienteDAO();

        // Regra de negocios

        pacienteDao.deletar(id);
    }
}
