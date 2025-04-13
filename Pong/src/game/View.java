package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View {
	
	private JFrame F;
	private JPanel P;
	private JButton Player1;
	private JButton Player2;
	
	Controller C;
	
	Cirkel Cirkel;
	
	Timer MoveTimer;
	
	String move = "LeftRightUp";
	
	View(Controller C){
		this.C = C;
		
		F = new JFrame();
		P = new JPanel();
		P.setLayout(null);
		P.setBackground(Color.blue);
		Player1 = new JButton();
		Player1.setBounds(0, C.getPlayer1Y(), 15, 50);
	
		Player2 = new JButton();
		Player2.setBounds(241, C.getPlayer2Y(),  15, 50);
			
		P.add(Player1);
		P.add(Player2);
		Cirkel = new Cirkel();
		P.add(Cirkel);
			
		F.add(P);
		F.setSize(new Dimension(270, 292));
		F.setLocation(300, 300);
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
				C.setCurrent1("");
				C.setCurrent2("");
			}
		});
		
		move();
		
	}
	
	public void MovePlayer() {
		
		if(C.getCurrent1() == "Up" && Player1.getBounds().y != 0) {
			C.setBounds1Y(5);	
			Player1.setBounds(0, C.getPlayer1Y(), 15, 50);
		}
		else if(C.getCurrent1() == "Down" && (Player1.getBounds().y + Player1.getHeight()) < P.getHeight()) {
			C.setBounds1Y(5);
			Player1.setBounds(0, C.getPlayer1Y(), 15, 50);
		}
		else if(C.getCurrent2() == "Up" && Player2.getBounds().y != 0) {
			C.setBounds2Y(5);
			Player2.setBounds(241, C.getPlayer2Y(), 15, 50);
		}
		else if(C.getCurrent2() == "Down" && (Player2.getBounds().y + Player2.getHeight() < P.getHeight())) {
			C.setBounds2Y(5);
			Player2.setBounds(241, C.getPlayer2Y(), 15, 50);
		}
		
		P.repaint();	
	}
	
	
	public void move() {
		MoveTimer = new Timer();
		
		MoveTimer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {				
				//höger ner till vänster upp
				if(Cirkel.getBounds().x >= 0 && move.equals("RightLeftUp")) {
					
					
					if(Cirkel.getBounds().intersects(Player1.getBounds()) && move.equals("RightLeftUp")) {
						move = "LeftRightUp";
					}
					else if(Cirkel.getY() == 0 && move.equals("RightLeftUp")) {
						System.out.println("TopRightLeftUp");
						move = "RightLeftDown";
					}
					else if(Cirkel.getBounds().x > 0 ) {
						C.setCirkelBounds(Cirkel.getBounds().x - 10);
						C.setCirkelBoundsY(Cirkel.getBounds().y - 5);
					}
					else {
						this.cancel();
					}
				}
				
				//Går från höger uppe till vänster nere
				else if(Cirkel.getBounds().x <= (P.getWidth() - Cirkel.getBounds().width) && Cirkel.getBounds().y <= (P.getHeight() - 25) && move.equals("RightLeftDown")) {
					
					
					if(Cirkel.getBounds().intersects(Player1.getBounds()) && move.equals("RightLeftDown")) {
						move = "LeftRightDown";
					}
					else if((Cirkel.getY() + Cirkel.getHeight()) >= P.getHeight() && move.equals("RightLeftDown")) {
					    System.out.println("BottenRightLeftDown");                                                                                                                                                        
						move = "RightLeftUp";
					}
					else if(Cirkel.getBounds().x > 0){
						C.setCirkelBounds(Cirkel.getBounds().x - 10);
						C.setCirkelBoundsY(Cirkel.getBounds().y + 5);
					}
					else {
						this.cancel();
					}
				}
				

				//Går från vänster upp till höger nere
				else if(Cirkel.getBounds().x <= (P.getWidth() - Cirkel.getBounds().width) && Cirkel.getBounds().y <= (P.getHeight() - 25) && move.equals("LeftRightDown")) {
					
					
					if((Cirkel.getBounds().intersects(Player2.getBounds())) && move.equals("LeftRightDown")) {
						move = "RightLeftDown";
					}
					//Höger upp till vänster ner
					else if((Cirkel.getY() + Cirkel.getHeight()) >= P.getHeight() && move.equals("LeftRightDown")) {
						System.out.println("BottenLeftRightDown");                                                                                                                                                        
						move = "LeftRightUp";
						
					}
					else if((Cirkel.getBounds().x + Cirkel.getWidth()) <= P.getWidth()){
						C.setCirkelBounds(Cirkel.getBounds().x + 10);
						C.setCirkelBoundsY(Cirkel.getBounds().y + 5);
					}
					else {
						this.cancel();
					}
				}
				
				//Vänster nere till höger uppes
				else if(Cirkel.getBounds().x >= 0 && move.equals("LeftRightUp")) {
					
					
					if(Cirkel.getBounds().intersects(Player2.getBounds()) && move.equals("LeftRightUp")) {
						move = "RightLeftUp";
					}
					//Vänster upp till höger ner
					else if((Cirkel.getY()) == 0 && move.equals("LeftRightUp")) {

	   					System.out.println("TopLeftRightUp");                                                                                                                                                        
						move = "LeftRightDown";
						
					}
					else if((Cirkel.getBounds().x + Cirkel.getWidth()) <= P.getWidth()){
						C.setCirkelBounds(Cirkel.getBounds().x + 10);
						C.setCirkelBoundsY(Cirkel.getBounds().y - 5);
					}
					else {
						this.cancel();
					}
				}				
					Cirkel.setBounds(C.getCirkelBounds(), C.getCirkelBoundsY(), 25, 25);
				}
				
		}, 0, 100 );
	}
}
