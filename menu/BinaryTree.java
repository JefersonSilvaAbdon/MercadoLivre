import java.util.Iterator;
import java.util.Stack;

// Classe BinaryTree que implementa a interface Iterable para permitir a iteração sobre seus elementos
public class BinaryTree implements Iterable<String> {
    Node root; // Raiz da árvore

    // Método público para inserir um novo valor na árvore
    public void insert(String key) {
        root = insertRec(root, key); // Chama o método recursivo de inserção
    }

    // Método recursivo privado para inserir um novo valor na árvore
    private Node insertRec(Node root, String key) {
        // Se a árvore estiver vazia, cria um novo nó e retorna
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Se não estiver vazia, percorre a árvore recursivamente
        if (key.compareTo(root.key) < 0) // Se o valor for menor que o valor do nó atual, vai para a esquerda
            root.left = insertRec(root.left, key);
        else if (key.compareTo(root.key) > 0) // Se o valor for maior, vai para a direita
            root.right = insertRec(root.right, key);

        // Retorna o ponteiro para o nó após a inserção
        return root;
    }

    // Método que retorna um iterador para percorrer a árvore em ordem
    @Override
    public Iterator<String> iterator() {
        return new BinaryTreeIterator(root);
    }
    
    // Método público que verifica se a árvore está vazia
    public boolean isEmpty() {
        return root == null; // Retorna true se a raiz for nula, indicando que a árvore está vazia
    }

    // Classe interna que implementa a interface Iterator para percorrer a árvore em ordem
    private class BinaryTreeIterator implements Iterator<String> {
        Stack<Node> stack; // Pilha para manter o controle dos nós durante a iteração

        // Construtor que inicia o iterador no menor valor da árvore (mais à esquerda)
        public BinaryTreeIterator(Node root) {
            stack = new Stack<>();
            while (root != null) {
                stack.push(root); // Adiciona os nós à pilha enquanto houver nós à esquerda
                root = root.left;
            }
        }

        // Verifica se ainda existem elementos para iterar
        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        // Retorna o próximo elemento na iteração e avança o iterador
        @Override
        public String next() {
            Node current = stack.pop(); // Remove e retorna o nó do topo da pilha
            String key = current.key; // Armazena a chave do nó atual
            if (current.right != null) { // Se houver subárvore à direita, adiciona os nós à pilha
                current = current.right;
                while (current != null) {
                    stack.push(current);
                    current = current.left; // Continua adicionando à esquerda até encontrar o menor valor
                }
            }
            return key; // Retorna a chave do nó atual
        }
    }
    
    // Classe interna Node representando cada elemento da árvore binária
    class Node {
        String key; // Valor armazenado no nó
        Node left, right; // Ponteiros para os nós filhos à esquerda e à direita

        public Node(String item) {
            key = item; // Inicializa a chave com o valor passado como argumento
            left = right = null; // Inicializa os ponteiros dos filhos como nulos
        }
    }
}
