package br.com.alura.escola.domain.aluno.domain.aluno;

public class Cpf {
    private String numero;

    public Cpf(String numero) {
        if(numero == null ||
                !numero.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}"))
            throw new IllegalArgumentException("CPF Inválido!");
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }
}
