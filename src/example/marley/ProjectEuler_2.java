package example.marley;
import javax.swing.*;
import java.awt.*;
public class ProjectEuler_2 {
	static JTextField aField;
	public int sumEvenFibonachi(int upperLimit)
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
	
	public static void display(JFrame inFrame)
	{
		SwingUtilities.invokeLater(()->{
		for(Component component : inFrame.getContentPane().getComponents())
			{
				if(component.getName().equals("Operation Content"))
				{
					Container operationContainer = (Container) component;
					operationContainer.removeAll();

					aField = new JTextField();
					
					operationContainer.add(aField);
					
					inFrame.revalidate();
					inFrame.repaint();
					inFrame.pack();
					break;
					
				}
			}
				
		});
	}

}
