package practice;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ImmutableDemo {
    public static void main(String[] args) throws InterruptedException {
//        ImmutablePoint p = new ImmutablePoint(0, 0);
//
//        // two threads read the same object concurrently
//        Thread reader1 = new Thread(() -> {
//            for (int i = 0; i < 5; i++) {
//            	
//                System.out.println("R1 sees: " + p.moveBy(1, 2));
//                sleep(100);
//            }
//        });
//
//        Thread reader2 = new Thread(() -> {
//            for (int i = 0; i < 5; i++) {
//            	
//                System.out.println("R2 sees: " + p.moveBy(3, 1));
//                sleep(100);
//            }
//        });
//
//        reader1.start();
//        reader2.start();
//        reader1.join();
//        reader2.join();
//    }
//
//    private static void sleep(long ms) {
//        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
//    }
    
    Function<String, Integer> f = str -> str.length();
    System.out.println(f.apply("vishwam"));
    
    Consumer<Integer> c = s -> System.out.println(s);
    c.accept(203);
    
    Supplier<Double> s = () -> Math.random();
    System.out.println(s.get());
    
    Predicate<Integer> p = in -> in %2==0;
    System.out.println(p.test(22));
    
    
    
    
    	
    }
}
