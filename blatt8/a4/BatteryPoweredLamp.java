class Bulb {}

interface Lamp {
	public void switchOn();
	public void switchOff();
	public void replaceBulb(Bulb bulb);
}

public class BatteryPoweredLamp implements Lamp{
	private double batteryEnergy;

	public double getBatteryEnergy(){
		return batteryEnergy;
	}

	public void setBatteryEnergy(double batteryEnergy){
		this.batteryEnergy=batteryEnergy;
	}
}