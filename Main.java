public class Main {
    public static void main(String[] args) {

        System.out.println("\n==================================================\n");
        System.out.println("              MEDIÇÃO DE DESEMPENHO                 ");

        int[] tamanhos = { 100, 1000, 10000 };
        String[] ordens = { "Ordenada", "Inversamente Ordenada", "Aleatória" };
        GerarDados dadosTeste = new GerarDados();

        System.out.println("\n==================================================\n");
        System.out.println("           MEDIÇÃO DO TEMPO DE INSERÇÃO               ");
        System.out.println("====================================================");

        // Cabeçalho da Tabela (Melhor formato para o relatório)
        System.out.printf("| %-30s | %15s | %15s | %15s |%n",
                "Cenário (Tamanho/Ordem)",
                "Vetor (ms)",
                "ABB (ms)",
                "AVL (ms)");
        System.out.println("|--------------------------------|-----------------|-----------------|-----------------|");

        for (int tamanho : tamanhos) { // vai pegar cada tamanho

            // para cada tamanho, vai pegar cada ordem - faz todas as ordens para um tamanho
            // antes de ir para o próximo tamanho
            for (String ordem : ordens) {

                int[] dados;

                // gera os dados conforme a ordem
                if (ordem.equals("Ordenada")) {
                    dados = dadosTeste.gerarDadosOrdenados(tamanho);
                } else if (ordem.equals("Inversamente Ordenada")) {
                    dados = dadosTeste.gerarDadosInversos(tamanho);
                } else { // Aleatória
                    dados = dadosTeste.gerarDadosAleatorios(tamanho);
                }

                // mede o tempo de inserção para cada uma com o método do MedirTempo
                long tempoVetor = MedirTempo.medirInsercaoVetor(tamanho, dados);
                long tempoABB = MedirTempo.medirInsercaoABB(tamanho, dados);
                long tempoAVL = MedirTempo.medirInsercaoAVL(tamanho, dados);

                // conversão de nanosegundos para milessegundos, usa double para manter a
                // precisão
                double tempoVetorMs = tempoVetor / 1_000_000.0;
                double tempoABBMs = tempoABB / 1_000_000.0;
                double tempoAVLMs = tempoAVL / 1_000_000.0;

                // coloca os resultados na tabela
                String cenario = String.format("%d / %s", tamanho, ordem);
                System.out.printf("| %-30s | %15f | %15f | %15f |%n",
                        cenario,
                        tempoVetorMs,
                        tempoABBMs,
                        tempoAVLMs);
            }
            System.out.println(
                    "|--------------------------------|-----------------|-----------------|-----------------|");

        }

        System.out.println("==================================================");
        System.out.println("MEDIÇÃO DE INSERÇÃO CONCLUÍDA. Os tempos estão em milissegundos(ms).");

        System.out.println("\n===================================================");
        System.out.println("          MEDIÇÃO DO TEMPO DE BUSCA                 ");
        System.out.println("====================================================");

        // Mesmos tamanhos e ordens do teste de inserção

        // O que vai ser buscado (7 tipos)
        String[] tiposBusca = {
                "Primeiro Elemento", "Elemento do Meio", "Último Elemento",
                "Elemento Aleatório 1/3", "Elemento Aleatório 2/3", "Elemento Aleatório 3/3",
                "Inexistente"
        };

        // Cabeçalho da Tabela para busca

        System.out.printf("| %-30s | %-25s | %15s | %15s | %15s | %15s |%n",
                "Cenário (Tamanho/Ordem)",
                "Elemento Buscado",
                "Vetor Seq (ms)",
                "Vetor Bin (ms)",
                "ABB (ms)",
                "AVL (ms)");
        System.out.println(
                "|--------------------------------|---------------------------|-----------------|-----------------|-----------------|-----------------|");

        for (int tamanho : tamanhos) {
            for (String ordem : ordens) {

                int[] dados;

                if (ordem.equals("Ordenada")) {
                    dados = dadosTeste.gerarDadosOrdenados(tamanho);
                } else if (ordem.equals("Inversamente Ordenada")) {
                    dados = dadosTeste.gerarDadosInversos(tamanho);
                } else {
                    dados = dadosTeste.gerarDadosAleatorios(tamanho);
                }

                // Estruturas com dados na ordem original (para busca sequencial e árvores)
                PopularEstruturas estruturasOriginais = new PopularEstruturas(tamanho, dados);

                // Vetor ordenado especificamente para busca binária
                Vetor vetorOrdenado = new Vetor(tamanho);
                for (int valor : dados) {
                    vetorOrdenado.inserir(valor);
                }
                vetorOrdenado.ordenarQuickSort();

                for (int i = 0; i < tiposBusca.length; i++) {
                    String tipoBusca = tiposBusca[i];
                    int elementoBuscado = 0;

                    if (tipoBusca.equals("Primeiro Elemento")) {
                        elementoBuscado = estruturasOriginais.primeiroElemento;
                    } else if (tipoBusca.equals("Elemento do Meio")) {
                        elementoBuscado = estruturasOriginais.meioElemento;
                    } else if (tipoBusca.equals("Último Elemento")) {
                        elementoBuscado = estruturasOriginais.ultimoElemento;
                    } else if (tipoBusca.equals("Inexistente")) {
                        elementoBuscado = estruturasOriginais.elementoInexistente;
                    } else if (tipoBusca.equals("Elemento Aleatório 1/3")) {
                        elementoBuscado = estruturasOriginais.elementosAleatorios[0];
                    } else if (tipoBusca.equals("Elemento Aleatório 2/3")) {
                        elementoBuscado = estruturasOriginais.elementosAleatorios[1];
                    } else if (tipoBusca.equals("Elemento Aleatório 3/3")) {
                        elementoBuscado = estruturasOriginais.elementosAleatorios[2];
                    }

                    // Busca sequencial no vetor ORIGINAL (não ordenado)
                    long tempoVetorSeq = MedirTempo.medirBuscaVetorSequencial(estruturasOriginais.vetor,
                            elementoBuscado);

                    // Busca binária no vetor ORDENADO
                    long tempoVetorBin = MedirTempo.medirBuscaVetorBinaria(vetorOrdenado, elementoBuscado);

                    // Árvores usam estruturas originais
                    long tempoABB = MedirTempo.medirBuscaABB(estruturasOriginais.abb, elementoBuscado);
                    long tempoAVL = MedirTempo.medirBuscaAVL(estruturasOriginais.avl, elementoBuscado);

                    // converte para milissegundos
                    double tempoVetorSeqMs = tempoVetorSeq / 1_000_000.0;
                    double tempoVetorBinMs = tempoVetorBin / 1_000_000.0;
                    double tempoABBMs = tempoABB / 1_000_000.0;
                    double tempoAVLMs = tempoAVL / 1_000_000.0;

                    String cenario = String.format("%d / %s", tamanho, ordem);

                    System.out.printf("| %-30s | %-25s | %15s | %15s | %15s | %15s |%n",
                            cenario,
                            tipoBusca,
                            tempoVetorSeqMs,
                            tempoVetorBinMs,
                            tempoABBMs,
                            tempoAVLMs);
                }
                System.out.println(
                        "|--------------------------------|---------------------------|-----------------|-----------------|-----------------|-----------------|");
            }
        }
        System.out.println("MEDIÇÃO DE BUSCA CONCLUÍDA. Os tempos estão em milissegundos (ms).");

        System.out.println("\n==================================================");
        System.out.println("          MEDIÇÃO DO TEMPO DE ORDENAÇÃO             ");
        System.out.println("====================================================");

        System.out.printf("| %-30s | %20s | %20s |%n",
                "Cenário (Tamanho/Ordem)",
                "Insertion Sort (ms)",
                "QuickSort (ms)");
        System.out.println("|--------------------------------|----------------------|----------------------|");

        for (int tamanho : tamanhos) {
            for (String ordem : ordens) {

                int[] dados;

                if (ordem.equals("Ordenada")) {
                    dados = dadosTeste.gerarDadosOrdenados(tamanho);
                } else if (ordem.equals("Inversamente Ordenada")) {
                    dados = dadosTeste.gerarDadosInversos(tamanho);
                } else {
                    dados = dadosTeste.gerarDadosAleatorios(tamanho);
                }

                long tempoInsertSort = MedirTempo.medirOrdenacaoInsertSort(dados, tamanho);
                long tempoQuickSort = MedirTempo.medirOrdenacaoQuickSort(dados, tamanho);

                double tempoInsertSortMs = tempoInsertSort / 1_000_000.0;
                double tempoQuickSortMs = tempoQuickSort / 1_000_000.0;

                String cenario = String.format("%d / %s", tamanho, ordem);

                System.out.printf("| %-30s | %20.3f | %20.3f |%n",
                        cenario,
                        tempoInsertSortMs,
                        tempoQuickSortMs);
            }
            System.out.println("|--------------------------------|----------------------|----------------------|");
        }

        System.out.println("==================================================");
        System.out.println("TODAS AS MEDIÇÕES CONCLUÍDAS. Os tempos estão em milissegundos (ms).");
    }
}