package br.com.alura.escola.domain.aluno;

public interface CifradorDeSenha {
    String cifraSenha(String senha);
    boolean validarSenhaCifrada(String senhaCifrada, String senha);
}
