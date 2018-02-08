public class Lab_10 {
	
	static CannonSolution c = new CannonSolution();

	public static CannonSolution RMHC(int iter)
	{
		double oldfit = 0, newfit = 0;

		for (int i = 0; i < iter; i++)
		{
			oldfit = c.CannonFitness();
			CannonSolution oldc = new CannonSolution(c.GetAngle(),c.GetVelocity());
			System.out.println("Old Fitness ... " + oldfit);

			c.SmallChange();
			newfit = c.CannonFitness();
			System.out.println("New Fitness ... " + newfit);

			if (newfit < oldfit) 
			{
				c = new CannonSolution(oldc.GetAngle(),oldc.GetVelocity());
				System.out.println(" result oldfit... ");
			}
			else
			{
				System.out.println(" result newfit... ");
			}
		}
		//System.out.println(newfit);
		return (c);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		double r = Cannon.GetMaxRange(40.0, 1575.0);
//		System.out.println(r);
//		ArrayList<Double> xt = Cannon.GetX();
//		ArrayList<Double> yt = Cannon.GetY();
//		System.out.println(xt.size());
//		System.out.println(yt.size());

		RMHC(500);
		System.out.println("Best Angle and Velocity " + c.GetAngle() + " ... " + c.GetVelocity());
		System.out.println("Maximum Range " + c.CannonFitness());
	}

}
