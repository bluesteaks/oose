public class A4 {
	public static void main(String[] args){
		Car car1 = new Car("det 123","Manfred","poopweg");
		System.out.println(car1.getLicensePlate());

		TrafficOffice tr=new TrafficOffice();
		tr.registerCar(car1);
		System.out.println(tr.getCar("det 123").getowner());

		tr.registerDelict(40,3,"det 123");

		Delict[] del=tr.getDelicts("det 123");
		for(int i=0;i<tr.getNumDelicts("det 123");i++)
			System.out.println(del[i].toString());
	}
}