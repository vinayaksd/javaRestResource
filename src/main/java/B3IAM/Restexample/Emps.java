package B3IAM.Restexample;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Emps implements Comparable<Emps>{
	public int id;
	public String name;
	public double sal;
	double bonus;
	int depid;
	int manager_id;
	
	Emps(){
		
	}
	Emps(int id, String name,double sal,double bonus,int depid,int manager_id){
		this.id=id;
		this.name=name;
		this.sal=sal;
		this.bonus=bonus;
		this.depid=depid;
		this.manager_id=manager_id;
	}
	

	@Override
	public int compareTo(Emps i) {
		
		return (int)(bonus-i.bonus);
	}
}
