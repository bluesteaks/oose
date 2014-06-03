import java.util.*;

public class ThreadTest {
	public static void main(String args[]){
		Thread t1 = new Thread(new DateCommand());
		t1.start();
		Thread t2 = new Thread(new CounterCommand());
		t2.start();
	}
}

class DateCommand implements Runnable{
	public void run(){
		for(int i=0;i<10;i++){
			try{
			Thread.sleep(new java.util.Random().nextInt(1000));
			} catch(InterruptedException e){}
			System.out.println(new Date());
		}

	}
}

class CounterCommand implements Runnable{
	public void run(){
		for(int i=0;i<10;i++){
			try{
			Thread.sleep(new java.util.Random().nextInt(1000));
			} catch(InterruptedException e){}
			System.out.println(i);
		}

	}
}