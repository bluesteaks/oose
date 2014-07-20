class testthread implements Runnable{
	public void run(){
		for(int i=0;i<20;i++)
			System.out.println("Hi");
	}
}

public class test{
	public static void main(String[] args){
		Thread t=new Thread(new testthread());
		t.start();
		try{t.join();}catch(InterruptedException ex){}
	}

}