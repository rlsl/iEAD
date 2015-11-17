package iEAD;

import java.util.List;  
import java.util.Scanner;  
import java.util.ArrayList;  

public class Main {
	
	private static Scanner teclaS, teclaI;
    private static List<Conta> contas;
    
    //private int telefone;
	//private String login,
	//				nome,
	//				senha,
	//				endereco;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		teclaS = new Scanner(System.in);
		teclaI = new Scanner(System.in);
        contas = new ArrayList<Conta>();  
  
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
            usuario.setSenha(entradaTexto("Senha: "));  
            usuario.setNome(entradaTexto("Nome: "));
            usuario.setCpf(entradaNumero("CPF: "));
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
		String user = entradaTexto("Login:");
		String pass = entradaTexto("Senha:");
		if(retornaLogin(user,pass) == true) {
			System.out.println("\nUsuario Logado \n");
			while (true) {  
	            String opcao = menuUsuario();  
	  
	            if (opcao.equalsIgnoreCase("s")) {  
	            	System.out.println("\nImplementando \n");
	            } else if (opcao.equalsIgnoreCase("e")) {  
	            	System.out.println("\nImplementando \n");
	            } else if (opcao.equalsIgnoreCase("t")) {
	            	System.out.println("\nImplementando \n");
	            } else if (opcao.equalsIgnoreCase("x")) {
	            	break;
	            } else {  
	                System.out.println("\nOpção Inválida \n");  
	            }  
	        }  

		} else {
			System.out.println("\nUsuario não cadastrado \n");
		}
	}
	
	private static boolean retornaLogin(String user, String pass) {
		if (contas.size() == 0) {  
            System.out.println("\nNão existem cadastros !!! \n");  
        } else {  
            for (int i = 0; i < contas.size(); i++) {
            	Conta u = contas.get(i);
            	if(user.equals(u.getLogin()) && (pass.equals(u.getSenha()))) {
            		return true;
            	}
            }
            return false;
        }
		return false;
            
	}
	
	private static void listarCadastros() {  
        if (contas.size() == 0) {  
            System.out.println("\nNão existem cadastros !!!\n");  
        } else {  
            System.out.println("\nLista de Cadastros\n");  
            for (int i = 0; i < contas.size(); i++) {  
                Conta u = contas.get(i);  
                System.out.println("Cadastro número: " + i);  
                System.out.println("\tNome: " + u.getLogin());  
                System.out.println("\tLogin: " + u.getSenha());  
                System.out.println("\tCargo: " + u.getNome() + "\n");  
            }  
            System.out.println("\nFim da lista\n");  
        }  
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
        System.out.println("S - Alterar senha");  
        System.out.println("E - Alterar endereço");
        System.out.println("T - Alterar telefone");
        System.out.println("X - Logout");  
        return teclaS.nextLine();  
    }
	
	private static String entradaTexto(String info) {  
        System.out.println(info);  
        return teclaS.nextLine();  
    }
	
	private static int entradaNumero(String info) {  
        System.out.println(info);
        return teclaI.nextInt();  
    }
}
