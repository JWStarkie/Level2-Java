import java.util.ArrayList;

public class Lab8 {

	static ScalesSolution s = new ScalesSolution(5);
	static int amount = 8;
	static ScalesSolution s2 = new ScalesSolution(amount);

	public static void main(String args[])
	{
		/*	for(int i=0;i<10;++i)
		{
			int x = CS2004.UI(0, 1);
			System.out.println(x);
		}

		ScalesSolution s = new ScalesSolution("10101");
		s.println();
		s = new ScalesSolution("10101x");
		s.println();
		s = new ScalesSolution(10);
		s.println();*/

		/*ArrayList<Double> weights = new ArrayList<>();
		double n = 1, x = 2, p = 3, l = 4, f = 10;

		weights.add(n);
		weights.add(x);
		weights.add(p);
		weights.add(l);
		weights.add(f);
		System.out.println(weights);
		s.println();
		System.out.println(s.ScalesFitness(weights));

		//--------------------
		//Scales solution for specific amount of numbers from prime text file
		ArrayList<Double> h = CS2004.ReadNumberFile("1000 Primes.txt");
		ArrayList<Double> newReadNum = new ArrayList<>();
		ArrayList<Double> newReadNum10 = new ArrayList<>();
		ArrayList<Double> newReadNum100 = new ArrayList<>();
		ArrayList<Double> newReadNum250 = new ArrayList<>();
		ArrayList<Double> newReadNum500 = new ArrayList<>();
		ArrayList<Double> newReadNum1000 = new ArrayList<>();

		//making smaller arraylist 
		for (int i = 0; i < amount; i++)
		{
			newReadNum.add(h.get(i));
		}
		System.out.println(newReadNum);
		s2.println();
		System.out.println(s2.ScalesFitness(newReadNum));
		 */
		ArrayList<Double> h = CS2004.ReadNumberFile("1000 Primes.txt");

		//10 weights
		double average = 0;
		double xs;
		for (int i = 0; i < 100; i++)
		{
			ScalesSolution s10 = new ScalesSolution(10);
			xs = s10.ScalesFitness(h);
			//System.out.println(xs);
			average = average + xs;
		}
		double newAverage = average / 100;
		System.out.println(newAverage);

		//100 weights

		for (int i = 0; i < 100; i++)
		{
			ScalesSolution s100 = new ScalesSolution(100);
			xs = s100.ScalesFitness(h);
			//System.out.println(xs);
			average = average + xs;
		}
		newAverage = average / 100;
		System.out.println(newAverage);

		//250 weights

		for (int i = 0; i < 100; i++)
		{
			ScalesSolution s250 = new ScalesSolution(250);
			xs = s250.ScalesFitness(h);
			//System.out.println(xs);
			average = average + xs;
		}
		newAverage = average / 100;
		System.out.println(newAverage);

		//500 weights

		for (int i = 0; i < 100; i++)
		{
			ScalesSolution s500 = new ScalesSolution(500);
			xs = s500.ScalesFitness(h);
			//System.out.println(xs);
			average = average + xs;
		}
		newAverage = average / 100;
		System.out.println(newAverage);

		//1000 weights

		for (int i = 0; i < 100; i++)
		{
			ScalesSolution s1000 = new ScalesSolution(1000);
			xs = s1000.ScalesFitness(h);
			//System.out.println(xs);
			average = average + xs;
		}
		newAverage = average / 100;
		System.out.println(newAverage);
	}
}