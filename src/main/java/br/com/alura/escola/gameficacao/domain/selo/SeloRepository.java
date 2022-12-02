package br.com.alura.escola.gameficacao.domain.selo;

public interface SeloRepository {

    void salvar(Selo selo);

    Selo buscarPorNome(String nome);
}
