import java.util.ArrayList;
import java.util.Scanner;

interface Avalie {
    void avaliar();

    void setNumeroParaContato(String s);
}

public class suporte implements Avalie {
    String numeroParaContato;
    String conta;
    int senha;
    private String pagamento;
    private String informacaoTecnica;
    private String suporteResponsaveis;
    private String systemStore;


    public suporte() {
        this.numeroParaContato = "Sem Número";
        this.conta = "Sem Conta";
        this.senha = 0;
        this.pagamento = "Sem Pagamento";
        this.informacaoTecnica = "Sem Informação Técnica";
        this.suporteResponsaveis = "Sem Responsáveis";
        this.systemStore = "Sem System Store";
    }

    public suporte(String numeroParaContato, String conta, int senha, String pagamento,
                   String informacaoTecnica, String suporteResponsaveis, String systemStore) {
        this.numeroParaContato = numeroParaContato;
        this.conta = conta;
        this.senha = senha;
        this.pagamento = pagamento;
        this.informacaoTecnica = informacaoTecnica;
        this.suporteResponsaveis = suporteResponsaveis;
        this.systemStore = systemStore;
    }

    public void avaliar() {
        System.out.println("Avaliando o suporte...");
    }

    public void setNumeroParaContato(String s) {
        this.numeroParaContato = s;
    }

    static class SuporteAvaliado extends suporte {
        private int avaliacao;
        private String pagamento;
        private String informacaoTecnica;
        private String suporteResponsaveis;
        private String systemStore;

        public SuporteAvaliado() {
            super();
            this.avaliacao = 0;
        }

        public SuporteAvaliado(String numeroParaContato, String conta, int senha, String pagamento,
                               String informacaoTecnica, String suporteResponsaveis, String systemStore, int avaliacao) {
            super(numeroParaContato, conta, senha, pagamento, informacaoTecnica, suporteResponsaveis, systemStore);
            this.avaliacao = avaliacao;
        }

        public void avaliar() {
            System.out.println("Avaliação do Suporte: " + avaliacao + " estrelas");
        }

        public void setConta(String s) {
            this.conta = s;
        }

        public void setSenha(int i) {
            this.senha = i;
        }

        public void setPagamento(String s) {
            this.pagamento = s;
        }

        public void setInformacaoTecnica(String s) {
            this.informacaoTecnica = s;
        }

        public void setSuporteResponsaveis(String s) {
            this.suporteResponsaveis = s;
        }

        public void setSystemStore(String s) {
            this.systemStore = s;
        }
    }

    public static void main(String[] args) {
        ArrayList<SuporteAvaliado> avaliacoes = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantidade de avaliações de suporte a serem cadastradas: ");
        int quantidadeAvaliacoes = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < quantidadeAvaliacoes; i++) {
            SuporteAvaliado suporteAvaliado = new SuporteAvaliado();

            System.out.print("Número para Contato: ");
            suporteAvaliado.setNumeroParaContato(scanner.nextLine());

            System.out.print("Conta: ");
            suporteAvaliado.setConta(scanner.nextLine());

            System.out.print("Senha: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Digite um número para a senha:");
                scanner.nextLine();
            }
            suporteAvaliado.setSenha(scanner.nextInt());
            scanner.nextLine();

            System.out.print("Pagamento: ");
            suporteAvaliado.setPagamento(scanner.nextLine());

            System.out.print("Informação Técnica: ");
            suporteAvaliado.setInformacaoTecnica(scanner.nextLine());

            System.out.print("Responsáveis pelo Suporte: ");
            suporteAvaliado.setSuporteResponsaveis(scanner.nextLine());

            System.out.print("System Store: ");
            suporteAvaliado.setSystemStore(scanner.nextLine());

            System.out.print("Avaliação do Suporte (em estrelas): ");
            suporteAvaliado.avaliacao = scanner.nextInt();
            scanner.nextLine();

            avaliacoes.add(suporteAvaliado);
        }

        scanner.close();

        System.out.println("Detalhes das avaliações de suporte:");

        for (SuporteAvaliado avaliacao : avaliacoes) {
            System.out.println("Número para Contato: " + avaliacao.numeroParaContato);
            System.out.println("Conta: " + avaliacao.conta);
            System.out.println("Senha: " + avaliacao.senha);
            System.out.println("Pagamento: " + avaliacao.pagamento);
            System.out.println("Informação Técnica: " + avaliacao.informacaoTecnica);
            System.out.println("Responsáveis pelo Suporte: " + avaliacao.suporteResponsaveis);
            System.out.println("System Store: " + avaliacao.systemStore);
            avaliacao.avaliar();
            System.out.println("------------------------------");
        }
    }
}
