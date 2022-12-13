package br.com.alura.escola.academico.application.aluno;

import br.com.alura.escola.shared.domain.evento.PublicadorDeEventos;
import br.com.alura.escola.academico.domain.aluno.Aluno;
import br.com.alura.escola.academico.domain.aluno.AlunoMatriculado;
import br.com.alura.escola.academico.domain.aluno.AlunoRepository;

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