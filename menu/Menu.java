import java.util.Scanner;

//import javax.sound.midi.Soundbank;
//import MercadoLivre.cadastro de vendedor.src.CadastroVendedorApp;
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
                Pilha p2 = new Pilha();
                Pilha p3 = new Pilha();
                BinaryTree binaryTree = new BinaryTree();
                Fila f = new Fila();

                while (true) {
                    System.out.println("--------------------");
                    System.out.println("1. LOGIN COMPRADOR");
                    System.out.println("2. LOGIN VENDEDOR");
                    System.out.println("3. VOLTAR");
                    System.out.println("--------------------");
                    int log = scanner.nextInt();
                    scanner.nextLine();

                    if (log == 1) {
                        System.out.println("----LOGIN COMPRADOR----");
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("Senha: ");
                        String senha = scanner.nextLine();
                        System.out.println("--------------------");

                        while (true) {
                            System.out.println("---ACESSO COMPRADOR---");
                            System.out.println("1. VER PRODUTOS DISPONÍVEIS");
                            System.out.println("2. VER PRODUTOS COMPRADOS");
                            System.out.println("3. VOLTAR");
                            int arvore = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("--------------------");
                            
                            if (arvore == 1) {
                                if (p.isEmpty() && p3.isEmpty()){
                                    System.out.println("NÃO HÁ PRODUTOS DISPONIVEIS");
                                    System.out.println(""); //Espaço vazio
                                } else if (!p.isEmpty()) {
                                    while (!p.isEmpty()) {
                                        String elemento = p.pop();
                                        System.out.println("Produto: " + elemento);
                                        System.out.println("DESEJA COMPRAR O PRODUTO ACIMA?");
                                        System.out.println("1. SIM ");
                                        System.out.println("2. NÃO ");
                                        int comprar = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println("--------------------");
                                        System.out.println(""); //Espaço vazio
                                        if (comprar == 1) {
                                            System.out.println("Produto: " + elemento + " comprado!");
                                            System.out.println("--------------------");
                                            binaryTree.insert(elemento); 
                                        } else if (comprar == 2) {

                                        } else {
                                            System.out.println("OPÇÃO INVÁLIDA");
                                        }
                                    }                             
                                } else if (!p3.isEmpty()) {
                                    while (!p3.isEmpty()) {
                                        String elemento3 = p3.pop();
                                        System.out.println(elemento3);
                                        System.out.println("DESEJA COMPRAR O PRODUTO ACIMA?");
                                        System.out.println("1. SIM ");
                                        System.out.println("2. NÃO ");
                                        int comprar = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println("--------------------");
                                        System.out.println(""); //Espaço vazio
                                        if (comprar == 1) {
                                            System.out.println("Produto " + elemento3 + " comprado!");
                                            binaryTree.insert(elemento3); 
                                        } else if (comprar == 2) {

                                        } else {
                                            System.out.println("OPÇÃO INVÁLIDA");
                                        }
                                    }                             
                                }    
                                
                            } else if (arvore == 2) {
                                if (binaryTree.isEmpty()) {
                                    System.out.println("Você ainda não comprou nenhum produto!");
                                    System.out.println(""); //Espaço vazio;
                                } else {
                                    for (String key : binaryTree) {
                                        // Aqui você pode colocar cada 'key' em uma nova estrutura
                                        System.out.println("Produto: " + key);
                                        System.out.println("Deseja avaliar o produto acima?");
                                        System.out.println("1. SIM ");
                                        System.out.println("2. NÃO ");
                                        int avaliar = scanner.nextInt();
                                        scanner.nextLine();
                                        int nota;
                                        while (true) {
                                            if (avaliar == 1) {
                                                while (true) {
                                                    System.out.println("Com qual nota você deseja avaliar ? (0 a 5)");
                                                    nota = scanner.nextInt();
                                                    if (nota >= 0 && nota <= 5) {
                                                        System.out.println("Você digitou a nota: " + nota);
                                                        System.out.println("--------------------");
                                                        break; // Sai do loop se o valor estiver no intervalo correto
                                                    } else {
                                                        System.out.println("Nota inválida! Tente novamente.");
                                                    }
                                                }
                                                // Formatação da string para incluir a avaliação
                                                String produtoNota = key + " > COM AVALIAÇÃO " + nota;
                                                f.inserir(produtoNota);
                                                break;
                                            } else if (avaliar == 2) {
                                                System.out.println("Produto não avaliado!");
                                                System.out.println(""); //Espaço vazio
                                                break;
                                            } else {
                                                System.out.println("OPÇÃO INVÁLIDA");
                                            } 
                                        }
                                    }

                                }
                                System.out.println("LISTA DOS PRODUTOS AVALIADOS:");
                                while (!f.isEmpty()) {
                                    String x = f.retirar();
                                    System.out.println(x);     
                                }   
                            } else if (arvore == 3) {
                                break;
                            } else {
                                System.out.println("Opção Inválida!");
                            }
                        } 

                    } else if (log == 2) {
                        System.out.println("----LOGIN VENDEDOR----");
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("Senha: ");
                        String senha = scanner.nextLine();


                        while (true) {
                            System.out.println("---ACESSO VENDEDOR---");
                            System.out.println("1. CADASTRO PRODUTOS");
                            System.out.println("2. CONSULTA DE PRODUTOS CADASTRADOS");
                            System.out.println("3. VOLTAR");
                            int pilha = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("--------------------");

                            if (pilha == 1) {
                                while (!p.isFull()) {
                                    System.out.println(""); //Espaço vazio
                                    System.out.println("O QUE DESEJA ADICIONAR? ");
                                    String produto = scanner.nextLine();
                                    p.push(produto);
                                    System.out.println(""); //Espaço vazio
                                    System.out.println("Produto: " + produto + " adicionado com sucesso!");
                                    System.out.println("--------------------");
                                    int cadastro = 0;
                                    if (!p.isFull()) {
                                        System.out.println("DESEJA CADASTRAR MAIS UM PRODUTO? ");
                                        System.out.println("1. SIM ");
                                        System.out.println("2. NÃO ");
                                        cadastro = scanner.nextInt();
                                        scanner.nextLine();
                                    } else {
                                        System.out.println("Você atingiu o limite de produtos que podem ser adicionados!");
                                        System.out.println("--------------------");
                                        break;
                                    }

                                    if (cadastro == 1) {

                                    } else if (cadastro == 2) {
                                        break;
                                    } else {
                                        System.out.println("OPÇÃO INVÁLIDA");
                                    }
                                }
                            
                            } else if (pilha == 2) {
                                if (p.isEmpty()){
                                    System.out.println("NÃO HÁ PRODUTOS CADASTRADOS!");
                                    System.out.println(""); //Espaço vazio.
                                }else {
                                    while (!p.isEmpty()) {
                                        String elemento = p.pop();
                                        System.out.println("Produto: " + elemento);
                                        p2.push(elemento);
                                        }
                                    }
                                    while (!p2.isEmpty()) {
                                        String elemento2 = p2.pop();
                                        p3.push(elemento2);
                                }
                            } else if (pilha == 3) {
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
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }