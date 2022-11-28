package B3IAM.Restexample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class implListSalary {

	 public static void main(String[] args) {
		 implListSalary imp = new implListSalary();
		 imp.listofStuds();
	}
		public List<Emps> listofStuds(){
			int id[]= {101,102,103,104};
			String names[]= {"vinnu","akash","abhishek","amani"};
			int sal[]= {70000,10000,5000,2000};
			int bonus[]= new int[sal.length];
			System.out.println(sal.length);
			
			
			for(int i=0;i<bonus.length;i++) {
				
				if(sal[i]>25000)
					bonus[i]=10*sal[i]/100;
				if(sal[i]>10000 && sal[i]<=25000)
					bonus[i]=15*sal[i]/100;	
				if(sal[i]<=10000)
					bonus[i]=20*sal[i]/100;
				
			}
			
			List <Emps> list= new ArrayList<Emps>();
			int j =0;
			
			for(int i =0; i<=sal.length;i++) {
			Emps e= new Emps(id[i],names[i],sal[i],bonus[i]);
			list.add(e);
			}
			 Collections.sort(list);
			 
			for(Emps e:list)
			System.out.println(e.name+"  ="+e.bonus+" ");
			return list;	
		}

	}


