package br.com.alura.escola.academico.domain.aluno;

import br.com.alura.escola.shared.domain.evento.Evento;
import br.com.alura.escola.shared.domain.Cpf;
import br.com.alura.escola.shared.domain.evento.TipoDeEvento;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class AlunoMatriculado implements Evento {

    private final Cpf cpfDoAluno;
    private final LocalDateTime momento = LocalDateTime.now();

    public AlunoMatriculado(Cpf cpfDoAluno) {
        this.cpfDoAluno = cpfDoAluno;
    }

    public Cpf getCpfDoAluno() {
        return cpfDoAluno;
    }

    @Override
    public LocalDateTime getMomento() {
        return momento;
    }

    @Override
    public TipoDeEvento tipo() {
        return TipoDeEvento.ALUNO_MATRICULADO;
    }

    @Override
    public Map<String, Object> informacoes() {
        return Map.of("cpf", cpfDoAluno);
    }
}
