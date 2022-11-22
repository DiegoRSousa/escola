package br.com.alura.escola.application.aluno;

import br.com.alura.escola.domain.aluno.Aluno;
import br.com.alura.escola.domain.aluno.AlunoRepository;
import br.com.alura.escola.domain.aluno.Cpf;
import br.com.alura.escola.infra.aluno.AlunoRepositoryList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MatriculaAlunoTest {

    @Test
    public void deveriaPersistirAluno() {
        AlunoRepository alunoRepository = new AlunoRepositoryList();
        MatriculaAluno useCase = new MatriculaAluno(alunoRepository);
        useCase.matricular(new AlunoDTO("nome teste", "089.565.943-34", "teste@gmail.com"));

        Aluno aluno = alunoRepository.buscarPorCpf(new Cpf("089.565.943-34"));
        assertEquals("nome teste", aluno.getNome());
    }
}