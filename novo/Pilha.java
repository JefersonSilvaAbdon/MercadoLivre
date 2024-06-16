public class Pilha {

    String elementos[];
    int topo;

    public Pilha(){
        elementos = new String[10];
        topo      = -1; //Posição inválida do vetor
    }
    //Método para empilhar
    public void push(String e){
        if (isFull()){
            throw new RuntimeException("Pilha Cheia!");
        }
        topo++;
        elementos[topo] = e;
    }
    //Método para desempilhar
    public String pop(){
        if (isEmpty()){
            throw new RuntimeException("Pilha vazia!");
        }
        String e;
        e = elementos[topo];
        topo--;
        return e; 
    }
    //Método para verificar se a pilha está vazia
    public boolean isEmpty() {
        return (topo == -1);
    }
    //Método para verificar se a pilha está cheia
    public boolean isFull() {
        return topo == elementos.length - 1; //Verificar se está certo
    }    
    //Método para retornar o elemento que está no topo
    public String top(){
        if (isEmpty()){
            throw new RuntimeException("Pilha vazia!");
        }
        return elementos[topo];
    }
}