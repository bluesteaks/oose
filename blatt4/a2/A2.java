interface Food {
	String getMeal();
}

class Cauliflower implements Food {
	public String getMeal(){
		return "Blumenkohl an Gorgonzolasoße";
	}
}

class Spaghetti implements Food {
	public String getMeal(){
		return "Spaghetti Bolognese";
	}
}

class A2 {
	static public void main(String[] args){
		Food food;
		food = new Cauliflower();
		//prinzip: dynamic binding
		//dynamischer typ von food ist cauliflower -> cauliflower.getMeal() wird ausgeführt
		System.out.println(food.getMeal());
		food = new Spaghetti();
		//dynamischer typ von food ist spaghetti -> spaghetti.getMeal() wird ausgeführt
		System.out.println(food.getMeal());
	}
}