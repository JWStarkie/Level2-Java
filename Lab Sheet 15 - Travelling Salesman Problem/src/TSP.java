import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Collections;

//Some useful code for the CS2004 (2016-2017) Travelling Salesman Worksheet
public class TSP 
{
	public static ArrayList<Integer> tList = new ArrayList<Integer>();
	public static ArrayList<Integer> oldTList = new ArrayList<Integer>();
	
	public static void CreateRandomTSP(int n)
	{
		tList.clear();
		for (int i = 0; i < n; i++)
		{
			tList.add(i);
		}
		Collections.shuffle(tList);
	}
	
	@SuppressWarnings("unchecked")
	public static void SwapSmallChangeTSP(int n)
	{
		oldTList = (ArrayList<Integer>) tList.clone();
		int i = 0, j = 0; 
		while(i == j)
		{
			i = CS2004.UI(0, n - 1);
			j = CS2004.UI(0, n - 1);
		}
		int temp = tList.get(i);
		tList.set(i, tList.get(j));
		tList.set(j, temp);
	}
	
	@SuppressWarnings("unchecked")
	public static void UndoSwap() {
		// TODO Auto-generated method stub
		tList = (ArrayList<Integer>) oldTList.clone();
	}

	static public double TSPFitnessFunc(int numOfCities, ArrayList<Integer> tourList, double[][] distances){

		double s = 0;
		if (tourList.isEmpty()) return (-1);
		
		for (int i = 0; i < numOfCities - 1; i++)
		{
			int a = tourList.get(i);
			int b = tourList.get(i + 1);
			s += distances[a][b];
		}
		
		int end_city = tourList.get(numOfCities - 1);
		int start_city = tourList.get(0);
		s += distances[end_city][start_city];
		
		return(s);
	}
	
	public ArrayList<Integer> GetTourList()
	{
		return (tList);
	}
	
	public static double GetMSTFitness(double[][] mst_matrix, int matrix_size)
	{
		double mst_fit = 0;

		for (int i = 0; i < matrix_size; i++)
		{
			for (int j = 0; j < matrix_size; j++)
			{
				if (mst_matrix[i][j] != 0.0)
				{
					mst_fit += mst_matrix[i][j];
				}
			}
		}
		
		mst_fit /= 2.0; //divide by 2 because the matrix is symmetrical so values will be doubled 
		return (mst_fit);
	}

	//Print a 2D double array to the console Window
	static public void PrintArray(double x[][])
	{
		for(int i=0;i<x.length;++i)
		{
			for(int j=0;j<x[i].length;++j)
			{
				System.out.print(x[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	//This method reads in a text file and parses all of the numbers in it
	//This method is for reading in a square 2D numeric array from a text file
	//This code is not very good and can be improved!
	//But it should work!!!
	//'sep' is the separator between columns
	static public double[][] ReadArrayFile(String filename,String sep)
	{
		double res[][] = null;
		try
		{
			BufferedReader input = null;
			input = new BufferedReader(new FileReader(filename));
			String line = null;
			int ncol = 0;
			int nrow = 0;
			
			while ((line = input.readLine()) != null) 
			{
				++nrow;
				String[] columns = line.split(sep);
				ncol = Math.max(ncol,columns.length);
			}
			res = new double[nrow][ncol];
			input = new BufferedReader(new FileReader(filename));
			int i=0,j=0;
			while ((line = input.readLine()) != null) 
			{
				
				String[] columns = line.split(sep);
				for(j=0;j<columns.length;++j)
				{
					res[i][j] = Double.parseDouble(columns[j]);
				}
				++i;
			}
		}
		catch(Exception E)
		{
			System.out.println("+++ReadArrayFile: "+E.getMessage());
		}
	    return(res);
	}
	//This method reads in a text file and parses all of the numbers in it
	//This code is not very good and can be improved!
	//But it should work!!!
	//It takes in as input a string filename and returns an array list of Integers
	static public ArrayList<Integer> ReadIntegerFile(String filename)
	{
		ArrayList<Integer> res = new ArrayList<Integer>();
		Reader r;
		try
		{
			r = new BufferedReader(new FileReader(filename));
			StreamTokenizer stok = new StreamTokenizer(r);
			stok.parseNumbers();
			stok.nextToken();
			while (stok.ttype != StreamTokenizer.TT_EOF) 
			{
				if (stok.ttype == StreamTokenizer.TT_NUMBER)
				{
					res.add((int)(stok.nval));
				}
				stok.nextToken();
			}
		}
		catch(Exception E)
		{
			System.out.println("+++ReadIntegerFile: "+E.getMessage());
		}
	    return(res);
	}

	
	public static ArrayList<Integer> GetOptimumTour(String fileName)
	{
		ArrayList<Integer> optimum_tour = TSP.ReadIntegerFile(fileName);
		
		if (optimum_tour.size() < 1) 
			{
			optimum_tour.clear();
			}
		
		return (optimum_tour);
	}
	
	public static boolean Probability(double currentFitness, double newFitness, double temp)
	{
		double probability = 1 / (1 + Math.exp((currentFitness - newFitness) / temp));
		if (probability > CS2004.UR(0, 1)) return (true);
			
		else return (false);
	}
}