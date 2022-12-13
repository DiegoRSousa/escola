package br.com.alura.escola.shared.domain.evento;

import java.time.LocalDateTime;
import java.util.Map;

public interface Evento {
    LocalDateTime getMomento();
    TipoDeEvento tipo();
    Map<String, Object> informacoes();
}
