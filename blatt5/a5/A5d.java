public class A5d {
	public static void main(String[] args){

		Car car1 = new Car("auto1","Manfred","testweg");
		Car car2 = new Car("auto2","Detlef","anderer Weg");

		TrafficOffice office1=new TrafficOffice();
		office1.registerCar(car1);

		TrafficOffice office2=new TrafficOffice();
		office2.registerCar(car2);

		TrafficWarden warden1=new TrafficWarden(office1);
		warden1.checkCar("auto1");
		warden1.fine();
		warden1.printTicket();
	
		TrafficWarden warden2=new TrafficWarden(office2);
		warden2.checkCar("auto2");
		warden2.fine();
		warden2.printTicket();
	}
}