import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        ConsultaMoeda cMoeda = new ConsultaMoeda();

        int numeroOpcao = 0;
        while (numeroOpcao != 7) {

            System.out.println("""
                        🪙 CONVERSOR DE MOEDAS 🪙
                         
                    1) Dólar =>> Peso Argentino
                    2) Peso Argentino ==> Dólar
                    3) Dólar =>> Real Brasileiro
                    4) Real Brasileiro =>> Dólar
                    5) Dólar =>> Peso Colombiano
                    6) Peso Colombiano =>> Dólar
                    7) SAIR
                   """);
            System.out.println("Escolha uma das opções a cima:");
            numeroOpcao = leitura.nextInt();
            System.out.println("Digite o valor que deseja converter:");
            double valorAConverter = leitura.nextDouble();

            String moeda = "";
            String target_code = "";

            switch (numeroOpcao) {
                case 1:
                    moeda = "USD";
                    target_code = "ARS";

                    break;
                case 2:
                    moeda = "ARS";
                    target_code = "USD";
                    break;
                case 3:
                    moeda = "USD";
                    target_code = "BRL";
                    break;
                case 4:
                    moeda = "BRL";
                    target_code = "USD";
                    break;
                case 5:
                    moeda = "USD";
                    target_code = "COP";
                    break;
                case 6:
                    moeda = "COP";
                    target_code = "USD";
                    break;
                case 7:
                    System.out.println("Programa encerrado");
                    break;
                default:
                    System.out.println("Opação inválida.\nEscolha uma opção válida.");

            }
            Moeda novaMoeda = cMoeda.consultaMoeda(moeda, target_code, valorAConverter);
            System.out.printf("""
                    O valor %s [%s] corresponde ao valor final de =>> %f [%s]
                    
                    """, valorAConverter, novaMoeda.base_code(), novaMoeda.conversion_result(), novaMoeda.target_code())
            ;

        }
        leitura.close();

    }
}