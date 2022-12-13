package br.com.alura.escola.gameficacao.application;

import br.com.alura.escola.gameficacao.domain.selo.Selo;
import br.com.alura.escola.gameficacao.domain.selo.SeloRepository;
import br.com.alura.escola.gameficacao.infra.selo.SeloRepositoryList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdicionarSeloTest {

    @Test
    @DisplayName("deveria adicionar selo")
    void test01() {
        var nome = "formacao java";
        SeloRepository repository = new SeloRepositoryList();
        AdicionarSelo useCase = new AdicionarSelo(repository);
        useCase.adicionarSelo(new SeloDTO("056.562.134-54", nome));

        Selo selo = repository.buscarPorNome(nome);
        assertEquals(nome, selo.getNome());
    }
}
