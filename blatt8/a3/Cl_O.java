public class Cl_O {
	public static void main (String args[]){
		int a=2;
		int b=2;
		int c=a;
		int d;
		Cl_A f = new Cl_A();
		a= Cl_A.a[b];
		System.out.println(a); //Ausgabe 1
		System.out.println(c); //Ausgabe 2
		//System.out.println(f.mt_A(a)); //Ausgabe 3
		Cl_A.a[c+1]= 2;
		d=Cl_A.a[c-1];
		System.out.println(f.mt_A(d)); //Ausgabe 4
		System.out.println(f.mt_A(Cl_A.a[3])); //Ausgabe 5
	}
}