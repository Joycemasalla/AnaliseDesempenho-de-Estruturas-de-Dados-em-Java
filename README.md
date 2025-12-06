# Análise de Desempenho de Estruturas de Dados em Java

## Descrição
Implementação e análise comparativa de desempenho entre Vetor, Árvore Binária de Busca (ABB) e Árvore AVL, incluindo algoritmos de ordenação e busca.

## Estrutura do Projeto
```
projeto/
│
├── ABB.java                    # Implementação da Árvore Binária de Busca
├── AVL.java                    # Implementação da Árvore AVL com rotações
├── Vetor.java                  # Implementação do Vetor com ordenação e busca
├── No.java                     # Classe de nó para ABB e AVL
├── GerarDados.java            # Geração de conjuntos de dados (ordenado, inverso, aleatório)
├── PopularEstruturas.java     # Classe auxiliar para popular todas as estruturas
├── MedirTempo.java            # Medição de tempo de inserção, busca e ordenação
├── Main.java                  # Classe principal com execução dos testes
└── README.md                  # Este arquivo
```

## Como Compilar

### Opção 1: Usando linha de comando
```bash
javac *.java
```

### Opção 2: Usando IDE (Eclipse, IntelliJ, VS Code)
1. Abra o projeto na IDE
2. Compile automaticamente ou use a opção de build

## Como Executar

### Linha de comando:
```bash
java Main
```

### IDE:
Execute a classe `Main.java` (botão Run/Play)

## Saída Esperada

O programa gera três tabelas com medições de tempo:
1. **Tempo de Inserção** - Para Vetor, ABB e AVL em 9 cenários
2. **Tempo de Busca** - Para 7 tipos de busca em todas as estruturas
3. **Tempo de Ordenação** - Para Insertion Sort e QuickSort

Todos os tempos são apresentados em milissegundos (ms) e representam a média de 5 execuções.

## Estruturas Implementadas

- **Vetor**: Inserção O(1), Busca Sequencial O(n), Busca Binária O(log n)
- **ABB**: Inserção/Busca O(log n) no caso médio, O(n) no pior caso
- **AVL**: Inserção/Busca O(log n) garantido (auto-balanceada)

## Algoritmos de Ordenação

- **Insertion Sort**: O(n²) no pior caso, O(n) no melhor caso
- **QuickSort**: O(n log n) no caso médio, usa pivô do meio

## Conjuntos de Teste

- Tamanhos: 100, 1.000, 10.000 elementos
- Ordens: Crescente, Decrescente, Aleatória
- Cada teste executado 5 vezes (média registrada)

## Autores

[Joyce Masalla Jorge]
[4° Período - Análise e Desenvolvimento de Sistemas]