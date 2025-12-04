package practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsPractice {
	
	
	
	public static void main(String args[]) {
	
		List<Integer> list = Arrays.asList(1,2,4,8,7,9,11,13,14,18,22);
		
	 list.stream().filter(n-> n%2==0).forEach(System.out::println);
	int ans =  list.stream().max(Integer::compare).get();
	int min =  list.stream().min(Integer::compare).get();
	System.out.println(ans+" -max, min - :"+min);
	List<String> str = list.stream().map(String::valueOf).collect(Collectors.toList()); 
	System.out.println(str);
		
	}

}
