import java.util.LinkedList;

public class AlgoritmoMutacoes {

    private LinkedList<Character> decompositor;

    public AlgoritmoMutacoes(String dna) {
        this.decompositor = new LinkedList<>();
        for (char c : dna.toCharArray()) {
            this.decompositor.add(c);
        }
    }

    public String decomposicao() {
        LinkedList<Character> dnaSequencia = new LinkedList<>(decompositor);

        boolean mutacao;

        do {
            mutacao = false;
            for (int i = 0; i < dnaSequencia.size() - 1; i++) {
                char baseAtual = dnaSequencia.get(i);
                char proxBase = dnaSequencia.get(i + 1);

                if (baseAtual != proxBase) {
                    char novaBase = realizaMutacao(baseAtual, proxBase);
                    dnaSequencia.set(i, novaBase);
                    dnaSequencia.remove(i + 1);
                    mutacao = true;
                    break;
                }
            }
        } while (mutacao);

        return dnaSequencia.toString();
    }

    private char realizaMutacao(char base1, char base2) {
        if ((base1 == 'D' && base2 == 'A') ||
                (base1 == 'A' && base2 == 'D')) {
            return 'N';
        } else if ((base1 == 'D' && base2 == 'N') ||
                (base1 == 'N' && base2 == 'D')) {
            return 'A';
        } else if ((base1 == 'A' && base2 == 'N') ||
                (base1 == 'N' && base2 == 'A')) {
            return 'D';
        } else {
            return base1;
        }
    }
}