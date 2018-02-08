import java.util.ArrayList;

//Simulates the flight path of an unguided projectile
//with no propulsion that is fired at a given velocity and angle
//It is assumed to be launched from a flat surface
//Air density and drag is modelled
//Wind effects and the curvature and spin of the earth is NOT modelled
//Currently "hard wired" for modelling K12
public class Cannon 
{
	private static ArrayList<Double> xi = null,yi = null;
	//Compute the maximum range using angle 'angle' and initial velocity 'muzzlevelocity' 
	//'angle' is in degrees and 'muzzlevelocity' is in metres per second
	//Returns maximum range as a Double in metres 
	public static Double GetMaxRange(Double angle,Double muzzlevelocity)
	{
		//Muzzle velocity must be between 1500 and 1650 metres per second
		//Angle must be between 25 and 55 degrees
		//return value is the horizontal range in metres
		//These figures are for K12
		Double t = angle;
		Double vzero = muzzlevelocity;
		if (t < 25) t = 25.0;
		if (t > 55) t = 55.0;
		if (vzero < 1500) vzero = 1500.0;
		if (vzero > 1650) vzero = 1650.0;
		int i;
		xi = new ArrayList<Double>();
		yi = new ArrayList<Double>();
		ArrayList<Double> vxi = new ArrayList<Double>();
		ArrayList<Double> vyi = new ArrayList<Double>();
		
		xi.add(new Double(0.0));
		yi.add(new Double(0.0));
		
		//Double vzero = new Double(1120.0); For Anzio Annie
		//'angle' no more than 50 degrees, not sure about minimum!
		Double theta = new Double((t/360.0)*2*Math.PI);
		Double dt = new Double(0.01);
		Double m = new Double(107.5);
		Double g = new Double(9.80665);
				
		vxi.add(new Double(vzero*Math.cos(theta)));
		vyi.add(new Double(vzero*Math.sin(theta)));
		
		i=0;
		while(yi.get(i) >= 0)
		{
			Double b2 = B2(yi.get(i));
			Double vi = Math.sqrt(Math.abs(vxi.get(i)*vxi.get(i))+Math.abs(vyi.get(i)*vyi.get(i)));
			xi.add(xi.get(i)+vxi.get(i)*dt);
			vxi.add(vxi.get(i) - ( b2*vi*vxi.get(i)/m)* dt);
			yi.add(yi.get(i)+vyi.get(i)*dt);
			vyi.add(vyi.get(i)-g*dt-(b2*vi*vyi.get(i)/m)*dt);
			++i;
		}	
		Double xmax = xi.get(xi.size()-1);
		return(xmax);
	}
	//Return last run x values 
	public static ArrayList<Double> GetX()
	{
		return(xi);
	}
	//Return last run y values
	public static ArrayList<Double> GetY()
	{
		return(yi);
	}
	//This is used by GetMaxRange
	//Drag for K12 projectile taking into account air density 
	public static Double B2(Double y)
	{
		Double b2 = new Double(0.0054);
		b2 = b2*AirDensity(y);
		return(b2);
	}
	//Compute air density
	//Returns a value between 0 and 1 (I think!!!)
	public static Double AirDensity(Double y)
	{
		Double d = new Double(0.0);
		if(y > 44000) return(d);
		Double L = new Double(0.0065);
		Double T0 = new Double(288.0);
		Double M = new Double(0.0289644);
		Double g = new Double(9.80665); //Gravity of the earth
		Double R = new Double(8.31447);
		
		d = Math.pow((1.0-L*y/T0),(g*M/(R*L)));
		return(d);
	}
}