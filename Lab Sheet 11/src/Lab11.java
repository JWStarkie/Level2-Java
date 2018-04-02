import java.util.ArrayList;

public class Lab11 
{
	public static void main(String args[])
	{
		//Read in the weights
		//Make sure you change the filename as appropriate!
		//This will only work if "c:\temp\1000 Primes.txt" exists!
		ArrayList<Double> w = CS2004.ReadNumberFile("1000 Primes.txt");
//		ArrayList<Double> w = new ArrayList<Double>();
//		double e = 2, s = 4, g = 6, h = 8, c = 10;
//		w.add(e);
//		w.add(s);
//		w.add(g);
//		w.add(h);
//		w.add(c);
//
//		//Set the weights
		ScalesChrome.SetWeights(w);
		//Run 10 repeats
		for(int i=0;i<10;++i)
		{
			//Reset the fitness count
			ScalesChrome.ClearFC();
			//The following parameters are not very good!
			//These are the ones you should try and optimise!
			int popsize = 100;
			double mrate = 0.001;
			double crate = 0.70;
			//You will not need to change the following
			SimpleGeneticAlgorithm ga = new SimpleGeneticAlgorithm(popsize,10,1000,mrate,crate);
			//Run the GA for 10,000 function calls
			double f = ga.RunSGA(10000,false).GetFitness();
			System.out.println(f);
		}
	}
}
