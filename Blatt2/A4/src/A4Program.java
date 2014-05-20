
public class A4Program {

	public static void main(String[] args) {
		MeterMaid maid=new MeterMaid();
		
		TransportAuthority.registerCar("BN GG 1337","Typ","Musterstraße 123");
		
		maid.checkCar("BN GG 1337");
		maid.fine();
		maid.fine();
		maid.fine();
		maid.printTicket();
	}

}
