package br.com.alura.escola.academico.domain.aluno;

import br.com.alura.escola.shared.domain.evento.Ouvinte;
import br.com.alura.escola.shared.domain.evento.Evento;
import br.com.alura.escola.shared.domain.evento.TipoDeEvento;

import java.time.format.DateTimeFormatter;

public class LogDeAlunoMatriculado extends Ouvinte {

    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento.tipo().equals(TipoDeEvento.ALUNO_MATRICULADO);
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
