import java.util.Scanner;

// Classe Cliente para representar cada cliente
class Cliente {
    private String cpf;
    private String nome;
    private String email;
    private Cliente proximo;
    private Cliente anterior;

    // Construtor
    public Cliente(String cpf, String nome, String email) {
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

    public Cliente getProximo() {
        return proximo;
    }

    public void setProximo(Cliente proximo) {
        this.proximo = proximo;
    }

    public Cliente getAnterior() {
        return anterior;
    }

    public void setAnterior(Cliente anterior) {
        this.anterior = anterior;
    }
}

// Classe ListaClientes para gerenciar a lista duplamente encadeada de clientes
class ListaClientes {
    private Cliente primeiro;
    private Cliente ultimo;

    // Construtor
    public ListaClientes() {
        this.primeiro = null;
        this.ultimo = null;
    }

    // Método para verificar se a lista está vazia
    public boolean estaVazia() {
        return primeiro == null;
    }

    // Método para adicionar um cliente ao final da lista
    public void adicionarCliente(String cpf, String nome, String email) {
        Cliente novoCliente = new Cliente(cpf, nome, email);
        if (estaVazia()) {
            primeiro = novoCliente;
            ultimo = novoCliente;
        } else {
            novoCliente.setAnterior(ultimo);
            ultimo.setProximo(novoCliente);
            ultimo = novoCliente;
        }
    }

    // Método para exibir todos os clientes da lista
    public void exibirClientes() {
        Cliente atual = primeiro;
        System.out.println("Lista de Clientes:");
        while (atual != null) {
            System.out.println("CPF: " + atual.getCpf() + ", Nome: " + atual.getNome() + ", Email: " + atual.getEmail());
            atual = atual.getProximo();
        }
        System.out.println();
    }

    // Método para buscar um cliente pelo ID
    public Cliente buscarCliente(String cpf) {
        Cliente atual = primeiro;
        while (atual != null) {
            if (atual.getCpf() == cpf) {
                return atual;
            }
            atual = atual.getProximo();
        }
        return null; // Retorna null se o cliente não for encontrado
    }

    // Método para remover um cliente pelo ID
    public void removerCliente(String cpf) {
        Cliente atual = primeiro;
        while (atual != null) {
            if (atual.getCpf() == cpf) {
                if (atual == primeiro && atual == ultimo) {
                    // Caso especial: só há um cliente na lista
                    primeiro = null;
                    ultimo = null;
                } else if (atual == primeiro) {
                    // Remover o primeiro cliente
                    primeiro = primeiro.getProximo();
                    if (primeiro != null) {
                        primeiro.setAnterior(null);
                    }
                } else if (atual == ultimo) {
                    // Remover o último cliente
                    ultimo = ultimo.getAnterior();
                    if (ultimo != null) {
                        ultimo.setProximo(null);
                    }
                } else {
                    // Remover cliente do meio da lista
                    atual.getAnterior().setProximo(atual.getProximo());
                    atual.getProximo().setAnterior(atual.getAnterior());
                }
                System.out.println("Cliente com CPF " + cpf + " removido com sucesso.");
                return; // Cliente removido, termina o método
            }
            atual = atual.getProximo();
        }
        System.out.println("Cliente com CPF " + cpf + " não encontrado.");
    }
}

// Classe principal para o aplicativo de cadastro de clientes
public class CadastroClientesApp {
    private static ListaClientes listaClientes = new ListaClientes();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean sair = false;
        while (!sair) {
            System.out.println("====== Menu ======");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Remover Cliente");
            System.out.println("3. Buscar Cliente");
            System.out.println("4. Exibir Todos os Clientes");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    adicionarCliente();
                    break;
                case 2:
                    removerCliente();
                    break;
                case 3:
                    buscarCliente();
                    break;
                case 4:
                    exibirClientes();
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

    private static void adicionarCliente() {
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o email do cliente: ");
        String email = scanner.nextLine();

        listaClientes.adicionarCliente(cpf, nome, email);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void removerCliente() {
        System.out.print("Digite o CPF do cliente que deseja remover: ");
        String cpf = scanner.nextLine();
        scanner.nextLine(); // Limpar o buffer do scanner

        listaClientes.removerCliente(cpf);
    }

    private static void buscarCliente() {
        System.out.print("Digite o CPF do cliente que deseja buscar: ");
        String cpf = scanner.nextLine();
        scanner.nextLine(); // Limpar o buffer do scanner

        Cliente cliente = listaClientes.buscarCliente(cpf);
        if (cliente != null) {
            System.out.println("Cliente encontrado:");
            System.out.println("CPF: " + cliente.getCpf() + ", Nome: " + cliente.getNome() + ", Email: " + cliente.getEmail());
        } else {
            System.out.println("Cliente com CPF " + cpf + " não encontrado.");
        }
    }

    private static void exibirClientes() {
        listaClientes.exibirClientes();
    }
}
