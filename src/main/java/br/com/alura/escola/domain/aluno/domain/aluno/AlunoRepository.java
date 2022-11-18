package br.com.alura.escola.domain.aluno.domain.aluno;

import java.util.List;

public interface AlunoRepository {

    void matricular(Aluno aluno);

    Aluno buscarPorCpf(Cpf cpf);

    List<Aluno> listarTodosAlunos();
}
