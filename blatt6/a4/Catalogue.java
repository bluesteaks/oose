import java.util.HashSet;
import java.util.Iterator;

class Catalogue{
	private HashSet<Product> products = new HashSet<Product>();

	public void add(Product product){
		products.add(product);
	}

	public void printMe(){
		Iterator iter=products.iterator();
		while(iter.hasNext()){
			Product prod=(Product)iter.next();
			System.out.println(prod.toString()+" - price with tax: "+prod.getPriceWithTax());
		}
	}

	public static void main(String[] args){
		Catalogue cat=new Catalogue();
		Product paper=new Product("Papier","A4",2.52);
		Clothing shirt=new Clothing("Hemd","Herren-Hemd",33.61,48,"Baumwolle");

		cat.add(paper);
		cat.add(shirt);
		cat.printMe();
	}
}