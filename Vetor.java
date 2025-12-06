public class Vetor {
  private int[] elementos;
  private int tamanhoAtual;

  public Vetor(int capacidade) {
    this.elementos = new int[capacidade];
    this.tamanhoAtual = 0;
  }

  public void imprimirVetorParaTeste() {
    System.out.print("[");
    for (int i = 0; i < this.tamanhoAtual; i++) {
      System.out.print(this.elementos[i]);
      if (i < this.tamanhoAtual - 1) {
        System.out.print(", ");
      }
    }
    System.out.println("]");
  }

  public void inserir(int elemento) {
    if (this.tamanhoAtual == elementos.length) {
      System.out.println("Vetor cheio");
      return;
    }
    this.elementos[this.tamanhoAtual] = elemento; // 1 operação
    this.tamanhoAtual++; // 2 operações -> É constante O(1)

  }

  public boolean buscarSequencial(int elemento) {
    for (int i = 0; i < this.tamanhoAtual; i++) { // N operações -> percorre tudo O(N)
      if (this.elementos[i] == elemento) {
        return true;
      }
    }
    return false;
  }

  public boolean buscarBinaria(int elemento) {
    int inicio = 0;
    int fim = this.tamanhoAtual - 1;
    while (inicio <= fim) { // log N operações -> pior caso: encontrado na última posição ou não encontrado
      int meio = (inicio + fim) / 2; // 1 operação
      if (this.elementos[meio] == elemento) {
        return true;
      } else if (this.elementos[meio] < elemento) {
        inicio = meio + 1; // 1 operação
      } else {
        fim = meio - 1; // 1 operação
      }
    }

    return false;
  }

  public void ordenarInsertSort() { // pior caso tem que executar o for e o while N vezes -> O(N^2) ; melhor caso
                                    // O(N) quando o array já está ordenado
    int n = this.tamanhoAtual;
    for (int i = 1; i < n; i++) { // N operações -> percorre todo o array que não está ordenado
      int valor = this.elementos[i]; // assume que o valor atual é o segundo elemento do array
      int indiceAnterior = i - 1; // o indice que vamos fazer a comparação - elemento anterior
      while (indiceAnterior >= 0 && this.elementos[indiceAnterior] > valor) { // enquanto o anterior for maior que o
                                                                              // valor, eles vão pra direita
        this.elementos[indiceAnterior + 1] = this.elementos[indiceAnterior]; // troca de posição
        indiceAnterior--; // vai andando pra esquerda
      }
      this.elementos[indiceAnterior + 1] = valor;
    }
  }

  private void ordenarQuickSort(int inicio, int fim) { // O(n log n) no caso médio e melhor caso; O(n^2) no pior caso
    if (inicio < fim) {
      int indicePivo = partir(inicio, fim);
      ordenarQuickSort(inicio, indicePivo - 1);
      ordenarQuickSort(indicePivo + 1, fim);
    }
  }

  private int partir(int inicio, int fim) {
    int meio = (inicio + fim) / 2;
    int pivo = this.elementos[meio]; // escolhe o pivô como o elemento do meio

    // Move o pivô para o fim temporariamente
    int temp = this.elementos[meio];
    this.elementos[meio] = this.elementos[fim];
    this.elementos[fim] = temp;

    int i = inicio - 1;

    for (int j = inicio; j < fim; j++) { // percorre o vetor
      if (this.elementos[j] <= pivo) { // se o elemento atual for menor ou igual ao pivô
        i++;
        int swap = this.elementos[i];
        this.elementos[i] = this.elementos[j];
        this.elementos[j] = swap;
      }
    }

    // Coloca o pivô na posição correta
    int swap = this.elementos[i + 1];
    this.elementos[i + 1] = this.elementos[fim];
    this.elementos[fim] = swap;

    return i + 1;
  }

  public void ordenarQuickSort() {
    // usa o início = 0 e o fim = tamanhoAtual - 1 do vetor
    ordenarQuickSort(0, this.tamanhoAtual - 1);
  }
}