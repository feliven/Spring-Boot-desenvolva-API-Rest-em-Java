package med.voll.api.model;

public enum Especialidade {
    ORTOPEDIA("ortopedia"),
    CARDIOLOGIA("cardiologia"),
    GINECOLOGIA("ginecologia"),
    DERMATOLOGIA("dermatologia");

    private final String nome;

    Especialidade(String nome) {
        this.nome = nome;
    }

}
