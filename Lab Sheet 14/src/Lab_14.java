import java.util.ArrayList;

public class Lab_14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> genericArrangement = new ArrayList<Integer>();
		int clusterID1 = 1, clusterID2 = 2, clusterID3 = 3;

		for (int j = 0; j < 25; j++)
		{
			genericArrangement.add(clusterID1);
		}
		for (int j = 0; j < 50; j++)
		{
			genericArrangement.add(clusterID2);
		}
		for (int j = 0; j < 25; j++)
		{
			genericArrangement.add(clusterID3);
		}

		double[][] clusterLabArray = KMeans.ReadArrayFile("ClusterLab.txt", ",");
		
		for (int i = 0; i < 10; i++)
		{
			KMeans kObject = new KMeans(clusterLabArray, 3, 100);
			ArrayList<Integer> newArrangement = kObject.RunIter(3, 10, genericArrangement, false);
			double kappaResult = KMeans.GroupingWK(genericArrangement, newArrangement);
			System.out.println(kappaResult);
		}
		
		
		
		System.out.println("-------Second txt file------");
		ArrayList<Integer> genericArrangement2 = new ArrayList<Integer>();

		for (int j = 0; j < 25; j++)
		{
			genericArrangement2.add(1);
		}
		for (int j = 0; j < 50; j++)
		{
			genericArrangement2.add(2);
		}
		for (int j = 0; j < 25; j++)
		{
			genericArrangement2.add(3);
		}
		for (int j = 0; j < 50; j++)
		{
			genericArrangement2.add(4);
		}

		double[][] clusterLabArray2 = KMeans.ReadArrayFile("IrisData.txt", ",");
		for (int i = 0; i < 100; i++)
		{
			KMeans kObject2 = new KMeans(clusterLabArray2, 5, 150);
			ArrayList<Integer> newArrangement2 = kObject2.RunIter(4, 10, genericArrangement2, false);
			double kappaResult2 = KMeans.GroupingWK(genericArrangement2, newArrangement2);
			System.out.println(kappaResult2);
		}
		
	}

}
