package br.com.alura.escola.domain.aluno;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    private FabricaDeAluno fabricaDeAluno = new FabricaDeAluno();
    private Aluno aluno;
    private Telefone telefone = new Telefone("83", "984593418");

    @DisplayName("não deveria permitir criar aluno com mais de dois telefones")
    @Test
    void test01() {

        aluno = fabricaDeAluno
                .comNomeCpfEmail("Pedro", "084.451.146-56", "teste@gmail.com")
                .comTelefone("83","998345832")
                .comTelefone("83","995678824")
                .criar();

        assertThrows(IllegalArgumentException.class, () -> {
            aluno.adicionarTelefone(telefone);
        });

        assertEquals(2, aluno.getTelefones().size());
    }

    @DisplayName("deveria permitir criar aluno com dois telefones")
    @Test
    void teste02() {
        aluno = fabricaDeAluno
                .comNomeCpfEmail("Pedro", "084.451.146-56", "teste@gmail.com")
                .comTelefone("83","998345832")
                .criar();

        assertDoesNotThrow(() -> {aluno.adicionarTelefone(telefone);});
        assertEquals(2, aluno.getTelefones().size());
    }
}