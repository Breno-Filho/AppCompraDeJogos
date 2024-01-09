import java.util.ArrayList;
import java.util.Scanner;

interface Avaliacao {
    void avaliar();

    void exibirAvaliacao();
}

class Pessoa {
    private String nome;
    private int idade;
    private String cpf;
    private String email;

    public Pessoa() {
    }

    public Pessoa(String nome, int idade, String cpf, String email) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.email = email;
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

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

public class cliente extends Pessoa implements Avaliacao {

    public cliente() {
        super();
    }

    public cliente(String nome, int idade, String cpf, String email) {
        super(nome, idade, cpf, email);
    }

    public static void main(String[] args) {
        ArrayList<cliente> clientes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantidade de contas a serem cadastradas: ");
        int quantidadeClientes = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < quantidadeClientes; i++) {
            cliente cliente = new cliente();

            System.out.print("Nome: ");
            cliente.setNome(scanner.nextLine());

            System.out.print("Idade: ");
            cliente.setIdade(scanner.nextInt());
            scanner.nextLine();

            System.out.print("CPF: ");
            cliente.setCpf(scanner.nextLine());

            System.out.print("Email: ");
            cliente.setEmail(scanner.nextLine());

            clientes.add(cliente);

            cliente.avaliar();
            cliente.exibirAvaliacao();
        }

        scanner.close();

        System.out.println("Dados das contas:");

        for (cliente cliente : clientes) {
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Idade: " + cliente.getIdade());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println("------------------------------");
        }
    }

    @Override
    public void avaliar() {
    }

    @Override
    public void exibirAvaliacao() {
    }
}