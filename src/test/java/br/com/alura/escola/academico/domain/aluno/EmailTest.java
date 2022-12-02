package br.com.alura.escola.academico.domain.aluno;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    @DisplayName("nao deveria criar email com endereco invalido")
    void test01() {
        assertThrows(IllegalArgumentException.class, () -> new Email(null));
        assertThrows(IllegalArgumentException.class, () -> new Email(""));
        assertThrows(IllegalArgumentException.class, () -> new Email("emailinvalido"));
    }

    @Test
    @DisplayName("deveria criar email com endereco valido")
    void test02() {
        var endereco = "teste@gmail.com";
        var email = new Email(endereco);
        assertNotNull(email);
        assertEquals(endereco, email.getEndereco());
    }
}