
public class Lottoproblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Berechnung für k!, (n choose k) und k!(n choose k).\n Bitte n eingeben:");
		int n=Input.readInt();
		System.out.println("Bitte k eingeben:");
		int k=Input.readInt();
		
		long kfac=fakultaet(k);
		long binkoeff=binomialkoeffizient(n,k);
		
		System.out.println("k!="+kfac);
		System.out.println("(n choose k)="+binkoeff);
		System.out.println("k!(n choose k)="+(kfac*binkoeff));
	}
	
	public static long fakultaet(long n){
		if (n>=1)
			return n*fakultaet(n-1);
		return 1;
	}
	
	public static long binomialkoeffizient(long n, long k){
		if(n<k)
			return 0;
		else {
			return fakultaet(n)/(fakultaet(k)*fakultaet(n-k));
		}
		
	}

}
