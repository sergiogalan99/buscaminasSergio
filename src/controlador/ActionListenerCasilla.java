package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class ActionListenerCasilla implements MouseListener {
	private ParaBuscaminas parabuscaminas;
	private int cordenadas[];

	public ActionListenerCasilla(ParaBuscaminas parabuscaminas) {
		super();
		this.parabuscaminas = parabuscaminas;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.cordenadas=convertirCoordenadas(((JButton)e.getSource()).getName());
		if ((e.getModifiers() & 16) != 0
				&& parabuscaminas.getCasillero().getCasillas()[this.cordenadas[0]][this.cordenadas[1]].isEnabled()) {
			if (e.getClickCount() > 1) {

			} else {
				this.parabuscaminas.jugar(this.cordenadas);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public int[] convertirCoordenadas(String nameCoordenada) {
		int x = Integer.parseInt(nameCoordenada.substring(0, nameCoordenada.indexOf(" ")));
		int y = Integer.parseInt(nameCoordenada.substring(nameCoordenada.indexOf(" ") + 1));
		int[] coordenadas = { x, y };
		return coordenadas;
	}
}
