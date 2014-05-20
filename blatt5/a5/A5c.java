public class A5c {
	public static void main(String[] args){

		Car car1 = new Car("det 123","Manfred","testweg");

		TrafficOffice office=new TrafficOffice();
		office.registerCar(car1);

		TrafficWarden warden=new TrafficWarden(office);
		warden.checkCar("det 123");
		warden.fine();
		warden.fine();
		warden.fine();
		warden.printTicket();
	}
}