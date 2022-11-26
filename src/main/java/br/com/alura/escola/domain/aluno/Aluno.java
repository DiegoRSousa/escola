package br.com.alura.escola.domain.aluno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Aluno {

    private Cpf cpf;
    private String nome;
    private Email email;
    private String senha;
    private List<Telefone> telefones = new ArrayList<>();


    public Aluno(Cpf cpf, String nome, Email email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public void adicionarTelefone(Telefone telefone) {
        if(telefones.size() == 2)
            throw new IllegalArgumentException("Número máximo de telefones já atingido!");
        telefones.add(telefone);
    }

    public Cpf getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public Email getEmail() {
        return email;
    }

    public List<Telefone> getTelefones() {
        //return List.of(telefones.toArray(new Telefone[]{}));
        return Collections.unmodifiableList(telefones);
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "cpf=" + cpf +
                ", nome='" + nome + '\'' +
                ", email=" + email +
                ", senha='" + senha + '\'' +
                ", telefones=" + telefones +
                '}';
    }
}
