import java.util.ArrayList;
import java.util.Collections;

public class SimpleGeneticAlgorithm
{
	//The population is an array list of Scales Chromosomes
	private ArrayList<ScalesChrome> population = new ArrayList<ScalesChrome>();
	//How many weights we are solving Scales for
	private int nbits;
	//How big is the population
	private int popsize;
	//How many generations to run for
	private int gensize;
	//The mutation rate
	private double mrate;
	//The crossover rate
	private double crate;
	//Create a Genetic Algorithm with the specified parameters
	public SimpleGeneticAlgorithm(int ps,int gs,int nb,double mr,double cr)
	{
		nbits = nb;
		popsize = ps;
		gensize = gs;
		mrate = mr;
		crate = cr;
	}
	//Run the Genetic Algorithm with the current parameter set
	//If 'report' is true then display the best fitness for each generation
	public ScalesChrome RunSGA(boolean report)
	{
		InitPop();
		for(int i=0;i<gensize;++i)
		{
			CrossOver();
			Mutation();
			Survival();
			Report(i,report);
		}
		return(population.get(0));
	}
	//Run the Genetic Algorithm with the current parameter set, except for generations
	//The GA is run for a specified number of fitness function calls 'nfc'
	//If 'report' is true then display the best fitness for each generation
	public ScalesChrome RunSGA(int nfc,boolean report)
	{
		InitPop();
		int i = 0;
		while(ScalesChrome.GetFC() < nfc)
		{
			CrossOver();
			Mutation();
			Survival();
			Report(i++,report);
		}
		return(population.get(0));
	}
	//Create a new random population
	private void InitPop()
	{
		population.clear();
		for(int i=0;i<popsize;++i)
		{
			population.add(new ScalesChrome(nbits));
		}
	}
	//Display summary information each generation if 'report' is true
	private void Report(int i,boolean report)
	{
		if (!report) return;
		System.out.print(i);
		System.out.print(" ");
		System.out.print(ScalesChrome.GetFC());
		System.out.print(" ");	
		System.out.print(ComputeAverage());
		System.out.print(" ");
		System.out.println(population.get(0).GetFitness());
	}
	//Compute the average fitness for the population
	public double ComputeAverage()
	{
		double av = 0.0;
		for(int i=0;i<population.size();++i) av += population.get(i).GetFitness();
		av /= (double)(population.size());
		return(av);
	}
	//Do one point Crossover - as in the lectures
	private void DoOnePointCrossOver(int p1id,int p2id)
	{
		ArrayList<Integer> p1 = population.get(p1id).GetRep();
		ArrayList<Integer> p2 = population.get(p2id).GetRep();
		ArrayList<Integer> c1 = new ArrayList<Integer>();
		ArrayList<Integer> c2 = new ArrayList<Integer>();
		
		int xopos = CS2004.UI(1,nbits-1);
		for(int i=0;i<nbits;++i)
		{
			if (i < xopos)
			{
				c1.add(p1.get(i));
				c2.add(p2.get(i));
			}
			else
			{
				c1.add(p2.get(i));
				c2.add(p1.get(i));
			}
//			System.out.println("c1 = " + c1.get(i));
//			System.out.println("c2 = " + c2.get(i));
		}
		population.add(new ScalesChrome(c1));
		population.add(new ScalesChrome(c2));
	}
	//Do Uniform Crossover - as in the lectures - INCOMPLETE
	private void DoUniformCrossOver(int p1id,int p2id)
	{
		ArrayList<Integer> p1 = population.get(p1id).GetRep();
		ArrayList<Integer> p2 = population.get(p2id).GetRep();
		ArrayList<Integer> c1 = new ArrayList<Integer>();
		ArrayList<Integer> c2 = new ArrayList<Integer>();
		//CHECK CODE!!!
		
		for (int i = 0; i < nbits; ++i)
		{
			int xopos = CS2004.UI(0, 1);
			if (xopos == 0)
			{
				c1.add(p1.get(i)); 
				c2.add(p2.get(i));
			}
			else 
			{
				c1.add(p2.get(i)); 
				c2.add(p1.get(i));
			}

		}
		//Add Uniform Crossover here - use DoOnePointCrossOver as a basis 
		population.add(new ScalesChrome(c1));
		population.add(new ScalesChrome(c2));
	}
	//Perform Crossover for the population
	private void CrossOver()
	{
		//Decide who gets to breed
		ArrayList<Integer> xlist = new ArrayList<Integer>();
		for(int i=0;i<popsize;++i)
		{
			if (CS2004.UR(0.0,1.0) < crate) xlist.add(i);
		}
		//Pair up random parents
		while(xlist.size() > 1)
		{
			int a = -1,b = -2;
			while(a >= b)
			{
				a = CS2004.UI(0,xlist.size()-1);
				b = CS2004.UI(0,xlist.size()-1);
			}
			//DoOnePointCrossOver(xlist.get(a),xlist.get(b));
			//Comment out the above and uncomment the following for Uniform Crossover
			DoUniformCrossOver(xlist.get(a),xlist.get(b));
			xlist.remove(b);
			xlist.remove(a);
		}
	}
	//Mutate the whole population
	private void Mutation()
	{
		//Might be bigger than popsize due to crossover
		int n = population.size();
		for(int i=0;i<n;++i)
		{
			ArrayList<Integer> chrome = population.get(i).CopyRep();
			boolean changed = false;
			for(int j=0;j<nbits;++j)
			{
				if (CS2004.UR(0.0,1.0) < mrate)
				{
					Integer x = chrome.get(j);
					x = (x + 1) % 2;
					chrome.set(j,x);
					changed = true;
				}
			}
			//Only add a new Chromosome if at least one bit/gene has changed
			if (changed) population.add(new ScalesChrome(chrome));
		}
	}
	//Keep the best 'popsize' individuals
	private void Survival()
	{
		Collections.sort(population,new CompareOneMaxChrome());
		while(population.size() > popsize)
		{
			population.remove(popsize);
		}
	}
}