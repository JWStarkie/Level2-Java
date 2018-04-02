public class RRHC {

	private static double bestFitness;
	private static int iter = 5000, randomRestarts = 20;

	public static double RRHC_H_Search(int n, double[][] distances)
	{		
		for (int i = 0; i < randomRestarts - 1; i++)
		{
			double currentFitness = RMHC.RMHC_H_Search(iter, n, distances);
			if (i == 0) bestFitness = currentFitness;
			if (currentFitness < bestFitness) bestFitness = currentFitness;
			
		}
		return (bestFitness);
	}
}
