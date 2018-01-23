
public class ArrayMaxExcercise {
	
	public double ArrayMax(double arr[]){
		
		
		double CurrentMax = arr[0];
		
		for (int i = 1; i < arr.length; i++)
		{
			if (arr[i]>CurrentMax)
			{
				CurrentMax=arr[i];
			}
		}
		return(CurrentMax);
	}
}
