import javax.swing.JOptionPane;

public class Metodos {
    private Votacao votacao;

    public Metodos(Votacao votacao) {
        this.votacao = votacao;
    }

    public void menu() {
        while (true) {
            String input = JOptionPane.showInputDialog(
                null,
                "SISTEMA DE ELEIÇÃO\n\n1 - Cadastrar eleitor\n2 - Menu de votação\n3 - Salvar dados\n4 - Encerrar",
                "Entrada",
                JOptionPane.QUESTION_MESSAGE
            );

            if (input == null || input.equals("4")) {
                break;
            }

            switch (input) {
                case "1":
                    cadastrarEleitor();
                    break;
                case "2":
                    menuVotacao();
                    break;
                case "3":
                    salvarDados();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
            }
        }
    }

    private void cadastrarEleitor() {
        String nomeEleitor = JOptionPane.showInputDialog("Nome do Eleitor:");
        String tituloEleitor = JOptionPane.showInputDialog("Título do Eleitor:");

        Eleitor eleitor = new Eleitor(nomeEleitor, tituloEleitor);//Objeto
        votacao.adicionarEleitor(eleitor);

        JOptionPane.showMessageDialog(null, "Eleitor cadastrado com sucesso!");
    }

    private void menuVotacao() {
        votacao.exibirCandidatos();
        int numeroCandidato = Integer.parseInt(JOptionPane.showInputDialog("Número do Candidato:"));

        votacao.votar(numeroCandidato);
    }

    private void salvarDados() {
        String nomeArquivo = JOptionPane.showInputDialog("Digite o nome do arquivo para salvar:");
        votacao.salvarDados(nomeArquivo);
    }
}
