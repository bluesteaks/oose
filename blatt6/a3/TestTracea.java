class CallEg {
	public void methodA() throws ArithmeticException {double a=1/0; }
	public void methodB() throws ArithmeticException { }
	public void methodC() throws ArithmeticException { }
}


//Reihenfolge: TestTrace.main -> methodA -> ExcDivByZero
//=>Stack: andersherum (letzt ausgeführte oben im Stack)
public class TestTracea {
	public static void main(String[] args) {
		CallEg eg = new CallEg(); // use default constructor
		try {
			eg.methodA();
		} catch (ArithmeticException oops) {
			oops.printStackTrace();
		}
	}
}