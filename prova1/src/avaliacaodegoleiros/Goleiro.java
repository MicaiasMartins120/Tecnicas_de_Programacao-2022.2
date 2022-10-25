package avaliacaodegoleiros;

import java.util.ArrayList;

public class Goleiro {
	private int id;
	private String nome;
	private int velocidade;
	private int flexibilidade;
	private int agilidade;
	private int coordenacao;
	private int forca;
	private int equilibrio;
	private int defesasSucedidas = 0;
	private int defesasFalhas = 0;
	private int golsSofridos = 0;
	private ArrayList<Chute> listaChutes;
	
	public Goleiro(int id, String nome) {
		this.setId(id);
		this.setNome(nome);
		setListaChutes(new ArrayList<Chute>());
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

	public int getVelocidade() {
		return velocidade;
	}

	public int getFlexibilidade() {
		return flexibilidade;
	}

	public int getAgilidade() {
		return agilidade;
	}

	public int getCoordenacao() {
		return coordenacao;
	}

	public int getForca() {
		return forca;
	}

	public int getEquilibrio() {
		return equilibrio;
	}
	public void setStats(int velocidade, int flexibilidade, int agilidade, int coordenacao, int forca, int equilibrio) {
		if(velocidade > 0 && velocidade < 11) {
			this.velocidade = velocidade;
		}
		if(flexibilidade > 0 && flexibilidade < 11) {
			this.flexibilidade = flexibilidade;
		}
		if(agilidade > 0 && agilidade < 11) {
			this.agilidade = agilidade;
		}
		if(coordenacao > 0 && coordenacao < 11) {
			this.coordenacao = coordenacao;
		}
		if(forca > 0 && forca < 11) {
			this.forca = forca;
		}
		if(equilibrio > 0 && equilibrio < 11) {
			this.equilibrio = equilibrio;
		}
	}

	public int getAAG() {
		int AAG = 0;
		
		AAG += 3 * getVelocidade();
		AAG += 2 * getFlexibilidade();
		AAG += 3 * getAgilidade();
		AAG += 2 * getCoordenacao();
		AAG += getForca();
		AAG += 2 * getEquilibrio();
		AAG = AAG/8;
		
		return AAG;
	}

	public ArrayList<Chute> getListaChutes() {
		return listaChutes;
	}

	public void setListaChutes(ArrayList<Chute> listaChutes) {
		this.listaChutes = listaChutes;
	}
	
	public void addChute(ArrayList<Chute> listaChutes) {
		for (Chute chute : listaChutes) {
			this.listaChutes.add(chute);
		}
	}

	public int getDefesasSucedidas() {
		return defesasSucedidas;
	}

	public void setDefesasSucedidas() {
		this.defesasSucedidas ++;
	}

	public int getGolsSofridos() {
		return golsSofridos;
	}

	public void setGolsSofridos(int golsSofridos) {
		this.golsSofridos = golsSofridos;
	}

	public int getDefesasFalhas() {
		return defesasFalhas;
	}

	public void setDefesasFalhas() {
		this.defesasFalhas++; 
	}
	
}
