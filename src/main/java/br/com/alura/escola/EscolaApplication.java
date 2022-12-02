package br.com.alura.escola;

import br.com.alura.escola.academico.application.aluno.AlunoDTO;
import br.com.alura.escola.academico.domain.PublicadorDeEventos;
import br.com.alura.escola.academico.application.aluno.MatriculaAluno;
import br.com.alura.escola.academico.domain.aluno.LogDeAlunoMatriculado;
import br.com.alura.escola.academico.infra.aluno.AlunoRepositoryList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EscolaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscolaApplication.class, args);
		System.out.println("###Matriculando Aluno###");
	  	AlunoDTO aluno = new AlunoDTO("Aluno", "046.544.834-45", "teste@gmail.com");
		PublicadorDeEventos publicador = new PublicadorDeEventos();
		publicador.adicionar(new LogDeAlunoMatriculado());
		MatriculaAluno matricularAluno = new MatriculaAluno(new AlunoRepositoryList(), publicador);
		matricularAluno.matricular(aluno);

	}

}
