import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        double saldo = 2000.00;
        int opcao = 0;
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        String textoInitial = """
                ****************************
                Banco Java 
                Oi tudo bem?
                Seu saldo %s
                ****************************
                """.formatted(formatoMoeda.format(saldo));

        System.out.println(textoInitial);

        do{
            String textoOpcao = """
                ****************************
                Seleciona as opções:
                1- Ver saldo;
                2- Fazer Deposito;
                3- Fazer Saque;
                4- Sair
                ****************************
                """;
            System.out.println(textoOpcao);
            opcao = sc.nextInt();
            switch(opcao){
                case 1:
                    System.out.println("O Saldo é: "+ formatoMoeda.format(saldo));
                    break;
                case 2:
                    System.out.println("O Saldo é: "+ formatoMoeda.format(saldo));
                    System.out.println("O qual valor de deposito: ");
                    double deposito = sc.nextDouble();
                    saldo += deposito;
                    System.out.println("O Saldo Final: "+ formatoMoeda.format(saldo));
                    break;
                case 3:
                    System.out.println("O Saldo é: "+ formatoMoeda.format(saldo));
                    if(saldo > 0) {
                        System.out.println("O qual valor de saque: ");
                        double saque = sc.nextDouble();
                        if(saque > saldo) {
                            System.out.println("Valor do saque maior que o saldo");
                        }else {
                            saldo -= saque;
                            System.out.println("O Saldo Final: " + formatoMoeda.format(saldo));
                        }
                    }
                    break;
                case 4:
                    System.out.println("Sair da tela");
                    break;
            }

            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        }while(opcao != 4);

    }
}