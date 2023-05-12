package example.marley;
import java.util.Scanner;
import example.marley.ProjectEuler_1;
import example.marley.ProjectEuler_2;
//import example.marley.ProjectEuler_4;

public class MainMenu {
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		String input = "";
		
		while(true){
			
			System.out.println("Type 'Euler_1' to use the solution to Euler_1\nType 'Euler_2' to use the solution to Euler_2\n Type'Euler_4' to use the solution to Euler_4\nType 'quit' to quit");
			input = scanner.nextLine();
			if(input.equals("Euler_1"))
			{
				String multiple = "";
				String upperLimit = "";
				System.out.println("Enter the multiple you want to count");
				multiple = scanner.nextLine();
				System.out.println("Enter the upper limit");
				upperLimit = scanner.nextLine();
				try
				{
					Integer.parseInt(upperLimit);
					Integer.parseInt(multiple);
				} catch (NumberFormatException e)
				{
					System.out.println("The upperLimit and multiple must be a number");
					continue;
				}
				ProjectEuler_1 operation = new ProjectEuler_1();
				
				int answer = operation.addMultiples(Integer.parseInt(multiple), Integer.parseInt(upperLimit));
				if (answer != 0)
				{
					System.out.println("The answer is " + answer);
				}
			}
			else if(input.equals("Euler_2"))
			{
				System.out.println("Enter an upper limit");
				String upperLimit = scanner.nextLine();
				try
				{
					Integer.parseInt(upperLimit);
				} catch (NumberFormatException e)
				{
					System.out.println("The upperLimit must be a number");
					continue;
				}
				ProjectEuler_2 operation = new ProjectEuler_2();
				int result = operation.sumEvenFibonachi(Integer.parseInt(upperLimit));
				System.out.println("Here is the result: " + result);
			}
			else if(input.equals("Euler_4"))
			{
				ProjectEuler_4 operation = new ProjectEuler_4();
				System.out.println("The result is: " + operation.findPalindrome());
				
			}
			else if(input.equalsIgnoreCase("quit"))
			{
				break;
			}
		}
		
		System.out.println("Exiting progrram.");
		scanner.close();
	}
}
