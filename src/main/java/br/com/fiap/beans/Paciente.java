package br.com.fiap.beans;

public class Paciente {

    private int id;
    private String nome;
    private String cpf;        // 11 dígitos
    private String nascimento; // ISO 'YYYY-MM-DD'
    private String telefone;

    public Paciente() {}

    public Paciente(int id, String nome, String cpf, String nascimento, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.telefone = telefone;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getNascimento() { return nascimento; }
    public void setNascimento(String nascimento) { this.nascimento = nascimento; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
}
