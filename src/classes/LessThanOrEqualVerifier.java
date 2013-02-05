package classes;

import javax.swing.JComponent;

public class LessThanOrEqualVerifier extends TextFieldInputVerifier {
	
	protected TextFieldInputVerifier inputVerifier;
	protected JComponent lessThanComponent;
	
	public LessThanOrEqualVerifier(TextFieldInputVerifier inputVerifier, JComponent lessThanComponent){
		super(inputVerifier.panel);
		this.inputVerifier=inputVerifier;
		this.lessThanComponent=lessThanComponent;
	}
	
	@Override
	public boolean verify(JComponent input) {
		// TODO Auto-generated method stub
		if(((NumberTextField) input).getNumber()>((NumberTextField) lessThanComponent).getNumber()){
			panel.setErrorDescription(String.format(Constants.ERROR_RNG_ISSUE, panel.getDescription(), input.getName(), lessThanComponent.getName().toLowerCase()));
			return false;
		}
		return inputVerifier.verify(input);
	}

}
