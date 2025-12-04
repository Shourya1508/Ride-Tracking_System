package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class employee implements Comparable<employee>{
	
	private int id;
	private String name;
	
	public employee(String name,int id) {
		this.name=name;
		this.id=id;
	}
	
	public String getName() {return name;}
	public int getId() {return id;}
	
	public String toString() {
		return name + " - "+id;
	}
	public int compareTo(employee other) {
		return Integer.compare(this.id, other.getId());
	}
}

public class CustomComparator implements Comparator<employee> {
	

	
	public int compare(employee e1,employee e2) {
		
		return Integer.compare(e2.getId(), e1.getId());
	}
	
	public static void main(String args[]) {
		
		List<employee> list = new ArrayList<>(Arrays.asList(
			    new employee("vishwam",1),
			    new employee("adi",3),
			    new employee("raj",-3),
			    new employee("green",-1),
			    new employee("risabh",2)
			));
		
		Collections.sort(list);
//		list.sort(new CustomComparator());/
		System.out.println(list);
		System.out.println("sort by name");
		list.sort(Comparator.comparing(employee::getName));
		System.out.println(list);
	}

}
