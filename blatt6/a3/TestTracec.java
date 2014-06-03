class CallEg {
	public void methodA() throws ArithmeticException {
		try{methodB();}
		catch (ArithmeticException oops) {
			oops.printStackTrace();
			throw oops;
		}
	}

	public void methodB() throws ArithmeticException {
		try{methodC();}
		catch (ArithmeticException oops) {
			oops.printStackTrace();
			throw oops;
		}
	}
	public void methodC() throws ArithmeticException {
		try{double a=1/0; }
		catch (ArithmeticException oops) {
			oops.printStackTrace();
			throw oops;
		}
	}
}


//Reihenfolge: TestTrace.main -> methodA -> methodB->methodC ->ExcDivByZero
//=>Stack: andersherum (letzt ausgeführte oben im Stack)
//Ausgabe ist die gleiche Ausgabe wie in b in 4facher Ausführung, da wir immer die selbe Exception weiterleiten und davon einen StackTrace ausgeben. Das ganze 4 mal.

public class TestTracec {
	public static void main(String[] args) {
		CallEg eg = new CallEg(); // use default constructor
		try {
			eg.methodA();
		} catch (ArithmeticException oops) {
			oops.printStackTrace();
		}
	}
}