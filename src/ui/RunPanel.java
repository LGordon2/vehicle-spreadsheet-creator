package ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import classes.Row;

public class RunPanel extends SheetPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JComboBox<String> siloDropDown;
	private JComboBox<String> machineDropDown;
	private ArrayList<JCheckBox> checkBoxes;

	/**
	 * Create the panel.
	 */
	public RunPanel() {
		checkBoxes = new ArrayList<JCheckBox>();
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0, 0, 0, 0, 30};
		gridBagLayout.rowHeights = new int[] {0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0};
		setLayout(gridBagLayout);
		
		JLabel lblUsername = new JLabel("Username");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.anchor = GridBagConstraints.EAST;
		gbc_lblUsername.gridx = 0;
		gbc_lblUsername.gridy = 0;
		add(lblUsername, gbc_lblUsername);
		
		usernameField = new JTextField();
		lblUsername.setLabelFor(usernameField);
		GridBagConstraints gbc_usernameField = new GridBagConstraints();
		gbc_usernameField.insets = new Insets(0, 0, 5, 5);
		gbc_usernameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_usernameField.gridx = 1;
		gbc_usernameField.gridy = 0;
		add(usernameField, gbc_usernameField);
		usernameField.setColumns(10);
		
		siloDropDown = new JComboBox<String>();
		siloDropDown.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4"}));
		GridBagConstraints gbc_siloDropDown = new GridBagConstraints();
		gbc_siloDropDown.insets = new Insets(0, 0, 5, 5);
		gbc_siloDropDown.fill = GridBagConstraints.HORIZONTAL;
		gbc_siloDropDown.gridx = 4;
		gbc_siloDropDown.gridy = 2;
		add(siloDropDown, gbc_siloDropDown);
		
		JLabel lblPassword = new JLabel("Password");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 1;
		add(lblPassword, gbc_lblPassword);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 1;
		add(passwordField, gbc_passwordField);
		passwordField.setColumns(10);
		
		JLabel lblMachine = new JLabel("Machine");
		GridBagConstraints gbc_lblMachine = new GridBagConstraints();
		gbc_lblMachine.anchor = GridBagConstraints.EAST;
		gbc_lblMachine.insets = new Insets(0, 0, 5, 5);
		gbc_lblMachine.gridx = 0;
		gbc_lblMachine.gridy = 2;
		add(lblMachine, gbc_lblMachine);
		
		machineDropDown = new JComboBox<String>();
		machineDropDown.setModel(new DefaultComboBoxModel<String>(new String[] {"QLM", "QIM", "QNM", "QMM"}));
		GridBagConstraints gbc_machineDropDown = new GridBagConstraints();
		gbc_machineDropDown.insets = new Insets(0, 0, 5, 5);
		gbc_machineDropDown.fill = GridBagConstraints.HORIZONTAL;
		gbc_machineDropDown.gridx = 1;
		gbc_machineDropDown.gridy = 2;
		add(machineDropDown, gbc_machineDropDown);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 2;
		gbc_panel.gridwidth = 4;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JCheckBox chckbxRegister = new JCheckBox("Register");
		GridBagConstraints gbc_chckbxRegister = new GridBagConstraints();
		gbc_chckbxRegister.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxRegister.gridx = 0;
		gbc_chckbxRegister.gridy = 0;
		panel.add(chckbxRegister, gbc_chckbxRegister);
		checkBoxes.add(chckbxRegister);
		
		JCheckBox chckbxSell = new JCheckBox("Sell");
		GridBagConstraints gbc_chckbxSell = new GridBagConstraints();
		gbc_chckbxSell.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxSell.gridx = 1;
		gbc_chckbxSell.gridy = 0;
		panel.add(chckbxSell, gbc_chckbxSell);
		checkBoxes.add(chckbxSell);
		
		JCheckBox chckbxPsi = new JCheckBox("PSI");
		GridBagConstraints gbc_chckbxPsi = new GridBagConstraints();
		gbc_chckbxPsi.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxPsi.gridx = 2;
		gbc_chckbxPsi.gridy = 0;
		panel.add(chckbxPsi, gbc_chckbxPsi);
		checkBoxes.add(chckbxPsi);
		
		JCheckBox chckbxArbitration = new JCheckBox("Arbitration");
		GridBagConstraints gbc_chckbxArbitration = new GridBagConstraints();
		gbc_chckbxArbitration.gridx = 3;
		gbc_chckbxArbitration.gridy = 0;
		panel.add(chckbxArbitration, gbc_chckbxArbitration);
		checkBoxes.add(chckbxArbitration);
		
		JLabel lblNewLabel = new JLabel("Silo");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.LINE_END;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);

	}


	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Run";
	}

	@Override
	protected ArrayList<Row> getSheetValues() {
		// TODO Auto-generated method stub
		ArrayList<Row> sheetValues = new ArrayList<Row>();
		
		//UserName
		Row r = new Row();
		r.setData("UserName", usernameField.getText());
		r.setData("Password", String.valueOf(passwordField.getPassword()));
		r.setData("Machine", (String) machineDropDown.getSelectedItem() + (String) siloDropDown.getSelectedItem());
		for(JCheckBox c : checkBoxes){
			r.setData(c.getText(), c.isSelected()?"Y":"N");
		}
		sheetValues.add(r);
		
		return sheetValues;
	}


}
