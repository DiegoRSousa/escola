package br.com.alura.escola;

import br.com.alura.escola.application.aluno.AlunoDTO;
import br.com.alura.escola.application.aluno.MatriculaAluno;
import br.com.alura.escola.infra.aluno.AlunoRepositoryList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EscolaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscolaApplication.class, args);
		System.out.println("###Matriculando Aluno###");
		AlunoDTO aluno = new AlunoDTO("Aluno", "046.544.834-45", "teste@gmail.com");
		MatriculaAluno matricularAluno = new MatriculaAluno(new AlunoRepositoryList());
		matricularAluno.matricular(aluno);

	}

}
