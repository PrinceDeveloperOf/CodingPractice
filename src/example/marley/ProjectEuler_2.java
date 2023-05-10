package example.marley;

public class ProjectEuler_2 {
	public int sumEvenFibonachi(int upperLimit )
	{
		int sum = 0;
		int x = 1;
		int y = 1;
		int temp;
		while(y + x < upperLimit)
		{
			temp = y;
			y = x + y;
			x = temp;
			if(y % 2 == 0) {
				sum += y;
			}
		
		}
			
		return sum;
		
	}

}
