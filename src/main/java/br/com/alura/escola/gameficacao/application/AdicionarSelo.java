package br.com.alura.escola.gameficacao.application;

import br.com.alura.escola.gameficacao.domain.selo.Selo;
import br.com.alura.escola.gameficacao.domain.selo.SeloRepository;

public class AdicionarSelo {

    private SeloRepository repository;

    public AdicionarSelo(SeloRepository repository) {
        this.repository = repository;
    }

    public void adicionarSelo(SeloDTO seloDTO) {
        Selo selo = seloDTO.toModel();
        repository.salvar(selo);
    }
}
