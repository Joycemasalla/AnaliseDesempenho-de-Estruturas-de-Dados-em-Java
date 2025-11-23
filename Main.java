public class Main {
    public static void main(String[] args) {

        System.out.println("ESTRUTURA VETOR (ARRAY)");
        System.out.println("==================================================");

        Vetor vetor = new Vetor(5);

        // --- Inserção e Validação do Limite ---
        System.out.println("\n--- Inserção e Checagem de Limite ---");
        vetor.inserir(10);
        vetor.inserir(30);
        vetor.inserir(40);
        vetor.inserir(20);
        vetor.inserir(50);
        vetor.inserir(60); // Testa a mensagem de "Vetor cheio"

        System.out.print("Vetor Atual [10,30,40,20,50]: ");
        vetor.imprimirVetorParaTeste();

        System.out.println("\n--- Busca Sequencial (O(N)) ---");
        System.out.println("Buscar 30 (Existe): " + vetor.buscarSequencial(30)); // Esperado: true
        System.out.println("Buscar 99 (Não Existe): " + vetor.buscarSequencial(99)); // Esperado: false

        System.out.println("\n--- Ordenação (Insertion Sort) e Busca Binária ---");
        System.out.println("Vetor antes da ordenação: ");
        vetor.imprimirVetorParaTeste();

        vetor.ordenarInsertSort(); // Ordena o vetor

        System.out.println("Vetor após Ordenação (aplica o método ordenarInsertSort): ");
        vetor.imprimirVetorParaTeste();

        System.out.println("\nBusca Binária no vetor ordenado:");
        System.out.println("Buscar 20 (Existe): " + vetor.buscarBinaria(20));
        System.out.println("Buscar 99 (Não Existe): " + vetor.buscarBinaria(99));

        System.out.println("\n==================================================");
        System.out.println("ÁRVORE BINÁRIA DE BUSCA (ABB)");

        ABB arvore1 = new ABB();
        System.out.println("\n--- Balanceada ---");
        System.out.println("Inserindo: 50(raiz), 30, 70, 20...");
        arvore1.inserir(50);
        arvore1.inserir(30);
        arvore1.inserir(70);
        arvore1.inserir(20);

        System.out.println("Buscar 30 (Existe): " + arvore1.buscar(30));
        System.out.println("Buscar 90 (Não Existe): " + arvore1.buscar(90));

        ABB arvore2 = new ABB();
        System.out.println("\n---Cenário Desbalanceado ---");
        System.out.println("Inserindo Ordenado: 10, 20, 30, 40...");
        arvore2.inserir(10);
        arvore2.inserir(20);
        arvore2.inserir(30);
        arvore2.inserir(40);

        System.out.println("Buscar 40 (Existe): " + arvore2.buscar(40));
        System.out.println("Buscar 50 (Não Existe): " + arvore2.buscar(50));

        System.out.println("\n==================================================");
        System.out.println(" ÁRVORE AVL ");

        AVL arvoreAVL = new AVL();
        System.out.println("\n--- Inserção Ordenada (10, 20, 30, 40, 50) ---");
        System.out.println("A AVL aplica Rotações para permanecer balanceada.");

        arvoreAVL.inserir(10);
        arvoreAVL.inserir(20);
        arvoreAVL.inserir(30);
        arvoreAVL.inserir(40);
        arvoreAVL.inserir(50);

        System.out.println("\nBusca na AVL Balanceada:");
        System.out.println("Buscar 20 (Existe): " + arvoreAVL.buscar(20));
        System.out.println("Buscar 99 (Não Existe): " + arvoreAVL.buscar(99));

        System.out.println("\n==================================================");
        System.out.println("              MEDIÇÃO DE DESEMPENHO                 ");

        System.out.println("\n==================================================");
        System.out.println("MEDIÇÃO DO TEMPO DE INSERÇÃO <<<");
        System.out.println("==================================================");

        int[] tamanhos = { 100, 1000, 10000 };
        String[] ordens = { "Ordenada", "Inversamente Ordenada", "Aleatória" };
        GerarDados dadosTeste = new GerarDados();

        // Cabeçalho da Tabela (Melhor formato para o relatório)
        System.out.printf("| %-30s | %15s | %15s | %15s |%n",
                "Cenário (Tamanho/Ordem)",
                "Vetor (ms)",
                "ABB (ms)",
                "AVL (ms)");
        System.out.println("|--------------------------------|-----------------|-----------------|-----------------|");

        for (int tamanho : tamanhos) { // vai pegar cada tamanho

            // para cada tamanho, vai pegar cada ordem - faz todas as ordens para um tamanho antes de ir para o próximo tamanho
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
                double tempoVetorSeg = tempoVetor / 1_000_000.0;
                double tempoABBSeg = tempoABB / 1_000_000.0;
                double tempoAVLSeg = tempoAVL / 1_000_000.0;

                // coloca os resultados na tabela
                String cenario = String.format("%d / %s", tamanho, ordem);
                System.out.printf("| %-30s | %15f | %15f | %15f |%n",
                        cenario,
                        tempoVetorSeg,
                        tempoABBSeg,
                        tempoAVLSeg);
            }
        }

        System.out.println("==================================================");
        System.out.println("MEDIÇÃO DE INSERÇÃO CONCLUÍDA. Os tempos estão em milissegundos(ms).");

    }
}