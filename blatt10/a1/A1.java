public class A1 {
	public static void main(String args[]){
		Thread t= new Thread(new DateiBeobachter("test"));
		t.start();
	}
}

class DateiBeobachter implements Runnable{
	private java.io.File file;
	private long lastModified;

	public DateiBeobachter(String path){
		this.file= new java.io.File(path);
		this.lastModified=file.lastModified();
	}

	public DateiBeobachter(java.io.File file){
		this.file=file;
		this.lastModified=file.lastModified();
	}

	public void run(){
		while(true){
			try{Thread.sleep(500);} catch(Exception e){}
			System.out.println(file.getName());
			if(file.lastModified()!=lastModified){
				lastModified=file.lastModified();
				System.out.println("File "+file.getName()+" changed.");
			}
		}
	}
}