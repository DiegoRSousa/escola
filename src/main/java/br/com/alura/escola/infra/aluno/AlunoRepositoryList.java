package br.com.alura.escola.infra.aluno;

import br.com.alura.escola.domain.aluno.domain.aluno.Aluno;
import br.com.alura.escola.domain.aluno.domain.aluno.AlunoRepository;
import br.com.alura.escola.domain.aluno.domain.aluno.Cpf;

import java.util.ArrayList;
import java.util.List;

public class AlunoRepositoryList implements AlunoRepository {

    List<Aluno> matriculados = new ArrayList<>();

    @Override
    public void matricular(Aluno aluno) {
        matriculados.add(aluno);
    }

    @Override
    public Aluno buscarPorCpf(Cpf cpf) {
        return matriculados.stream().filter(a
                -> a.getCpf().getNumero().equals(cpf.getNumero())).findFirst().orElse(null);
    }

    @Override
    public List<Aluno> listarTodosAlunos() {
        return matriculados;
    }
}
