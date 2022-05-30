package model;

public class ContaComum extends Conta {

	//Construtor
	public ContaComum(int numconta) {
		super(numconta);

	}

	//Metodos
	public boolean Sacar(double valor_saque) {
		if (getSaldo() < valor_saque) {
			return false;
		} else {
			this.saldo = this.saldo - valor_saque;
			return true;
		}
	}

}
