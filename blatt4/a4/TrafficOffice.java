public class TrafficOffice {
	private Car[] cars=new Car[1000];
	private Delict[][] delicts= new Delict[1000][500];
	private int numcars;
	private int[] numdelicts=new int[1000];

	public void registerCar(Car car){
		cars[numcars]=car;
		numcars++;
	}

	public Car getCar(String licensePlate){
		for(int i=0;i<numcars;i++)
			if(cars[i].getLicensePlate().equals(licensePlate))
				return cars[i];

		return null;
	}

	public void registerDelict(double fee, int points, String licensePlate){
		int i;
		for(i=0;i<numcars;i++)
			if(cars[i].getLicensePlate().equals(licensePlate))
				break;

		delicts[i][numdelicts[i]]=new Delict(fee,points);
		numdelicts[i]++;
	}

	public Delict[] getDelicts(String licensePlate){
		int i;
		for(i=0;i<numcars;i++)
			if(cars[i].getLicensePlate().equals(licensePlate))
				break;

		return delicts[i];
	}

	public int getNumDelicts(String licensePlate){
		int i;
		for(i=0;i<numcars;i++)
			if(cars[i].getLicensePlate().equals(licensePlate))
				break;

		return numdelicts[i];
	}
}
