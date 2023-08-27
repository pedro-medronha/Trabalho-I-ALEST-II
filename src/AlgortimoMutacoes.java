import java.util.LinkedList;

public class AlgortimoMutacoes {
    private LinkedList<Character> decompositor;

    public AlgortimoMutacoes(String dna) {
        decompositor = new LinkedList<>();

        for (int i=0; i<dna.length(); i++) {
            decompositor.add(dna.charAt(i));
        }
    }

    public String decomposicao() {
        for (int i=0; i<decompositor.size(); i++) {

            switch (decompositor.get(i)) {
                case 'D' -> {
                    if(i == decompositor.size()-1) break;
                    if (decompositor.get(i+1).equals('A')) {
                        decompositor.removeFirst();
                        decompositor.removeFirst();
                        decompositor.add('N');
                    } else if (decompositor.get(i+1).equals('N')) {
                        decompositor.removeFirst();
                        decompositor.removeFirst();
                        decompositor.add('A');
                    }
                }
                case 'N' -> {
                    if(i == decompositor.size()-1) break;
                    if (decompositor.get(i+1).equals('A')) {
                        decompositor.removeFirst();
                        decompositor.removeFirst();
                        decompositor.add('D');
                    } else if (decompositor.get(i+1).equals('D')) {
                        decompositor.removeFirst();
                        decompositor.removeFirst();
                        decompositor.add('A');
                    }
                }
                case 'A' -> {
                    if(i == decompositor.size()-1) break;
                    if (decompositor.get(i+1).equals('D')) {
                        decompositor.removeFirst();
                        decompositor.removeFirst();
                        decompositor.add('N');
                    } else if (decompositor.get(i+1).equals('N')) {
                        decompositor.removeFirst();
                        decompositor.removeFirst();
                        decompositor.add('D');
                    }
                }
                default -> throw new IllegalStateException("Unexpected value: " + decompositor.get(i));
            }
        }

        return decompositor.toString();
    }
}