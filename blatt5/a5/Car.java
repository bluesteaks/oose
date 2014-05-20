public class Car {
	private String licensePlate;
	private String owner;
	private String address;

	private Delict[] delicts= new Delict[500];
	private int numDelicts;

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

	public void registerDelict(Delict delict){
		delicts[numDelicts++]=delict;
	}

	public Delict[] getDelicts(){
		return delicts;
	}
}
