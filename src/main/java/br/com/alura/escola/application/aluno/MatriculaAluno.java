package br.com.alura.escola.application.aluno;

import br.com.alura.escola.domain.PublicadorDeEventos;
import br.com.alura.escola.domain.aluno.Aluno;
import br.com.alura.escola.domain.aluno.AlunoRepository;
import br.com.alura.escola.domain.aluno.AlunoMatriculado;

public class MatriculaAluno {

    private final AlunoRepository alunoRepository;
    private final PublicadorDeEventos publicadorDeEventos;

    public MatriculaAluno(AlunoRepository alunoRepository, PublicadorDeEventos publicadorDeEventos) {
        this.alunoRepository = alunoRepository;
        this.publicadorDeEventos = publicadorDeEventos;
    }

    public void matricular(AlunoDTO alunoDTO) {

        Aluno aluno = alunoDTO.toModel();
        alunoRepository.matricular(aluno);

        AlunoMatriculado evento = new AlunoMatriculado(aluno.getCpf());
        publicadorDeEventos.publicar(evento);
    }
}