public class Singleton{
	private static Singleton singleton = null;

	private Singleton();

	public static Singleton getSingletonInstance(){
		if(singleton==null)
			singleton = new Singleton();
		return singleton;
	}
}