import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
//import java.util.LinkedList;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;


public class Lab5 {

	public static void PrintCollection(Collection<Data> c)
	{
		for (Iterator<Data> iter = c.iterator(); iter.hasNext();)
		{
			Data x = (Data)iter.next();
			x.Print();
		}
		System.out.println();

	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Data x = new Data("Fred",21);
		Data y = new Data("Jo",43);
		Data z = new Data("Zoe",37);
		Data b = new Data("Harry",78);
		ArrayList<Data> ArrayA = new ArrayList<Data>();
		ArrayList<Data> ArrayB = new ArrayList<Data>();
		ArrayA.add(x);
		ArrayA.add(y);
		ArrayA.add(b);
		ArrayA.add(z);

		PrintCollection(ArrayA);
		ArrayB = ArrayA;
		PrintCollection(ArrayB);
		ArrayA.remove(1);
		System.out.println("First Test");
		System.out.println("Array B = ");
		PrintCollection(ArrayB);
		System.out.println("Array A = ");
		PrintCollection(ArrayA);
		//The code above just directs us to the data in one table. Doesn't clone it.
		//Changing one array WILL change the other.
		Data x2 = new Data("Janet",21);
		Data y2 = new Data("Mario",43);
		Data z2 = new Data("Nikky",37);
		Data b2 = new Data("Ahmed",78);
		ArrayList<Data> ArrayC = new ArrayList<Data>();
		ArrayList<Data> ArrayD = new ArrayList<Data>();
		ArrayC.add(x2);
		ArrayC.add(y2);
		ArrayC.add(b2);
		ArrayC.add(z2);
		System.out.println("-------------");
		PrintCollection(ArrayC);
		ArrayD = (ArrayList<Data>)ArrayC.clone();
		ArrayC.remove(1);
		PrintCollection(ArrayD);
		System.out.println("Second Test");
		System.out.println("Array C = ");
		PrintCollection(ArrayC);
		System.out.println("Array D = ");
		PrintCollection(ArrayD);
		System.out.println();
		//The code above clones the array list in to the other array list. Changes in one 
		//list WILL NOT be shown in the other list.


		//STACK
		Stack<Data> stack = new Stack<Data>();
		stack.push(x);
		stack.push(y);
		stack.push(z);
		while (stack.isEmpty() == false)//while the stack is NOT empty 
		{
			stack.pop().Print();//print all data being removed (pop = removes the top item)
		}
		System.out.println(stack.size());//when the stack is empty print the size of the empty stack

		//QUEUES

		ArrayBlockingQueue<Data> q = new ArrayBlockingQueue<Data>(10);
		q.add(x);
		q.add(y);
		q.add(z);
		System.out.println("Queues");
		PrintCollection(q);
		while(q.isEmpty() == false)//while the queue is NOT empty 
		{
			q.poll().Print();//.poll() retrieves and removes the head of the queue
		}	
		System.out.println(q.size());//when the queue is empty print the size of the empty stack

		for(int i=0;i<20;++i)
		{
			q.offer(new Data("Test:"+String.valueOf(i),i));
		}
		PrintCollection(q);
		//when changing the for loop to 20 and keeping the .add(), there is an error because the maximum size 
		//of the queue can only be 10, when 20 is entered is can't add anymore 
		//items to the queue
		//.offer() will add values to the queue only if it can without violating any rules

	}
}



