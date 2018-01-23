
public class Labsheet_4 {

	//THIS IS TO PRINT OUT EACH VALUE OF THE ARRAY
	private static void PrintArray(double[] X) 
	{
		int n = X.length;
		
		for (int i = 0; i < n; i++)
		{
			System.out.println(X[i]);
		}
	}
	
	
	//THIS IS THE PREFIX AVERAGE 1 ALGORTIHM
	public static double[] PrefixAverage1(double X[]){
		int n = X.length;
		double A[] = new double[n];
		
		for (int i = 0; i < n; i++)
		{
			double s = X[0];
			for (int j = 1; j < n; j++)
			{
				if (j <= i)
				{
					s = s + X[j];
				}
			}
			A[i] = s / (i+1);
		}
		return A;
	}
	
	//THIS IS THE PREFIX AVERAGE 2 ALGORTIHM
	public static double[] PrefixAverage2(double X[])
	{
		int n = X.length; 
		double A[] = new double [n];
		double s = 0;
		
		for (int i = 0; i < n; i++)
		{
			s = s + X[i];
			A[i] = s / (i + 1);
		}
		return A;
		
	}

	public static void main(String args[])
	{
		double X[] = {7, 3, -1, 2, 9 ,0, 0.8, 52, 2.2, 900};
		double Y[] = {1,2,3,4,5,6,7,8,10};
		
		double A[] = PrefixAverage1(X);
		double B[] = PrefixAverage2(Y);
		
		System.out.println("Prefix Average Test 1");
		System.out.println("Array Input");
		PrintArray(X);
		System.out.println("Average Output");
		PrintArray(A);
		System.out.println("Prefix Average Test 2");
		System.out.println("Array Input");
		PrintArray(Y);
		System.out.println("Average Output");
		PrintArray(B);
	}
}


