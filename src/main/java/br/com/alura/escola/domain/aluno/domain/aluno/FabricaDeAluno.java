package br.com.alura.escola.domain.aluno.domain.aluno;

public class FabricaDeAluno {

    private Aluno aluno;

    public FabricaDeAluno comNomeCpfEmail(String nome, String cpf, String email) {
        this.aluno = new Aluno(new Cpf(cpf), nome, new Email(email));
        return this;
    }

    public FabricaDeAluno comTelefone(String ddd, String numero) {
        this.aluno.adicionarTelefone(new Telefone(ddd, numero));
        return this;
    }

    public Aluno criar() {
        return this.aluno;
    }
}