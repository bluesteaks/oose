public class Delict{
	private double fee;
	private int points;

	public Delict(double f, int p){
		fee=f;
		points=p;
	}

	public int getPoints(){
		return points;
	}

	public double getFee(){
		return fee;
	}

	public String toString(){
		return "points: "+Integer.toString(points)+" fee: "+Double.toString(fee);
	}
}