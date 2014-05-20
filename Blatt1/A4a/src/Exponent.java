
public class Exponent {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length == 2) {
			System.out.println(args[0] + "^" + args[1] + " = " +
			exponent(Integer.parseInt(args[0]),
			Integer.parseInt(args[1])));
			}
			else {
			System.out.println("Bitte mit java Exponent <a> <n> aufrufen");
			}
	}
	
	public static int exponent (int a, int n){
		if(n==1)
			return a;
		else
			return a*exponent(a,n-1);
	}
}
