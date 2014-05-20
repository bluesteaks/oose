public class TrafficOffice {
	private Car[] cars=new Car[1000];
	private int numcars;

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
}
