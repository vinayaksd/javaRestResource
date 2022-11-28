package B3IAM.Restexample;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Emps implements Comparable<Emps>{
	public int id;
	public String name;
	public double sal;
	double bonus;
	
	
	Emps(int id, String name,double sal,double bonus){
		this.id=id;
		this.name=name;
		this.sal=sal;
		this.bonus=bonus;
		
	}
	

	@Override
	public int compareTo(Emps i) {
		
		return (int)(bonus-i.bonus);
	}
}
