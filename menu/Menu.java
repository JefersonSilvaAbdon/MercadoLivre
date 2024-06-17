import java.util.Scanner;
    // Método principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----TELA INICIAL----");
            System.out.println("1. LOGIN");
            System.out.println("2. CADASTRO");
            System.out.print("--------------------");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // limpar o buffer do scanner

            if (escolha == 1) {
                System.out.println("LOGIN");
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("Senha: ");
                String senha = scanner.nextLine();

            } else if (escolha == 2) {
                System.out.println("----TELA DE CADASTRO---");
                System.out.println("1. VENDEDOR");
                System.out.println("2. COMPRADOR");
                System.out.println("----------------------");
                int tipo = scanner.nextInt();
                
                if (tipo == 1) {
                    CadastroVendedorApp.main(null);
                } else if (tipo == 2) {
                    CadastroCompradorApp.main(null);
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }
    }