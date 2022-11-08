package B3IAM.Restexample;

public class varargs {

	float sum = 0;

	public float add(String op, String... x) {

		for (String n : x)
			sum += Float.parseFloat(n);
		return  sum;
	}

	public String avg(String op, String... x) {
		return op+": "+sum*50/100;

	}
}
