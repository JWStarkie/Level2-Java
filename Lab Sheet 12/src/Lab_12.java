public class Lab_12 {
	public static void main(String args[])
	{
		//Run 10 repeats
		for(int i=0;i<10;++i)
		{
			//Reset the fitness count
			OneMaxChrome.ClearFC();
			//The following parameters are not very good!
			//These are the ones you should try and optimise!
			int popsize = 100;
			double mrate = 0.0028;
			double crate = 0.65;
			//You will not need to change the following
			SimpleGeneticAlgorithm ga = new SimpleGeneticAlgorithm(popsize,10,300,mrate,crate);
			//Run the GA for 10,000 function calls
			double f = ga.RunSGA(10000,false).GetFitness();
			System.out.println(f);
		}
	}
}
