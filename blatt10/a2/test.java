public class test {
	public static void main(String args[]){
		A a= new A();
		a.print();
		B b=new B(); 
		b.print();
	}
}

class A {
	public void print(){
		System.out.println("AAA");
}
}

class B extends A {
	public void print(){
		System.out.println("BBB");
}
}