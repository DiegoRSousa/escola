package br.com.alura.escola.application.indicacao;

import br.com.alura.escola.domain.aluno.Aluno;

public interface EnviaEmailIndicacao {

    void enviarPara(Aluno aluno);
}
