
public class Summation {
int res = 0;
	public int LinearSum(int n)
	{
		
		for (int i = 0; i <= n; i++)
		{
			res = res + i;
		}
		return res;
	}
	
	public String Check(int x)
	{
		if (res == (x*(x+1))/2)
		{
			return "correct";
		}
		return null;
		
	}
	
}
