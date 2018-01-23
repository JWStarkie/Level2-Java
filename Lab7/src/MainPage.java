import java.util.Random;

public class MainPage {

	public static void main(String[] args) {

		double g [] [] = {{ 0, 1, 2},{ 1, 0, 3},{ 2, 3, 0}};//values in the matrix are the weights of the edges
		//the rows and column numbers in the matrix are the nodes
		//i.e. column 1 and row 2 are nodes 1 and 2 and the weight is the value in the matrix
		double m [] [] = {{ 0, 1, 2, 3, 0},{ 1, 0, 6, 0, 5},{ 2, 6, 0, 4, 1},{ 3, 0, 4, 0, 2},{0, 5, 1, 2, 0}};
		double mst [] [] = MST.PrimsMST(g);
		double mmst [] [] = MST.PrimsMST(m);
		PrintArray(g);
		PrintArray(mst);
		System.out.println("3rd array");
		PrintArray(mmst);
		double random1 [] [] = RandomArray(100);
		double random2 [] [] = RandomArray(200);
		double random3 [] [] = RandomArray(300);
		double random4 [] [] = RandomArray(400);
		double random5 [] [] = RandomArray(500);

		for (int i = 0; i < 10; i++)
		{
			final long startTime = System.currentTimeMillis();
			MST.PrimsMST(random1);
			final long endTime = System.currentTimeMillis();
			//System.out.print("Total Execution Time for 100 nodes = " + (endTime - startTime));
			System.out.print(endTime - startTime);
			System.out.print("\t");
			/*final long startTime2 = System.currentTimeMillis();
		MST.PrimsMST(random2);
		final long endTime2 = System.currentTimeMillis();
		System.out.print("Total Execution Time for 200 nodes = " + (endTime2 - startTime2));
		System.out.println();
		final long startTime3 = System.currentTimeMillis();
		MST.PrimsMST(random3);
		final long endTime3 = System.currentTimeMillis();
		System.out.print("Total Execution Time for 300 nodes = " + (endTime3 - startTime3));
		System.out.println();
		final long startTime4 = System.currentTimeMillis();
		MST.PrimsMST(random4);
		final long endTime4 = System.currentTimeMillis();
		System.out.print("Total Execution Time for 400 nodes = " + (endTime4 - startTime4));
		System.out.println();
		final long startTime5 = System.currentTimeMillis();
		MST.PrimsMST(random5);
		final long endTime5 = System.currentTimeMillis();
		System.out.print("Total Execution Time for 500 nodes = " + (endTime5 - startTime5));
		System.out.println();*/
		}
	}

	public static void PrintArray(double array[][])
	{

		for (int i = 0; i < array.length; i++)
		{
			for (int j = 0; j < array.length; j++)
			{
				System.out.print(array[i][j] + "\t");
			}
			System.out.print("\n");
		}
	}
	public static double[][] RandomArray(int n)
	{
		Random rand = new Random();
		double rarray[][] = new double[n][n];
		int high = 100;
		int low = 0;
		for (int i = 0; i < n; i++) 
		{
			for (int j = 0; j < n; j++)
			{
				if (i == j)
				{
					rarray[i][j] = 0;
				}
				else 
				{
					int x = rand.nextInt(high - low) + low;
					rarray[i][j] = x;
					rarray[j][i] = rarray[i][j];
				}
			}
		}
		return rarray;
	}
}