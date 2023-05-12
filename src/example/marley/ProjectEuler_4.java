package example.marley;

public class ProjectEuler_4 {

	public int findPalindrome()
	{
		
		int biggestPalindrome = 0;
		
		for(int i = 999; i > 100; i--)
		{
			for(int j = 999; j > 100; j--)
			{
				int result = j * i;
				if (isPalindrome(Integer.toString(result)))
				{
					if(result > biggestPalindrome)
					{
						biggestPalindrome = result;
					}
				}
			}
		}
		
		return biggestPalindrome;
	}
	
	public boolean isPalindrome(String input)
	{
		if(input.length() % 2 == 1)
		{
			for(int i = 0, j = input.length() - 1; j >= 0 ;i++, j-- )
			{
				if(input.charAt(i) != input.charAt(j))
				{
					return false;
				}
			}
			System.out.println(input + " is a palindrome");
			return true;
			
		}
		else
		{
			for(int i = 0, j = input.length() - 1; j >= 0 ;i++, j-- )
			{
				if(input.charAt(i) != input.charAt(j))
				{
					return false;
				}
			}
			System.out.println(input + " is a palindrome");
			return true;
		
		}
	}
}
