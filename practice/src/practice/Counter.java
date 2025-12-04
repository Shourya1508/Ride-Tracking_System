package practice;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
	
	private  int count =0;
	
	public  void increase() {
		count++;;
	}
	
	public int getcount() {
		return count;
	}

	public static void main(String args[]) {
		
		
		Counter c =  new Counter();
		Runnable r = () ->{
			String name = Thread.currentThread().getName();
			int i =1;
			while(i<=5) {
				 {
					 synchronized(c) {
				c.increase();
				System.out.println(name+" working ");
				System.out.println("count: "+c.getcount());
				i++;
			}
				 }
			}
		};
		
		
		Thread t1 = new Thread(r,"T1");
		Thread t2 = new Thread(r,"T2");
		t1.start();
		t2.start();
		
	}
	
}
