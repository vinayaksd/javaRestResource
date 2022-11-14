package B3IAM.Restexample;

public class indexString {

	public int findIndex(String[] arr, String val) {
		
		int i = 0;
		while (i < arr.length) {
			if (arr[i] == val)
				return i;
			else
				i++;

		}
		return -1;
		
	}
}
