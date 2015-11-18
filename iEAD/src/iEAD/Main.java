package iEAD;

import java.util.List;  
import java.util.Scanner;  
import java.util.ArrayList;  

public class Main {
	
	private static Scanner teclaS, teclaI;
	
    private static List<Conta> contas;
    private static List<Amigo> amigos;
    
    private static long telefone,
    						cpf;
	private static String login,
							nome,
							senha,
							endereco;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		teclaS = new Scanner(System.in);
		teclaI = new Scanner(System.in);
        contas = new ArrayList<Conta>();
        amigos = new ArrayList<Amigo>();
  
        System.out.println("Bem Vindo ao iEAD");  
  
        while (true) {  
            String opcao = menuCadastro();  
  
            if (opcao.equalsIgnoreCase("c")) {  
                cadastrar();  
            } else if (opcao.equalsIgnoreCase("l")) {  
                login();
            } else if (opcao.equalsIgnoreCase("x")) {
            	break;
            } else {  
                System.out.println("\nOpção Inválida \n");  
            }  
        }  

	}
	
	private static void cadastrar() {    
		  
        while (true) {  
        	
            System.out.println("Cadastro de Usuário");  
            Conta usuario = new Conta();  
            usuario.setLogin(entradaTexto("Login:"));
            if (retornaLogin(usuario.getLogin()) == true) {
            	System.out.println("Usuario já cadastrado, reiniciando cadastro.");
            	continue;
            }
            usuario.setSenha(entradaTexto("Senha: "));  
            usuario.setNome(entradaTexto("Nome: "));
            usuario.setCpf(entradaNumero("CPF: "));
            if (retornaLogin(usuario.getCpf()) == true) {
            	System.out.println("CPF já cadastrado, reiniciando cadastro.");
            	continue;
            }
            usuario.setEndereco(entradaTexto("Endereço: "));
            usuario.setTelefone(entradaNumero("Telefone: "));
  
            String cadastrar = entradaTexto("Adicionar usuário (S/N) ?");  
            if (cadastrar.equalsIgnoreCase("s")) {  
                System.out.println("Cadastro adicionado !!!");  
                contas.add(usuario);
                break;
            } else if (cadastrar.equalsIgnoreCase("n")){  
                System.out.println("Cadastro ignorado !!!");
                
                String continua = entradaTexto("Continuar cadastrando (S/N) ?");  
                if (continua.equalsIgnoreCase("N")) {  
                    break;  
                } else if (continua.equalsIgnoreCase("s")){  
                    // se for s sai do if e volta para o inicio do while  
                } else {  
                    System.out.println("\nOpção inválida \n");  
                    break;  
                }
            } else {  
                System.out.println("\nOpção inválida \n");
                break;
            }  
    
        }  
    }  
	
	private static void login() {
		System.out.println("\nTela de Login \n");
		String user = entradaTexto("Login: ");
		String pass = entradaTexto("Senha: ");
		if(retornaLogin(user,pass) == true) {
			System.out.println("\nUsuario Logado \n");
			while (true) {  
	            String opcao = menuUsuario();  
	  
	            if (opcao.equalsIgnoreCase("s")) {  
	            	if(updateLogin(1) == true) {
	            		System.out.println("\nSenha alterada com sucesso \n");
	            	}
	            } else if (opcao.equalsIgnoreCase("n")) {
	            	if(updateLogin(2) == true) {
	            		System.out.println("\nNome atualizado com sucesso \n");
	            	} 
	            } else if (opcao.equalsIgnoreCase("e")) {
	            	if(updateLogin(3) == true) {
	            		System.out.println("\nEndereço atualizado com sucesso \n");
	            	}
	            } else if (opcao.equalsIgnoreCase("t")) {
	            	if(updateLogin(4) == true) {
	            		System.out.println("\nTelefone alterada com sucesso \n");
	            	}
	            } else if (opcao.equalsIgnoreCase("a")) {
	            	System.out.println("\nImplementando \n");
	            } else if (opcao.equalsIgnoreCase("c")) {
	            	System.out.println("\nImplementando \n");
	            } else if (opcao.equalsIgnoreCase("l")) {
	            	System.out.println("\nImplementando \n");
	            } else if (opcao.equalsIgnoreCase("x")) {
	            	break;
	            } else {  
	                System.out.println("\nOpção Inválida \n");  
	            }  
	        }  

		} else {
			System.out.println("\nUsuario ou senha estão incorreta(s) ou usuario não cadastrado \n");
		}
	}
	
	private static boolean updateLogin(int selecao) {
		for (int i = 0; i < contas.size(); i++) {
			Conta u = contas.get(i);
			
			if(login.equals(u.getLogin())) {
				switch(selecao) {
				case 1:
					senha = entradaTexto("Digite nova senha: ");
					if(senha.equals(u.getSenha())) {
						System.out.println("\nSenha não atualizada, igual a anterior \n");
						return false;
					} else {
						u.setSenha(senha);
						contas.set(i, u);
						break;
					}
				case 2:
					System.out.println("\nNome cadastrado: " + nome);
					nome = entradaTexto("Digite a atualização do seu nome: ");
					if(nome.equals(u.getNome())) {
						System.out.println("\nNome não atualizada, igual a anterior \n");
						return false;
					} else {
						u.setNome(nome);
						contas.set(i, u);
						break;
					}
				case 3:
					System.out.println("\nEndereço cadastrado: " + endereco);
					endereco = entradaTexto("Digite novo endereço: ");
					if(endereco.equals(u.getEndereco())) {
						System.out.println("\nEndereço não atualizada, igual a anterior \n");
						return false;
					} else {
						u.setEndereco(endereco);
						contas.set(i, u);
						break;
					}
				case 4:
					System.out.println("\nTelefone cadastrado: " + telefone);
					telefone = entradaNumero("Digite novo telefone: ");
					if(telefone == (u.getTelefone())) {
						System.out.println("\nTelefone não atualizada, igual a anterior \n");
						return false;
					} else {
						u.setTelefone(telefone);
						contas.set(i, u);
						break;
					}
				default:
					System.out.println("\nOpção invalida \n");
					return false;
				}
				
				return true;
            }
        }
		return false;
	}
	
	private static boolean retornaLogin(String user, String pass) {
		if (contas.size() == 0) {  
            System.out.println("\nNão existem cadastros !!! \n");
        } else {  
            for (int i = 0; i < contas.size(); i++) {
            	Conta u = contas.get(i);
            	if(user.equals(u.getLogin()) && (pass.equals(u.getSenha()))) {
            		if(login != u.getLogin()) {
            			login = u.getLogin();
                		senha = u.getSenha();
                		nome = u.getNome();
                		cpf = u.getCpf();
                		endereco = u.getEndereco();
                		telefone = u.getTelefone();
            		}
            		return true;
            	}
            }
        }
		return false;        
	}
	
	private static boolean retornaLogin(String login) {
		if (contas.size() == 0) {  
			return false;
        } else {  
            for (int i = 0; i < contas.size(); i++) {
            	Conta u = contas.get(i);
            	if(login.equals(u.getLogin())) {
            		return true;
            	}
            }
        }
		return false;        
	}
	
	private static boolean retornaLogin(Long cpf) {
		if (contas.size() == 0) {  
			return false;
        } else {  
            for (int i = 0; i < contas.size(); i++) {
            	Conta u = contas.get(i);
            	if(cpf.equals(u.getCpf())) {
            		return true;
            	}
            }
        }
		return false;        
	}
	
	private static String menuCadastro() {  
        System.out.println("Selecione a opção:");  
        System.out.println("C - Criar usuario");  
        System.out.println("L - Login no sistema");  
        System.out.println("X - Sair");  
        return teclaS.nextLine();  
    }
	
	private static String menuUsuario() {  
        System.out.println("Selecione a opção:");
        System.out.println("-------------------------");
        System.out.println("A - Adicionar amigos");
        System.out.println("C - Aceitar convites");
        System.out.println("L - Listar amigos");
        System.out.println("-------------------------");
        System.out.println("S - Alterar senha");
        System.out.println("N - Atualizar nome");
        System.out.println("E - Atualizar endereço");
        System.out.println("T - Alterar telefone");
        System.out.println("-------------------------");
        System.out.println("X - Logout");  
        return teclaS.nextLine();  
    }
	
	private static String entradaTexto(String info) {  
        System.out.println(info);  
        return teclaS.nextLine();  
    }
	
	private static long entradaNumero(String info) {  
        System.out.println(info);
        return teclaI.nextLong();  
    }
}
