import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

interface ProdutoraJogos {
    void produzirJogo(String nome, String jogo);
    void listarJogos();
}

class Empresa {
    private String ubisoft;
    private String ryotGames;
    private String microsoft;
    private String eaSports;
    private String rockstar;
    private String gameloft;

    public Empresa() {
    }

    protected void setUbisoft(String ubisoft) {
        this.ubisoft = ubisoft;
    }

    protected void setRyotGames(String ryotGames) {
        this.ryotGames = ryotGames;
    }

    public void setMicrosoft(String microsoft) {
        this.microsoft = microsoft;
    }

    public String getMicrosoft() {
        return microsoft;
    }

    public void setSony(String eaSports) {
        this.eaSports = eaSports;
    }

    public String getEaSports(String eaSports) {
        return eaSports;
    }
    public void setRockstar(String rockstar) {
        this.rockstar = rockstar;
    }

    public String getRockstar() {
        return rockstar;
    }

    public void setGameloft(String gameloft) {
        this.gameloft = gameloft;
    }

    public String getGameloft() {
        return gameloft;
    }

    protected void setEaSports(String s) {
    }
}

class EmpresaProdutora extends Empresa implements ProdutoraJogos {
    private Map<String, List<String>> jogosProduzidos;

    public EmpresaProdutora() {
        super();
        jogosProduzidos = new HashMap<>();
    }

    public void produzirJogo(String nome, String jogo) {
        if (!jogosProduzidos.containsKey(nome)) {
            jogosProduzidos.put(nome, new ArrayList<>());
        }
        jogosProduzidos.get(nome).add(jogo);
    }

    public void listarJogos() {
        System.out.println("Jogos produzidos por algumas empresas:");
        for (Map.Entry<String, List<String>> entry : jogosProduzidos.entrySet()) {
            System.out.println(entry.getKey() + ": " + String.join(", ", entry.getValue()));
        }
    }

    public static void main(String[] args) {
        EmpresaProdutora empresaProdutora = new EmpresaProdutora();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Jogos produzidos pela Ubisoft: ");
        empresaProdutora.setUbisoft(scanner.nextLine());

        System.out.print("Jogos produzidos pela Ryot Games: ");
        empresaProdutora.setRyotGames(scanner.nextLine());

        System.out.print("Jogos produzidos pela Microsoft: ");
        empresaProdutora.setMicrosoft(scanner.nextLine());

        System.out.print("Jogos produzidos pela Ea Sports: ");
        empresaProdutora.setEaSports(scanner.nextLine());

        System.out.print("Jogos produzidos pela Rockstar: ");
        empresaProdutora.setRockstar(scanner.nextLine());

        System.out.print("Jogos produzidos pela Gameloft: ");
        empresaProdutora.setGameloft(scanner.nextLine());

        empresaProdutora.produzirJogo("Ubisoft", "Assassin's Creed.");
        empresaProdutora.produzirJogo("Ea Sports", "Ea Sports FC 24.");
        empresaProdutora.produzirJogo("Rockstar", "GTA V.");
        empresaProdutora.produzirJogo("Ryot games", "Valorant");
        empresaProdutora.produzirJogo("Microsoft", "Call of Duty");
        empresaProdutora.produzirJogo("Gameloft", "Asphalt 9");

        empresaProdutora.listarJogos();

        scanner.close();
    }
}

