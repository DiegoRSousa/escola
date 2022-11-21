package br.com.alura.escola.domain.aluno;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelefoneTest {

    @Test
    @DisplayName("nao deveria criar telefone com ddd invalido")
    void test01() {
        assertThrows(IllegalArgumentException.class, () -> new Telefone(null, "998591847"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("1", "988837292"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("123", "988837292"));
    }

    @Test
    @DisplayName("deveria criar telefone com ddd e numero valido")
    void test02() {
        var ddd = "83";
        var numero = "988834856";
        var telefone = new Telefone(ddd, numero);
        assertNotNull(telefone);
        assertEquals(ddd, telefone.getDdd());
        assertEquals(numero, telefone.getNumero());
    }

    @Test
    @DisplayName("nao deveria criar telefone com numero invalido")
    void test03() {
        assertThrows(IllegalArgumentException.class, () -> new Telefone("39",null));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("11", "837292"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("12", "98883729211"));
    }


}