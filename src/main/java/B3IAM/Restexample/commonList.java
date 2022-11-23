package B3IAM.Restexample;

import java.util.ArrayList;
import java.util.List;

public class commonList {

	public static void main(String[] args) {
		
		int k = 0;
		int n=0;
		String s = "";
		
		List<Integer> list1 = new ArrayList<>(); // list1
		List<Integer> list2 = new ArrayList<>(); // list2
		List<Integer> list3 = new ArrayList<>();

		for (int i = 1; i <= 10; i++) {
			list1.add(k++, i);
		}

		for (int i = 5; i <= 10; i++) {
			list2.add(n++, i);
		}

		for (int i = 0; i < list2.size(); i++) {
			int j=0;
			if (list1.contains(list2.get(i)))
				list3.add(j++, list2.get(i));
		}
		
		for (Integer a : list3) {
			System.out.println(a);
			s+=a+" ";
		}
		System.out.print(s);
		
	}


}
