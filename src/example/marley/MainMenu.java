package example.marley;
import java.awt.*;
import java.awt.GridBagConstraints;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

import java.util.Arrays;
import java.util.Scanner;
import example.marley.ProjectEuler_1;
import example.marley.ProjectEuler_2;
//import example.marley.ProjectEuler_4;
import example.marley.ProjectEuler_11;

public class MainMenu {
	private static JFrame frame;
	private static Map<String, Solution> operationsMap;
	public static void main(String[] args)
	{
		operationsMap = new HashMap<>();
		operationsMap.put("Euler_1", new ProjectEuler_1());
		SwingUtilities.invokeLater(()->{
			frame = new JFrame("Swing App");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			String[] operationNames = {"Euler_1", "Euler_2", "Euler_4", "Euler_11", "Euler_19", "Euler_28"};
			JComboBox<String> comboBox = new JComboBox<>(operationNames);
			GridBagConstraints gbc = new GridBagConstraints();
			
			JPanel parentContainer = new JPanel();
			parentContainer.setLayout(new GridBagLayout());
			parentContainer.setName("Parent Name");

			JPanel childContainer = new JPanel();
			childContainer.setLayout(new GridBagLayout());
			childContainer.setName("Top Bar");
			
			JPanel operationContainer = new JPanel();
			operationContainer.setName("Operation Content");
			operationContainer.setLayout(new GridBagLayout());
					
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.anchor = GridBagConstraints.NORTH;
			gbc.weightx = 1.0;
			gbc.weighty = 0.0;
			
			childContainer.add(comboBox, gbc);
			parentContainer.add(childContainer, gbc);
			gbc.gridx = 0;
			gbc.gridy = 1;
			gbc.fill = GridBagConstraints.BOTH;
			gbc.anchor = GridBagConstraints.CENTER;
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
				
			
			parentContainer.add(operationContainer, gbc);
			
			
			comboBox.addItemListener(new ItemListener()
					{
						@Override
						public void itemStateChanged(ItemEvent e) 
						{
							if(e.getStateChange() == ItemEvent.SELECTED)
							{
								String selectedOption = (String) comboBox.getSelectedItem();
								if(operationsMap.get(selectedOption) != null)
								{
									operationsMap.get(selectedOption).display(frame);;
								}
							}
						}
					});
			
			frame.setContentPane(parentContainer);
			
			frame.pack();
			frame.setVisible(true);
		});
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
			else if(input.equals("Euler_11"))
			{
				ArrayList<Integer> row1 = new ArrayList<>(Arrays.asList(8, 2, 22, 97, 38, 15, 0, 40, 0, 75, 4, 5, 7, 78, 52, 12, 50, 77, 91, 8));
				ArrayList<Integer> row2 = new ArrayList<>(Arrays.asList(49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48, 4, 56, 62, 0));
				ArrayList<Integer> row3 = new ArrayList<>(Arrays.asList(81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30, 3, 49, 13, 36, 65));
				ArrayList<Integer> row4 = new ArrayList<>(Arrays.asList(52, 70, 95, 23, 4, 60, 11, 42, 69, 24, 68, 56, 1, 32, 56, 71, 37, 2, 36, 91));
				ArrayList<Integer> row5 = new ArrayList<>(Arrays.asList(22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40, 28, 66, 33, 13, 80));
				
				ArrayList<Integer> row6 = new ArrayList<>(Arrays.asList(24, 47, 32, 60, 99, 3, 45, 2, 44, 75, 33, 53, 78, 36, 84, 20, 35, 17, 12, 50));
				ArrayList<Integer> row7 = new ArrayList<>(Arrays.asList(32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70, 66, 18, 38, 64, 70));
				ArrayList<Integer> row8 = new ArrayList<>(Arrays.asList(67, 26, 20, 68, 2, 62, 12, 20, 95, 63, 94, 39, 63, 8, 40, 91, 66, 49, 94, 21));
				ArrayList<Integer> row9 = new ArrayList<>(Arrays.asList(24, 55, 58, 5, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88, 34, 89, 63, 72));
				ArrayList<Integer> row10 = new ArrayList<>(Arrays.asList(21, 36, 23, 9, 75, 0, 76, 44, 20, 45, 35, 14, 0, 61, 33, 97, 34, 31, 33, 95));
				
				ArrayList<Integer> row11 = new ArrayList<>(Arrays.asList(78, 17, 53, 28, 22, 75, 31, 67, 15, 94, 3, 80, 4, 62, 16, 14, 9, 53, 56, 92));
				ArrayList<Integer> row12 = new ArrayList<>(Arrays.asList(16, 39, 5, 42, 96, 35, 31, 47, 55, 58, 88, 24, 0, 17, 54, 24, 36, 29, 85, 57));
				ArrayList<Integer> row13 = new ArrayList<>(Arrays.asList(86, 56, 0, 48, 35, 71, 89, 7, 5, 44, 44, 37, 44, 60, 21, 58, 51, 54, 17, 58));
				ArrayList<Integer> row14 = new ArrayList<>(Arrays.asList(19, 80, 81, 68, 5, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17, 77, 4, 89, 55, 40));
				ArrayList<Integer> row15 = new ArrayList<>(Arrays.asList(4, 52, 8, 83, 97, 35, 99, 16, 7, 97, 57, 32, 16, 26, 26, 79, 33, 27, 98, 66));
				
				ArrayList<Integer> row16 = new ArrayList<>(Arrays.asList(88, 36, 68, 87, 57, 62, 20, 72, 3, 46, 33, 67, 46, 55, 12, 32, 63, 93, 53, 69));
				ArrayList<Integer> row17 = new ArrayList<>(Arrays.asList(4, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18, 8, 46, 29, 32, 40, 62, 76, 36));
				ArrayList<Integer> row18 = new ArrayList<>(Arrays.asList(20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59, 85, 74, 4, 36, 16));
				ArrayList<Integer> row19 = new ArrayList<>(Arrays.asList(20, 73, 35, 29, 78, 31, 90, 1, 74, 31, 49, 71, 48, 86, 81, 16, 23, 57, 5, 54));
				ArrayList<Integer> row20 = new ArrayList<>(Arrays.asList(1, 70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52, 1, 89, 19, 67, 48));
				
				ArrayList<ArrayList<Integer>> Grid = new ArrayList<ArrayList<Integer>>();

				Grid.add(row1);
				Grid.add(row2);
				Grid.add(row3);
				Grid.add(row4);
				Grid.add(row5);
				Grid.add(row6);
				Grid.add(row7);
				Grid.add(row8);
				Grid.add(row9);
				Grid.add(row10);
				Grid.add(row11);
				Grid.add(row12);
				Grid.add(row13);
				Grid.add(row14);
				Grid.add(row15);
				Grid.add(row16);
				Grid.add(row17);
				Grid.add(row18);
				Grid.add(row19);
				Grid.add(row20);
				
				ProjectEuler_11 operation = new ProjectEuler_11();
				System.out.println("The answer is: " + operation.solveGrid(Grid, 4));
			}
			else if(input.equalsIgnoreCase("quit"))
			{
				break;
			}
		}
		
		System.out.println("Exiting program.");
		scanner.close();
	}
}
