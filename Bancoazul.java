import java.util.Locale;
import java.util.Scanner;

class Bancoazul{
    public static void main(String[] args){
        /* int deposito = 0; */
        double saldo = 0;
        String extrato = "";
        int numerosaques = 0;
        int limitedesaques = 3;
        double limiteValor = 500;
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=============================\n");
            System.out.println("====Escolha uma das opções====\n");
            System.out.println("[1] - deposito\n");
            System.out.println("[2] - Saque\n");
            System.out.println("[3] - Extrato\n");
            System.out.println("[4] - Sair\n");
            System.out.println("=============================\n");

            int opcao = scanner.nextInt();
            if(opcao == 1){
                System.out.println("Digite o valor do deposito : \n");
                double valordeposito = scanner.nextDouble();

                if(valordeposito > 0){
                    saldo += valordeposito;
                    String respostAoextrato = "O valor do deposito foi de %.2f";
                    String respostaFormatada = String.format(respostAoextrato, valordeposito);
                    extrato += respostaFormatada+"\n";
                    System.out.println(extrato+"\n");
                }else{
                    System.out.println("Valor informado é invalido\n");
                }

            }
            else if(opcao == 2){
                System.out.println("Digite o valor do saque : \n");
                double saquevalor = scanner.nextDouble();
                boolean valor1 = saquevalor > saldo;
                boolean valor2 = saquevalor > limiteValor;
                boolean valor3 = numerosaques == 3;
                if(valor1){
                    System.out.println("Valor indicado superou o valor do seu saldo atual. Tente novamente");
                }else if(valor2){
                    System.out.println("Valor indicado superou o valor de 500. Tente novamente");
                }else if(valor3){
                    System.out.println("Nao foi possivel realizar a operação porque o valor de saques possiveis foi excedido. Tente novamente");
                }else{
                        saldo -= saquevalor;
                        String respostaAoextrato = "O valor do saque foi de %.2f";
                        String respostaFormatada = String.format(respostaAoextrato, saquevalor);
                        System.out.println(respostaFormatada);
                        extrato += respostaFormatada+"\n";
                        numerosaques++;
                }
                    /* saldo -= saquevalor;
                    String respostaAoextrato = "O valor do saque foi de %.2f";
                    String respostaFormatada = String.format(respostaAoextrato, saquevalor);
                    extrato += respostaFormatada+"\n";
                    numerosaques++; */
                

            
            }else if(opcao == 3){
                String mensagem = extrato.isEmpty() ? "Não foi realizadas movimentações" : extrato;
                System.out.println(mensagem+"\n");
                System.out.println();
                System.out.println("Saldo atual : "+saldo);
                System.out.println("\n");
            }
            else if(opcao == 4){
                System.out.println("\nAte breve...\n");
                break;
            }
        }
        scanner.close();
        


    }
}