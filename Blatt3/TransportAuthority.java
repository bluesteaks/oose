
public class TransportAuthority {
	private static int numCars=0;
	private static String[] licensePlateList = new String[3000];
	private static String[] ownerList = new String[3000];
	private static String[] addressList = new String[3000];
	private static int[] carToAuth = new int[3000];
	
	private static int[] numDelicts = new int[3000];
	private static double[][] feesList = new double[3000][500];
	private static int[][] pointsList = new int[3000][500];
	
	public static int getAuthority(String licensePlate){
		for(int i=0;i<numCars;i++)
			if(licensePlateList[i].equals(licensePlate))
				return carToAuth[i];

		return -1;
	}

	public static void registerCar(int authority, String licensePlate, String owner, String address) {
		licensePlateList[numCars]=licensePlate;
		ownerList[numCars]=owner;
		addressList[numCars]=address;
		carToAuth[numCars]=authority;
		numCars++;
		}
	
	public static String getOwner(String licensePlate){
		for(int i=0;i<numCars;i++)
			if(licensePlateList[i].equals(licensePlate))
				return ownerList[i];
		
		return "N/A";						
	}
	
	public static String getAddress(String licensePlate){
		for(int i=0;i<numCars;i++)
			if(licensePlateList[i].equals(licensePlate))
				return addressList[i];
		
		return "N/A";						
	}
	
	public static void registerDelict(String licensePlate, double fee, int points){
		for(int i=0;i<numCars;i++)
			if(licensePlateList[i].equals(licensePlate)){
				feesList[i][numDelicts[i]]=fee;
				pointsList[i][numDelicts[i]]=points;
				numDelicts[i]++;				
			}
	}
	
	public static double[] getFees(String licensePlate){
		double fees[]=new double[500];
		for(int i=0;i<numCars;i++)
			if(licensePlateList[i].equals(licensePlate))
				for(int j=0;j<numDelicts[i];j++)
					fees[j]=feesList[i][j];
		
		return fees;
	}
	
	public static int[] getPoints(String licensePlate){
		int points[]=new int[500];
		for(int i=0;i<numCars;i++)
			if(licensePlateList[i].equals(licensePlate))
				for(int j=0;j<numDelicts[i];j++)
					points[j]=pointsList[i][j];
		
		return points;	
	}
	
}
