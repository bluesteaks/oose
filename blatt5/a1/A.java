public class A {
	double wert1,wert2;
	public void set_wert_1(double wert1) {
		wert1=wert1;
	}

	public void set_wert_2(double wert2) {
		this.wert2=wert2;
	}

	public double get_wert_1(){
		return wert1;
	}

	public double get_wert_2(){
		return wert2;
	}

	public static void main(String[]args){
		A a = new A();
		a.wert2=1.0; //setzt a.wert2 auf 1.0
		a.set_wert_1(5.0);//macht nichts, denn wert1=wert1 weisst dem _parameter_ wert1 den wert wert1 zu, nicht dem classmember wert1.
		a.set_wert_2(5.0);//setzt a.wert2 auf 5.0
		double wert1=a.get_wert_1();
		double wert2=a.get_wert_2();
		System.out.println(wert1);
		System.out.println(wert2);
	}
}