package eleicao_mt;

public class Eleitor { //Case do eletor com os atributos
    String nome;
    int data_nascimento;
    String titulo_eletor;
    boolean permitido;

    public Eleitor(){ //Este é o método construtor
        if (data_nascimento < 18) {
            permitido = false;
            
        }else {
            permitido = true;
            System.out.println("O candidato " + nome + "pode votar!");
        }
        System.out.println("Erro! A data não é valida!");

    }
    public String getNome() {//Este é são os métodos
        System.out.println("Digite seu primeiro nome: " );
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTitulo_eletor() {
        System.out.println("Digite o nº do seu título: " );
        return titulo_eletor;
    }
    public void setTitulo_eletor(String titulo_eletor) {
        this.titulo_eletor = titulo_eletor;
    }

    public void status(){
        System.out.println("Candidato " + getNome() + " - " + getTitulo_eletor());
    }
    
}
