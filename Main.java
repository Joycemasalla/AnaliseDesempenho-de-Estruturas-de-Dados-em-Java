public class Main {
    public static void main(String[] args) {

        Vetor vetor = new Vetor(5); 

        vetor.inserir(10);
        vetor.inserir(20);
        vetor.inserir(30);
        vetor.inserir(40);
        vetor.inserir(50);

        vetor.inserir(60); // Vetor cheio

        System.out.println("\n--- Busca Sequencial ---");
        System.out.println("Buscar 30: " + vetor.buscarSequencial(30)); 
        System.out.println("Buscar 99: " + vetor.buscarSequencial(99)); 

        System.out.println("\n--- Busca Binária ---");
        System.out.println("Buscar 20: " + vetor.buscarBinaria(20)); 
        System.out.println("Buscar 99: " + vetor.buscarBinaria(99)); 
    }
}
