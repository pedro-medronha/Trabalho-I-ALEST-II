import java.util.LinkedList;

public class AlgortimoMutacoes {

    private LinkedList<Character> dna;

    public AlgortimoMutacoes(String dna) {
        this.dna = new LinkedList<>();
        for (char base : dna.toCharArray()) {
            this.dna.add(base);
        }
    }
}