package avaliacaodegoleiros;

import java.util.ArrayList;

public class Selecao {
	private int id;
	private String nome;
	private ArrayList<Goleiro> listaGoleiros;
	
	public Selecao(int id, String nome) {
		this.id = id;
		this.nome = nome;
		setListaGoleiros(new ArrayList<Goleiro>());
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public ArrayList<Goleiro> getListaGoleiros() {
		return listaGoleiros;
	}

	public void setListaGoleiros(ArrayList<Goleiro> listaGoleiros) {
		this.listaGoleiros = listaGoleiros;
	}
	
	public void addGoleiro(Goleiro goleiro) {
		listaGoleiros.add(goleiro);
	}
}
