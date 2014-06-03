public class Schaf {
	private int dna;
	private String name;

	public Schaf(String name) {
		this.name = name;
		this.dna = 0 + (int)(Math.random() * ((100 - 0) + 1));
	}
	public String getName() {
	return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	/**
	* Erstellt eine identische Kopie des aktuellen Objekts
	**/
	public Schaf klone() {
		return this;
	}

	public Schaf klone_korrekt(){
		Schaf result = new Schaf(this.getName());
		result.dna=this.dna;

		return result;
	}

	public boolean equals(Object obj){
		if (obj instanceof Schaf){
			Schaf schaf2=(Schaf)obj;
			if(schaf2.name.equals(this.name) && schaf2.dna==this.dna)
				return true;
		}
		return false;
	}

	public static void main(String[] args){
		Schaf a=new Schaf("a");
		Schaf c=new Schaf("c");
		Schaf b=a.klone();

		b.setName("b");

		//Gibt "b" aus, denn a und b referenzieren selbes Objekt, also kein Klon nach Definition.
		System.out.println(a.getName());
		System.out.println(a.equals(c));
	}
}

//allgemein Klonbedingung:
/*
if(obj1!=obj2 && obj1.equals(obj2)) (referenzieren nicht das selbe Objekt, aber alle Instanzvariablen sind gleich)
	Klon
else
	nicht Klon
*/