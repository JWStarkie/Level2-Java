
public class RMHC {
	
	private static double currentFit;
	
	public static double RMHC_H_Search(int iter, int n, double[][] distances) {
		// TODO Auto-generated method stub

		TSP.CreateRandomTSP(n);

		for (int i = 0; i < iter; i++)
		{
			currentFit = TSP.TSPFitnessFunc(n, TSP.tList, distances);

			TSP.SwapSmallChangeTSP(n);

			double newfit = TSP.TSPFitnessFunc(n, TSP.tList, distances);

			if (newfit > currentFit) 
			{
				TSP.UndoSwap();
			}
			else
			{
				currentFit = newfit;
			}
			//System.out.println(i + " = " + currentFit);
		}
		return (currentFit);
	}

}
