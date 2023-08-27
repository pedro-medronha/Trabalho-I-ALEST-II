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
        String dna = null;
        for (int i = 0; i < total; i++) {
            String caracter = String.valueOf(letras[r.nextInt(3)]);
            if (dna == null) { // Primeiro caractere
                dna = caracter;
            } else {
                dna += caracter;
            }
            System.out.print(caracter);
        }
        System.out.println("\n");

        AlgortimoMutacoes algortimo = new AlgortimoMutacoes(dna);
        System.out.println(algortimo.decomposicao());
    }
}