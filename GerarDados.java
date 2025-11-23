import java.util.Random;

public class GerarDados {

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
            dados[i] = quantidadeElementos - i - 1;
        }
        return dados;
    }

    // Aleatórios
    public int[] gerarDadosAleatorios(int quantidadeElementos) {
        int[] dados = new int[quantidadeElementos];
        for (int i = 0; i < quantidadeElementos; i++) {
            dados[i] = i;
        }
        // Embaralhar os dados
        Random random = new Random();
        for (int i = quantidadeElementos - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = dados[i];
            dados[i] = dados[j];
            dados[j] = temp;
        }
        return dados;
    }
}
