package controlador;

import java.awt.Color;

import modelo.Casillero;
import vista.BuscaminasUI;

public class ParaBuscaminas extends BuscaminasUI {
	private Casillero control = new Casillero();
	private ActionListenerCasilla actionlistener = new ActionListenerCasilla(this);

	public ParaBuscaminas() {
		super();
		setListener();
	}

	public void jugar(int[] cordenadas) {
		control.setCoordenadas(cordenadas);
		if (control.iniciarJugada()) {
			actualizarCasillero();
		}
	}

	public void actualizarCasillero() {
		for (int i = 0; i < this.control.getDimension(); i++) {
			for (int j = 0; j < this.control.getDimension(); j++) {
				if (this.control.getCasillero()[i][j].isDesvelada()
						&& this.control.getCasillero()[i][j].getMinasAlrededor() == 0) {
					casillero.getCasillas()[i][j].setEnabled(false);
					casillero.getCasillas()[i][j].setBackground(new Color(180, 180, 180));
				}
				if (control.getCasillero()[i][j].getMinasAlrededor() > 0) {
					casillero.getCasillas()[i][j]
							.setText(String.valueOf(control.getCasillero()[i][j].getMinasAlrededor()));
					casillero.getCasillas()[i][j].setBackground(new Color(180, 180, 180));
				}
			}

		}

	}

	private void setListener() {
		for (int i = 0; i < this.control.getDimension(); i++) {
			for (int j = 0; j < this.control.getDimension(); j++) {
				this.casillero.getCasillas()[i][j].addMouseListener(actionlistener);
			}

		}
	}

}
