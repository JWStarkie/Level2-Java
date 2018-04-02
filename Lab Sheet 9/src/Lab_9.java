import java.util.ArrayList;

public class Lab_9 {

	private static double finalfitness;
	
	public static ScalesSolution RMHC(ArrayList<Double> weights, int n, int iter)
	{
		ScalesSolution oldsol = new ScalesSolution(n);
		double oldfit, newfit = 0;

		for (int i = 0; i <= iter; i++)
		{
			oldfit = oldsol.ScalesFitness(weights);
			//System.out.println(oldsol.GetSol() + " .oldfit.. " + oldfit);

			ScalesSolution newsol = new ScalesSolution(oldsol.GetSol());
			newsol.SmallChange();
			newfit = newsol.ScalesFitness(weights);
			//System.out.println(newsol.GetSol() + " .newfit.. " + newfit);

			if (newfit < oldfit) 
			{
				oldsol = newsol;
				finalfitness = newfit;
				//System.out.println(" result newfit... " + newfit);
			}
			else
			{
				finalfitness = oldfit;
			}
		}
		return (oldsol);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//				ScalesSolution s = new ScalesSolution("00000");
//				s.println();
//				s.SmallChange();
//				s.println();
//				
//				ScalesSolution s1 = new ScalesSolution(10);
//				s1.println();
//				ScalesSolution s2 = new ScalesSolution(s1.GetSol());
//				s2.println();

		ArrayList<Double> test = new ArrayList<Double>();
		test.add((double) 1);
		test.add((double) 2);
		test.add((double) 3);
		test.add((double) 4);
		test.add((double) 10);
		test.add((double) 198);
		test.add((double) 223);
		test.add((double) 34);
		test.add((double) 4790);
		test.add((double) 1033);
		test.add((double) 10);
		test.add((double) 20);
		test.add((double) 30);
		test.add((double) 40);
		test.add((double) 100);
		test.add((double) 1098);
		test.add((double) 2023);
		test.add((double) 304);
		test.add((double) 40790);
		test.add((double) 10033);

		//System.out.println("Best Solution ... = " + RMHC(test, 20, 400).GetSol());

		ArrayList<Double> h = CS2004.ReadNumberFile("1000 Primes.txt");
		//System.out.println(h);
//		for (int i = 0; i < 5; i++)
//		{
//			System.out.println(h.get(i));
//		}
		System.out.println("Best Solution ... = " + RMHC(h, 200, 100).GetSol());
		System.out.println("Best fitness " + finalfitness);
	}

}
