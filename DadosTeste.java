import java.util.Random;

public class DadosTeste {

    // Ordenados
    public int[] gerarDadosOrdenados(int quantidadeElementos) {
        int[] dados = new int[quantidadeElementos];
        for (int i = 0; i < quantidadeElementos; i++) {
            dados[i] = i;
        }
        return dados;
    }

    // Inversamente Ordenados
    public int[] gerarDadosInversos(int quantidadeElementos) {
        int[] dados = new int[quantidadeElementos];
        for (int i = 0; i < quantidadeElementos; i++) {
            dados[i] = quantidadeElementos - i;
        }
        return dados;
    }

    // Aleatórios
    public int[] gerarDadosAleatorios(int quantidadeElementos) {
        int[] dados = new int[quantidadeElementos];
        Random random = new Random();
        for (int i = 0; i < quantidadeElementos; i++) {
            dados[i] = random.nextInt(quantidadeElementos);
        }
        return dados;
    }
}
