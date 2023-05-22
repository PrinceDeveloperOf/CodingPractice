package example.marley;
import javax.swing.*;
import javax.swing.event.*;

public class SolutionHelpers {
	public static int[] turnTextFieldIntoNumericOnlyTextField(JTextField inTextField)
	{
		int[] num = new int[]{0};
					inTextField.getDocument().addDocumentListener(new DocumentListener()
					{

						@Override
						public void insertUpdate(DocumentEvent e) {
							int[] num = new int[] {0};
							if(SolutionHelpers.checkIfTextFieldIsAllDigits(inTextField, num))
							{
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
				return num;	

	}
	public static Boolean checkIfTextFieldIsAllDigits(JTextField inTextField, int[] digits)
	{
		if(digits.length == 0)
		{
			return false;
		}
		String text = inTextField.getText();
		try {
			digits[0] = Integer.parseInt(inTextField.getText());
			return true;
		}catch(NumberFormatException e){
			return false;
		}
	}
}
