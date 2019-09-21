package dadospessoais;

public class Professor extends Pessoa {

    private int siape;

    public Professor() {

    }

    public Professor(int idade, String sexo, int cpf, String nome, int siape) {

        super(idade, sexo, cpf, nome);

        this.siape = siape;
    }

    public int getSiape() {
        return siape;
    }

    public void setSiape(int siape) {
        this.siape = siape;
    }

}
