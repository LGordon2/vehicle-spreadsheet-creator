package ui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;

import javax.swing.JTextField;

public class NumberTextField extends JTextField {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2723750646943902771L;

	public NumberTextField(){
		super();
		this.addKeyListener(new KeyAdapter(){
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Pattern.matches("\\d", String.valueOf(e.getKeyChar())))
					e.consume();
			}
		});
	}
}
