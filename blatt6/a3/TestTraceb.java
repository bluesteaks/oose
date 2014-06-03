class CallEg {
	public void methodA() throws ArithmeticException {methodB();}
	public void methodB() throws ArithmeticException {methodC();}
	public void methodC() throws ArithmeticException {double a=1/0;  }
}


//Reihenfolge: TestTrace.main -> methodA -> methodB->methodC ->ExcDivByZero
//=>Stack: andersherum (letzt ausgeführte oben im Stack)

public class TestTraceb {
	public static void main(String[] args) {
		CallEg eg = new CallEg(); // use default constructor
		try {
			eg.methodA();
		} catch (ArithmeticException oops) {
			oops.printStackTrace();
		}
	}
}