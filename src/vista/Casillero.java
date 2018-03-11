package vista;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Casillero extends JPanel{
	protected JButton casillas[][];
	private final int dimension = 18;

	public Casillero() {
		iniciarCasillero();
	}

	public void iniciarCasillero() {
		this.casillas = new JButton[this.dimension][this.dimension];
		for (int i = 0; i < this.dimension; i++) {
			for (int j = 0; j < this.dimension; j++) {
				this.casillas[i][j] = new JButton();
				this.casillas[i][j].setName(String.valueOf(i)+" "+ String.valueOf(j));
				this.add(this.casillas[i][j]);
			}

		}
	}

	public JButton[][] getCasillas() {
		return casillas;
	}
}
