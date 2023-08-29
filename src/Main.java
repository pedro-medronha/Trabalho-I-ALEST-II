/*
 * Trabalho 1 - ALEST II
 * Prof. Marcelo Cohen
 * --------------------------
 * Alunos: Bianca Alves e Pedro Medronha
 * 
 * Obs: necessário estipular no path .vscode/launch.json 
 * o parâmetro args, para definir o tamanho da entrada
 */

import java.util.Random;

public class Main {
  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("java GeradorCasosTesteTrabalho1 [total]");
      System.exit(1);
    }

    Random r = new Random();
    int total = Integer.parseInt(args[0]);
    char[] leters = { 'D', 'N', 'A' };
    StringBuilder dnaBuilder = new StringBuilder();

    System.out.println("Entrada:");
    for (int i = 0; i < total; i++) {
      char character = leters[r.nextInt(3)];
      dnaBuilder.append(character);
      System.out.print(character);
    }
    System.out.println("\n"); // Quebra de linha

    long start = System.nanoTime();
    DNAlgorithm dna = new DNAlgorithm(dnaBuilder.toString());
    long end = System.nanoTime();
    System.out.println("Resultado:\n" + dna.mutation());
    System.out.printf("Tempo: %d ns\n", end - start);
  }
}