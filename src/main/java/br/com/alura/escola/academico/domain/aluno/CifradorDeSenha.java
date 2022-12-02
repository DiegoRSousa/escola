package br.com.alura.escola.academico.domain.aluno;

public interface CifradorDeSenha {
    String cifraSenha(String senha);
    boolean validarSenhaCifrada(String senhaCifrada, String senha);
}
