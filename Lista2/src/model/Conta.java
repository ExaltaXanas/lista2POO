package model;

public abstract class Conta {

	//ATRIBUTOS
	private int numconta;
	private String nomecliente;
	protected double saldo;

    //CONTRUTORES
	public Conta(int numconta) {
		this.numconta = numconta;
	}
	
     //METODOS
	public void Depositar(double valor_deposito) {
		double novosaldo = this.saldo + valor_deposito;
		this.saldo = novosaldo;
	}

	public abstract boolean Sacar(double valor_saque);
	
	//Gets e Sets
	public String getNomecliente() {
		return nomecliente;
	}

	public void setNomecliente(String nomecliente) {
		this.nomecliente = nomecliente;
	}

	public int getNumconta() {
		return numconta;
	}

	public double getSaldo() {
		return saldo;
	}
	
	

}
