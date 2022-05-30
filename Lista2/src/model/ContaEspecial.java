package model;

public class ContaEspecial extends Conta {
	
	//atributos
	private double credito;
	
    //Construtor
	public ContaEspecial(int numconta) {
		super(numconta);
	}

	//GET e SET
	public double getCredito() {
		return credito;
	}

	public void setCredito(double credito) {
		this.credito = credito;
	}

	//Metodos
	public boolean Sacar(double valor_saque) {
		
		if ( (getSaldo() + credito) < valor_saque) {
			return false;
		} else {
			this.saldo = this.saldo - valor_saque;
			this.credito = this.credito - valor_saque;
			return true;
		}

}
	
	
	
}
