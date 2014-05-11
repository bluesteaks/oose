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

class Student {
	public void eat(Food food) {
		System.out.println("I like " + food.getMeal());
	}
	public void eat(Cauliflower Cauliflower) {
		System.out.println("I don’t like " + Cauliflower.getMeal());
	}
}

class A3 {
	static public void main(String[] args){
		Student student = new Student();

		//I don't like Blumenkohl...
		Cauliflower essen1 = new Cauliflower();
		student.eat(essen1);

		//I like Spaghetti...
		Spaghetti essen2 = new Spaghetti();
		student.eat(essen2);

		//I like Blumenkohl..., denn statischer typ von food ist essen -> spezifischte methode ist student.eat(Food food)
		Food essen = new Cauliflower();
		student.eat(essen);
	}
}