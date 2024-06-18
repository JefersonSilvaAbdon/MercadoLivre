<<<<<<< HEAD
import java.util.Scanner;

// Classe Comprador para representar cada comprador
class Comprador {
    private String cpf;
    private String nome;
    private String email;
    private String senha;

    private Comprador proximo;
    private Comprador anterior;

    // Construtor
    public Comprador(String cpf, String nome, String email, String senha) {
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

    public Comprador getProximo() {
        return proximo;
    }

    public void setProximo(Comprador proximo) {
        this.proximo = proximo;
    }

    public Comprador getAnterior() {
        return anterior;
    }

    public void setAnterior(Comprador anterior) {
        this.anterior = anterior;
    }
}

// Classe ListaCompradores para gerenciar a lista duplamente encadeada de compradores
class ListaCompradores {
    private Comprador primeiro;
    private Comprador ultimo;

    // Construtor
    public ListaCompradores() {
        this.primeiro = null;
        this.ultimo = null;
    }

    // Método para verificar se a lista está vazia
    public boolean estaVazia() {
        return primeiro == null;
    }

    // Método para adicionar um comprador
    public void adicionarComprador(String cpf, String nome, String email, String senha) {
        Comprador novoComprador = new Comprador(cpf, nome, email, senha);
        if (estaVazia()) {
            primeiro = novoComprador;
            ultimo = novoComprador;
        } else {
            novoComprador.setAnterior(ultimo);
            ultimo.setProximo(novoComprador);
            ultimo = novoComprador;
        }
        System.out.println("Comprador cadastrado com sucesso!");
    }
}

// Classe principal para o aplicativo de cadastro de compradores
public class CadastroCompradorApp {
    private static ListaCompradores listaCompradores = new ListaCompradores();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean sair = false;
        
        while (!sair) {
            System.out.println("====== CADASTRO COMPRADOR ======");
            System.out.println("1. INICIAR");
            System.out.println("2. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    adicionarComprador(); // Chama o método para adicionar um novo comprador
                    break;
                case 2:
                    System.out.println("Voltando ao Menu Principal..."); // Mensagem de retorno ao menu
                    Menu.main(null);  //Retornar para o menu inicial
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

    // Método para adicionar um novo comprador à lista
    private static void adicionarComprador() {
        System.out.print("DIGITE SEU CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("DIGITE SEU NOME: ");
        String nome = scanner.nextLine();

        System.out.print("DIGITE SEU EMAIL: ");
        String email = scanner.nextLine();

        System.out.print("DIGITE SUA SENHA: ");
        String senha = scanner.nextLine();

        listaCompradores.adicionarComprador(cpf, nome, email, senha); // Chama o método da lista para adicionar o comprador
    }
}
=======
import java.util.Scanner;

// Classe Comprador para representar cada comprador
class Comprador {
    private String cpf;
    private String nome;
    private String email;
    private String senha;

    private Comprador proximo;
    private Comprador anterior;

    // Construtor
    public Comprador(String cpf, String nome, String email, String senha) {
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

    public Comprador getProximo() {
        return proximo;
    }

    public void setProximo(Comprador proximo) {
        this.proximo = proximo;
    }

    public Comprador getAnterior() {
        return anterior;
    }

    public void setAnterior(Comprador anterior) {
        this.anterior = anterior;
    }
}

// Classe ListaCompradores para gerenciar a lista duplamente encadeada de compradores
class ListaCompradores {
    private Comprador primeiro;
    private Comprador ultimo;

    // Construtor
    public ListaCompradores() {
        this.primeiro = null;
        this.ultimo = null;
    }

    // Método para verificar se a lista está vazia
    public boolean estaVazia() {
        return primeiro == null;
    }

    // Método para adicionar um comprador
    public void adicionarComprador(String cpf, String nome, String email, String senha) {
        Comprador novoComprador = new Comprador(cpf, nome, email, senha);
        if (estaVazia()) {
            primeiro = novoComprador;
            ultimo = novoComprador;
        } else {
            novoComprador.setAnterior(ultimo);
            ultimo.setProximo(novoComprador);
            ultimo = novoComprador;
        }
        System.out.println("Comprador cadastrado com sucesso!");
    }
}

// Classe principal para o aplicativo de cadastro de compradores
public class CadastroCompradorApp {
    private static ListaCompradores listaCompradores = new ListaCompradores();
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
                    adicionarComprador(); // Chama o método para adicionar um novo comprador
                    break;
                case 2:
                    System.out.println("Voltando ao Menu Principal..."); // Mensagem de retorno ao menu
                    Menu.main(null);  //Retornar para o menu inicial
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

    // Método para adicionar um novo comprador à lista
    private static void adicionarComprador() {
        System.out.print("DIGITE SEU CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("DIGITE SEU NOME: ");
        String nome = scanner.nextLine();

        System.out.print("DIGITE SEU EMAIL: ");
        String email = scanner.nextLine();

        System.out.print("DIGITE SUA SENHA: ");
        String senha = scanner.nextLine();

        listaCompradores.adicionarComprador(cpf, nome, email, senha); // Chama o método da lista para adicionar o comprador
    }
}
>>>>>>> 43c86ea73f6a0b15f79380fc0d69eb38e657ff98
