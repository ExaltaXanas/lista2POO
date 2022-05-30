package lista2;

import model.*;
import util.Keyboard;

public class Main {

	static Conta [] listaContas = new Conta [10];	
	static int cont;	
	
	public static void main(String[] args) {
		
		cont = 0;
		
		int opcoes = 0;
		
		
		 opcoes = Keyboard.menu("Cadastrar/Listar/Deposito/Saque/Consultar conta/Crditar rendimento/ Terminar");
		
		 do {
			 switch(opcoes) {
				
				case 1:
					Cadastar();
					break;
				case 2:
					ListarContas();
					break;
				case 3:
					Depositar();
					break;
				case 4:
					Sacar();
					break;
				case 5:
					ConsultarConta();
					break;
				case 6:
					CreditarRendimentos();
					break;
				case 7:
					System.out.println("Até!!");
					break;
				
			 }
		 } while (opcoes < 7);
	}
	

	private static void Sacar() {
	
		int numconta = Keyboard.readInt("Informe o numero da conta: ");
		Conta conta = getConta(numconta);
		
		if(conta != null) {
			double valor_saque = Keyboard.readDouble("Informe o valor do saque: ");
			if(conta instanceof ContaComum) {
				((ContaComum)conta).Sacar(valor_saque);
			}
			if(conta instanceof ContaEspecial) {
				((ContaEspecial)conta).Sacar(valor_saque);
			}
			if(conta instanceof ContaPoupanca) {
				((ContaPoupanca)conta).Sacar(valor_saque);
			}
				
		} else {
			System.out.println("Invalida");
		  }
		
	}


	private static void ConsultarConta() {
		  
		int numconta = Keyboard.readInt("Informe o numero da conta: ");
		Conta conta = getConta(numconta);
		
		if(conta != null) {
			System.out.println("Num conta           Nome Cliente              Saldo           Tipo COnta");
			System.out.println("---------           ------------              -----           ----------");
			System.out.print(conta.getNumconta() +  "           ");
			System.out.print(conta.getNomecliente() +  "           ");
			System.out.print(conta.getSaldo() +  "           ");
			
			if(conta instanceof ContaComum) {
				System.out.print("Comum");
			}
			if(conta instanceof ContaEspecial) {
				System.out.print("Especial");
			}
			if(conta instanceof ContaPoupanca) {
				System.out.print("Poupanca");
			}	
             System.out.println("");
			
		}
		
	}


	private static void Depositar() {
		
		int numconta = Keyboard.readInt("Informe o numero da conta: ");
		Conta conta = getConta(numconta);
		
		if(conta != null) {
		double deposito = Keyboard.readDouble("Informe o valor do deposito: ");
		conta.Depositar(deposito);
		} else {
			System.out.println("Conta nao encontrada!");
		}
	}


	private static void CreditarRendimentos() {
		
		double taxajuros = Keyboard.readDouble("Informe a taxa dae juros: ");
		for(int i = 0; i < cont; i++) {
			if(listaContas[i] instanceof ContaPoupanca) {
				((ContaPoupanca) listaContas[i]).CreditarRendimentos(taxajuros);
			}	      
	    }
	}


	private static void ListarContas() {
		for(int i = 0; i < cont; i++) {
		
				System.out.println("Num conta           Nome Cliente              Saldo           Tipo COnta");
				System.out.println("---------           ------------              -----           ----------");
				System.out.print(listaContas[i].getNumconta() +  "           ");
				System.out.print(listaContas[i].getNomecliente() +  "           ");
				System.out.print(listaContas[i].getSaldo() +  "           ");
				
				if(listaContas[i] instanceof ContaComum) {
					System.out.print("Comum");
				}
				if(listaContas[i] instanceof ContaEspecial) {
					System.out.print("Especial");
				}
				if(listaContas[i] instanceof ContaPoupanca) {
					System.out.print("Poupanca");
				}	
                 System.out.println("");
		}
	}
		     
	

	private static void Cadastar() {
		
		int numconta = 0;
		do { 
			numconta = Keyboard.readInt("Informe o numero da conta: "); 
			} while(verificarNumConta(numconta));
			
		String nomecliente = Keyboard.readString("Informe o nome do cliente: ");
		Conta novaconta;
		int tipoconta = Keyboard.menu("Conta Comum/Conta Especial/Conta Poupanca");
		
		switch(tipoconta) {
		case 1:
			novaconta = new ContaComum(numconta);
			novaconta.setNomecliente(nomecliente);
			listaContas[cont] = novaconta;	
			break;
		case 2:
			novaconta = new ContaEspecial(numconta);
			novaconta.setNomecliente(nomecliente);
			listaContas[cont] = novaconta;	
			break;
		case 3:
			novaconta = new ContaPoupanca(numconta);
			novaconta.setNomecliente(nomecliente);
			listaContas[cont] = novaconta;	
			break;
			
		}
		
		cont++;
			
	}
	

	private static Conta getConta(int numconta) {
		for(int i = 0; i < cont; i++) {
			if(listaContas[i].getNumconta() == numconta)
			{
				return listaContas[i];
			}
			
		}
		      return null;
	}
	
	private static boolean verificarNumConta(int numconta){
		for(int i = 0; i < cont; i++) {
			if(listaContas[i].getNumconta() == numconta)
			{
				return true;
			}
			
		}
		      return false;
		
	}

	
	
	
	
	
	
	
	
	
}
