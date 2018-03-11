package modelo;

public class Casillero {
	private final int dimension = 18;
	private Casilla casillero[][] = new Casilla[this.dimension][this.dimension];
	private int minas;
	private int coordenadas[] = new int[2];
	private boolean minaTocada = false;

	public Casillero() {
		super();
		inicializar();
	}

	public Casilla[][] getCasillero() {
		return casillero;
	}

	public void setCasillero(Casilla[][] casillero) {
		this.casillero = casillero;
	}

	public int getMinas() {
		return minas;
	}

	public void setMinas(int minas) {
		this.minas = minas;
	}

	public int[] getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(int[] coordenadas) {
		this.coordenadas = coordenadas;
	}

	public boolean isMinaTocada() {
		return minaTocada;
	}

	public void setMinaTocada(boolean minaTocada) {
		this.minaTocada = minaTocada;
	}

	public int getDimension() {
		return dimension;
	}

	// Va a guardar en cada posicion de la matriz una instancia de tipo casilla
	public void inicializar() {
		for (int i = 0; i < this.dimension; i++) {
			for (int j = 0; j < this.dimension; j++) {
				this.casillero[i][j] = new Casilla();
			}
		}

	}

	public void crearMinas() {
		int x;
		int y;
		int cuentaMina = 0;
		do {
			x = generarNumero(this.dimension - 1, 0);
			y = generarNumero(this.dimension - 1, 0);
			if (!this.casillero[x][y].isMina()) {
				this.casillero[x][y].setMina(true);
				cuentaMina++;
			}
		} while (cuentaMina != this.minas);
	}

	public int generarNumero(int max, int min) {
		return (int) (Math.random() * (max - min)) + min;
	}

	public int cuentaMinasAlrededor(int x, int y) {
		int minas = 0;
		for (int i = 0; i < this.dimension; i++) {
			for (int j = 0; j < this.dimension; j++) {
				if (Math.abs(x - i) <= 1 && Math.abs(y - j) <= 1) {
					if (this.casillero[i][j].isMina()) {
						minas++;
					}
				}
			}
		}
		return minas;
	}

	public void mostrarRecursivamente(int x, int y) {
		int minasContiguas = cuentaMinasAlrededor(x, y);
		if (minasContiguas != 0) {
			this.casillero[x][y].setDesvelada(true);
			this.casillero[x][y].setMinasAlrededor(minasContiguas);
		} else {
			this.casillero[x][y].setDesvelada(true);
			for (int i = 0; i < this.dimension; i++) {
				for (int j = 0; j < this.dimension; j++) {
					if (Math.abs(x - i) <= 1 && Math.abs(y - j) <= 1 && (i != x || j != y)
							&& !this.casillero[i][j].isDesvelada()) {
						mostrarRecursivamente(i, j);
					}
				}
			}
		}
	}

	public boolean juegoAcabado() {
		for (int i = 0; i < this.dimension; i++) {
			for (int j = 0; j < this.dimension; j++) {
				if (!this.casillero[i][j].isDesvelada() && !this.casillero[i][j].isMina()) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean iniciarJugada() {
		if (this.casillero[this.coordenadas[0]][this.coordenadas[1]].isMina()) {
			this.minaTocada = true;
			return false;
		} else {
			mostrarRecursivamente(this.coordenadas[0], this.coordenadas[1]);
			if (juegoAcabado()) {
				return false;
			}
			return true;
		}
	}

}
