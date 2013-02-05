package classes;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class TextFieldInputVerifier extends InputVerifier {

	protected SheetPanel panel;

	public TextFieldInputVerifier(SheetPanel panel){
		this.panel = panel;
	}
	
	@Override
	public boolean verify(JComponent input) {
		// TODO Auto-generated method stub
		if(((JTextField) input).getText().isEmpty()){
			panel.setErrorDescription(Constants.ERROR_FIELD_IS_BLANK, input);
			return false;
		}
		panel.setErrorDescription("", input);
		return true;
	}
	
	public boolean shouldYieldFocus(JComponent input){
		verify(input);
		return true;
	}

}
