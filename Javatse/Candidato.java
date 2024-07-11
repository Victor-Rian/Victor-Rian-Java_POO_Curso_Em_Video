public class Candidato {
    private String nome;//Atributos
    private int votos;

    public Candidato(String nome) {//Construtor
        this.nome = nome;
        this.votos = 0;
    }

    public String getNome() {//Métodos get 
        return nome;
    }
    
    public int getVotos() {
        return votos;
    }

    public void adicionarVoto() {
        this.votos++; //Adiciona + 1
    }
}
