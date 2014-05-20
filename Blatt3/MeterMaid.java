
public class MeterMaid {
	
	private String[] CarToCheck=new String[10];
	
	public void checkCar(int maid,String licensePlate){
		CarToCheck[maid]=licensePlate;
	}
	
	public void fine(int maid){
		double fee=10+(double) new java.util.Random().nextInt(9000)/100;
		int points=new java.util.Random().nextInt(3);
		TransportAuthority.registerDelict(CarToCheck[maid],fee,points);
	}

	public void printTicket(int maid){
		System.out.println("license plate: "+CarToCheck[maid]);
		System.out.println("owner: "+TransportAuthority.getOwner(CarToCheck[maid]));
		System.out.println("address: "+TransportAuthority.getAddress(CarToCheck[maid]));
		System.out.println("authority: "+TransportAuthority.getAuthority(CarToCheck[maid]));
		
		int[] points=TransportAuthority.getPoints(CarToCheck[maid]);
		double[] fees=TransportAuthority.getFees(CarToCheck[maid]);
		
		int i=0,sumpoints=0;
		double sumfees=0;
		while(fees[i]>0){
			System.out.println("delict "+(i+1)+": "+points[i]+" point(s)| "+fees[i]+"€");
			sumfees+=fees[i];
			sumpoints+=points[i];
			i++;
		}
		System.out.println("sum points: "+sumpoints+" | sum fees "+sumfees+"€");
		System.out.println("");
			
	}
}
