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
        // FB > 1 (Desequilíbrio para a Direita) | FB < -1 (Desequilíbrio para a  Esquerda)
        return calcularAltura(no.direita) - calcularAltura(no.esquerda);
    }

    private void atualizarAltura(No no) {
        no.altura = 1 + Math.max(calcularAltura(no.direita), calcularAltura(no.esquerda)); // Altura do nó é 1 + altura máxima dos filhos
    }

    public void inserir(int valor) {
        this.raiz = inserirRecursivoAVL(this.raiz, valor);
    }

    public boolean buscarAVL(int valor) {
        return buscarRecursivoAVL(this.raiz, valor);
    }

    // ROTACAO SIMPLES: GIRA PARA A DIREITA (Corrige desequilíbrio ESQUERDA-ESQUERDA)
    // FB <= -2 e o novo nó está na sub-subárvore esquerda.

    private No rotacaoParaDireita(No desbalanceado) { // a arvore esta toda pra esquerda
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

    // ROTACAO SIMPLES: GIRA PARA A ESQUERDA (Corrige desequilíbrio DIREITA-DIREITA)
    // FB >= +2 e o novo nó está na sub-subárvore direita.
    private No rotacaoParaEsquerda(No desbalanceado) {
        No pai = desbalanceado.direita;
        No neto = pai.esquerda;

        // fazer a rotação
        pai.esquerda = desbalanceado;

        desbalanceado.direita = neto;

        // atualizar alturas
        atualizarAltura(desbalanceado);
        atualizarAltura(pai);

        return pai;
    }

    // ROTACAO DUPLA: ESQUERDA-DIREITA (Corrige desequilíbrio ESQUERDA-DIREITA)
    // FB <= -2 e a inserção ocorre na sub-direita do filho esquerdo.
    private No rotacaoEsquerdaDireita(No desbalanceado) {

        // 1 Rotação Simples à ESQUERDA no filho esquerdo (vira em Esquerda-Esquerda)
        desbalanceado.esquerda = rotacaoParaEsquerda(desbalanceado.esquerda);

        // 2 Rotação Simples à DIREITA na raiz desbalanceada
        return rotacaoParaDireita(desbalanceado);
    }

    // ROTACAO DUPLA: DIREITA-ESQUERDA (Corrige desequilíbrio DIREITA-ESQUERDA)
    // FB >= +2 e a inserção ocorre na sub-esquerda do filho direito.

    private No rotacaoDireitaEsquerda(No desbalanceado) {

        // 1 Rotação Simples à DIREITA no filho direito (vira Direita-Direita)
        desbalanceado.direita = rotacaoParaDireita(desbalanceado.direita);

        // 2 Rotação Simples à ESQUERDA na raiz desbalanceada
        return rotacaoParaEsquerda(desbalanceado);

    }

    public No inserirRecursivoAVL(No raiz, int valor) {
        if (raiz == null) {
            return new No(valor);
        }

        if (valor < raiz.valor) {
            raiz.esquerda = inserirRecursivoAVL(raiz.esquerda, valor);
        } else if (valor > raiz.valor) {
            raiz.direita = inserirRecursivoAVL(raiz.direita, valor);
        } else {
            return raiz;
        }

        atualizarAltura(raiz);

        int balanceamento = calcularBalanceamento(raiz);

        // Casos de desbalanceamento
        // ESQUERDA-ESQUERDA: FB < -1 e inserção na esquerda
        if (balanceamento < -1 && valor < raiz.esquerda.valor) {
            return rotacaoParaDireita(raiz);

            // DIREITA-DIREITA: FB > 1 e inserção na direita
        } else if (balanceamento > 1 && valor > raiz.direita.valor) {
            return rotacaoParaEsquerda(raiz);
        }

        // ESQUERDA-DIREITA: FB < -1 e inserção na direita
        else if (balanceamento < -1 && valor > raiz.esquerda.valor) {
            return rotacaoEsquerdaDireita(raiz);
        }

        // DIREITA-ESQUERDA: FB > 1 e inserção na esquerda
        else if (balanceamento > 1 && valor < raiz.direita.valor) {
            return rotacaoDireitaEsquerda(raiz);
        }

        return raiz;
    }

    private boolean buscarRecursivoAVL(No raiz, int valor) {
        if (raiz == null) {
            return false;
        }
        if (raiz.valor == valor) {
            return true;
        }
        if (valor > raiz.valor) {
            return buscarRecursivoAVL(raiz.direita, valor);
        } else {
            return buscarRecursivoAVL(raiz.esquerda, valor);
        }

    }

}
