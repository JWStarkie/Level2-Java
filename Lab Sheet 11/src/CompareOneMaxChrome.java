//Compare Scales Chromosomes - used to sort an ArrayList of ScalesChrome
public class CompareOneMaxChrome implements java.util.Comparator<ScalesChrome>
{
	public int compare(ScalesChrome a, ScalesChrome b) 
	{
		if (a.GetFitness() < b.GetFitness()) return(-1);
		if (a.GetFitness() > b.GetFitness()) return(1);
		return(0);
	}
}