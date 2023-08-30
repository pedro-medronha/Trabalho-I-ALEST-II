import java.util.*;

public class DNAlgorithm {

  private LinkedList<Character> dnaSequence;
  private Map<Character, Map<Character, Character>> cache;

  public DNAlgorithm(String dna) {
    dnaSequence = new LinkedList<>();
    cache = new HashMap<>();
    cache = combination(cache);

    for (char c : dna.toCharArray()) { // Preenche a lista
      dnaSequence.add(c);
    }
  }

  /*
   * Há 2 iteradores:
   * 
   * while: determina a reinicialização do percorrimento da lista (inicio
   * index 0)
   * for: percorre a lista (do index 0 até lista.size() -1)
   */

  public String mutation() {
    boolean change;

    do {
      change = false; // Iterador while
      for (int i = 0; i < dnaSequence.size() - 1; i++) { // Loop que percorre a lista
        char current = dnaSequence.get(i);
        char prox = dnaSequence.get(i + 1);

        if (current != prox) { // Se os caracteres são diferentes...
          dnaSequence.add(generate(current, prox)); // Realiza mutação e adiciona ao fim
          dnaSequence.remove(i); // Remove as 2 bases antigas
          dnaSequence.remove(i);
          change = true; // Valida o iterador
          break; // Interrompe a iteração para reinicar no começo da lista
        }
      }
    } while (change);
    return dnaSequence.toString(); // Retorna a lista com o resultado
  }

  private Map<Character, Map<Character, Character>> combination(Map<Character, Map<Character, Character>> cache) {
    cache.put('D', new HashMap<>());
    cache.get('D').put('A', 'N');
    cache.get('D').put('N', 'A');

    cache.put('N', new HashMap<>());
    cache.get('N').put('A', 'D');
    cache.get('N').put('D', 'A');

    cache.put('A', new HashMap<>());
    cache.get('A').put('D', 'N');
    cache.get('A').put('N', 'D');

    return cache;
  }

  private char generate(char baseOne, char baseTwo) {
    return cache.getOrDefault(baseOne, new HashMap<>())
        .getOrDefault(baseTwo, '#');
  }
}