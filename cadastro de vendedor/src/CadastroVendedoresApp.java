import java.util.Scanner;

// Classe Vendedor para representar cada vendedor
class Vendedor {
    private String cpf;
    private String nome;
    private String email;
    private Vendedor proximo;
    private Vendedor anterior;

    // Construtor
    public Vendedor(String cpf, String nome, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.proximo = null;
        this.anterior = null;
    }

    // Getters e setters
    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Vendedor getProximo() {
        return proximo;
    }

    public void setProximo(Vendedor proximo) {
        this.proximo = proximo;
    }

    public Vendedor getAnterior() {
        return anterior;
    }

    public void setAnterior(Vendedor anterior) {
        this.anterior = anterior;
    }
}

// Classe ListaVendedores para gerenciar a lista duplamente encadeada de vendedores
class ListaVendedores {
    private Vendedor primeiro;
    private Vendedor ultimo;

    // Construtor
    public ListaVendedores() {
        this.primeiro = null;
        this.ultimo = null;
    }

    // Método para verificar se a lista está vazia
    public boolean estaVazia() {
        return primeiro == null;
    }

    // Método para adicionar um vendedor ao final da lista
    public void adicionarVendedor(String cpf, String nome, String email) {
        Vendedor novoVendedor = new Vendedor(cpf, nome, email);
        if (estaVazia()) {
            primeiro = novoVendedor;
            ultimo = novoVendedor;
        } else {
            novoVendedor.setAnterior(ultimo);
            ultimo.setProximo(novoVendedor);
            ultimo = novoVendedor;
        }
    }

    // Método para exibir todos os vendedores da lista
    public void exibirVendedores() {
        Vendedor atual = primeiro;
        System.out.println("Lista de Vendedores:");
        while (atual != null) {
            System.out.println("CPF: " + atual.getCpf() + ", Nome: " + atual.getNome() + ", Email: " + atual.getEmail());
            atual = atual.getProximo();
        }
        System.out.println();
    }

    // Método para buscar um vendedor pelo CPF
    public Vendedor buscarVendedor(String cpf) {
        Vendedor atual = primeiro;
        while (atual != null) {
            if (atual.getCpf().equals(cpf)) {
                return atual;
            }
            atual = atual.getProximo();
        }
        return null; // Retorna null se o vendedor não for encontrado
    }

    // Método para remover um vendedor pelo CPF
    public void removerVendedor(String cpf) {
        Vendedor atual = primeiro;
        while (atual != null) {
            if (atual.getCpf().equals(cpf)) {
                if (atual == primeiro && atual == ultimo) {
                    // Caso especial: só há um vendedor na lista
                    primeiro = null;
                    ultimo = null;
                } else if (atual == primeiro) {
                    // Remover o primeiro vendedor
                    primeiro = primeiro.getProximo();
                    if (primeiro != null) {
                        primeiro.setAnterior(null);
                    }
                } else if (atual == ultimo) {
                    // Remover o último vendedor
                    ultimo = ultimo.getAnterior();
                    if (ultimo != null) {
                        ultimo.setProximo(null);
                    }
                } else {
                    // Remover vendedor do meio da lista
                    atual.getAnterior().setProximo(atual.getProximo());
                    atual.getProximo().setAnterior(atual.getAnterior());
                }
                System.out.println("Vendedor com CPF " + cpf + " removido com sucesso.");
                return; // Vendedor removido, termina o método
            }
            atual = atual.getProximo();
        }
        System.out.println("Vendedor com CPF " + cpf + " não encontrado.");
    }
}

// Classe principal para o aplicativo de cadastro de vendedores
public class CadastroVendedoresApp {
    private static ListaVendedores listaVendedores = new ListaVendedores();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean sair = false;
        while (!sair) {
            System.out.println("====== Menu ======");
            System.out.println("1. Adicionar Vendedor");
            System.out.println("2. Remover Vendedor");
            System.out.println("3. Buscar Vendedor");
            System.out.println("4. Exibir Todos os Vendedores");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    adicionarVendedor();
                    break;
                case 2:
                    removerVendedor();
                    break;
                case 3:
                    buscarVendedor();
                    break;
                case 4:
                    exibirVendedores();
                    break;
                case 5:
                    sair = true;
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println(); // Linha em branco para melhorar a legibilidade
        }

        // Fechar o scanner ao sair do programa
        scanner.close();
    }

    private static void adicionarVendedor() {
        System.out.print("Digite o CPF do vendedor: ");
        String cpf = scanner.nextLine();

        System.out.print("Digite o nome do vendedor: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o email do vendedor: ");
        String email = scanner.nextLine();

        listaVendedores.adicionarVendedor(cpf, nome, email);
        System.out.println("Vendedor cadastrado com sucesso!");
    }

    private static void removerVendedor() {
        System.out.print("Digite o CPF do vendedor que deseja remover: ");
        String cpf = scanner.nextLine();

        listaVendedores.removerVendedor(cpf);
    }

    private static void buscarVendedor() {
        System.out.print("Digite o CPF do vendedor que deseja buscar: ");
        String cpf = scanner.nextLine();

        Vendedor vendedor = listaVendedores.buscarVendedor(cpf);
        if (vendedor != null) {
            System.out.println("Vendedor encontrado:");
            System.out.println("CPF: " + vendedor.getCpf() + ", Nome: " + vendedor.getNome() + ", Email: " + vendedor.getEmail());
        } else {
            System.out.println("Vendedor com CPF " + cpf + " não encontrado.");
        }
    }

    private static void exibirVendedores() {
        listaVendedores.exibirVendedores();
    }
}
