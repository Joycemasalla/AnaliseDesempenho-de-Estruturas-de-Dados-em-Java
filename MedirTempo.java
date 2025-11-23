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

    public static long medirInsercaoAVL(int tamanho, int[] dados) {
        long tempoTotal = 0;
        for (int i = 0; i < repeticoes; i++) {
            AVL arvore = new AVL();
            long inicio = System.nanoTime();

            for (int valor : dados) {
                arvore.inserir(valor);
            }
            long fim = System.nanoTime();
            tempoTotal += (fim - inicio);
        }
        return tempoTotal / repeticoes;
    }

    public static long medirBuscaVetorSequencial(Vetor vetor, int elemento) {
        long tempoTotal = 0;
        for (int i = 0; i < repeticoes; i++) {
            long inicio = System.nanoTime();
            vetor.buscarSequencial(elemento);
            long fim = System.nanoTime();
            tempoTotal += (fim - inicio);
        }
        return tempoTotal / repeticoes;
    }

    public static long medirBuscaVetorBinaria(Vetor vetor, int elemento) {
        long tempoTotal = 0;
        for (int i = 0; i < repeticoes; i++) {
            long inicio = System.nanoTime();
            vetor.buscarBinaria(elemento);
            long fim = System.nanoTime();
            tempoTotal += (fim - inicio);
        }
        return tempoTotal / repeticoes;
    }

    public static long medirBuscaABB(ABB arvore, int elemento) {
        long tempoTotal = 0;
        for (int i = 0; i < repeticoes; i++) {
            long inicio = System.nanoTime();
            arvore.buscar(elemento);
            long fim = System.nanoTime();
            tempoTotal += (fim - inicio);
        }
        return tempoTotal / repeticoes;
    }

    public static long medirBuscaAVL(AVL arvore, int elemento) {
        long tempoTotal = 0;
        for (int i = 0; i < repeticoes; i++) {
            long inicio = System.nanoTime();
            arvore.buscar(elemento);
            long fim = System.nanoTime();
            tempoTotal += (fim - inicio);
        }
        return tempoTotal / repeticoes;
    }

    public static long medirOrdenacaoInsertSort(int[] dadosOriginais, int tamanho) {
        long tempoTotal = 0;
        for (int i = 0; i < repeticoes; i++) {
            Vetor vetor = new Vetor(tamanho);
            for (int valor : dadosOriginais) {
                vetor.inserir(valor);
            }
            long inicio = System.nanoTime();
            vetor.ordenarInsertSort();
            long fim = System.nanoTime();
            tempoTotal += (fim - inicio);
        }
        return tempoTotal / repeticoes;
    }

    public static long medirOrdenacaoQuickSort(int[] dadosOriginais, int tamanho) {
        long tempoTotal = 0;
        for (int i = 0; i < repeticoes; i++) {
            Vetor vetor = new Vetor(tamanho);
            for (int valor : dadosOriginais) {
                vetor.inserir(valor);
            }
            long inicio = System.nanoTime();
            vetor.ordenarQuickSort();
            long fim = System.nanoTime();
            tempoTotal += (fim - inicio);
        }
        return tempoTotal / repeticoes;
    }

}
