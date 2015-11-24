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
  
        System.out.println("Bem Vindo ao iEAD \n");  
  
        while (true) {  
            String opcao = menuCadastro();  
  
            if (opcao.equalsIgnoreCase("c"))  
                cadastrar();  
            
            if (opcao.equalsIgnoreCase("l"))  
                login();
            
            if (opcao.equalsIgnoreCase("x"))
            	break;
        }  

	}
	
	private static void cadastrar() {    
		  
        while (true) {  
        	
            System.out.println("\nCadastro de Usuário");  
            Conta usuario = new Conta();  
            usuario.setLogin(entradaTexto("Login:"));
            if (retornaLogin(usuario.getLogin()) == true) {
            	System.out.println("\nUsuario já cadastrado, reiniciando cadastro. \n");
            	continue;
            }
            
            usuario.setSenha(entradaTexto("Senha: "));  
            usuario.setNome(entradaTexto("Nome: "));
            usuario.setCpf(entradaNumero("CPF: "));
            if (retornaLogin(usuario.getCpf()) == true) {
            	System.out.println("\nCPF já cadastrado, reiniciando cadastro.\n");
            	continue;
            }
            
            usuario.setEndereco(entradaTexto("Endereço: "));
            usuario.setTelefone(entradaNumero("Telefone: "));
  
            String cadastrar = entradaTexto("\nAdicionar usuário (S/N) ?");  
            if (cadastrar.equalsIgnoreCase("s")) {  
                System.out.println("\nCadastro adicionado !!! \n");  
                contas.add(usuario);
                break;
            }
            
            if (cadastrar.equalsIgnoreCase("n")){  
                System.out.println("\nCadastro ignorado !!! \n");
                
                String continua = entradaTexto("\nContinuar cadastrando (S/N) ?");  
                if (continua.equalsIgnoreCase("N"))  
                    break;  
                
                if (continua.equalsIgnoreCase("s"))
                	continue;
                else {  
                    System.out.println("\nOpção inválida \n");  
                    break;  
                }
            }
            else {
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
	  
	            if (opcao.equalsIgnoreCase("s"))  
	            	if(updateLogin(1) == true)
	            		System.out.println("\nSenha alterada com sucesso \n");
	            
	            if (opcao.equalsIgnoreCase("n"))
	            	if(updateLogin(2) == true)
	            		System.out.println("\nNome atualizado com sucesso \n");
	            
	            if (opcao.equalsIgnoreCase("e"))
	            	if(updateLogin(3) == true)
	            		System.out.println("\nEndereço atualizado com sucesso \n");
	            
	            if (opcao.equalsIgnoreCase("t"))
	            	if(updateLogin(4) == true)
	            		System.out.println("\nTelefone alterada com sucesso \n");
	            
	            if (opcao.equalsIgnoreCase("a"))
	            	addConvite();
	            
	            if (opcao.equalsIgnoreCase("c"))
	            	listaConvites();
	            
	            if (opcao.equalsIgnoreCase("l"))
	            	listaAmigos();
	            
	            if (opcao.equalsIgnoreCase("x"))
	            	break;
	        }  

		}
		else
			System.out.println("\nUsuario ou senha estão incorreta(s) ou usuario não cadastrado \n");
	}
	
	private static boolean updateLogin(int selecao) {
		for (int i = 0; i < contas.size(); i++) {
			Conta u = contas.get(i);
			
			if(login.equals(u.getLogin())) {
				switch(selecao) {
				case 1:
					senha = entradaTexto("\nDigite nova senha: ");
					if(senha.equals(u.getSenha())) {
						System.out.println("\nSenha não atualizada, igual a anterior \n");
						return false;
					}
					else {
						u.setSenha(senha);
						contas.set(i, u);
						break;
					}
				case 2:
					System.out.println("\nNome cadastrado: " + nome);
					nome = entradaTexto("\nDigite a atualização do seu nome: ");
					if(nome.equals(u.getNome())) {
						System.out.println("\nNome não atualizada, igual a anterior \n");
						return false;
					}
					else {
						u.setNome(nome);
						contas.set(i, u);
						break;
					}
				case 3:
					System.out.println("\nEndereço cadastrado: " + endereco);
					endereco = entradaTexto("\nDigite novo endereço: ");
					if(endereco.equals(u.getEndereco())) {
						System.out.println("\nEndereço não atualizada, igual a anterior \n");
						return false;
					}
					else {
						u.setEndereco(endereco);
						contas.set(i, u);
						break;
					}
				case 4:
					System.out.println("\nTelefone cadastrado: " + telefone);
					telefone = entradaNumero("\nDigite novo telefone: ");
					if(telefone == (u.getTelefone())) {
						System.out.println("\nTelefone não atualizada, igual a anterior \n");
						return false;
					}
					else {
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
		
	private static void listaAmigos() {
		if (amigos.size() == 0)
            System.out.println("\nNenhum amigo \n");
		else {
        	String lamigos = "";
        	
            for (int i = 0; i < amigos.size(); i++) {
            	Amigo a = amigos.get(i);
            	if(a.getConta().equals(Main.login) && a.getStatus() == true)
            		lamigos = "\n* " + a.getAmigo();
            }
            
            for (int i = 0; i < amigos.size(); i++) {
            	Amigo a = amigos.get(i);
            	if(a.getAmigo().equals(Main.login) && a.getStatus() == true)
            		lamigos = "\n* " + a.getConta();
            }
            
            if(lamigos == "")
            	System.out.println("\nNenhum amigo \n");
            else
            	System.out.println("\nLista de amigos: " + lamigos + "\n");
        }
	}
	
	private static void listaConvites() {
		if (amigos.size() == 0)
            System.out.println("\nNenhum convite \n");
		else {
        	String lamigos = "";
            
        	for (int i = 0; i < amigos.size(); i++) {
            	Amigo a = amigos.get(i);
            	if(a.getAmigo().equals(Main.login) && a.getStatus() == false)
            		lamigos = "\n* " + a.getConta();
            }
            
            if(lamigos == "")
            	System.out.println("\nNenhum convite \n");
            else {
            	System.out.println("\nLista de convites: " + lamigos + "\n");
            	
            	String aceitar = entradaTexto("\nDigite o login do usuario, que será aceito o convite de amigo:");
            	if(aceitarConvite(aceitar) == true)
            		System.out.println("\nConvite aceito\n");
            	else
            		System.out.println("\nUsuario não encontrado\n");
            }
        }
	}
	
	private static void addConvite() {
		while(true) {
			String statusc, lamigo = entradaTexto("\nDigite o login do usuario, que será enviado o convite:");
			
			if(retornaAmigo(lamigo) == true) {
				enviarConvite(lamigo);
				break;
			}
			else {
				statusc = entradaTexto("\nConvite não enviado, deseja continuar? S/N : ");
				if(statusc.equalsIgnoreCase("n"))
					break;
			}
			
		}
	}
			
	private static boolean aceitarConvite(String lamigo) {
		if(retornaConvite(lamigo) == true) {
			for (int i = 0; i < amigos.size(); i++) {
            	Amigo a = amigos.get(i);
            	if(a.getAmigo().equals(Main.login) && a.getStatus() == false && a.getConta().equals(lamigo)) {
            		a.setStatus(true);
                	amigos.set(i, a);
                	return true;
            	}
            }
			
		}
		return false;
	}
	
	private static boolean retornaAmigo(String lamigo) {
		if(lamigo.equals(Main.login)) {
			System.out.println("\nMesmo nome do seu usuario \n");
			return false;
		}
		
		for (int i = 0; i < amigos.size(); i++) {
        	Amigo a = amigos.get(i);
        	if(a.getConta().equals(Main.login) || a.getAmigo().equals(Main.login))
        		if(a.getAmigo().equals(lamigo) || a.getConta().equals(lamigo)) {
        			if(a.getStatus() == true) {
        				System.out.println("\nJá são Amigos \n");
        				return false;
        			}
        			else {
        				System.out.println("\nJa existe um Convite \n");
        				return false;
        			}
        		}
        }
		
		for (int i = 0; i < contas.size(); i++) {
        	Conta u = contas.get(i);
        	if(lamigo.equals(u.getLogin()))
        		return true;
        }
		
		return false;
	}
	
	private static boolean retornaConvite(String lamigo) {
		if(lamigo.equals(Main.login)) {
			System.out.println("\nMesmo nome do seu usuario \n");
			return false;
		}
		
		for (int i = 0; i < amigos.size(); i++) {
        	Amigo a = amigos.get(i);
        	if(a.getConta().equals(login))
        		if(a.getAmigo().equals(lamigo)) {
        			if(a.getStatus() == true) {
        				System.out.println("\nJá são Amigos \n");
        				return false;
        			}
        		}
        }
		
		for (int i = 0; i < contas.size(); i++) {
        	Conta u = contas.get(i);
        	if(lamigo.equals(u.getLogin()))
        		return true;
        }
		
		return false;
	}	
	
	private static boolean retornaLogin(String user, String pass) {
		if (contas.size() == 0)
            System.out.println("\nNão existem cadastros !!! \n");
		else {  
            for (int i = 0; i < contas.size(); i++) {
            	Conta u = contas.get(i);
            	if(user.equals(u.getLogin()) && (pass.equals(u.getSenha()))) {
            		if(Main.login != u.getLogin()) {
            			Main.login = u.getLogin();
                		Main.senha = u.getSenha();
                		Main.nome = u.getNome();
                		Main.cpf = u.getCpf();
                		Main.endereco = u.getEndereco();
                		Main.telefone = u.getTelefone();
            		}
            		return true;
            	}
            }
        }
		return false;        
	}
	
	private static boolean retornaLogin(String login) {
		if (contas.size() == 0)  
			return false;
		else {  
            for (int i = 0; i < contas.size(); i++) {
            	Conta u = contas.get(i);
            	if(login.equals(u.getLogin()))
            		return true;
            }
        }	
		return false;        
	}
	
	private static boolean retornaLogin(Long cpf) {
		if (contas.size() == 0)  
			return false;
		else {  
            for (int i = 0; i < contas.size(); i++) {
            	Conta u = contas.get(i);
            	if(cpf.equals(u.getCpf()))
            		return true;
            }
        }
		return false;        
	}
	
	private static void enviarConvite(String lamigo) {  
        Amigo a = new Amigo();  
        
        a.setConta(login);  
        a.setAmigo(lamigo);
        a.setStatus(false);
        
        amigos.add(a);
        System.out.println("\nConvite enviado. \n");
	}
	
	private static String menuCadastro() {  
        System.out.println("\nSelecione a opção:");  
        System.out.println("C - Criar usuario");  
        System.out.println("L - Login no sistema");  
        System.out.println("X - Sair");  
        return teclaS.nextLine();  
    }
	
	private static String menuUsuario() {  
        System.out.println("\nSelecione a opção:");
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
