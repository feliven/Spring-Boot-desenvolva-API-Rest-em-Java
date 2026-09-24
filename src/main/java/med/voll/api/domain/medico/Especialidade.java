package med.voll.api.domain.medico;

public enum Especialidade {
    ORTOPEDIA("ortopedia"),
    CARDIOLOGIA("cardiologia"),
    GINECOLOGIA("ginecologia"),
    DERMATOLOGIA("dermatologia");

    final String nome;

    Especialidade(String nome) {
        this.nome = nome;
    }

}
