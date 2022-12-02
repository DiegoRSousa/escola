package br.com.alura.escola.academico.domain.aluno;

import br.com.alura.escola.academico.domain.Evento;
import br.com.alura.escola.shared.domain.Cpf;

import java.time.LocalDateTime;

public class AlunoMatriculado implements Evento {

    private final Cpf cpfDoAluno;
    private final LocalDateTime momento = LocalDateTime.now();

    public AlunoMatriculado(Cpf cpfDoAluno) {
        this.cpfDoAluno = cpfDoAluno;
    }

    public Cpf getCpfDoAluno() {
        return cpfDoAluno;
    }

    @Override
    public LocalDateTime getMomento() {
        return momento;
    }
}