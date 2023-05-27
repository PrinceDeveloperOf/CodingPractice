package example.marley;

import javax.swing.*;
import javax.swing.event.*;

public class SolutionHelpers {
	public static void turnTextFieldIntoNumericOnlyTextField(JTextField inTextField, Runnable action)
	{
		int[] num = new int[0];
		inTextField.getDocument().addDocumentListener(new DocumentListener()
			{
				@Override
				public void insertUpdate(DocumentEvent e) {
					if(SolutionHelpers.checkIfTextFieldIsAllDigits(inTextField))
					{
						action.run();
						return;
					}else{
						SwingUtilities.invokeLater(() -> {
							if(inTextField.getText().length() > 0)
							{
								inTextField.setText(inTextField.getText().substring(0,inTextField.getText().length() - 1));
							}
						});
					}
				}

				@Override
				public void removeUpdate(DocumentEvent e) {
					return;
				}

				@Override
				public void changedUpdate(DocumentEvent e) {
					return;
					
				}
			});
	}
	public static Boolean checkIfTextFieldIsAllDigits(JTextField inTextField)
	{
		String text = inTextField.getText();
		try {
			int digits = Integer.parseInt(text);
			digits = Integer.parseInt(text);
			return true;
		}catch(NumberFormatException e){
			return false;
		}
	}
}
