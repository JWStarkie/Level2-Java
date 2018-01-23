
public class Data {
	
	private String name;
	private int age;
	
	Data (String n, int a)
	{
		name = n;
		age = a;
	}
	
	public String GetName()
	{
		return (name);
	}
	
	public void SetName(String n)
	{
		name = n;
	}
	
	public int GetAge()
	{
		return (age);
	}
	
	public void SetAge(int a)
	{
		age = a;
	}
	
	public void Print()
	{
		System.out.print(("("+GetName()));
		System.out.print(",");
		System.out.print(GetAge());
		System.out.print(") ");
	}
	
}
