public class MedirTempo {
    private static final int repeticoes = 5;

    public static long medirInsercaoVetor(int tamanho, int[] dados) {
        long tempoTotal = 0;
        for (int i = 0; i < repeticoes; i++) {
            Vetor vetor = new Vetor(tamanho);
            long inicio = System.nanoTime();

            for (int valor : dados) {
                vetor.inserir(valor);
            }
            long fim = System.nanoTime();
            tempoTotal += (fim - inicio);
        }
        return tempoTotal / repeticoes;
        
    }

    public static long medirInsercaoABB(int tamanho, int[] dados) {
        long tempoTotal = 0;
        for (int i = 0; i < repeticoes; i++) {
            ABB arvore = new ABB();
            long inicio = System.nanoTime();

            for (int valor : dados) {
                arvore.inserir(valor);
            }
            long fim = System.nanoTime();
            tempoTotal += (fim - inicio);
        }
        return tempoTotal / repeticoes;
    }

}
