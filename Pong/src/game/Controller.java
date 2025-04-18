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
	
	public String getCurrent2() {
		return m.getCurrent2();
	}
	
	public void setCurrent2(String current) {
		m.setCurrent2(current);
	}
	
	public int getCirkelBounds() {
		return m.getCirkelBounds();
	}
	
	public void setCirkelBounds(int current) {
		m.setCirkelBounds(current);
	}
	
	public int getCirkelBoundsY() {
		return m.getCirkelBoundsY();
	}
	
	public void setCirkelBoundsY(int current) {
		m.setCirkelBoundsY(current);
	}
}
