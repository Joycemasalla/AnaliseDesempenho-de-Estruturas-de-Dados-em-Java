public class Vetor{
  private int [] elementos;
  private int tamanhoAtual;

  public Vetor(int capacidade){
    this.elementos = new int[capacidade];
    this.tamanhoAtual = 0;
  }

  public void inserir(int elemento){
    if(this.tamanhoAtual == elementos.length){
        System.out.println("Vetor cheio");
        return;
    }
    this.elementos[this.tamanhoAtual] = elemento; //1 operação
    this.tamanhoAtual++; //2 operações -> É constante O(1)

  }

  public boolean buscarSequencial (int elemento){
    for(int i = 0; i < this.tamanhoAtual; i++){ // N operações -> percorre tudo O(N)
        if(this.elementos[i] == elemento){
            return true;
        }
    }
    return false;
  }

  public boolean buscarBinaria (int elemento){
    int inicio = 0;
    int fim = this.tamanhoAtual - 1; 
    while(inicio <= fim){ // log N operações   -> pior caso encontrado na últia posição ou não encontrado
        int meio = (inicio + fim) / 2; // 1 operação
        if(this.elementos[meio] == elemento){
            return true;
        } else if(this.elementos[meio] < elemento){
            inicio = meio + 1; // 1 operação
        } else {
            fim = meio - 1; // 1 operação
        }
    }
    
    return false;
  }

  public void ordenarInsertSort(){
    
  }
}