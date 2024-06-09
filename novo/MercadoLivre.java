package novo;

import java.util.Scanner;

// Classe Node representando cada usuário
class No {
    String nome;
    String senha;
    String email;
    String endereco;
    String cpf;
    String tipousuario; // "cliente" ou "vendedor"
    No anterior;
    No proximo;

    No(String nome, String senha, String email, String endereco, String cpf, String tipousuario) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.endereco = endereco;
        this.cpf = cpf;
        this.tipousuario = tipousuario;
        this.anterior = null;
        this.proximo = null;
    }
}

// Classe para a lista duplamente encadeada
class ListaDuplamenteEncadeada {
    private No no;

    public ListaDuplamenteEncadeada() {
        this.no = null;
    }

    public void add(String nome, String senha, String email, String endereco, String cpf, String tipousuario) {
        No newNo = new No(nome, senha, email, endereco, cpf, tipousuario);
        if (no == null) {
            no = newNo;
        } else {
            No temp = no;
            while (temp.proximo != null) {
                temp = temp.proximo;
            }
            temp.proximo = newNo;
            newNo.anterior = temp;
        }
    }

    public No find(String nome) {
        No temp = no;
        while (temp != null) {
            if (temp.nome.equals(nome)) {
                return temp;
            }
            temp = temp.proximo;
        }
        return null;
    }
}

// Classe para autenticar usuários
class AutenticarUsuario {
    private ListaDuplamenteEncadeada usuarios;

    public AutenticarUsuario() {
        usuarios = new ListaDuplamenteEncadeada();
    }

    // Método para registrar usuários
    public void registrarUsuario(String nome, String senha, String email, String endereco, String cpf, String tipousuario) {
        if (usuarios.find(nome) != null) {
            System.out.println("Usuário já existe!");
        } else {
            usuarios.add(nome, senha, email, endereco, cpf, tipousuario);
            System.out.println("Cadastro realizado com sucesso!");
        }
    }

    // Método para autenticar usuários
    public String autenticarUsuario(String nome, String senha) {
        No pessoa = usuarios.find(nome);
        if (pessoa != null && pessoa.senha.equals(senha)) {
            return pessoa.tipousuario;
        } else {
            return null;
        }
    }

    // Método principal
    public static void main(String[] args) {
        AutenticarUsuario auth = new AutenticarUsuario();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("MERCADO LIVRE");
            System.out.println("1. Login");
            System.out.println("2. Cadastro Cliente");
            System.out.println("3. Cadastro Vendedor");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // limpar o buffer do scanner

            if (escolha == 1) {
                System.out.println("LOGIN");
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("Senha: ");
                String senha = scanner.nextLine();
                String userType = auth.autenticarUsuario(nome, senha);
                if (userType != null) {
                    System.out.println("Login bem-sucedido! Tipo de usuário: " + userType);
                } else {
                    System.out.println("Nome ou senha incorretos!");
                }
            } else if (escolha == 2) {
                System.out.println("CADASTRO CLIENTE");
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("Senha: ");
                String senha = scanner.nextLine();
                System.out.print("Email: ");
                String email = scanner.nextLine();
                System.out.print("Endereço: ");
                String endereco = scanner.nextLine();
                System.out.print("CPF: ");
                String cpf = scanner.nextLine();
                auth.registrarUsuario(nome, senha, email, endereco, cpf, "cliente");
            } else if (escolha == 3) {
                System.out.println("CADASTRO VENDEDOR");
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("Senha: ");
                String senha = scanner.nextLine();
                System.out.print("Email: ");
                String email = scanner.nextLine();
                System.out.print("Endereço: ");
                String endereco = scanner.nextLine();
                System.out.print("CPF: ");
                String cpf = scanner.nextLine();
                auth.registrarUsuario(nome, senha, email, endereco, cpf, "vendedor");
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }
}
