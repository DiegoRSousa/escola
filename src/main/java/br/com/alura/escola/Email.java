package br.com.alura.escola;

public class Email {
    private String endereco;

    public Email(String endereco)  {
        if(null == endereco || !endereco.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"))
            throw new IllegalArgumentException("Email inválido");
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }
}
