import java.util.ArrayList;
import java.util.Scanner;

interface Resgatavel {
    void resgatarCodigo();
}

class Produto {
    private String categoria;
    private String novidades;
    private String promocao;
    private String maisJogados;
    private int resgatarCodigo;

    public Produto() {
    }

    public Produto(String categoria, String novidades, String promocao, String maisJogados, int resgatarCodigo) {
        this.categoria = categoria;
        this.novidades = novidades;
        this.promocao = promocao;
        this.maisJogados = maisJogados;
        this.resgatarCodigo = resgatarCodigo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNovidades() {
        return novidades;
    }

    public void setNovidades(String novidades) {
        this.novidades = novidades;
    }

    public String getPromocao() {
        return promocao;
    }

    public void setPromocao(String promocao) {
        this.promocao = promocao;
    }

    public String getMaisJogados() {
        return maisJogados;
    }

    public void setMaisJogados(String maisJogados) {
        this.maisJogados = maisJogados;
    }

    public int getResgatarCodigo() {
        return resgatarCodigo;
    }

    public void setResgatarCodigo(int resgatarCodigo) {
        this.resgatarCodigo = resgatarCodigo;
    }
}

public class loja extends Produto implements Resgatavel {

    private static ArrayList<loja> produtos = new ArrayList<>();

    public loja() {
        super();
    }

    public loja(String categoria, String novidades, String promocao, String maisJogados, int resgatarCodigo) {
        super(categoria, novidades, promocao, maisJogados, resgatarCodigo);
    }

    @Override
    public void resgatarCodigo() {
        System.out.println("Código resgatado com sucesso!");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantidade de produtos a serem cadastrados: ");
        int quantidadeProdutos = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < quantidadeProdutos; i++) {
            loja produto = new loja();

            System.out.print("Categoria: ");
            produto.setCategoria(scanner.nextLine());

            System.out.print("Novidades: ");
            produto.setNovidades(scanner.nextLine());

            System.out.print("Promoção: ");
            produto.setPromocao(scanner.nextLine());

            System.out.print("Mais Jogados: ");
            produto.setMaisJogados(scanner.nextLine());

            System.out.print("Código para Resgatar: ");
            produto.setResgatarCodigo(scanner.nextInt());
            scanner.nextLine();

            produtos.add(produto);

            produto.resgatarCodigo();
        }

        scanner.close();

        System.out.println("Dados dos produtos:");

        for (loja produto : produtos) {
            System.out.println("Categoria: " + produto.getCategoria());
            System.out.println("Novidades: " + produto.getNovidades());
            System.out.println("Promoção: " + produto.getPromocao());
            System.out.println("Mais Jogados: " + produto.getMaisJogados());
            System.out.println("Código resgatado com sucesso!: ");
        }
    }
}