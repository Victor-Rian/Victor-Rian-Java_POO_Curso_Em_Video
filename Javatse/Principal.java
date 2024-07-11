public class Principal {
    public static void main(String[] args) {
        Votacao votacao = new Votacao();
        Metodos metodos = new Metodos(votacao);
        metodos.menu();
    }
}