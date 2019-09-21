package dadospessoais;

public class Aluno extends Pessoa {

    private int ra;

    public Aluno() {

    }

    public Aluno(int idade, String sexo, int cpf, String nome, int ra) {

        super(idade, sexo, cpf, nome);

        this.ra = ra;

    }

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

}
