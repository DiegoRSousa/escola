package br.com.alura.escola.gameficacao.application;

import br.com.alura.escola.gameficacao.domain.selo.Selo;
import br.com.alura.escola.gameficacao.domain.selo.SeloRepository;
import br.com.alura.escola.shared.domain.Cpf;
import br.com.alura.escola.shared.domain.evento.Evento;
import br.com.alura.escola.shared.domain.evento.Ouvinte;
import br.com.alura.escola.shared.domain.evento.TipoDeEvento;

public class GeraSeloAlunoMatriculado extends Ouvinte {

    private SeloRepository repository;

    public GeraSeloAlunoMatriculado(SeloRepository repository) {
        this.repository = repository;
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento.tipo().equals(TipoDeEvento.ALUNO_MATRICULADO);
    }

    @Override
    protected void reageAo(Evento evento) {
        Cpf cpf = (Cpf) evento.informacoes().get("cpf");
        Selo selo = new Selo(cpf,"Spring Boot 3");

        repository.salvar(selo);
    }
}
