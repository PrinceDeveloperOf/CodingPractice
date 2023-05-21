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
	public void display(JFrame inFrame) {
		SwingUtilities.invokeLater(() ->{
			inFrame.getContentPane().removeAll();
			
			JPanel panel = new JPanel(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			
			
			
			JButton button = new JButton("");

			
			inFrame.revalidate();
			inFrame.repaint();
		});
		
	}
}
