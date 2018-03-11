package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;

public class BuscaminasUI extends JFrame {

	private JPanel contentPane;

	protected Casillero casillero;
	//private JPanel panel;

	public BuscaminasUI() {
		setMinimumSize(new Dimension(500, 500));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		casillero = new Casillero();
		casillero.setLayout(new GridLayout(18,18,1,1));
		contentPane.add(casillero, BorderLayout.CENTER);
	}

	public Casillero getCasillero() {
		return casillero;
	}

}
