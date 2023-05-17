package example.marley;

public class ProjectEuler_28 {
	public int addDiagonalsOfASpiral(int spiralNum)
	{
		int sum = 1;
		for(int i = 1, level = 1; i < spiralNum; level = level + 2)
		{
			for(int j = 0; j < 4; ++j)
			{
				i = i + level; 
				if(i > spiralNum)
				{
					break;
				}
				sum += i;
			}
		}
		return sum;
		
	}
}
