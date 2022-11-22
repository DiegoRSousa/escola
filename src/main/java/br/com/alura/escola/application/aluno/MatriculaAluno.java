package br.com.alura.escola.application.aluno;

import br.com.alura.escola.domain.aluno.Aluno;
import br.com.alura.escola.domain.aluno.AlunoRepository;

public class MatriculaAluno {

    private final AlunoRepository alunoRepository;

    public MatriculaAluno(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public void matricular(AlunoDTO alunoDTO) {

        Aluno aluno = alunoDTO.toModel();
        alunoRepository.matricular(aluno);
    }
}
