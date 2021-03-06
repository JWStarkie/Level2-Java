import java.util.ArrayList;

public class Code_Runner_Test_Code {

	public static double ArrayMax(ArrayList<Double> array){



		if (array.isEmpty()==true)
		{
			return Double.MIN_VALUE;
		}
		else
		{


			double CurrentMax = array.get(0);

			for (int i = 1; i < array.size(); i++)
			{
				if (array.get(i)>CurrentMax)
				{
					CurrentMax = array.get(i);
				}
			}
			return(CurrentMax);
		}
	}
	public static int LinearSummation(int n)
	{
		if (n < 1)
		{
			return 0;
		}
		else
		{
			int res = 0;
			for (int i = 0; i <= n; i++)
			{
				res = res + i;
			}
			return res;
		}
	}
	public static boolean IsEven(int a)
	{
		if ((a % 2) == 0)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}

	public static String RevString(String input)
	{
		String result = "";

		for (int i = (input.length() - 1); i > -1; i--)
		{
			result = result + input.charAt(i);
		}
		return result;
	}

	public static int Factorial(int x)
	{
		int res = 1;
		if (x < 0)
		{
			x = -1; 
			return x;
		}
		else
		{
			for (int i = 1; i <= x; i++)
			{
				res = res * i;
			}
			return res;
		}
	}

	public static int CharCounter(String a, char b)
	{
		int count = 0;
		char g;
		a = a.toLowerCase();
		for (int i = 0; i < a.length(); i++)
		{
			g = a.charAt(i);
			if (g == b)
			{
				count = count + 1;
			};

		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//System.out.println(CharCounter(\"AAAAAaaaaa\", 'a'));

//		ArrayList<Integer> input = new ArrayList<Integer>();
//		input.add(5);
//		input.add(2);
//		input.add(3);
//		input.add(4);
//
//
//		ArrayList<Integer> x = createExpected(input);
//
//		for (int i = 0; i < x.size(); i++)
//		{
//			System.out.print(x.get(i));
//		}
//
//		String text = \"/xyz.jpg\";
//		System.out.println(text);
//		text = text.replace(\"/\", \"\");
//		System.out.println(text);
		String test = "[[{movie_id}]]";
		String newResult = test.substring(1, test.length()-1);
		System.out.println(newResult);

	}

	public static ArrayList<Integer> createExpected(ArrayList<Integer> sizes)
	{
		ArrayList<Integer> output = new ArrayList<Integer>();
		
		for (int i = 0; i < sizes.size(); i++)
		{
			for (int j = 0; j < sizes.get(i); j++)
			{
				output.add(sizes.get(i));
			}
		}
		return output;
	}


}
