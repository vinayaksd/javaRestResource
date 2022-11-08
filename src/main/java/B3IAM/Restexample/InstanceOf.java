package B3IAM.Restexample;

public class InstanceOf<T> {
	T x;
	T ar[];
	public String getType() {
		
	if(x  instanceof Integer)
		return "integer";
	else if (x instanceof Float)
		return "float";
	else
		return "anyother";
	}
	
	public void createArray(T... values) {
		 ar=values;
	}
	
	public T[] readArray() {
		return ar;
	}
}
