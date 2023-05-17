package example.marley;
import java.util.ArrayList;

public class ProjectEuler_11 {
	public int solveGrid(ArrayList<ArrayList<Integer>> Grid, int lineLength)
	{
		
		if(Grid.size() < lineLength || Grid.get(0).size() < lineLength)
		{
			System.out.println("The grid must be at least " + lineLength + "x" + lineLength);
			return 0;
		}
		
		int biggestNum = 0;
		ArrayList<Integer> biggestNums = new ArrayList<Integer>();
		String direction = "none";

		for(int i = 0; i < Grid.size() - lineLength; ++i)
		{
			for(int j = 0; j < Grid.get(0).size() - lineLength; ++j)
			{
				int iProduct = 0;
				ArrayList<Integer> iNumArray = new ArrayList<Integer>();
				int jProduct = 0;
				ArrayList<Integer> jNumArray = new ArrayList<Integer>();
				int kProduct = 0;
				ArrayList<Integer> kNumArray = new ArrayList<Integer>();
				int negkProduct = 0;
				ArrayList<Integer> negkNumArray = new ArrayList<Integer>();
				if(Grid.size() > i + lineLength)
				{
					++iProduct;
					for(int k = 0; k < lineLength; ++k)
					{
						iProduct = iProduct * Grid.get(i + k).get(j);
						iNumArray.add(Grid.get(i + k).get(j));
					}
				}
				if(Grid.get(i).size() > j + lineLength)
				{
					++jProduct;
					for(int k = 0; k < lineLength; ++k)
					{
						jProduct = jProduct * Grid.get(i).get(j + k);
						jNumArray.add(Grid.get(i).get(j + k));
					}
				}
				if(kProduct != 0 && kProduct != 0)
				{
					++kProduct;
					for(int k = 0; k < lineLength; ++k)
					{
						kProduct = kProduct * Grid.get(i + k).get(j + k);
						kNumArray.add(Grid.get(i + k).get(j + k));
					}
				}
				if(i - lineLength - 1  >= 0 && j - lineLength - 1 >= 0)
				{
					++negkProduct;
					for(int k = 0; k < lineLength; ++k)
					{
						negkProduct = negkProduct * Grid.get(i + k).get(j - k);
						negkNumArray.add(Grid.get(i + k).get(j - k));
					}
				}
				if(iProduct > biggestNum)
				{
					biggestNum = iProduct;
					biggestNums = iNumArray;
					direction = "vertical";
					//Vertical
				}
				if(jProduct > biggestNum)
				{
					biggestNum = jProduct;
					biggestNums = jNumArray;
					direction = "horizonatal";
					//Horizontal
				}
				if(kProduct > biggestNum)
				{
					biggestNum = kProduct;
					biggestNums = kNumArray;
					direction = "Ascending Diagonal";
					//Forward Diagonal
				}
				if(negkProduct > biggestNum)
				{
					biggestNum = negkProduct;
					biggestNums = negkNumArray;
					direction = "Decending Diagonal";
					//Backwards Diagonal
				}
			}
		}
		System.out.println("Biggest Nums: " 
		+ Integer.toString(biggestNums.get(0)) + ", "
		+ Integer.toString(biggestNums.get(1)) + ", "
		+ Integer.toString(biggestNums.get(2)) + ", "
		+ Integer.toString(biggestNums.get(3))
		);

		System.out.println("the direction is: " + direction);
		
		return biggestNum;
	}
}
