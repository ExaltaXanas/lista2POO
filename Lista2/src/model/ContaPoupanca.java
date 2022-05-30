package model;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(int numconta) {
		super(numconta);
		
	}

	
	public boolean Sacar(double valor_saque) {
		if (getSaldo() < valor_saque) {
			return false;
		} else {
			this.saldo = this.saldo - valor_saque;
			return true;
		}
	}
	
	public void CreditarRendimentos(double taxajuros) {
		
		double rendimento = this.saldo * taxajuros;
		this.saldo = this.saldo + rendimento;
		
	}

	
	
	
	
	
	
	
	
}
