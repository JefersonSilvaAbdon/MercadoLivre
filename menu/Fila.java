public class Fila {

    private String[] valores; // Array para armazenar os elementos da fila
    private int primeiro;     // Índice do primeiro elemento da fila
    private int ultimo;       // Índice do próximo espaço disponível na fila
    private int total;        // Número total de elementos na fila

    public Fila(){
        valores = new String[10]; // Inicializa o array com capacidade para 10 elementos
        primeiro = 0;             // A fila começa vazia, então o primeiro índice é 0
        ultimo = 0;               // A fila começa vazia, então o último índice é 0
        total = 0;                // A fila começa vazia, então o total de elementos é 0
    }
    
    public void inserir(String elemento){
        if(!isFull()){            // Verifica se a fila não está cheia antes de inserir
            valores[ultimo] = elemento; // Insere o elemento na posição 'ultimo'
            ultimo = (ultimo + 1) % valores.length; // Atualiza o índice 'ultimo' circularmente
            total++;               // Incrementa o total de elementos na fila
        } else {
            throw new RuntimeException("Fila cheia!"); // Lança uma exceção se a fila estiver cheia
        }
    }

    public String retirar(){
        if(!isEmpty()){           // Verifica se a fila não está vazia antes de retirar
            String elemento = valores[primeiro]; // Obtém o elemento na posição 'primeiro'
            primeiro = (primeiro + 1) % valores.length; // Atualiza o índice 'primeiro' circularmente
            total--;               // Decrementa o total de elementos na fila
            return elemento;       // Retorna o elemento retirado
        } else {
            throw new RuntimeException("Fila vazia!"); // Lança uma exceção se a fila estiver vazia
        }
    }

    public boolean isEmpty(){
        return (total == 0);      // Retorna verdadeiro se a fila estiver vazia (total == 0)
    }

    public boolean isFull(){
        return (total == valores.length); // Retorna verdadeiro se a fila estiver cheia (total == tamanho do array)
    }
}