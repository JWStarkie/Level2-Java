
public class SA {

	private static double c_rate = 0.5;
//0.35
	public static double SA_H_Search(int iter, int n, double[][] distances)
	{
		double temp = 100000;
		//double temp = 4500;
		double min_temp = 0.00;
		//double Lambda = Math.pow((0.001/temp),(1/(double)iter));
		double currentFitness = 0;
		
		TSP.CreateRandomTSP(n);
		
		for (int i = 0; i < iter; i++)
		{
			while (temp > min_temp)
			{
				currentFitness = TSP.TSPFitnessFunc(n, TSP.tList, distances);
				TSP.SwapSmallChangeTSP(n);
				double newFitness = TSP.TSPFitnessFunc(n, TSP.tList, distances);

				if (newFitness > currentFitness)
				{
					if (TSP.Probability(currentFitness, newFitness, temp))
					{
						TSP.UndoSwap();
					}else 
					{
						continue;
					}
				}else 
				{
					currentFitness = newFitness;
				}
				temp *= c_rate;
			}
		}
		return (currentFitness);
	}
}
