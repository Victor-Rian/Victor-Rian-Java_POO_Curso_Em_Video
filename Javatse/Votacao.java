import java.io.*;
import javax.swing.JOptionPane;

public class Votacao {
    private Eleitor[] eleitores; // Cria um Array de eleitores 
    private Candidato[] candidatos;
    private int numEleitores;

    public Votacao() { // Costrutor
        this.eleitores = new Eleitor[10]; // Instância Array de eleitores 
        this.candidatos = new Candidato[10];
        this.numEleitores = 0;
        inicializarCandidatos();
    }

    private void inicializarCandidatos() { //Método
        candidatos[0] = new Candidato("João da Silva");
        candidatos[1] = new Candidato("Maria Oliveira");
        candidatos[2] = new Candidato("Pedro Santos");
        candidatos[3] = new Candidato("Ana Souza");
        candidatos[4] = new Candidato("Carlos Lima");
    }

    public void adicionarEleitor(Eleitor eleitor) {
        if (numEleitores < eleitores.length) {
            eleitores[numEleitores] = eleitor;
            numEleitores++;
        } else {
            JOptionPane.showMessageDialog(null, "Capacidade máxima de eleitores atingida.");
        }
    }

    public void votar(int numeroCandidato) {
        if (numeroCandidato >= 1 && numeroCandidato <= candidatos.length) {
            Candidato candidato = candidatos[numeroCandidato - 1];
            if (candidato != null) {
                candidato.adicionarVoto();
                JOptionPane.showMessageDialog(null, "Voto computado com sucesso para " + candidato.getNome() + "!");
            } else {
                JOptionPane.showMessageDialog(null, "Candidato não encontrado.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Número de candidato inválido.");
        }
    }

    public void exibirCandidatos() {
        StringBuilder listaCandidatos = new StringBuilder("Candidatos Disponíveis:\n");
        for (int i = 0; i < candidatos.length; i++) {
            Candidato candidato = candidatos[i];
            if (candidato != null) {
                listaCandidatos.append((i + 1)).append(": ").append(candidato.getNome()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, listaCandidatos.toString());
    }

    public void salvarDados(String nomeArquivo) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(nomeArquivo)))) {
            for (int i = 0; i < numEleitores; i++) {
                Eleitor eleitor = eleitores[i];
                writer.println("Nome Eleitor: " + eleitor.getNome() + " Título: " + eleitor.getTitulo());
            }
            for (int i = 0; i < candidatos.length; i++) {
                Candidato candidato = candidatos[i];
                if (candidato != null) {
                    writer.println("C; " + candidato.getNome() + " - " + candidato.getVotos());
                }
            }
            writer.println("FIM DA VOTAÇÃO!");
                JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar dados: " + e.getMessage());
        }
    }
}
