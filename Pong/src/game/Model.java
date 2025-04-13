package game;

public class Model {
	
	
	private String Current1;
	private String Current2;
	
	int boundsY1 = 100;
	int boundsY2 = 100;
	
	public int getBoundsY1() {
		return boundsY1;
	}
	
	public void setBoundsY1(int Y) {
		if(Current1 == "Up") {
			boundsY1 -= Y;                                                                                        
		}
		else {
			boundsY1 += Y;
		}

	}
	
	public int getBoundsY2() {
		return boundsY2;
	}
	
	public void setBoundsY2(int Y) {
		
		boundsY2 += Y;
	}
	
	public String getCurrent1() {
		return Current1;
	}
	
	public void setCurrent1(String current) {
		Current1 = current;
	}
}
