<<<<<<< HEAD
// Classe que representa um nó em uma árvore binária
public class Node {
    String key; // valor do nó agora é uma String
    Node left, right; // ponteiros para os filhos esquerdo e direito

    // Construtor para criar um novo nó com um valor específico
    public Node(String item) {
        key = item;
        left = right = null; // inicialmente, os filhos são nulos
    }
}
=======
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
>>>>>>> 43c86ea73f6a0b15f79380fc0d69eb38e657ff98
