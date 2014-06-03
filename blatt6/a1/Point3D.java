public class Point3D extends Point{
	protected double z;

	public Point3D(double x, double y, double z){
		super(x,y);
		this.z=z;
	}

	public double distance(Point3D p1, Point3D p2){
		return Math.sqrt((p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y)+(p1.z-p2.z)*(p1.z-p2.z));
	}

	public String toString(){
		return super.toString()+" Z: "+this.z;
	}
}