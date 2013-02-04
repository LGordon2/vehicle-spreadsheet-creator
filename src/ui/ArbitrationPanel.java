package ui;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JList;

import classes.ComboBoxSheetPanel;
import classes.Row;

public class ArbitrationPanel extends ComboBoxSheetPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7632152648146094185L;
	private JList<String> vehicleList;
	private JComboBox<String> arbitrationStatusComboBox;
	private ArrayList<JComboBox<String>> comboBoxes;

	public ArbitrationPanel(){
		super(1);
	}
	
	public ArrayList<JComboBox<String> > setUpComboBoxes(){
		ArrayList<JComboBox<String> > comboBoxes = new ArrayList<JComboBox<String> >();
		arbitrationStatusComboBox = new JComboBox<String>();
		comboBoxes.add(arbitrationStatusComboBox);
		arbitrationStatusComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Arbitration Status", "-----------------", "Rollback Vehicle", "Request", "Buyer Bought", "Seller Withdrew", "Buyer Withdrew", "Cancel"}));
		GridBagConstraints gbc_arbitrationStatusComboBox = new GridBagConstraints();
		gbc_arbitrationStatusComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_arbitrationStatusComboBox.gridx = 0;
		gbc_arbitrationStatusComboBox.gridy = 1;
		add(arbitrationStatusComboBox, gbc_arbitrationStatusComboBox);
		return comboBoxes;
	}

	@Override
	protected ArrayList<Row> getDataRows(int rowCount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Arbitration";
	}

	@Override
	public String[] getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRequestedRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected void addItem(int index) {
		// TODO Auto-generated method stub
		
	}
}
