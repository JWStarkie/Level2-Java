
public class CannonSolution 
{
	private double angle;
	private double velocity;
	
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
			System.out.println("Change Angle");//make sure to remove!!
			float difference = 55 - 25;
			float smallNum = (difference * 4) / 100.0f;
			double addition = CS2004.UR(-smallNum, smallNum);
			angle = angle + addition;
			System.out.println(angle);
		}
		else if (p == 1)
		{
			System.out.println("Change Velocity");//make sure to remove!!
			float difference = 1650 - 1500;
			float smallNum = (difference * 4) / 100.0f;
			double addition = CS2004.UR(-smallNum, smallNum);
			velocity = velocity + addition;
			System.out.println(velocity);
		}
		if (angle < 25)
		{
			angle = 25;
			System.out.println(angle);
		}else if (55 < angle)
		{
			angle = 55;
			System.out.println(angle);
		}else if (velocity < 1500)
		{
			velocity = 1500;
			System.out.println(velocity);
		}else if (1650 < velocity)
		{
			velocity = 1650;
			System.out.println(velocity);
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
