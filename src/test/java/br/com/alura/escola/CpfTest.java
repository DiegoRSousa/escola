package br.com.alura.escola;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CpfTest {

    @Test
    @DisplayName("nao deveria criar cpf com numero invalido")
    void test01() {
        assertThrows(IllegalArgumentException.class, () -> new Cpf(null));
        assertThrows(IllegalArgumentException.class, () -> new Cpf(""));
        assertThrows(IllegalArgumentException.class, () -> new Cpf("038.945.91-32"));
    }

    @Test
    @DisplayName("deveria criar cpf com numero valido")
    void test02() {
        var numero = "239.174.934-84";
        var cpf = new Cpf(numero);
        assertNotNull(cpf);
        assertEquals("239.174.934-84", cpf.getNumero());
    }
}