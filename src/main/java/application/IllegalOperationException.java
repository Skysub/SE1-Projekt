package application;

public class IllegalOperationException extends Exception {
	private static final long serialVersionUID = 2430937934969691717L;
	
	IllegalOperationException(String e){
		super(e);
	}
}
