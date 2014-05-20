public class TrafficWarden {
	private TrafficOffice office;
	private Car carToCheck;

	public TrafficWarden(TrafficOffice office) {
		this.office = office;
	}

	public void checkCar(String licensePlate){
		carToCheck=office.getCar(licensePlate);
	}

	public void fine(){
		double fee=(double)(1000 + (int)(Math.random() * ((10000 - 1000) + 1)))/100;
		int points=new java.util.Random().nextInt(3);

		carToCheck.registerDelict(new Delict(fee,points));
	}

	public void printTicket(){
		System.out.println("Ticket:");
		System.out.println("license plate: "+carToCheck.getLicensePlate());
		System.out.println("owner: "+carToCheck.getowner());
		System.out.println("address: "+carToCheck.getaddress());
		System.out.println("delicts:");

		Delict[] delicts=carToCheck.getDelicts();

		int i=0;
		while(delicts[i] != null){
			System.out.println(delicts[i++].toString());
		}
	}

}