package example.marley;
import javax.swing.*;
import java.awt.*;
public class ProjectEuler_2 {
	static JTextField upperLimitTextField;
	static JLabel resultLabel;
	public static void sumEvenFibonachi()
	{
		int sum = 0;
		if(!SolutionHelpers.checkIfTextFieldIsAllDigits(upperLimitTextField))
		{
			return;
		}
		int upperLimit = Integer.parseInt(upperLimitTextField.getText());
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
		final String sumString = Integer.toString(sum);
		SwingUtilities.invokeLater(() -> {
			resultLabel.setText(sumString);
		});
		

	}
	public static void display(JFrame inFrame)
	{
		SwingUtilities.invokeLater(()->{
		for(Component component : inFrame.getContentPane().getComponents())
			{
				if(component.getName().equals("Operation Content"))
				{
					Container operationContainer = (Container) component;
					operationContainer.removeAll();

					JLabel upperLimitLabel = new JLabel("Upper Limit");
					resultLabel = new JLabel("Waiting for input");
					Runnable fibonachiRunnable = ProjectEuler_2::sumEvenFibonachi;
					
					upperLimitTextField = new JTextField();

					SolutionHelpers.turnTextFieldIntoNumericOnlyTextField(upperLimitTextField, fibonachiRunnable);

					GridBagConstraints gbc = new GridBagConstraints();
					gbc.gridx = 0;
					gbc.gridy = 0;
					gbc.weightx = 0.0;
					gbc.weighty = 1.0;
					
					operationContainer.add(upperLimitLabel, gbc);

					gbc.weightx = 1.0;
					gbc.gridx = 1;
					gbc.fill = GridBagConstraints.HORIZONTAL;

					operationContainer.add(upperLimitTextField, gbc);
					
					gbc.gridwidth = 2;
					gbc.gridy = 1;
					gbc.gridx = 0;
					
					operationContainer.add(resultLabel, gbc);
					
					inFrame.revalidate();
					inFrame.repaint();
					inFrame.pack();
					break;
				}
			}
				
		});
	}

}
