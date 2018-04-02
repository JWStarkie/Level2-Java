
public class SHC {

	private static double currentFit;

	public static double SHC_H_Search(int iter, int n, double[][] distances) {
		// TODO Auto-generated method stub

		double temp = 60;
		
		TSP.CreateRandomTSP(n);

		for (int i = 0; i < iter; i++)
		{
			currentFit = TSP.TSPFitnessFunc(n, TSP.tList, distances);

			TSP.SwapSmallChangeTSP(n);

			double newfit = TSP.TSPFitnessFunc(n, TSP.tList, distances);

			if (newfit > currentFit)
			{
				if (TSP.Probability(currentFit, newfit, temp))
				{
					TSP.UndoSwap();
				}else 
				{
					continue;
				}
			}else 
			{
				currentFit = newfit;
			}
			//System.out.println(i + " = " + currentFit);
		}
		return (currentFit);
	}
}
