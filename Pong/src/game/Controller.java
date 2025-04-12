package game;
public class Controller {

	Model m; 
	
	Controller(Model m){
		this.m = m;
	}
	
	public static void main(String[] args) {
	
		Controller C = new Controller(new Model());

	}

}
