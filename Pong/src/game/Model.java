package game;

public class Model {
	
	
	private String Current1;
	private String Current2;
	
	int boundsY1 = 100;
	int boundsY2 = 100;
	
	int cirkelBounds = 150;
	int cirkelBoundsY = 150;
	
	public int getBoundsY1() {
		return boundsY1;
	}
	
	public void setBoundsY1(int Y) {
		if(Current1 == "Up") {
			boundsY1 -= Y;                                                                                        
		}
		else if(Current1 == "Down"){
			boundsY1 += Y;
		}

	}
	
	public int getBoundsY2() {
		return boundsY2;
	}
	
	public void setBoundsY2(int Y) {
		if(Current2 == "Up") {
	   		boundsY2 -= Y;   
		}
		else if(Current2 == "Down"){
			boundsY2 += Y;
		}

	}
	
	public String getCurrent1() {
		return Current1;
	}
	
	public void setCurrent1(String current) {
		Current1 = current;
	}
	
	public String getCurrent2() {
		return Current2;
	}
	
	public void setCurrent2(String Current) {
		Current2 = Current;
	}
	
	public void setCirkelBounds(int Current) {
		cirkelBounds = Current;
	}
	
	public int getCirkelBounds() {
		return cirkelBounds;
	}
	
	public void setCirkelBoundsY(int Current) {
		cirkelBoundsY = Current;
	}
	
	public int getCirkelBoundsY() {
		return cirkelBoundsY;
	}
}
