package classes;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JPanel;

public class ComboBoxSandbox extends JPanel {
	private JCheckBox chckbxVerifyQlm;
	private JCheckBox chckbxVerifyQtm;
	private JCheckBox chckbxVerifyOds;
	private DefaultListModel<String> listModel;
	private JButton btnRemoveVehicle;
	private JList<String> vehicleList;

	public ComboBoxSandbox() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[5];
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[5];
		gridBagLayout.columnWeights = new double[]{1.0,1.0,1.0,1.0,Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton btnAddVehicle = new JButton("Add vehicle");
		
		chckbxVerifyQlm = new JCheckBox("Verify QLM");
		GridBagConstraints gbc_chckbxVerifyQlm = new GridBagConstraints();
		gbc_chckbxVerifyQlm.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxVerifyQlm.gridx = 0;
		gbc_chckbxVerifyQlm.gridy = 0;
		add(chckbxVerifyQlm, gbc_chckbxVerifyQlm);
		
		chckbxVerifyQtm = new JCheckBox("Verify QTM");
		GridBagConstraints gbc_chckbxVerifyQtm = new GridBagConstraints();
		gbc_chckbxVerifyQtm.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxVerifyQtm.gridx = 1;
		gbc_chckbxVerifyQtm.gridy = 0;
		gbc_chckbxVerifyQtm.anchor = GridBagConstraints.CENTER;
		add(chckbxVerifyQtm, gbc_chckbxVerifyQtm);
		
		chckbxVerifyOds = new JCheckBox("Verify ODS");
		GridBagConstraints gbc_chckbxVerifyOds = new GridBagConstraints();
		gbc_chckbxVerifyOds.gridx = 2;
		gbc_chckbxVerifyOds.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxVerifyOds.gridy = 0;
		add(chckbxVerifyOds, gbc_chckbxVerifyOds);
		
		GridBagConstraints gbc_btnAddVehicle = new GridBagConstraints();
		gbc_btnAddVehicle.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddVehicle.gridx = 0;
		gbc_btnAddVehicle.gridy = 2;
		add(btnAddVehicle, gbc_btnAddVehicle);
		
		listModel = new DefaultListModel<String>();
		
		btnRemoveVehicle = new JButton("Remove vehicle");
		btnRemoveVehicle.setEnabled(false);
		
		GridBagConstraints gbc_btnRemoveVehicle = new GridBagConstraints();
		gbc_btnRemoveVehicle.gridx = 2;
		gbc_btnRemoveVehicle.insets = new Insets(0, 0, 5, 5);
		gbc_btnRemoveVehicle.gridy = 2;
		add(btnRemoveVehicle, gbc_btnRemoveVehicle);
		
		vehicleList = new JList<String>(listModel);
		GridBagConstraints gbc_vehicleList = new GridBagConstraints();
		gbc_vehicleList.gridwidth = 3;
		gbc_vehicleList.fill = GridBagConstraints.BOTH;
		gbc_vehicleList.gridx = 0;
		gbc_vehicleList.gridy = 3;
		add(vehicleList, gbc_vehicleList);
	}

}