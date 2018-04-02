public class Lab_10 {

	static CannonSolution c = new CannonSolution();
	static CannonSolution r = new CannonSolution();
	static double oldfit, newfit;
	
	public static CannonSolution RMHCMaxRange(int iter)
	{
		for (int i = 0; i < iter; i++)
		{
			oldfit = c.CannonFitness();
			CannonSolution oldc = new CannonSolution(c.GetAngle(), c.GetVelocity());

			c.SmallChange();
			newfit = c.CannonFitness();

			if (newfit < oldfit) 
			{
				c = new CannonSolution(oldc.GetAngle(), oldc.GetVelocity());
			}
		}
		return (c);
	}

	public static CannonSolution RMHCMinRange(int iter)
	{
		for (int i = 0; i < iter; i++)
		{
			oldfit = c.CannonFitness();
			CannonSolution oldc = new CannonSolution(c.GetAngle(),c.GetVelocity());

			c.SmallChange();
			newfit = c.CannonFitness();

			if (newfit > oldfit) 
			{
				c = new CannonSolution(oldc.GetAngle(),oldc.GetVelocity());
			}
		}
		return (c);
	}

	public static CannonSolution RMHC(int iter)
	{
		for (int i = 0; i < iter; i++)
		{
			oldfit = r.CannonFitness2();
			CannonSolution oldr = new CannonSolution(r.GetAngle(),r.GetVelocity());
			
			r.SmallChange();
			newfit = r.CannonFitness2();

			if (newfit > oldfit) 
			{
				r = new CannonSolution(oldr.GetAngle(),oldr.GetVelocity());
			}
		}
		return (r);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//		double r = Cannon.GetMaxRange(40.0, 1575.0);
		//		System.out.println(r);
		//		ArrayList<Double> xt = Cannon.GetX();
		//		ArrayList<Double> yt = Cannon.GetY();
		//		System.out.println(xt.size());
		//		System.out.println(yt.size());

		RMHCMaxRange(1000);
		System.out.println("Best Angle and Velocity " + c.GetAngle() + " ... " + c.GetVelocity());
		System.out.println("Maximum Range " + c.CannonFitness());
		RMHCMinRange(1000);
		System.out.println("Best Angle and Velocity " + c.GetAngle() + " ... " + c.GetVelocity());
		System.out.println("Minimum Range " + c.CannonFitness());
		RMHC(1000);
		System.out.println("Angle: " +  r.GetAngle() + " and Velocity: " + r.GetVelocity() + " can get within: " + r.CannonFitness2() + " metres of the Target Range: " + r.targetRange);
	}

}
