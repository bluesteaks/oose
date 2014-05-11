public class Car {
	private String licensePlate;
	private String owner;
	private String address;

	public Car(String liPl, String ownr, String addr){
		licensePlate=liPl;
		owner=ownr;
		address=addr;
	}

	public String getLicensePlate(){
		return licensePlate;
	}

	public String getowner(){
		return owner;
	}

	public String getaddress(){
		return address;
	}
}
