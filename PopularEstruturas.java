import java.util.Random;

public class PopularEstruturas {
    public final Vetor vetor;
    public final ABB abb;
    public final AVL avl;

    public final int primeiroElemento;
    public final int ultimoElemento;
    public final int meioElemento;
    public final int[] elementosAleatorios; // 3 elementos aleatórios que existem
    public final int elementoInexistente; // elemento que não existe

    public PopularEstruturas(int tamanho, int[] dadosOriginais) {
        //cria as as estruturas vazias
        this.vetor = new Vetor(tamanho);
        this.abb = new ABB();
        this.avl = new AVL();

        //coloca os mesmos dados em todas 
        for (int valor : dadosOriginais) {
            this.vetor.inserir(valor);
            this.abb.inserir(valor);
            this.avl.inserir(valor);
        }

        this.primeiroElemento = dadosOriginais[0]; // Primeiro inserido 
        this.ultimoElemento = dadosOriginais[tamanho - 1]; // Último inserido 
        this.meioElemento = dadosOriginais[tamanho / 2]; // Elemento do meio 

        this.elementoInexistente = -1; // Elemento que não existe - os valores gerados são positivos

        // 3 elementos aleatórios 
        Random rand = new Random();
        this.elementosAleatorios = new int[3];
        for (int i = 0; i < 3; i++) {
            // Pega 3 índices aleatórios do vetor original
            this.elementosAleatorios[i] = dadosOriginais[rand.nextInt(tamanho)];
        }
    }

    public void ordenarVetorParaBusca() {
        this.vetor.ordenarQuickSort();
    }
}