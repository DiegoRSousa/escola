package br.com.alura.escola.gameficacao.application;

import br.com.alura.escola.gameficacao.domain.selo.Selo;
import br.com.alura.escola.shared.domain.Cpf;

public record SeloDTO(String cpf, String nome) {
    public Selo toModel() {
        return new Selo(new Cpf(cpf), nome);
    }
}
