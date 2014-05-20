
public class MeterMaid {
	
	private String CarToCheck="N/A";
	
	public void checkCar(String licensePlate){
		CarToCheck=licensePlate;
	}
	
	public void fine(){
		double fee=10+(double) new java.util.Random().nextInt(9000)/100;
		int points=new java.util.Random().nextInt(3);
		TransportAuthority.registerDelict(CarToCheck,fee,points);
	}

	public void printTicket(){
		System.out.println("license plate: "+CarToCheck);
		System.out.println("owner: "+TransportAuthority.getOwner(CarToCheck));
		System.out.println("address: "+TransportAuthority.getAddress(CarToCheck));
		
		int[] points=TransportAuthority.getPoints(CarToCheck);
		double[] fees=TransportAuthority.getFees(CarToCheck);
		
		int i=0,sumpoints=0;
		double sumfees=0;
		while(fees[i]>0){
			System.out.println("delict "+(i+1)+": "+points[i]+" point(s)| "+fees[i]+"€");
			sumfees+=fees[i];
			sumpoints+=points[i];
			i++;
		}
		System.out.println("sum points: "+sumpoints+" | sum fees "+sumfees+"€");
			
	}
}
