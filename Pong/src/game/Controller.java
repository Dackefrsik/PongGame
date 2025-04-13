package game;
public class Controller {

	Model m;
	View v;
	
	Controller( View v, Model m){
		this.m = new Model();
	}
	
	public static void main(String[] args) {
	
		Controller C = new Controller(null, new Model());
		C.v = new View(C);
	}
	
	public int getPlayer1Y() {
		return m.boundsY1;
	}
	
	public void setBounds1Y(int Y) {
		m.setBoundsY1(Y);
	}

	public int getPlayer2Y() {
		return m.boundsY2;
	}
	
	public void setBounds2Y(int Y) {
		m.setBoundsY2(Y);
	}
	
	public String getCurrent1() {
		return m.getCurrent1();
	}
	
	public void setCurrent1(String current) {
		m.setCurrent1(current);
	}
}
