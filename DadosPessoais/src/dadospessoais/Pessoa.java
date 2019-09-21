package dadospessoais;

public abstract class Pessoa {

    private int idade;
    private String sexo;
    private int cpf;
    private String nome;

    public Pessoa() {
    }

    public Pessoa(int idade, String sexo, int cpf, String nome) {
        this.idade = idade;
        this.sexo = sexo;
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getSexo() {
        return sexo;
    }

    public int getCpf() {
        return cpf;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

}
