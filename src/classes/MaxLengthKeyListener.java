package classes;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;


public class MaxLengthKeyListener extends KeyAdapter{
	private int maxLength;
	public MaxLengthKeyListener(int maxLength){
		this.maxLength = maxLength;
	}
	public void keyTyped(KeyEvent e) {
		if(e.getSource() instanceof JTextField){
			if(((JTextField) e.getSource()).getText().length() > this.maxLength-1)
				e.consume();
		}
	}
}
