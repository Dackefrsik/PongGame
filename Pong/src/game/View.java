package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View {
	
	private JFrame F;
	private JPanel P;
	private JButton Player1;
	private JButton Player2;
	
	Controller C;
	
	
	
	View(Controller C){
		this.C = C;
		
		F = new JFrame();
		P = new JPanel();
		P.setLayout(null);
		Player1 = new JButton();
		Player1.setBounds(0, C.getPlayer1Y(), 15, 50);
	
		Player2 = new JButton();
		Player2.setBounds(271, C.getPlayer2Y(),  15, 50);
		
		
		P.add(Player1);
		P.add(Player2);		
		
		
		
		F.add(P);
		F.setSize(300, 300);
		F.setVisible(true);
		F.setFocusable(true);
		F.setDefaultCloseOperation(F.EXIT_ON_CLOSE);
		
		
		F.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if(keyCode == KeyEvent.VK_W) {
					C.setCurrent1("Up");
					MovePlayer();
				}
				else if(keyCode == KeyEvent.VK_S) {
					C.setCurrent1("Down");
					MovePlayer();
				}
				else if(keyCode == KeyEvent.VK_UP) {
					C.setCurrent2("Up");
					MovePlayer();
				}
				else if(keyCode == KeyEvent.VK_DOWN) {
					C.setCurrent2("Down");
					MovePlayer();
				}
			}
		});
		
	}
	
	public void MovePlayer() {
		
		if(C.getCurrent1() == "Up") {
			System.out.println("up");
			C.setBounds1Y(5);	
			Player1.setBounds(0, C.getPlayer1Y(), 15, 50);
		}
		else if(C.getCurrent1() == "Down") {
			C.setBounds1Y(5);
			Player1.setBounds(0, C.getPlayer1Y(), 15, 50);
		}
		else if(C.getCurrent2() == "Up") {
			C.setBounds2Y(5);
			Player2.setBounds(271, C.getPlayer2Y(), 15, 50);
		}
		else if(C.getCurrent2() == "Down") {
			C.setBounds2Y(5);
			Player2.setBounds(271, C.getPlayer2Y(), 15, 50);
		}
		
		P.repaint();
		
	}
}
