package B3IAM.Restexample;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class studs {

	public int id;
	public String name;
	public String courses;
	public int age;
	public static String college="sit tumkur";
	
	studs(){
		
	}
	public studs(int id, String name, String courses, int age) {
		super();
		this.id = id;
		this.name = name;
		this.courses = courses;
		this.age = age;
	}
	public String toString() {
		return id+"  "+name+"  "+courses+"  "+age+"   "+college;
	}
}
