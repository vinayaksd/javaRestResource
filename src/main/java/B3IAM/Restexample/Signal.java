package B3IAM.Restexample;

public enum Signal {
	RED("STOP",0),YELLOW("READY",1),GREEN("GO",2);
	String signal;
	int code;
	Signal(String str, int val){
		this.signal=str;
		this.code=val;
	}
}
