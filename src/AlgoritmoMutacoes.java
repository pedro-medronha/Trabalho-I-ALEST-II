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
                    if (novaBase != '0') { // Se houve mutação...
                        dnaSequencia.add(novaBase); // Adiciona ao fim
                        dnaSequencia.remove(i); // Remove as 2 bases antigas
                        dnaSequencia.remove(i);
                    }
                    mutacao = true;
                    break;
                }
            }
        } while (mutacao);

        return dnaSequencia.toString();
    }

    private char realizaMutacao(char base1, char base2) {
        char newBase = '0';
        switch (base1) {
            case 'D':
                if (base2 == 'A')
                    newBase = 'N';
                if (base2 == 'N')
                    newBase = 'A';
                break;
            case 'N':
                if (base2 == 'A')
                    newBase = 'D';
                if (base2 == 'D')
                    newBase = 'A';
                break;
            case 'A':
                if (base2 == 'D')
                    newBase = 'N';
                if (base2 == 'N')
                    newBase = 'D';
                break;
            default:
                return newBase;
        }

        return newBase;
    }
}