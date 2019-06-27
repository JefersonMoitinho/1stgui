package br.edu.ifsc.ui.entities;

public class Student {
	private String nome;
	private String rg;
	private String cpf;
	private String data;
	private double peso;
	private double altura;
	private String endereco;

	public Student(String nome, String rg, String cpf, String data, double peso, double altura, String endereco) {
		super();
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.data = data;
		this.peso = peso;
		this.altura = altura;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso( double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	

}
