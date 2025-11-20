public class AVL {
    private No raiz;

    public AVL() {
        this.raiz = null;
    }

    private int calcularAltura(No no) {
        if (no == null) {
            return 0;
        }
        return no.altura;
    }

    private int calcularBalanceamento(No no) {
        if (no == null) {
            return 0;
        }
        return calcularAltura(no.esquerda) - calcularAltura(no.direita);
    }

    private void atualizarAltura(No no) {
        no.altura = 1 + Math.max(calcularAltura(no.esquerda), calcularAltura(no.direita)); // Altura do nó é 1 + altura máxima dos filhos
    }

    private void inserirAVL(int valor) {
        this.raiz = inserirRecursivoAVL(this.raiz, valor);
    }

    private void buscarAVL(int valor) {
        buscarRecursivoAVL(this.raiz, valor);
    }

    private No rotacaoDireita(No desbalanceado) { // a arvore esta toda pra esquerda
        No pai = desbalanceado.esquerda;
        No neto = pai.direita;

        // fazer a rotação
        pai.direita = desbalanceado;
        desbalanceado.esquerda = neto;

        // atualizar alturas
        atualizarAltura(desbalanceado); // atualiza altura da antiga raiz
        atualizarAltura(pai); // atualiza altura da nova raiz

        return pai; // nova raiz da subárvore
    }

    private No rotacaoEsquerda(No desbalanceado){
        No pai = desbalanceado.direita;
        No neto = pai.esquerda;

        //fazer a rotação
        pai.esquerda = desbalanceado;;
        desbalanceado.direita = neto;

        //atualizar alturas
        atualizarAltura(desbalanceado);
        atualizarAltura(pai);

        return pai;
    }

}
