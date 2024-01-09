import java.util.ArrayList;
import java.util.Scanner;

interface OperacaoPedido {
}

class Pedido {
    private String jogo;
    private String item;
    private String cliente;
    private boolean comprar;

    public Pedido() {
    }

    public Pedido(String jogo, String item, String cliente, boolean comprar) {
        this.jogo = jogo;
        this.item = item;
        this.cliente = cliente;
        this.comprar = comprar;
    }

    public String getJogo() {
        return jogo;
    }

    public void setJogo(String jogo) {
        this.jogo = jogo;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public boolean isComprar() {
        return comprar;
    }

    public void setComprar(boolean comprar) {
        this.comprar = comprar;
    }
}

class PedidoOnline extends Pedido implements OperacaoPedido {
    private String enderecoEntrega;

    public PedidoOnline() {
        super();
    }

    public PedidoOnline(String jogo, String item, String cliente, boolean comprar, String enderecoEntrega) {
        super(jogo, item, cliente, comprar);
        this.enderecoEntrega = enderecoEntrega;
    }

    public void processarPedido() {
        System.out.println("Pedido Online processado. Enviando para o endereço de entrega: " + enderecoEntrega);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Pedido> pedidos = new ArrayList<>();

        System.out.println("Digite os detalhes do pedido:");

        System.out.print("Nome do Jogo: ");
        String jogo = scanner.nextLine();

        System.out.print("Item do Pedido: ");
        String item = scanner.nextLine();

        System.out.print("Nome do Cliente: ");
        String cliente = scanner.nextLine();

        System.out.print("Deseja comprar? (true/false): ");
        boolean comprar = scanner.nextBoolean();

        Pedido pedido;

        if (comprar) {
            System.out.print("Digite o endereço de entrega: ");
            String enderecoEntrega = scanner.next();
            pedido = new PedidoOnline(jogo, item, cliente, comprar, enderecoEntrega);
            ((PedidoOnline) pedido).processarPedido();
        } else {
            pedido = new Pedido(jogo, item, cliente, comprar);
        }

        pedidos.add(pedido);

        scanner.close();

        for (Pedido p : pedidos) {
            System.out.println("Detalhes do Pedido:");
            System.out.println("Jogo: " + p.getJogo());
            System.out.println("Item: " + p.getItem());
            System.out.println("Cliente: " + p.getCliente());
            if (p.isComprar()) {
                System.out.println("Compra realizada!");
                if (p instanceof PedidoOnline) {
                    System.out.println("Endereço de entrega: " + ((PedidoOnline) p).enderecoEntrega);
                }
            } else {
                System.out.println("Compra não realizada!");
            }
        }
    }
}