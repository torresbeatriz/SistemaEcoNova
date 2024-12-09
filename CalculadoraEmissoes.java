import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Calculadora {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Introdução
        System.out.println("Cálculo das emissões de carbono mensais da empresa:");
        System.out.println("Por favor, insira os dados coletados no mês:");

        // 1- Veículos
        System.out.println("\nDigite o total de combustível utilizado pelos veículos no mês:");
        System.out.println(" - Gasolina (em litros):");
        double gasolina = scanner.nextDouble();

        System.out.println(" - Álcool (em litros):");
        double alcool = scanner.nextDouble();

        System.out.println(" - Diesel (em litros):");
        double diesel = scanner.nextDouble();

        System.out.println(" - Consumo de veículos elétricos (em kWh):");
        double eletrico = scanner.nextDouble();

        // Fatores de emissão para veículos
        double emissaoVGasolina = gasolina * 2.31;
        double emissaoVAlcool = alcool * 1.86;
        double emissaoVDiesel = diesel * 2.68;
        double emissaoVEletrico = eletrico * 0.5;

        double emissaoVTotal = emissaoVGasolina + emissaoVAlcool + emissaoVDiesel + emissaoVEletrico;

        // 2- Eletricidade
        System.out.println("\nDigite o consumo de eletricidade total da empresa (em kWh):");
        double consumoEletrico = scanner.nextDouble();
        double eletricidade = consumoEletrico * 0.5;

        // 3- Gás natural
        System.out.println("\nDigite o consumo de gás natural total da empresa (em m³):");
        double consumoGas = scanner.nextDouble();
        double gas = consumoGas * 2.0;

        // 4- Resíduos (lixo)
        System.out.println("\nDigite a quantidade total de resíduos gerados (em kg):");
        double kgResiduos = scanner.nextDouble();
        double residuo = kgResiduos * 1.2;

        // 5- Uso de papel
        System.out.println("\nDigite a quantidade total de papel consumida (em kg):");
        double kgPapel = scanner.nextDouble();
        double papel = kgPapel * 1.5;

        // Cálculo da emissão total
        double emissaoTotal = emissaoVTotal + eletricidade + gas + residuo + papel;

        // Obtém o mês atual e traduz para português
        LocalDate dataAtual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM").withLocale(new java.util.Locale("pt", "BR"));
        String mesAtual = dataAtual.format(formatter);

        // Exibe o resultado
        System.out.printf("\nA emissão de carbono total da empresa no mês de %s é: %.2f kg de CO2\n", mesAtual, emissaoTotal);

        scanner.close();
    }
}
