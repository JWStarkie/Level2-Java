//Store an edge, from node i to j with weight w
public class Edge extends Object
{
	public int i,j;
	public double w;
	Edge(int ii,int jj,double ww)
	{
		i = ii;
		j = jj;
		w = ww;
	};
	public void Print()
	{
		System.out.print("(");
		System.out.print(i);
		System.out.print(",");
		System.out.print(j);
		System.out.print(",");
		System.out.print(w);
		System.out.print(")");
	}
};