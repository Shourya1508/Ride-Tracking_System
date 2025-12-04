package practice;

import java.util.Scanner;

public class swapping {

	public int nFactorial(int n) {
		
		if(n == 1 || n == 0) {
			return 1;
		}
		return n*nFactorial(n-1);
		
	}
	
	public static void main(String args[]) {
	Scanner sc =new Scanner(System.in);
	
//	int a = sc.nextInt();
//	int b = sc.nextInt();
//	System.out.println("Before swapping a: "+a+" , b: "+b);
//	
//	a = a+b;
//	b = a-b;
//	a = a-b;
//	System.out.println("after swapping a: "+a+" , b: "+b);
	
//	String s = sc.nextLine();
//	System.out.println("original String:- "+s);
//	String rev="";
//	StringBuilder sb = new StringBuilder(s);
//	System.out.println("Reversed String:- "+sb.reverse());
	
	
//reverse string without reverse() method
//	for(int i =s.length()-1;i>=0;i--) {
//	
//		rev+=s.charAt(i);
//		
//	}
//	System.out.println("Reversed String:- "+rev);
//	
//	}
	
	// palindrome
//	int i =0,end=s.length()-1;
//	while(i<end) {
//		
//   if(s.charAt(i)==s.charAt(end)) {
//	   i++;
//   end--;
//   continue;}
//   else {
//	   System.out.println("Not palindrome");
//       break;
//   }	
//	}
//	if(i==end)
//	System.out.println(s+" is palindrome string");
//	
	
	swapping sw = new swapping();
	int n = sc.nextInt();
	System.out.println("Factorial of "+n+" is:- "+sw.nFactorial(n));
	
	}
	
}
