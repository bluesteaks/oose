
public class Numbers {

	public static int digitsum(int n){		
		int sum=0;
		
		 while(n>0){
			sum+=n%10;
			n/=10;
		}
		
		return sum;
	}
	
	public static int binary(int n){
		int bn=0,i=0;
		
		 while(n>0){
			bn+=(n%2)*Math.pow(10, i);			
			n/=2;	
			i++;
		}
		
		return bn;
	}
	
	public static void main(String[] args) {
		int n=1+(int)(Math.random()*100);
		
		System.out.println("Zufallszahl: "+n);
		System.out.println("Quersumme: "+digitsum(n));
		System.out.println("Binärdarstellung: "+binary(n));
	}

}
