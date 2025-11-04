package br.com.fiap.beans;

public class Consulta {

    private int id;
    private int id_paciente;
    private int id_medico;
    private String data;       // 'YYYY-MM-DD'
    private String hora;       // 'HH:mm'
    private String observacoes;

    public Consulta() {}

    public Consulta(int id, int id_paciente, int id_medico, String data, String hora, String observacoes) {
        this.id = id;
        this.id_paciente = id_paciente;
        this.id_medico = id_medico;
        this.data = data;
        this.hora = hora;
        this.observacoes = observacoes;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getPacienteId() { return id_paciente; }
    public void setPacienteId(int id_paciente) { this.id_paciente = id_paciente; }

    public int getMedicoId() { return id_medico; }
    public void setMedicoId(int id_medico) { this.id_medico = id_medico; }

    public String getData() { return data; }
    public void setData(String data) { this.data = data; }

    public String getHora() { return hora; }
    public void setHora(String hora) { this.hora = hora; }

    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
}
