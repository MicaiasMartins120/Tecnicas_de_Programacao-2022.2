package Salao_java;

public class Cliente {
	private int id;
	private String cpf;
	private String nome;
	
	public Cliente(String cpf) {
		this.cpf = cpf;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		if(id > 0)
			this.id = id;
	}

	public String getCpf() {
		return this.cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(nome.length() >= 3)
				this.nome = nome;
	}
}
