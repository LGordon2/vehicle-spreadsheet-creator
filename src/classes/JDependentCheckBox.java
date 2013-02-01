package classes;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

public class JDependentCheckBox extends JCheckBox implements ItemListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4416213181388210083L;

	public JDependentCheckBox(String string) {
		// TODO Auto-generated constructor stub
		super(string);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if (e.getStateChange() == ItemEvent.DESELECTED){
			this.setEnabled(false);
			this.setSelected(false);
		}else if(e.getStateChange() == ItemEvent.SELECTED){
			this.setEnabled(true);
		}
	}

}
