package modelo;

public class Casilla {
	private boolean mina = false;
	private boolean desvelada = false;
	private boolean marcada = false;
	private int minasAlrededor = 0;

	public boolean isMina() {
		return mina;
	}

	public void setMina(boolean mina) {
		this.mina = mina;
	}

	public boolean isDesvelada() {
		return desvelada;
	}

	public void setDesvelada(boolean desvelada) {
		this.desvelada = desvelada;
	}

	public boolean isMarcada() {
		return marcada;
	}

	public void setMarcada(boolean marcada) {
		this.marcada = marcada;
	}

	public int getMinasAlrededor() {
		return minasAlrededor;
	}

	public void setMinasAlrededor(int minasAlrededor) {
		this.minasAlrededor = minasAlrededor;
	}

}
