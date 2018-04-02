
public class CannonSolution 
{
	private double angle;
	private double velocity;
//	public double targetRange = 75000; //2% change
	public double targetRange = 95000; //1% change
//	public double targetRange = 65000; //3% change
	
	public CannonSolution(double a,double v)
	{
		angle = a;
		velocity = v;
	}

	public CannonSolution()
	{
		angle = RandomDouble(25, 55);
		velocity = RandomDouble(1500, 1650);
	}
	public double CannonFitness()
	{
		double fitness = Cannon.GetMaxRange(angle, velocity);
		return fitness;
	}
	
	public double CannonFitness2()
	{
	double range = Cannon.GetMaxRange(angle, velocity);
	double fitness = Math.abs(range - targetRange);
	return fitness;
	}
	public double RandomDouble(double lower, double upper)
	{
		double random = CS2004.UR(lower, upper);
		return random;
	}
	
	public void SmallChange()
	{
		int p = CS2004.UI(0, 1);
		if (p == 0)
		{
			float difference = 55 - 25;
			float smallNum = (difference * 1) / 100.0f;
			double addition = CS2004.UR(-smallNum, smallNum);
			angle = angle + addition;
		}
		else if (p == 1)
		{
			float difference = 1650 - 1500;
			float smallNum = (difference * 1) / 100.0f;
			double addition = CS2004.UR(-smallNum, smallNum);
			velocity = velocity + addition;
		}
		if (angle < 25)
		{
			angle = 25;
		}else if (55 < angle)
		{
			angle = 55;
		}else if (velocity < 1500)
		{
			velocity = 1500;
		}else if (1650 < velocity)
		{
			velocity = 1650;
		}
	}
	public double GetAngle()
	{
		return(angle);
	}
	public double GetVelocity()
	{
		return(velocity);
	}	
}
