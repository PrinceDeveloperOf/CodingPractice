package example.marley;

import javax.swing.*;
import java.awt.*;

public class ProjectEuler_1 implements Solution{

	public int addMultiples(int multiple, int upperLimit)
	{
		if(multiple < 0)
		{
			System.out.println("Multiple must be bigger than 0");
			return 0;
		}
		if(multiple > upperLimit)
		{
			System.out.println("upperLimit must be bigger than multiple");
			return 0;
		}
		int sum = 0;
		for(int i = 0; i < upperLimit; i += multiple)
		{
			sum += i;
		}
		
		return sum;
	}

	@Override
	public void display(JFrame inFrame)
	{
		SwingUtilities.invokeLater(() ->{
			for(Component component : inFrame.getContentPane().getComponents())
			{
				if(component.getName().equals("Operation Content"))
				{
					Container operationContainer = (Container) component;
					operationContainer.removeAll();
					
					GridBagConstraints gbc = new GridBagConstraints();
					gbc.gridx = 0;
					gbc.gridy = 0;
					gbc.weightx = 0.0;
					gbc.weighty = 1.0;
					JLabel multipleLabel = new JLabel("Multiple");
					JTextField multipleInput = new JTextField("Enter Multiple");
					JLabel upperLimitLabel = new JLabel("Upper Limit");
					JTextField upperLimitInput = new JTextField("Enter upperlimit");
					
					operationContainer.add(multipleLabel, gbc);
					gbc.gridy = 1;
					operationContainer.add(upperLimitLabel, gbc);
					
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
