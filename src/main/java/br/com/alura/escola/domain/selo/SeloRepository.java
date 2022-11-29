package br.com.alura.escola.domain.selo;

public interface SeloRepository {

    void salvar(Selo selo);

    Selo buscarPorNome(String nome);
}
