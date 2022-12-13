package br.com.alura.escola.gameficacao.infra.selo;

import br.com.alura.escola.gameficacao.domain.selo.Selo;
import br.com.alura.escola.gameficacao.domain.selo.SeloRepository;

import java.util.ArrayList;
import java.util.List;

public class SeloRepositoryList implements SeloRepository {

    private List<Selo> selos = new ArrayList<>();

    @Override
    public void salvar(Selo selo) {
        System.out.println("salbando selo: " + selo.getNome());
        selos.add(selo);
    }

    @Override
    public Selo buscarPorNome(String nome) {
        System.out.println("buscando selo por nome: " + nome);
        return selos.stream().filter(s -> s.getNome().equals(nome)).findFirst().orElse(null);
    }
}
