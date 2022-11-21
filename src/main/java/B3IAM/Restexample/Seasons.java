package B3IAM.Restexample;

public enum Seasons {
	SUMMER("HEAT",45),WINTER("COLD",5),AUTUMN("WARM",12);
	String situation;
	int temp;
	
	
	Seasons(String str, int val){
		this.situation=str;
		this.temp=val;
	}
}
