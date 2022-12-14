package avaliacaodegoleiros;

public class Chute {
	private int id;
	private int forca;
	private int quadrante;
	private int X;
	private int Y;
	private boolean foiGol = true;
	
	public Chute(int id) {
		this.setId(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getForca() {
		return forca;
	}

	public int getQuadrante() {
		return quadrante;
	}

	public int getX() {
		return X;
	}

	public int getY() {
		return Y;
	}
	
	public void setInfoChute(int forca, int quadrante, int x, int y) {
		this.forca = forca;
		this.quadrante = quadrante;
		this.X = x;
		this.Y = y;
	}

	public boolean isFoiGol() {
		return foiGol;
	}

	public void setFoiGol(boolean foiGol) {
		this.foiGol = foiGol;
	}
}
