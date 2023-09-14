import java.util.Scanner ;

public class Program{
    public static void main (String[] args){
        String s = "";
        Numero n;
                
        System.out.println("\n\n________________________________________");
        
        if (args.length == 0){
            Scanner in = new Scanner(System.in);
            System.out.print("Digite um numero : ");
            s = in.nextLine();
            in.close();
        }
        else{
            for (String string : args) {
                s += string;
            }
        }

        try{
            n = new Numero(s);
        }
        catch(NumberFormatException e) {
            System.out.println("# ERRO: o numero que você digitou não é válido. \n Encerrando o programa... \n");
            System.out.println(e);
            return;
        }

        System.out.println();
        System.out.println("2-) Escreva um programa que dado um valor numérico digitado pelo usuário (armazenado em  uma variável inteira), imprima cada um dos seus dígitos por extenso.");
        System.out.print("\tDigitos de [" + n.getValue() + "] : ");
        System.out.println(n.getDigitosPorExtenso());
        System.out.println("\n encerrando o programa ... \n\n");


        /*
        Long a = Test("A");
        System.out.println();
        Long b = Test("B");
        System.out.println("__________________");
        System.out.println("B is better : \t" + (a>b));
        System.out.println("Melhoria : \t" + (a/b)*100 + "%");
        System.out.println("Diferenca: \t" + (a-b));
        */
    }

    static Long Test(String param){
        int counter = 0;

        long start = System.nanoTime();
        for (int i = 1; i < 10000; i*=9) {
            for (int j = 0; j < 10000; j++) {
                Numero n = new Numero(i);

                if(param == "A"){
                    n.getDigitosPorExtenso();
                }

                
                if(param == "B"){
                    n.OptimizedGetDigitosPorExtenso();
                }

                counter++;
            }
        }
        long finish = System.nanoTime();

        System.out.println("\n_________________\n\tMETODO " + param);
        System.out.println(" iteracoes: \t" + counter);
        System.out.println(" start : \t" + start);
        System.out.println(" finish : \t" + finish);
        System.out.println(" elapsed : \t" + (finish-start));

        return (finish-start);
    }
}