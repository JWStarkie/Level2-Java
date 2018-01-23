
public class Geometric {

	
	
	public static void GeoSum(int a, int n)
	{
		double res = 0;
		for (int i = 0; i <= n; i++)
		{
			res =  res + Math.pow(a, i);
		}
		System.out.println(res);
	}

public static void RunAlgorithm()
{
	long StartTime, EndTime, ElapsedTime;
		
	System.out.println("Testing algorithm …");

	// Save the time before the algorithm run
	StartTime=System.nanoTime();

	// Run the algorithm
	GeoSum(3, 3);

	// Save the time after the run
	EndTime=System.nanoTime();

	// Calculate the difference
	ElapsedTime= EndTime- StartTime;

	// Print it out
	System.out.println("The algorithm took " + ElapsedTime + " nanoseconds to run.");
}
private static void DummyAlgorithm()
{
	// This is a dummy function and should be replaced with your 
	// own implementation of the actual algorithm
	// The following is an example algorithm and took 112 ms to run on my
	// computer........
    	for(int i = 0;i<1000000;++i)
    	{
    		double x = Math.sin((double)(i)/1000000.0);
    	}
}

}
