public class Clothing extends Product{
	int size;
	String material;

	public Clothing(String name, String desc, double price, int size, String material){
		super(name,desc,price);
		this.size=size;
		this.material=material;
	}

	public String toString() {
		return super.toString()+" - size: "+size+" - material: "+material;
	}
}