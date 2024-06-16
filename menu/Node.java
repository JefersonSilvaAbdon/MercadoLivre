// Classe que representa um nó em uma árvore binária
public class Node {
    int key; // valor do nó
    Node left, right; // ponteiros para os filhos esquerdo e direito

    // Construtor para criar um novo nó com um valor específico
    public Node(int item) {
        key = item;
        left = right = null; // inicialmente, os filhos são nulos
    }
}
