import java.util.ArrayList;
import java.util.Scanner;

interface Avaliavel {
    void avaliar();
}

class Jogo implements Avaliavel {
    private String nomeDoJogo;
    private String genero;
    private String preco;

    public Jogo() {
        this.nomeDoJogo = "Sem Nome";
        this.genero = "Sem Gênero";
        this.preco = "Sem Preço";
    }

    public Jogo(String nomeDoJogo, String genero, String preco) {
        this.nomeDoJogo = nomeDoJogo;
        this.genero = genero;
        this.preco = preco;
    }

    public void avaliar() {
        System.out.println("Avaliando o jogo...");
    }

    public void setNomeDoJogo(String nomeDoJogo) {
        this.nomeDoJogo = nomeDoJogo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getNomeDoJogo() {
        return nomeDoJogo;
    }

    public String getGenero() {
        return genero;
    }

    public String getPreco() {
        return preco;
    }
}
 class JogoAvaliado extends Jogo {
    int avaliacao;

    public JogoAvaliado() {
        super();
        this.avaliacao = 0;
    }

    public JogoAvaliado(String nomeDoJogo, String genero, String preco, int avaliacao) {
        super(nomeDoJogo, genero, preco);
        this.avaliacao = avaliacao;
    }

    @Override
    public void avaliar() {
        System.out.println("Avaliação do Jogo: " + avaliacao + " estrelas");
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList<JogoAvaliado> jogos = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantidade de jogos a serem cadastrados: ");
        int quantidadeJogos = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < quantidadeJogos; i++) {
            System.out.print("Nome do Jogo: ");
            String nomeDoJogo = scanner.nextLine();

            System.out.print("Gênero do Jogo: ");
            String genero = scanner.nextLine();

            System.out.print("Preço do Jogo: ");
            String preco = scanner.nextLine();

            System.out.print("Avaliação do Jogo (em estrelas): ");
            int avaliacao = scanner.nextInt();
            scanner.nextLine();

            JogoAvaliado jogoAvaliado = new JogoAvaliado(nomeDoJogo, genero, preco, avaliacao);
            jogos.add(jogoAvaliado);
        }

        scanner.close();

        for (JogoAvaliado jogo : jogos) {
            System.out.println("Detalhes do Jogo:");
            System.out.println("Nome: " + jogo.getNomeDoJogo());
            System.out.println("Gênero: " + jogo.getGenero());
            System.out.println("Preço: " + jogo.getPreco());
            jogo.avaliar();
            System.out.println("------------------------------");
        }
    }
}