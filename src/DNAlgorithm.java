import java.util.LinkedList;

public class DNAlgorithm {
  private LinkedList<Character> dnaSequence;

  public DNAlgorithm(String dna) {
    dnaSequence = new LinkedList<>();

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

  private char generate(char baseOne, char baseTwo) {
    switch (baseOne) { // Verifica a nova base a ser gerada...
      case 'D':
        if (baseTwo == 'A')
          return 'N';
        if (baseTwo == 'N')
          return 'A';
        break;
      case 'N':
        if (baseTwo == 'A')
          return 'D';
        if (baseTwo == 'D')
          return 'A';
        break;
      case 'A':
        if (baseTwo == 'D')
          return 'N';
        if (baseTwo == 'N')
          return 'D';
    }
    return '#';
  }
}