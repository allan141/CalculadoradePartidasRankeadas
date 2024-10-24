import java.util.Scanner;

public class CalculadoraRanqueadas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Digite a quantidade de vitórias: ");
                int vitorias = Integer.parseInt(scanner.nextLine());

                System.out.print("Digite a quantidade de derrotas: ");
                int derrotas = Integer.parseInt(scanner.nextLine());

                Resultados resultados = calcularRanque(vitorias, derrotas);
                System.out.printf("O Herói tem de saldo de %d e está no nível de %s%n", resultados.saldoVitorias, resultados.nivel);

            } catch (NumberFormatException e) {
                System.out.println("Por favor, insira apenas números inteiros.");
            }

            System.out.print("Deseja calcular novamente? (s/n): ");
            String continuar = scanner.nextLine().trim().toLowerCase();
            if (!continuar.equals("s")) {
                break;
            }
        }

        scanner.close();
    }

    public static Resultados calcularRanque(int vitorias, int derrotas) {
        int saldoVitorias = vitorias - derrotas;
        String nivel;

        if (vitorias < 10) {
            nivel = "Ferro";
        } else if (vitorias <= 20) {
            nivel = "Bronze";
        } else if (vitorias <= 50) {
            nivel = "Prata";
        } else if (vitorias <= 80) {
            nivel = "Ouro";
        } else if (vitorias <= 90) {
            nivel = "Diamante";
        } else if (vitorias <= 100) {
            nivel = "Lendário";
        } else {
            nivel = "Imortal";
        }

        return new Resultados(saldoVitorias, nivel);
    }

    static class Resultados {
        int saldoVitorias;
        String nivel;

        Resultados(int saldoVitorias, String nivel) {
            this.saldoVitorias = saldoVitorias;
            this.nivel = nivel;
        }
    }
}
