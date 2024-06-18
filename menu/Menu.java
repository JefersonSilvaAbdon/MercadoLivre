import java.util.Scanner;
    // Método principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----TELA INICIAL----");
            System.out.println("1. LOGIN");
            System.out.println("2. CADASTRO");
            System.out.println("--------------------");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // limpar o buffer do scanner

            if (escolha == 1) {
                Pilha p = new Pilha();
                BinaryTree binaryTree = new BinaryTree();

                while (true) {
                    System.out.println("1. LOGIN COMPRADOR");
                    System.out.println("2. LOGIN VENDEDOR");
                    System.out.println("3. VOLTAR");
                    int log = scanner.nextInt();
                    scanner.nextLine();

                    if (log == 1) {
                        System.out.println("----LOGIN COMPRADOR----");
                        System.out.println("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.println("Senha: ");
                        String senha = scanner.nextLine();

                        while (true) {
                            System.out.println("---ACESSO COMPRADOR---");
                            System.out.println("1. VER PRODUTOS DISPONÍVEIS");
                            //System.out.println("2. COMPRAR PRODUTOS");
                            System.out.println("3. AVALIAR PRODUTOS COMPRADOS");
                            System.out.println("4. VOLTAR");
                            int arvore = scanner.nextInt();
                            scanner.nextLine();

                            if (arvore == 1) {
                                if (p.isEmpty()){
                                    System.out.println("NÃO HÁ PRODUTOS DISPONIVEIS");
                                }else {
                                    while (!p.isEmpty()) {
                                        String elemento = p.pop();
                                        System.out.println(elemento);
                                        System.out.println("DESEJA COMPRAR O PRODUTO? ");
                                        System.out.println("1. SIM ");
                                        System.out.println("2. NÃO ");
                                        int comprar = scanner.nextInt();
                                        scanner.nextLine();

                                        if (comprar == 1) {
                                            binaryTree.insert(elemento);
                                        } else if (comprar == 2) {

                                        } else {
                                            System.out.println("OPÇÃO INVÁLIDA");
                                        }

                                    }
                                    binaryTree.inorder();

                                }

                            } else if (arvore == 2) {

                            } else if (arvore == 3) {

                            } else if (arvore == 4) {
                                break;
                            } else {
                                System.out.println("Opção Inválida!");
                            }

                        } 

                    } else if (log == 2) {
                        System.out.println("----LOGIN VENDEDOR----");
                        System.out.println("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.println("Senha: ");
                        String senha = scanner.nextLine();


                        while (true) {
                            System.out.println("---ACESSO VENDEDOR---");
                            System.out.println("1. CADASTRO PRODUTOS");
                            System.out.println("2. CONSULTA PRODUTOS CADASTRADOS");
                            //System.out.println("3. REMOVER PRODUTOS");
                            System.out.println("4. VOLTAR");
                            int pilha = scanner.nextInt();
                            scanner.nextLine();

                            //Pilha p = new Pilha();

                            if (pilha == 1) {
                            
                                while (!p.isFull()) {
                                    System.out.println("O QUE DESEJA ADICIONAR? ");
                                    String produto = scanner.nextLine();
                                    p.push(produto);
                                    String elemento = p.top();
                                    //System.out.println("Produto " +elemento);
                                    System.out.println("DESEJA CADASTRAR MAIS UM PRODUTO? ");
                                    System.out.println("1. SIM ");
                                    System.out.println("2. NÃO ");
                                    int cadastro = scanner.nextInt();
                                    scanner.nextLine();

                                    if (cadastro == 1) {

                                    } else if (cadastro == 2) {
                                        break;
                                    } else {
                                        System.out.println("OPÇÃO INVÁLIDA");
                                    }
                                }
                            

                            } else if (pilha == 2) {
                                if (p.isEmpty()){
                                    System.out.println("NÃO HÁ PRODUTOS DISPONIVEIS");
                                }else {
                                    while (!p.isEmpty()) {
                                        String elemento = p.pop();
                                        System.out.println(elemento);
                                    }
                                }
                            } else if (pilha == 3) {

                            } else if (pilha == 4) {
                                break;
                            } else {
                                System.out.println("Opção Inválida!");
                            }

                        } 

                    } else if (log == 3) {
                        break;

                    }else {
                        System.out.println("Opção Inválida!");
                    }
                }
                


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