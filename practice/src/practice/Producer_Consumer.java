package practice;

import java.util.LinkedList;
import java.util.Queue;

class Buffer {
	
	private final Queue<Integer> queue = new LinkedList<Integer>(); 
	private final int size;
	
	public Buffer(int size) {
		this.size=size;
	}

	public synchronized void produce(int item) throws InterruptedException{
		
		while(queue.size()==size) {
			System.out.println("Full capacity, producer waiting");
			wait();
		}
		
		queue.add(item);
		System.out.println("Produced Item: "+item);
		notify();  // notify consumer
		
	}
	
	public synchronized int consume() throws InterruptedException{
		
		while(queue.isEmpty()) {
			System.out.println("Empty Buffer,consumer waiting");
			wait();
		}
		
		int item = queue.poll();
		System.out.println("Consumed Item: "+item);
		notify(); // notify producer
		return item;
	}
}


class Producer implements Runnable {
	
	private final Buffer buffer;
	
	public Producer(Buffer buff) {
		this.buffer = buff; 
	}
	
	public void run () {
		
		int i = 1;
		
		while(true) {
			
			try {
				buffer.produce(i++);
				Thread.sleep(500);;
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}

class Consumer implements Runnable {
	
	private final Buffer buffer;
	
	public Consumer(Buffer buff) {
		this.buffer = buff; 
	}
	
	public void run () {
		
		while(true) {
			
			try {
				buffer.consume();
				Thread.sleep(600);;
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}




public class Producer_Consumer {
	
	public static void main(String args[] ){
	
	Buffer buffer = new Buffer(6);
	
	Thread producerThread = new Thread(new Producer(buffer), "Producer");
	Thread consumerThread = new Thread(new Consumer(buffer), "Consumer");
	producerThread.start();
	consumerThread.start();
	}

}
