package B3IAM.Restexample;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.glassfish.connectors.admin.cli.internal.GetSystemRarsAllowingPoolCreation;

import stringReturn.StringMessage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

@Path("vinayak")
public class vinayak {

	static String message = "";

	@GET
	@Produces("text/plain")
	@Path("/training")
	public String wish() {
		return "hello vin,irf,arati";
	}

	@GET
	@Produces("text/plain")
	@Path("{username}")
	public String wish(@PathParam("username") String name) {
		return "hello: " + name + " welcome to rest";
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("add/{add1}/{add2}")
	public String wish1(@PathParam("add1") String name, @PathParam("add2") String name2) {
		try {
			float sum = Float.parseFloat(name) + Float.parseFloat(name2);
			return "sum is : " + sum;
		}

		catch (Exception e) {
			return "plz enter the numbers only";
		}

	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/read/{number1}/{filename1}")
	public String naser(@PathParam("number1") int number, @PathParam("filename1") String filename) {
		Scanner input = new Scanner(System.in);
		System.out.println("enter the number to create a file of table:");
		String values = "";
		try {

			FileWriter my = new FileWriter("D:\\infra\\" + "tab_" + number + ".txt");

			for (int i = 1; i <= 10; i++) {
				my.write(number + "*" + i + "=" + (number * i) + "," + "\n");

			}
			my.close();
			System.out.println("You're file is created: ");
			System.out.println("enter the filename to read: ");
			Scanner scfile = new Scanner(System.in);
			System.out.println("hi writing.....");

			FileInputStream fin = new FileInputStream("D:\\infra\\" + "tab_" + filename + ".txt");

			int i = 0;

			while ((i = fin.read()) != -1) {

				if (",".equals(i)) {
					System.out.println("are you going......");
					values = values + "<br>";
				} else
					values += (char) i;
			}
			fin.close();

		} catch (IOException e) {
			System.out.println(e);
		}

		return values;

	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/objects")
	public String show() {
		studs s1 = new studs();
		studs s2 = new studs();
		s1.id = 101;
		s1.age = 25;
		s1.courses = "java";
		s1.name = "vinayak";
		studs.college = "sit tumkurrrrrrr";

		s2.id = 102;
		s2.age = 26;
		s2.courses = "css";
		s2.name = "akash";

		return s1 + "<br>" + s2;

	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/salary")
	public String salary() {

		SalaryDisplay s1 = new SalaryDisplay();
		SalaryDisplay s2 = new SalaryDisplay();

		s1.name = "vinayak";
		s1.salary = 1000000;
		s1.id = 101;
		s1.annualSalary = (int) ((s1.salary) * 12);

		s2.name = "akash";
		s2.salary = 100;
		s2.id = 101;
		s2.annualSalary = (int) ((s2.salary) * 12);

		return s1 + "" + s2;

	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/array")
	public String getarray() {
		// int a[]=new int[5];
		String s = "";
		String a[] = { "vin", "akash", "bheem sir", "arati" };
		// a[2]=5;
		for (int i = 0; i < a.length; i++) {
			s += a[i] + "<br>";
		}
		return s;
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("students")
	public String getstudsArray() {
		String s = "";
		studs arr[] = new studs[4];
		int ids[] = { 1, 2, 3, 4 };
		String names[] = { "vin", "akash", "naseer", "arati" };
		String courses[] = { "sailpoint", "java", "python", "java" };
		int ages[] = { 25, 23, 24, 25 };
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new studs();
			arr[i].id = ids[i];
			arr[i].name = names[i];
			arr[i].courses = courses[i];
			arr[i].age = ages[i];
			s += arr[i].id + ", " + arr[i].name + ", " + arr[i].courses + ", " + arr[i].age + "<br>";
		}
		return s;

	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("salaryemp/{size}")
	public String getsalaryarray(@PathParam("size") int size) {

		String s = "<table border=2><tr><th>Id</th><th>Name</th><th>salary</th></tr>";
		SalaryDisplay sal[] = new SalaryDisplay[size];
		int ids[] = new int[size];
		String name[] = new String[size];
		double salary[] = new double[size];
		ids[0] = 10;
		name[0] = "vin";
		salary[0] = 10000;

		for (int i = 1; i < size; i++) {

			ids[i] = ids[i - 1] + 10;
		}
		for (int i = 1; i < size; i++) {

			name[i] = i + "vin";
		}
		for (int i = 1; i < size; i++) {

			salary[i] = salary[i - 1] + 10000;
		}

		for (int i = 0; i < sal.length; i++) {
			sal[i] = new SalaryDisplay(); // creating array objects out of declared class salarydisplay
			sal[i].id = ids[i];
			sal[i].name = name[i];
			sal[i].salary = salary[i];
			// s=s+"all" we are doing to capture all the objects inside this loop
			s += "<tr><td>" + sal[i].id + "</td><td>" + sal[i].name + "</td><td>" + sal[i].salary + "</tr>" + "<br>";

		}
		s += "</table>";
		return s;
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("amani/string/{str}")
	// method to demonstrate vowels and replace with its uppercase.

	public String amani(@PathParam("str") String s) {
		String res = s.substring(s.length() - 3, s.length()).toUpperCase();
		int count = 0;
		String m = "";
		int index_a = -1, index_e = -1, index_i = -1, index_o = -1, index_u = -1; // default values.

		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'
					|| s.charAt(i) == 'u') {

				m = m + (s.charAt(i) + "").toUpperCase();

				if (s.charAt(i) == 'a') {
					count++;
					index_a = s.indexOf(s.charAt(i));

				} else if (s.charAt(i) == 'e') {
					count++;
					index_e = s.indexOf(s.charAt(i));
				} else if (s.charAt(i) == 'i') {
					count++;
					index_i = s.indexOf(s.charAt(i));
				} else if (s.charAt(i) == 'o') {
					count++;
					index_o = s.indexOf(s.charAt(i));
				} else if (s.charAt(i) == 'u') {
					count++;
					index_u = s.indexOf(s.charAt(i));
				}

			} else {
				m = m + (s.charAt(i));

			}
		}
		return m + "<br>" + "---------------------------------" + "<br>" + "count of vowels: " + "<b>" + count
				+ "</b><br>" + "index_a: " + "<b>" + index_a + "</b>" + "<br>" + "index_e:" + "<b>" + index_e
				+ "</b><br>" + "index_i: " + "<b>" + index_i + "</b><br>" + "index_o: " + "<b>" + index_o + "</b><br>"
				+ "index_u: " + "<b>" + index_u + "</b><br>";
	}

	// 3 same method names for overloading (1.int, int) (2. float,float) (3.int,
	// float)

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("akash/addint/{y}/{x}")
	public String amani(@PathParam("y") int num1, @PathParam("x") int num2) {
		return "sum:" + (num1 + num2);

	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("floats/add/{float1}/{float2}")
	public String sum(@PathParam("float1") float x, @PathParam("float2") float y) {

		return "sum:  " + (x + y);

	}

	@GET // int and float overloading method
	@Produces(MediaType.TEXT_HTML)
	@Path("int/add/{int1}/{float1}")
	public String sum(@PathParam("int1") int val1, @PathParam("float1") float val2) {
		float sum = val1 + val2;
		return "sum of int & float: " + sum;

	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("arraylast/{input}") // give the array size and input seperated by commas.

	public String readlastcharOfArray(@PathParam("input") String input) {
		String splitarr[] = input.split(",");
		String s = "";
		s = "<table border=2><tr><th>String</th><th>Last character</th></tr>";

		for (int i = 0; i < splitarr.length; i++) {

			s += "<tr><td>last character of :" + splitarr[i] + " is :" + "</td>" + "<td>"
					+ splitarr[i].charAt(splitarr[i].length() - 1) + "</td></tr>" + "<br>";

		}

		s += "</table>";

		return s;
	}

	// to check private variable can e accessed by public methods

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("constructor/{pin}")
	public String constructorcall(@PathParam("pin") int value) {

		StringMessage sm = new StringMessage(value);

		return sm.msg();

	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("integer/{float}")
	public String intreturn(@PathParam("float") float value) {
		int i = (int) value; // casting done here
		return i + "";

	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("char/{c}")
	public String intreturn(@PathParam("c") String c) {
		int i = (int) c.charAt(0); // casting done here to print ascii value of character
		return i + " is ascii value of: " + c + "space";

	}

	// counting words and making 1st letter to capital
	@SuppressWarnings("null")
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("enterString/{sentence}")
	public String displaywords(@PathParam("sentence") String sentence) {
		String m = "";
		String s = "";
		String a = "";
		String combinedLetters = "";
		s = "<table border=1>";
		String arr[] = sentence.split(" ");
		int words = arr.length;

		int inc = 0;

		int count = 0;
		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr[i].length(); j++) {

				if (arr[i].charAt(j) == 'a' || arr[i].charAt(j) == 'e' || arr[i].charAt(j) == 'i'
						|| arr[i].charAt(j) == 'o' || arr[i].charAt(j) == 'u') {
					count++;
				}
			}

		}

		String add[] = new String[count];

		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr[i].length(); j++) {

				if (arr[i].charAt(j) == 'a' || arr[i].charAt(j) == 'e' || arr[i].charAt(j) == 'i'
						|| arr[i].charAt(j) == 'o' || arr[i].charAt(j) == 'u') {

					System.out.println("inside: array index " + i + " " + arr[i].charAt(j) + " j is " + j);

					add[inc] = arr[i].charAt(j) + "";
					inc++;
				}
			}

		}

		for (String ad : add)
			a += ad + " ";

		for (int i = 0; i < arr.length; i++) { // first character of each string to upperchar

			m += "<b>" + (arr[i].charAt(0) + "").toUpperCase() + "</b>";
			m += arr[i].substring(1, arr[i].length()) + " ";
		}
		// combining last letters of word and vowels into array
		for (int i = 0; i < arr.length; i++) {
			combinedLetters += arr[i].substring((arr[i].length() - 1), arr[i].length());

		}

		s += "<tr><td>count of words = " + words
				+ "</td><td>making first letter of words to caps</td></tr><tr><td>String entered is  :" + sentence
				+ "</td><td> After changing is :" + m + "</td></tr>" + "<br> after combining last letter of words: "
				+ "<b>" + combinedLetters + "</b>" + "<br>array filled with vowel: " + a;
		s += "</table>";
		return s;

	}

	@GET
	@Produces(MediaType.APPLICATION_XML) // Sending data object to webserver by using xmlrootelemnt on subclass +
											// @XmlAccessorType(XmlAccessType.FIELD)
	@Path("inhert")
	public currstuds inhert() {

		currstuds curr = new currstuds();
		curr.id = 101;
		curr.age = 26;
		curr.stipend = 10000;
		curr.trainer = "bheem sir";

		return curr;

	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("overriding")
	public String overridinggetsalary() {
		child ch = new child();
		return ch.getallsalary();
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("boxing/{x}")
	public String checkboxing(@PathParam("x") int x) {

		Integer xob = new Integer(x); // converting to obj of wrapper class from primitive x
		return Integer.toHexString(x);

	}

	// method to display value methods of wrapper classes
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("reverseboxing/{x}")
	public String checkbox(@PathParam("x") String m) {
		int x = Integer.parseInt(m);
		return Integer.valueOf(m) + 26 + " " + m; // int changed to Integer type object.

	}

	// varags values sending and performing operation
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("varagrs/{x}")
	public String operationValues(@PathParam("x") String x) {
		String ar[] = x.split(",");
		varargs va = new varargs();

		return "sum: " + va.add("add", ar) + "<br>" + va.avg("avg", ar);

	}

	// checking instance of variable
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("checktype")
	public String checktype(@PathParam("x") String x) {
		InstanceOf<Integer> io = new InstanceOf<Integer>();
		InstanceOf<String> st = new InstanceOf<String>();
		io.x = 0;
		st.x = "";
		return io.getType();
	}

	@GET
	@Path("t_array")
	@Produces(MediaType.TEXT_HTML)
	public String getArrayValues() {
		InstanceOf<Float> inst = new InstanceOf<Float>();
		inst.createArray(56.8f, 69.9f, 58.4f, 36.3f);
		String s = "";
		for (Float i : inst.readArray())
			s += i + ",";
		return s;

	}

	@GET
	@Path("abstract/{val}")
	@Produces(MediaType.TEXT_HTML)
	public String getShape(@PathParam("val") float x) {

		childShape circle = new childShape();
		{
			circle.i = 5;
		}
		;
		childShape triangle = new childShape();
		return "circle area is: " + 3.14 * circle.area(x) + "<br>" + circle.i + "<br>triangle area is : " + x * x * x
				+ "<br>" + "drawn circle by: " + circle.drawnBy("naser") + "<br>drawn traingle by: "
				+ triangle.drawnBy("vinnu");

	}

	// implementation of functional interface.using the numberType (num,multi)
	// implementation of interface number
	@GET
	@Path("function/{x}/{y}")
	@Produces(MediaType.TEXT_HTML)
	public String getFunctionalInterface(@PathParam("x") float x, @PathParam("y") float y) {

		Number num = (val1, val2) -> { // -> is called lambda expression.
			return x + y;
		};

		Number multi = (val3, val4) -> {
			return x * y;
		};
		return "addition: " + num.operation(x, y) + "<br>" + " multiplication: " + multi.operation(x, y);

	}

	@GET
	@Path("alphabets/{str}")
	@Produces(MediaType.TEXT_HTML)

	public String vowelconsonantsPositions(@PathParam("str") String x) {
		String sent[] = x.split(",");
		String vowels[] = { "a", "e", "i", "o", "u" };
		String consonants[] = { "b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v",
				"w", "x", "y", "z" };
		String s = "";
		indexString is = new indexString();
		for (String val : sent) {

			for (String conso : consonants) {
				if (val == conso) {
					s += "c" + "" + is.findIndex(consonants, val);

				}
			}
			for (String vowel : vowels) {

				if (val == vowel) {

					s += "v" + "" + is.findIndex(vowels, val);

				}
			}
		}

		return s;
	}

	@GET
	@Path("Signal/{str}")
	@Produces(MediaType.TEXT_HTML)
	// enum explained with associated signal code
	public String getSignal(@PathParam("str") String color) {

		String text = "";
		String result = "";
		try {
			Signal signal = Signal.valueOf(color.toUpperCase());
			switch (signal) {
			case RED:
				text = "<font color='red' size=10px>";
				break;
			case GREEN:
				text = "<font color='green' size=10px>";
				break;
			case YELLOW:
				text = "<font color='YELLOW' size=10px>";
				break;
			default:
				text = "<font color='green' size=10px>";
			}
			result = text + signal.toString() + ":" + signal.signal + " :" + signal.code + "</font>";
			return result;
		}

		catch (Exception e) {
			result = "<font color='" + color + "' size=10px>The given signal color is not valid</font>";
			return result;
		}

	}

	@GET
	@Path("Season/{str}")
	@Produces(MediaType.TEXT_HTML)
	public String getSeason(@PathParam("str") String Season) {
		String text = "";
		String result = "";
		try {
			Seasons season = Seasons.valueOf(Season.toUpperCase()); // enumname.valueof(enums) into an object

			switch (season) {
			case SUMMER:
				text = "<font color='orange' size=10px>";
				break;
			case WINTER:
				text = "<font color='blue' size=10px>";
				break;
			case AUTUMN:
				text = "<font color='yellow' size=10px>";
				break;
			}
			result = text + season.toString() + ":" + season.situation + " is " + season.temp + "</font>";
			return result;
		} catch (Exception e) {
			return text + "<font color='red' size=10px>" + "invalid input of season" + "</font>";

		}

	}

	@GET
	@Path("inputstreams/{str1}/{str2}")
	@Produces(MediaType.TEXT_HTML)

	public String getAddition(@PathParam("str1") int str1, @PathParam("str2") int str2) {
		String s = "";

		try {
			FileWriter my = new FileWriter("D:\\infra\\test.txt");
			int out = str1 + str2;
			my.write("inputs ->" + str1 + "," + str2 + "\n" + "output ->" + out); // inserting values with addition
			my.close();

			FileInputStream fin = new FileInputStream("D:\\infra\\test.txt"); // inputstream is to read the inputdata
			FileOutputStream fos = new FileOutputStream("D:\\iam_basics\\trail.txt"); // outputing into diff file

			int i = 0;
			while ((i = fin.read()) != -1) { // i holds the characters from file

				if (i == '\n') { // 13 is ascii value of "enter"
					s += "<br>";
					fos.write((char) i);
				}

				else {
					s += (char) i; // appending to s
					fos.write((char) i);
				}
			}

			return s;
		}

		catch (Exception e) {
			return "no file is present";
		}

	}

	@GET
	@Path("CricketEnum/{str}")
	@Produces(MediaType.TEXT_HTML)
	public String getCricketEnum(@PathParam("str") String str) {

		try {

			String runs = "";
			int output;
			Cricket cri = Cricket.valueOf(str.toUpperCase()); // enumname.valueof(enums) into an object

			switch (cri) {
			case NOBALL:
				runs += cri.immediateEffect + 6;
				break;
			case WICKET:
				runs += cri.immediateEffect + 0;
				break;
			case WIDE:
				runs += cri.immediateEffect + 4;
				break;
			case LEGBYES:
				runs += cri.immediateEffect + 4;
				break;
			case GOOD:
				runs += cri.immediateEffect + 6;
				break;
			case OVER20MATCH:
				runs += cri.immediateEffect;
				break;
			case OVER50MATCH:
				runs += cri.immediateEffect;
				break;
			}
			return "<u>" + runs + "</u>" + " can be scored by a " + cri.toString() + " ball." + "<br>"
					+ "credit of ball to batsman = " + cri.immediateEffect + "<br>" + " ----" + cri.Result;
		}

		catch (Exception e) {
			return e.getMessage();
		}
	}

	@GET
	@Path("list3")
	@Produces(MediaType.TEXT_HTML)
	public String getCommonElements(@PathParam("str") String str) {

		int k = 0;
		int n = 0;
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

		for (int i = 0; i < list2.size(); i++) { // checking the contents froms 2nd list
			int j = 0;
			if (list1.contains(list2.get(i)))
				list3.add(j++, list2.get(i));
		}

		for (Integer a : list3)
			s += a + " ";
		return s;
	}

	@GET
	@Path("Sortchar/{str}")
	@Produces(MediaType.TEXT_HTML)
	public String SortArray(@PathParam("str") String str) {
		String s = str;
		String r = "";
		char arr[] = s.toCharArray();

		Arrays.sort(arr);
		List<Character> list = new ArrayList<>();
		for (char result : arr)
			list.add(result);

		for (char result : arr)

			r = r + result + " ";
		return "after sorting = " + r;

	}

	@GET
	@Path("duplicates/{str}")
	@Produces(MediaType.TEXT_HTML)
	public String removeDuplicates(@PathParam("str") String str) {
		String r = "";
		String s1[] = str.split(",");
		// input list with duplicates
		List<String> list = new ArrayList<>(Arrays.asList(s1));
		// Print the Arraylist
		System.out.println("ArrayList with duplicates: " + list);

		// Construct a new list from the set constucted from elements
		// of the original list
		List<String> newList = list.stream().distinct().collect(Collectors.toList());

		for (String m : newList)
			r += m + " ";
		return "duplicates removed = " + r;
	}

	@GET
	@Path("items/list")
	@Produces(MediaType.APPLICATION_XML)
	public List<Item> getItems() {
		Item i1 = new Item(10, "biryani", 250);
		Item i2 = new Item(11, "roti", 25);
		Item i3 = new Item(12, "curry", 150);
		List<Item> items = new ArrayList<>();
		items.add(i1);
		items.add(i2);
		items.add(i3);
		Collections.sort(items);
		return items;
	}

	@GET
	@Path("sort/emp")
	@Produces(MediaType.APPLICATION_XML)

	public List<Emps> listofStuds() {
		int id[] = { 101, 102, 103, 104 };
		String names[] = { "vinnu", "akash", "abhishek", "amani" };
		double sal[] = { 70000, 10000, 5000, 2000 };
		double bonus[] = new double[sal.length];

		for (int i = 0; i < bonus.length; i++) {

			if (sal[i] > 25000)
				bonus[i] = 10 * sal[i] / 100;
			if (sal[i] > 10000 && sal[i] <= 25000)
				bonus[i] = 15 * sal[i] / 100;
			if (sal[i] <= 10000)
				bonus[i] = 20 * sal[i] / 100;

		}

		List<Emps> list = new ArrayList<Emps>();

		for (int i = 0; i < sal.length; i++) {
			Emps e = new Emps(id[i], names[i], sal[i], bonus[i]);
			list.add(e);
		}
		Collections.sort(list);
		return list;
	}

	@GET
	@Path("map")
	@Produces(MediaType.TEXT_HTML)

	public String getMap() {
		Map<Integer, String> map = new HashMap<>();
		String names[] = { "vinnu", "akash", "irfan" };
		for (int i = 101; i <= 100 + names.length; i++)
			map.put(i, names[i - 101]);
		String s = "";
		for (Map.Entry<Integer, String> take : map.entrySet())
			s += take.getKey() + " :  " + take.getValue() + "<br>";
		return s;
	}

	@GET
	@Path("map/list")
	@Produces(MediaType.TEXT_HTML)

	public String getMarks() {
		Map<Integer, List<Integer>> map = new HashMap<>();
		List<Integer> marks1 = Arrays.asList(56, 66, 78, 89, 98);
		List<Integer> marks2 = Arrays.asList(45, 65, 87, 39, 90);
		map.put(101, marks1);
		map.put(102, marks2);
		String s = "";
		int i = 0;
		for (Map.Entry<Integer, List<Integer>> take : map.entrySet()) {
			s += take.getKey() + " :  " + take.getValue() + "<br>";

		}
		return s;
	}

	@GET
	@Path("map/ofMap")
	@Produces(MediaType.TEXT_HTML)
	public String family() {
		Map<String, Map<String, Object>> map = new LinkedHashMap<>();
		Map<String, Object> head = new LinkedHashMap<>();
		Map<String, Object> mem1 = new LinkedHashMap<>();
		Map<String, Object> mem2 = new LinkedHashMap<>();

		head.put("papa", "Tall");
		head.put("age", 55);
		head.put("likes", "me");

		mem1.put("sister", "short");
		mem1.put("age", "22");
		mem1.put("likes", "all");

		mem2.put("me", "normalHeight");
		mem2.put("Likes", "Noone");
		mem2.put("interest", "java");

		map.put("head", head);
		map.put("sister", mem1);
		map.put("me", mem2);

		String s = "";

		for (Entry<String, Map<String, Object>> take : map.entrySet()) {
			s += take.getKey() + " :  " + take.getValue() + "<br>";
		}
		return s;
	}

	@GET
	@Path("mapMarks")
	@Produces(MediaType.TEXT_HTML)
	public String marksMap() {
		int total = 0;
		int total2 = 0;
		String s = "";

		Map<String, Map<String, Integer>> map = new HashMap<>();
		Map<String, Integer> sub = new HashMap<>();

		List<Integer> social = Arrays.asList(56, 66, 78, 89, 98);
		List<Integer> maths = Arrays.asList(45, 76, 22, 67, 90);

		List<Integer> percent = new ArrayList<>();

		for (Integer a : social) {
			total += a;
		}
		for (Integer a : maths) {
			total2 += a;
		}
		int percent1 = total * 100 / 500;
		int percent2 = total2 * 100 / 500;
		Integer p1 = new Integer(percent1);
		Integer p2 = new Integer(percent2);

		sub.put("social", p1);
		sub.put("maths", p2);
		map.put("vinayak", sub);

		for (Entry<String, Map<String, Integer>> take : map.entrySet()) {
			s += take.getKey() + " :  " + take.getValue() + "<br>" + percent1;
		}
		return s;

	}

	@GET
	@Path("connect_db")
	@Produces(MediaType.TEXT_HTML)
	public String connectToDatabase() {
		try {
			Connection c = serviceRest.connect();			
			
			return "connected  :" + c;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
	
	

	@GET
	@Produces(MediaType.TEXT_HTML)			//converting file data into list then displaying
	@Path("listFilename/{name}")
	public String fileIntoList(@PathParam("name") int name) throws FileNotFoundException {
		

		int i = 0;
		String value = "";
		String s = "";
		int count = 0;

		List<String> l = new ArrayList<>();

		try {
			FileInputStream fin = new FileInputStream("D:\\infra\\" + "tab_" + name + ".txt");
			while ((i = fin.read()) != -1) {

				if (i=='\n') {   								//"\n".equals(i) didnt worked here
					l.add(value);
					count++;
					value = "";
					
				} else {
					value = value + (char) i;
				}

			}
			fin.close();

			for (String a : l) {
				s += a + "<br>";
				System.out.println(a+" ");
			}

		}

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;

	}
	@GET
	@Path("insert/{id},{name},{sal},{dep},{mgr}")
	@Produces(MediaType.TEXT_HTML)
	public String insert(@PathParam("id")int id,@PathParam("name")String name,@PathParam("sal")int sal,@PathParam("dep")int dep,@PathParam("mgr")int mgr) throws SQLException {
		serviceRest db=new serviceRest();
		
		Connection con =serviceRest.connect();
		Statement st = con.createStatement();
		if(con==null)
			return "not connected";
		else {
		
			db.insert(id, name, sal, dep, mgr);
			return "data saved";
		}
		/**/
	}
	
	@GET
	@Path("create/{id},{name},{courses},{age}")
	@Produces(MediaType.TEXT_HTML)
	public String createTable(@PathParam("id") int id,@PathParam("name") String name,@PathParam("courses") String courses,@PathParam("age") int age ) throws SQLException {
		
		serviceRest db=new serviceRest();
		Connection con =serviceRest.connect();
		Statement st = con.createStatement();
		if(con==null)
			return "not connected";
		else {
		
			db.createtbStudents(id, name, courses, age);
			return "data saved";
		}
		
	}
	
	@GET
	@Path("personBday")
	@Produces(MediaType.TEXT_HTML)
	public String wishPerson(@Context HttpServletRequest req) {
		String name= req.getParameter("uname");
		String value[]= req.getParameterValues("age");
		String s="";
		
		if(value==null)
			return null;
		
		
		int s1=Integer.parseInt(value[0]);   //only one value at index 0 after selection radio button.
		
			
		switch(s1) {
		case 30:
		s+= "Happy b day  "+"<b>"+name+ "<br>you are celebrating your "+"0-30"+" birthday";
		break;
		case 60:
		s+= "Happy b day  "+"<b>"+name+ "<br>you are celebrating your "+"31-60"+" birthday";
		break;
		case 100:			
		s+= "Happy b day  "+"<b>"+name+ "<br>you are celebrating your "+"61-100"+" birthday";
		break;
		}
		
		return s;
	}
	
	@GET
	@Path("website/open")
	@Produces(MediaType.TEXT_HTML)
	public void websiteOpening(@Context HttpServletRequest req,@Context HttpServletResponse rep) throws IOException {
		
		String value= req.getParameter("web");  //picking by common name 'web'
		
		switch(value) {
		
		case "identity and access":
			 rep.sendRedirect("https://www.identityandaccesssolutions.com/");
		break;
		
		case "facebook":
			rep.sendRedirect("https://www.facebook.com/");
		break;
		
		case "google":			
			rep.sendRedirect("https://www.google.com");
		break;
		
		}	
		
	}
	
	@GET
	@Path("token/{enter}/{delimiter}")   //delimiter allows you to split based on individual characters. eg @. 
	@Produces(MediaType.TEXT_HTML)		//whereever @ character and . is present in string it splits.
	
	public String tokeniser(@PathParam("enter") String enter,@PathParam("delimiter")String delimiter) {
		String s="";
		StringTokenizer tock = new StringTokenizer(enter, delimiter);	
		
		while(tock.hasMoreTokens()) {
			s+=tock.nextToken()+"<br>";
		}
		
		return s;
		
		
	}
	
	@GET
	@Path("outer") 
	@Produces(MediaType.TEXT_HTML)
	
	public String outerclass() {
		Outer out = new Outer();
		Outer.Inner in = out.new Inner();
		Outer.Inner1 in1= new Outer.Inner1();
		return in.i1+"---------"+in1.i2;
		
		
	}
	
	@GET
	@Path("time") 
	@Produces(MediaType.TEXT_HTML)
	public String getDate() {
		Calendar cal = Calendar.getInstance();  //factory method is that method when called provides object
		cal.set(2022,10,30,1,10);
		return cal.getTime().toString()+"<br>"+
				"Day: "+cal.get(cal.DAY_OF_WEEK)+"<br>"
				+"Month_Day: "+cal.get(cal.DAY_OF_MONTH)+"<br>"
				+"Year: "+ cal.get(cal.YEAR)+"<br>"
				+"AM/PM: "+ cal.get(cal.AM_PM);
		}

}