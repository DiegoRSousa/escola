package br.com.alura.escola.domain.aluno;

public class Telefone {
    private String ddd;
    private String numero;

    public Telefone(String ddd, String numero) {
        if(null == ddd || !ddd.matches("\\d{2}"))
            throw new IllegalArgumentException("DDD Inválido!");
        if(null == numero || !numero.matches("\\d{8}|\\d{9}"))
            throw new IllegalArgumentException("Número Inválido!");
        this.ddd = ddd;
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }

    public String getNumero() {
        return numero;
    }
}
