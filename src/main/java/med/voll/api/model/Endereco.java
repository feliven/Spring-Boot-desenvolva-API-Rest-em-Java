package med.voll.api.model;

public class Endereco {
    String logradouro;
    String numeroEndereco;
    String complementoEndereco;
    String cidade;
    SiglaUf siglaUf;
    String cep;

    public Endereco() {
    }

    public Endereco(String logradouro, String numeroEndereco, String complementoEndereco,
            String cidade, SiglaUf siglaUf, String cep) {
        this.logradouro = logradouro;
        this.numeroEndereco = numeroEndereco;
        this.complementoEndereco = complementoEndereco;
        this.cidade = cidade;
        this.siglaUf = siglaUf;
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumeroEndereco() {
        return numeroEndereco;
    }

    public String getComplementoEndereco() {
        return complementoEndereco;
    }

    public String getCidade() {
        return cidade;
    }

    public SiglaUf getSiglaUf() {
        return siglaUf;
    }

    public String getCep() {
        return cep;
    }

    @Override
    public String toString() {
        return "Endereco [logradouro=" + logradouro + ", numeroEndereco=" + numeroEndereco + ", complementoEndereco="
                + complementoEndereco + ", cidade=" + cidade + ", siglaUf=" + siglaUf + ", cep=" + cep + "]";
    }
}
