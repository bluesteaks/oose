public class A2{
	static void main(String args[]){
	}
}

class Angestellter {
	private String vorname;
	private String nachname;
	private int alter;
	private int gehalt;

	public void Angestellter(String vorname, String nachname, int alter, int gehalt){
		this.vorname=vorname;
		this.nachname=nachname;
		this.alter=alter;
		this.gehalt=gehalt;
	}

	public String getVorname(){
		return vorname;
	}

	public String getNachname(){
		return nachname;
	}

	public int getAlter(){
		return alter;
	}

	public int getGehalt(){
		return gehalt;
	}

	public void age(){
		alter++;
	}

	public void increaseGehalt(int value){
		gehalt+=value;
	}
}

class Praktikant extends Angestellter{
	public void Praktikant(String vorname, String nachname, int alter){
		super(vorname,nachname,alter,400);
	}

	private void increaseGehalt(int value){}
}