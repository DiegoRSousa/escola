package br.com.alura.escola.academico.application.aluno;

import br.com.alura.escola.shared.domain.evento.PublicadorDeEventos;
import br.com.alura.escola.academico.domain.aluno.Aluno;
import br.com.alura.escola.academico.domain.aluno.AlunoRepository;
import br.com.alura.escola.academico.domain.aluno.LogDeAlunoMatriculado;
import br.com.alura.escola.academico.infra.aluno.AlunoRepositoryList;
import br.com.alura.escola.shared.domain.Cpf;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MatriculaAlunoTest {

    @Test
    void deveriaPersistirAluno() {
        AlunoRepository alunoRepository = new AlunoRepositoryList();
        PublicadorDeEventos publicador = new PublicadorDeEventos();
        publicador.adicionar(new LogDeAlunoMatriculado());
        MatriculaAluno useCase = new MatriculaAluno(alunoRepository, publicador);
        useCase.matricular(new AlunoDTO("nome teste", "089.565.943-34", "teste@gmail.com"));

        Aluno aluno = alunoRepository.buscarPorCpf(new Cpf("089.565.943-34"));
        assertEquals("nome teste", aluno.getNome());
    }
}