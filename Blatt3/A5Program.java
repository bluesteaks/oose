
public class A5Program {

	public static void main(String[] args) {
		MeterMaid maid=new MeterMaid();
		MeterMaid maid2=new MeterMaid();
		
		TransportAuthority.registerCar(1,"BN GG 1337","Typ","Musterstraße 123");
		TransportAuthority.registerCar(2,"BN GG 1338","Typ2","Musterstraße2 456");
		
		maid.checkCar(0,"BN GG 1337");
		maid.fine(0);
		maid.fine(0);
		maid.fine(0);
		maid.printTicket(0);

		maid2.checkCar(1,"BN GG 1338");
		maid2.fine(1);
		maid2.fine(1);
		maid2.fine(1);
		maid2.printTicket(1);
	}

}
