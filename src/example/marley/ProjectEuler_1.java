package example.marley;

import javax.swing.*;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;

import example.marley.SolutionHelpers;

public class ProjectEuler_1{
	static JTextField multipleInput;
	static JTextField upperLimitInput;
	static JLabel displayLabel;

	public static void addMultiples()
	{
		int[] multipleNum = new int[] {0};
		int[] upperLimitNum = new int[] {0};
		
		Boolean isUpperLimitAllDigits = SolutionHelpers.checkIfTextFieldIsAllDigits(upperLimitInput);
		Boolean isMultipleAllDigits = SolutionHelpers.checkIfTextFieldIsAllDigits(multipleInput);

		if(!isUpperLimitAllDigits || !isMultipleAllDigits )
		{
			return;
		}
		int multiple = Integer.parseInt(multipleInput.getText());
		int upperLimit = Integer.parseInt(upperLimitInput.getText());
		if(multiple < 0)
		{
			SwingUtilities.invokeLater(() ->{
				displayLabel.setText("Multiple must be bigger than 0");
			});
				return;
		}
		if(multiple > upperLimit)
		{
			SwingUtilities.invokeLater(() ->{
						displayLabel.setText("Upper Limit must be bigger than multiple");
					});
			return;
		}
		int sum = 0;
		for(int i = 0; i < upperLimit; i += multiple)
		{
			sum += i;
		}
		final String sumString = Integer.toString(sum);
		SwingUtilities.invokeLater(() ->{
			displayLabel.setText(sumString);
		});
		return;
	}

	public static void display(JFrame inFrame)
	{
		SwingUtilities.invokeLater(() ->{
			for(Component component : inFrame.getContentPane().getComponents())
			{
				if(component.getName().equals("Operation Content"))
				{
					Container operationContainer = (Container) component;
					operationContainer.removeAll();
					
					JLabel multipleLabel = new JLabel("Multiple");
					multipleInput = new JTextField("");
					Runnable addMultiplesRunnable = ProjectEuler_1::addMultiples;
					JLabel upperLimitLabel = new JLabel("Upper Limit");
					SolutionHelpers.turnTextFieldIntoNumericOnlyTextField(multipleInput, addMultiplesRunnable);
					upperLimitInput = new JTextField("");
					SolutionHelpers.turnTextFieldIntoNumericOnlyTextField(upperLimitInput, addMultiplesRunnable);
					displayLabel = new JLabel("Waiting for input");

					GridBagConstraints gbc = new GridBagConstraints();
					gbc.gridx = 0;
					gbc.gridy = 0;
					gbc.weightx = 0.0;
					gbc.weighty = 1.0;
					
					operationContainer.add(multipleLabel, gbc);
					gbc.gridy = 1;
					operationContainer.add(upperLimitLabel, gbc);
					gbc.gridy = 2;
					gbc.gridwidth = 2;
					operationContainer.add(displayLabel, gbc);

					gbc.gridwidth = 1;

					gbc.gridy = 0;
					gbc.weightx = 1.0;
					gbc.gridx = 1;
					gbc.fill = GridBagConstraints.HORIZONTAL;
					operationContainer.add(multipleInput, gbc);
					gbc.gridy = 1;
					operationContainer.add(upperLimitInput,gbc);

					
					inFrame.revalidate();
					inFrame.repaint();
					inFrame.pack();
					break;
				}
			}
			
			JPanel panel = new JPanel(new GridBagLayout());
		});
		
	}
}
