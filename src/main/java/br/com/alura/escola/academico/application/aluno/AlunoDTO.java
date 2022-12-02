package br.com.alura.escola.academico.application.aluno;

import br.com.alura.escola.academico.domain.aluno.Aluno;
import br.com.alura.escola.academico.domain.aluno.FabricaDeAluno;

public record AlunoDTO(String nome, String cpf, String email) {

    public Aluno toModel() {
        return new FabricaDeAluno().comNomeCpfEmail(nome, cpf, email).criar();
    }
}
