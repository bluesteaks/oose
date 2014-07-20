import java.util.*;

public class Klasse {
	private String string;
	private List<String> stringList=new ArrayList<String>();

	public void setString(String string){
		this.string=string;
	}

	public String getString(){
		return this.string;
	}

	public void setStringList(List<String> stringList){
		this.stringList=stringList;
	}

	public List<String> getStringList(){
		return this.stringList;
	}

	public void add(String string){
		stringList.add(string);
	}

	public Klasse clone(){
		Klasse result=new Klasse();
		result.setString(this.string);

		List<String> resultStringList=new ArrayList<String>(stringList);
		result.setStringList(resultStringList);

		return result;
	}

	public boolean equals(Object obj){
		if(obj instanceof Klasse){
			Klasse kl=(Klasse) obj;

			if(kl.getString().equals(this.string) && kl.getStringList().equals(this.stringList))
				return true;
		}

		return false;
	}

	public static void main(String args[]){
		Klasse kl1=new Klasse();
		kl1.setString("LALALA");
		kl1.add("1");
		kl1.add("2");

		Klasse kl2=kl1.clone();

		System.out.println(kl2.equals(kl1));

		kl2.add("3");
		System.out.println(kl2.equals(kl1));
	}
}