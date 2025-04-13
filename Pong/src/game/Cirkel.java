package game;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class Cirkel extends JComponent{
	

	
	public Cirkel() {
		setBounds(125,125,25,25);
	}
		
	protected void paintComponent(Graphics g) {
		
		super.paintComponents(g);
		g.setColor(Color.red);
		g.fillOval(0, 0, 25, 25);
	}
}
