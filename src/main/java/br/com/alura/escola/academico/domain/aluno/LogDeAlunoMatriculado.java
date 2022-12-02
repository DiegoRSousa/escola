package br.com.alura.escola.academico.domain.aluno;

import br.com.alura.escola.academico.domain.Ouvinte;
import br.com.alura.escola.academico.domain.Evento;

import java.time.format.DateTimeFormatter;

public class LogDeAlunoMatriculado extends Ouvinte {

    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento instanceof AlunoMatriculado;
    }

    @Override
    public void reageAo(Evento evento) {
        String momento = evento.getMomento().format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(
                String.format("Aluno com CPF: %s matriculado em: %s",
                        ((AlunoMatriculado) evento).getCpfDoAluno(),
                        momento));
    }

}
