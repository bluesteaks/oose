class V {
	int x = 11;
	int getX( ){
		System.out.println("V::getX aufgerufen; x="+x);
		return x;
	}
	
	void setX (int y ) {
		x = y;
		System.out.println("V::setX("+y+") aufgerufen");
	}
	
	void f(){
		System.out.println("V::f aufgerufen");
	}
	
	void g(){
		System.out.println("V::g aufgerufen");
	}
}
class W extends V {
	int x = 13;

	int getX( ){
		System.out.println("W::getX aufgerufen; x="+x);
		return x;
	}

	void setX (int y ) {
		x = y;
		System.out.println("W::setX("+y+") aufgerufen");
	}

	void f(){
		System.out.println("W::f aufgerufen");
	}

	void h(){
		System.out.println("W::h aufgerufen");
	}
}

public class Test {
	static public void main ( String[ ] args ) {
	V v=new W();
	W w=new W();
	v.setX(15);
	v.x=22;
	System.out.println((v).x);

	v.f();
	v.g();
	System.out.println();
	//compile error (v hat kein h)
	//v.h();
	w.f();
	w.g();
	w.h();
	v.getX();
	w.getX();
	System.out.println();
	System.out.println();

	//compile error
	//V r= new V(); r.h();

	//runtime error
	//V r = new V(); ((W) r).f();

	((W) v).f();
	((V) w).f();
	}
}