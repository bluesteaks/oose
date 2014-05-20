
public class Exponent {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Bitte Basis eingeben:");
		int a=Input.readInt();
		
		System.out.println("Bitte Exponenten eingeben:");
		int n=Input.readInt();
		
		System.out.println(a+"^"+n+"="+exponent(a,n));
		
	}
	
	public static int exponent (int a, int n){
		if(n==1)
			return a;
		else
			return a*exponent(a,n-1);
	}
}
