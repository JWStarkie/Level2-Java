import java.util.ArrayList;
import java.util.Arrays;

public class Lab_15 {
	public static int iter = 100000, runs = 25;
	public static String data_48 = "TSP_Data/TSP_48.txt", opt_data_48 = "TSP_Data/TSP_48_OPT.txt",
			data_51 = "TSP_Data/TSP_51.txt", opt_data_51 = "TSP_Data/TSP_51_OPT.txt", 
			data_52 = "TSP_Data/TSP_52.txt", opt_data_52 = "TSP_Data/TSP_52_OPT.txt", 
			data_70 = "TSP_Data/TSP_70.txt", opt_data_70 = "TSP_Data/TSP_70_OPT.txt",
			data_76 = "TSP_Data/TSP_76.txt", opt_data_76 = "TSP_Data/TSP_76_OPT.txt",
			data_100 = "TSP_Data/TSP_100.txt", opt_data_100 = "TSP_Data/TSP_100_OPT.txt",
			data_105 = "TSP_Data/TSP_105.txt", opt_data_105 = "TSP_Data/TSP_105_OPT.txt",
			data_136 = "TSP_Data/TSP_136.txt", data_150 = "TSP_Data/TSP_150.txt", 
			data_198 = "TSP_Data/TSP_198.txt", data_226 = "TSP_Data/TSP_226.txt",
			data_264 = "TSP_Data/TSP_264.txt", data_318 = "TSP_Data/TSP_318.txt",
			data_400 = "TSP_Data/TSP_400.txt", data_442 = "TSP_Data/TSP_442.txt", 
			opt_data_442 = "TSP_Data/TSP_442_OPT.txt", data_493 = "TSP_Data/TSP_493.txt",
			data_574 = "TSP_Data/TSP_574.txt", none = "";

	public static double AverageRMHCFitness(int n, double[][] distances)
	{
		double fitness = 0.0;
		for (int i = 0; i < runs; i++)
		{
			fitness += RMHC.RMHC_H_Search(iter, n, distances);
		}
		fitness /= runs;
		return (fitness);
	}
	
	public static double AverageRRHCFitness(int n, double[][] distances)
	{
		double fitness = 0.0;
		for (int i = 0; i < runs; i++)
		{
			fitness += RRHC.RRHC_H_Search(n, distances);
		}
		fitness /= runs;
		return (fitness);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double [][] distances = TSP.ReadArrayFile(data_48, " ");
		ArrayList<Integer> optimum_tour = TSP.GetOptimumTour(opt_data_48);
		int n = distances.length;
		double [][] y = MST.PrimsMST(distances);
		
		double mst_fit = TSP.GetMSTFitness(y, n);
		
		double opt_fit = TSP.TSPFitnessFunc(n, optimum_tour, distances);

		//put in for loop to run 25 times(store as variable, then work out the average and spit that out 
		double rmhc_fitness = RMHC.RMHC_H_Search(iter, n, distances);
		//double rmhc_fitness = AverageRMHCFitness(n, distances);
		
		//methods in the main lab 
		//all shared variables can stay in TSP 
		//at least 1/3 needs to be comments
		//What does each method do, inputs and outputs, state sophisticated loops etc... JUST EXPLAIN !!!
		double rrhc_fitness = RRHC.RRHC_H_Search(n, distances);
		//double rrhc_fitness = AverageRRHCFitness(n, distances);

		double shc_fitness = SHC.SHC_H_Search(iter, n, distances);

		double sa_fitness = SA.SA_H_Search(iter, n, distances);


		//48 cities = 70% for RMHC, 80% for SHC, 82% for RRHC, 90% for SA.
		//Optimum divided by my best fitness
		//for MST each % should be round 10% less than optimum 
		//MST fitness divided by my best fitness
		//MST fitness should ALWAS be less than the optimum
		//RRHC uses RMHC --> CHECK LECTURE NOTES !!!!
		//Temperature for the SHC and SA will be difficult, test on the 48 and tweak temperature until
		//you get a better result than the heuristic search methods

		System.out.println("RMHC fitness = " + rmhc_fitness);//my fitness
		System.out.println("SHC fitness = " + shc_fitness);//my fitness
		System.out.println("RRHC fitness = " + rrhc_fitness);//my fitness
		System.out.println("SA fitness = " + sa_fitness);//my fitness
		System.out.println("Optimum Fitness = " + opt_fit); //actual best fitness
		System.out.println("MST Fitness = " + mst_fit); //estimation of the best fitness
	}

}
