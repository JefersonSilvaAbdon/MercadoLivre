<<<<<<< HEAD
import java.util.Scanner;

// Classe Vendedor para representar cada vendedor
class Vendedor {
    private String cpf;
    private String nome;
    private String email;
    private String senha;

    private Vendedor proximo;
    private Vendedor anterior;

    // Construtor
    public Vendedor(String cpf, String nome, String email, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    // Método para adicionar um vendedor
    public void adicionarVendedor(String cpf, String nome, String email, String senha) {
        Vendedor novoVendedor = new Vendedor(cpf, nome, email, senha);
        if (estaVazia()) {
            primeiro = novoVendedor;
            ultimo = novoVendedor;
        } else {
            novoVendedor.setAnterior(ultimo);
            ultimo.setProximo(novoVendedor);
            ultimo = novoVendedor;
        }
        System.out.println("Vendedor cadastrado com sucesso!");
    }
}

// Classe principal para o aplicativo de cadastro de vendedores
public class CadastroVendedorApp {
    private static ListaVendedores listaVendedores = new ListaVendedores();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean sair = false;
        
        while (!sair) {
            System.out.println("====== CADASTRO VENDEDOR ======");
            System.out.println("1. INICIAR");
            System.out.println("2. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    adicionarVendedor(); // Chama o método para adicionar um novo vendedor
                    break;
                case 2:
                    System.out.println("Voltando ao Menu Principal..."); // Mensagem de retorno ao menu
                    Menu.main(null); // Retornar para o menu inicial
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente."); // Mensagem de opção inválida
                    break;
            }

            System.out.println(); // Linha em branco para melhorar a legibilidade
        }

        // Fechar o scanner ao sair do programa
        scanner.close();
    }

    // Método para adicionar um novo vendedor à lista
    private static void adicionarVendedor() {
        System.out.print("Digite SEU CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("DIGITE SEU NOME: ");
        String nome = scanner.nextLine();

        System.out.print("DIGITE SEU EMAIL: ");
        String email = scanner.nextLine();

        System.out.print("Digite SUA SENHA: ");
        String senha = scanner.nextLine();

        listaVendedores.adicionarVendedor(cpf, nome, email, senha); // Chama o método da lista para adicionar o vendedor
    }
}
=======
import java.util.Scanner;

// Classe Vendedor para representar cada vendedor
class Vendedor {
    private String cpf;
    private String nome;
    private String email;
    private String senha;

    private Vendedor proximo;
    private Vendedor anterior;

    // Construtor
    public Vendedor(String cpf, String nome, String email, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    // Método para adicionar um vendedor
    public void adicionarVendedor(String cpf, String nome, String email, String senha) {
        Vendedor novoVendedor = new Vendedor(cpf, nome, email, senha);
        if (estaVazia()) {
            primeiro = novoVendedor;
            ultimo = novoVendedor;
        } else {
            novoVendedor.setAnterior(ultimo);
            ultimo.setProximo(novoVendedor);
            ultimo = novoVendedor;
        }
        System.out.println("Vendedor cadastrado com sucesso!");
    }
}

// Classe principal para o aplicativo de cadastro de vendedores
public class CadastroVendedorApp {
    private static ListaVendedores listaVendedores = new ListaVendedores();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean sair = false;
        
        while (!sair) {
            System.out.println("====== Menu ======");
            System.out.println("1. INICIAR");
            System.out.println("2. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    adicionarVendedor(); // Chama o método para adicionar um novo vendedor
                    break;
                case 2:
                    System.out.println("Voltando ao Menu Principal..."); // Mensagem de retorno ao menu
                    Menu.main(null); // Retornar para o menu inicial
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente."); // Mensagem de opção inválida
                    break;
            }

            System.out.println(); // Linha em branco para melhorar a legibilidade
        }

        // Fechar o scanner ao sair do programa
        scanner.close();
    }

    // Método para adicionar um novo vendedor à lista
    private static void adicionarVendedor() {
        System.out.print("Digite SEU CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("DIGITE SEU NOME: ");
        String nome = scanner.nextLine();

        System.out.print("DIGITE SEU EMAIL: ");
        String email = scanner.nextLine();

        System.out.print("Digite SUA SENHA: ");
        String senha = scanner.nextLine();

        listaVendedores.adicionarVendedor(cpf, nome, email, senha); // Chama o método da lista para adicionar o vendedor
    }
}
>>>>>>> 43c86ea73f6a0b15f79380fc0d69eb38e657ff98
