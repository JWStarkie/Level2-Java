import java.util.ArrayList;

public class Lab6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> random2 = ThreeSort.RandomArray(5);
		ArrayList<Integer> random3 = ThreeSort.RandomArray(6);
		ArrayList<Integer> random4 = ThreeSort.RandomArray(7);

		
//		for (int i = 0; i < 10; i++){
//			ArrayList<Integer> random = ThreeSort.RandomArray(35000);
//			final long startTime = System.currentTimeMillis();
//			ThreeSort.SortA(random);
//			//ThreeSort.SortB(random);
//			//ThreeSort.SortC(random);
//			final long endTime = System.currentTimeMillis();
//			System.out.print("Total Execution Time = " + (endTime - startTime));
//			System.out.println();
//		}

		System.out.println("Sort Algorithm A");
		ThreeSort.ShowArray(random2);
		ThreeSort.ShowArray(ThreeSort.SortA(random2));
		System.out.println();
		System.out.println("------------------");
		System.out.println("Sort Algorithm B");
		ThreeSort.ShowArray(random3);
		ThreeSort.ShowArray(ThreeSort.SortB(random3));
		System.out.println();
		System.out.println("------------------");
		System.out.println("Sort Algorithm C");
		ThreeSort.ShowArray(random4);
		ThreeSort.ShowArray(ThreeSort.SortC(random4));


	}

}
