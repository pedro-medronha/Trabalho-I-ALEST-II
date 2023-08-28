import java.util.Random;

public class GeradorCasosDeTeste {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("java GeradorCasosTesteTrabalho1 [total]");
            System.exit(1);
        }

        Random r = new Random();
        int total = Integer.parseInt(args[0]);
        char[] letras = { 'D', 'N', 'A' };
        StringBuilder dnaBuilder = new StringBuilder();

        for (int i = 0; i < total; i++) {
            char caracter = letras[r.nextInt(3)];
            dnaBuilder.append(caracter);
            System.out.print(caracter);
        }

        System.out.println("\n");

        AlgoritmoMutacoes algoritmo = new AlgoritmoMutacoes(dnaBuilder.toString());
        System.out.println(algoritmo.decomposicao());
    }
}