package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Medico;
import br.com.fiap.dao.MedicoDAO;

public class MedicoBO {

    MedicoDAO medicoDAO;

    // Selecionar
    public ArrayList<Medico> selecionarBo() throws ClassNotFoundException, SQLException {
        medicoDAO = new MedicoDAO();
        // Regra de negocios

        return (ArrayList<Medico>) medicoDAO.selecionarTodos();
    }

    // Inserir
    public void inserirBo(Medico medico) throws ClassNotFoundException, SQLException {
        MedicoDAO medicoDao = new MedicoDAO();
        // Regra de negocios
        medicoDao.inserir(medico);
    }

    // Atualizar
    public void atualizarBo(Medico medico) throws ClassNotFoundException, SQLException {
        MedicoDAO medicoDao = new MedicoDAO();
        // Regra de negocios
        medicoDao.atualizar(medico.getId(), medico);
    }

    // Deletar
    public void deletarBo(int id) throws ClassNotFoundException, SQLException {
        MedicoDAO medicoDao = new MedicoDAO();

        // Regra de negocios

        medicoDao.deletar(id);
    }
}
