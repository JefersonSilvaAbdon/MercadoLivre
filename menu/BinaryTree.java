
// Classe que representa uma árvore binária de busca
public class BinaryTree {
    Node root; // raiz da árvore

    // Método para inserir um novo valor na árvore
    public void insert(int key) {
        root = insertRec(root, key); // chama o método recursivo de inserção
    }

    // Método recursivo privado para inserir um novo valor na árvore
    public Node insertRec(Node root, int key) {
        // Se a árvore estiver vazia, cria um novo nó e retorna
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Se não estiver vazia, percorre a árvore recursivamente
        if (key < root.key) // se o valor for menor que o valor do nó atual, vai para a esquerda
            root.left = insertRec(root.left, key);
        else if (key > root.key) // se o valor for maior, vai para a direita
            root.right = insertRec(root.right, key);

        // Retorna o ponteiro para o nó após a inserção
        return root;
    }

    // Método público para iniciar o percurso em ordem da árvore
    public void inorder() {
        inorderRec(root); // chama o método recursivo de percurso em ordem
    }

    // Método recursivo privado para percorrer a árvore em ordem
    public void inorderRec(Node root) {
        if (root != null) { // se o nó não for nulo, continua o percurso
            inorderRec(root.left); // primeiro percorre a subárvore esquerda
            System.out.println(root.key); // visita o nó atual
            inorderRec(root.right); // depois percorre a subárvore direita
        }
    }
}
