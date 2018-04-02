import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Random;

//KMeans clustering class - badly hacked together by Dr Stephen Swift....
class KMeans
{
	//Fields/attributes
	//Random number generator
	private static Random rand;
	//Number of variables, number of cases/instances to be clustered and number of clusters being sought
	private static int n,len,nc;
	//The clustering arrangement at each iteration
	private ArrayList<Integer> clusters;
	//Assume that rows are instances and columns are variables
	//The data being clustered - 'len' by 'n'
	private double data[][];
	//The centres of each cluster 'nc' by 'n' 
	private double centres[][];
	//Create 'nc' random centres
	private void AssignRandomCentres()
	{
		double max[] = new double[n];
		double min[] = new double[n];
		//Locate max and min for each variable
		for(int j=0;j<n;++j)
		{
			max[j] = data[0][j];
			min[j] = data[0][j];
			for(int i=1;i<len;++i)
			{
				if (max[j] < data[i][j]) max[j] = data[i][j];
				if (min[j] > data[i][j]) min[j] = data[i][j];
			}
		}
		for(int i=0;i<nc;++i)
		{
			for(int j=0;j<n;++j)
			{
				centres[i][j] = UR(min[j],max[j]);
			}
		}
	}
	//How far is variable 'j' from centre 'ci'?
	//Uses squared Euclidean distance
	private double ComputeDistance(int ci,int j)
	{
		double d = 0.0;
		for(int i=0;i<n;++i)
		{
			double r = centres[ci][i] - data[j][i];
			d += r*r;
		}
		return(d);
	}
	//Find which cluster data item 'j' is closest to 
	private int FindCluster(int j)
	{
		double dist = -1;
		int index = -1;
		for(int i=0;i<nc;++i)
		{
			double d = ComputeDistance(i,j);
			if (d < dist || dist == -1) 
			{
				index = i;
				dist = d;
			}
		}
		return(index);
	}
	//Update the centres - throw away old values and recompute based on 'clusters'
	private void UpdateCentres()
	{
		//Loop variables
		int i,j;
		//Cluster membership count
		int cc[] = new int[nc];
		//Blank centres
		for(i=0;i<nc;++i)
		{
			cc[i] = 0;
			for(j=0;j<n;++j)
			{
				centres[i][j] = 0;
			}
		}
		//How big is each cluster?
		for(i=0;i<clusters.size();++i)
		{
			int index = clusters.get(i);
			cc[index] += 1;
		}
		//Compute new centre as average of 'clusters' membership
		for(i=0;i<clusters.size();++i)
		{
			int index = clusters.get(i);
			for(j=0;j<n;++j)
			{
				double v = data[i][j] / (double)(cc[index]);
				centres[index][j] += v;
			}
		}
	}
	//Compute the total sum of squared distance from members to centres
	//This should decrease each iteration
	private double SumOfSquared()
	{
		double res = 0.0;
		for(int i=0;i<clusters.size();++i)
		{
			int c = clusters.get(i);
			res += ComputeDistance(c,i);
		}
		return(res);
	}
	//Show the progress of KMeans
	//Displays the iteration number, Weighted Kappa (if a known/expected arrangement is given),
	//and sum of squared error
	private void LogRun(int i,ArrayList<Integer> real)
	{
		double ss = SumOfSquared();
		double wk = GroupingWK(real,clusters);
		System.out.print(i);
		System.out.print(" ");
		System.out.print(wk);
		System.out.print(" ");
		System.out.println(ss);
	}
	//The KMeans constructor
	//'d' is the dataset being clustered, rows are instances, columns are variables
	//'nn' the number of variables in the dataset
	//'ll' the numbers of rows in the dataset
	public KMeans(double d[][],int nn,int ll)
	{
		n = nn;
		len = ll;
		data = new double[len][n];
		for(int i=0;i<len;++i)
		{
			for(int j=0;j<n;++j)
			{
				data[i][j] = d[i][j]; 
			}
		}
	}
	//Run KMeans clustering for 'iter' iterations
	//'nncc' is the number of clusters we are looking for
	//'real' is the expected clustering arrangement - leave blank (empty) if unknown
	//'showlog' if false then no status or iteration data is shown
	public ArrayList<Integer> RunIter(int nncc,int iter,ArrayList<Integer> real,boolean showlog)
	{
		nc = nncc;
		centres = new double[nc][n];
		AssignRandomCentres();
		for(int rep=0;rep<iter;++rep)
		{
			clusters = new ArrayList<Integer>();
			for(int i = 0;i<len;++i)
			{
				clusters.add(-1);
			}
			for(int i = 0;i<len;++i)
			{
				int index = FindCluster(i);
				clusters.set(i,index);
			}
			UpdateCentres();
			if (showlog) LogRun(rep,real);
		}
		return(clusters);
	}
	//The following static function should be useful
	//Create a uniformly distributed random double between a and b inclusive
	static public double UR(double a,double b)
	{
		if (rand == null) 
		{
			rand = new Random();
			rand.setSeed(System.nanoTime());
		}
		return((b-a)*rand.nextDouble()+a);
	}
	//Compute the weighted kappa between two clustering arrangements
	//A return value of -2 means the two vectors are different sizes
	//A return value of -1 means the first vector is of zero size
	//A return value of +1 is total agreement - identical clusters
	//A return value of -1 is total disagreement
	//A return value of 0 is the expected agreement between two random clusters
	//A real number between -1 and +1 if no error is found
	public static double GroupingWK(ArrayList<Integer> a, ArrayList<Integer> b)
	{
		int nv = a.size();
		if (nv != b.size()) return(-2.0);
		if (nv == 0) return(-3.0);
		double res = 0.0;
		long[][] counts = new long[2][2];
		for (int i = 0; i < nv - 1; ++i) 
		{
			for (int j = i + 1; j < nv; ++j) 
			{
				int ix = 1, iy = 1;
				if (a.get(i) == a.get(j)) ix = 0;
				if (b.get(i) == b.get(j)) iy = 0;
				counts[ix][iy] += 1;
			}
		}
		res = WK(counts);
		return (res);
	}
	//Calculate the WK statistic on a contingency table
	//Returns -2 if the table is not square
	//Returns -3 if the tables is less than 2 rows in size  
	public static double WK(long[][] counts) 
	{
		double wk = 0.0;
		if (counts.length != counts[0].length) return (-2);
		if (counts.length < 2) return (-3);
		double g = counts[0].length;
		long[][] weights = new long[(int) g][(int) g];
		int i, j;
		double q = 0;
		ArrayList<Double> rows = new ArrayList<Double>((int) g);
		ArrayList<Double> cols = new ArrayList<Double>((int) g);
		for (int o = 0; o < rows.size(); o++) 
		{
			rows.add(q);
		}
		for (int t = 0; t < cols.size(); t++) 
		{
			cols.add(q);
		}
		for (i = 0; i < g; ++i) 
		{
			double row = 0;
			double col = 0;
			for (j = 0; j < g; ++j) 
			{
				row += counts[i][j];
				col += counts[j][i];
				weights[i][j] = (long) (1.0 - (Math.abs((double) (i) - (double) (j)) / (double) (g - 1)));
			}
			rows.add(row);
			cols.add(col);
		}
		double po = 0.0, pe = 0.0;
		double n = 0;
		for (i = 0; i < g; ++i) 
		{
			n += rows.get(i);
			for (j = 0; j < g; ++j) 
			{
				po += weights[i][j] * counts[i][j];
				pe += weights[i][j] * rows.get(i) * cols.get(j);
			}
		}
		po /= n;
		pe /= (n * n);
		if (pe != 1) 
		{
			wk = (po - pe) / (1.0 - pe);
		} else 
		{
			wk = 1.0;
		}
		return (wk);
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
	//As above but used for reading in a matrix of data - returns a double array
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
}