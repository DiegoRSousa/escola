package br.com.alura.escola.application.selo;

import br.com.alura.escola.domain.aluno.Cpf;
import br.com.alura.escola.domain.selo.Selo;

public record SeloDTO(String cpf, String nome) {
    public Selo toModel() {
        return new Selo(new Cpf(cpf), nome);
    }
}
