package example.marley;
import java.util.ArrayList;

public class ProjectEuler_11 {
	public int solveGrid(ArrayList<ArrayList<Integer>> Grid, int lineLength)
	{
		
		if(Grid.size() < lineLength || Grid.get(0).size() < lineLength)
		{
			System.out.println("The grid must be at least " + lineLength + "x" + lineLength);
		}
		
		int biggestNum = 0;

		for(int i = 0; i < Grid.size() - lineLength; ++i)
		{
			for(int j = 0; j < Grid.get(0).size() - lineLength; ++j)
			{
				int iProduct = 0;
				int jProduct = 0;
				int kProduct = 0;
				int negkProduct = 0;
				if(Grid.size() > i + lineLength)
				{
					++iProduct;
					for(int k = 0; k < lineLength; ++k)
					{
						iProduct = iProduct * Grid.get(i + k).get(j);
					}
				}
				if(Grid.get(i).size() > i + lineLength)
				{
					++jProduct;
					for(int k = 0; k < lineLength; ++k)
					{
						jProduct = jProduct * Grid.get(i).get(j + k);
					}
				}
				if(kProduct != 0 && kProduct != 0)
				{
					++kProduct;
					for(int k = 0; k < lineLength; ++k)
					{
						kProduct = kProduct * Grid.get(i + k).get(j + k);
					}
				}
				if(i - lineLength >= 0 && j - lineLength >= 0)
				{
					++negkProduct;
					for(int k = 0; k < lineLength; ++k)
					{
						negkProduct = negkProduct * Grid.get(i + k).get(j + k);
					}
				}
				if(iProduct > biggestNum)
				{
					biggestNum = iProduct;
				}
				if(jProduct > biggestNum)
				{
					biggestNum = jProduct;
				}
				if(kProduct > biggestNum)
				{
					biggestNum = kProduct;
				}
				if(negkProduct > biggestNum)
				{
					biggestNum = negkProduct;
				}

			}
		}
		return 0;
	}
}
