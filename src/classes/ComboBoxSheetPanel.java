package classes;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JList;

public abstract class ComboBoxSheetPanel extends SheetPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8884147792907227273L;
	private JList<String> vehicleList;
	private AbstractButton btnRemoveVehicle;
	private JCheckBox chckbxVerifyOds;
	private JCheckBox chckbxVerifyQtm;
	private JCheckBox chckbxVerifyQlm;
	private JButton btnAddVehicle;
	private DefaultListModel<String> listModel;
	private ArrayList<JComboBox<String>> allComboBoxes;

	public ComboBoxSheetPanel(int comboBoxCount) {

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0,1.0,1.0,1.0,Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		allComboBoxes = setUpComboBoxes();
		btnAddVehicle = new JButton("Add vehicle");
		btnAddVehicle.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				//Make sure we actually selected a valid value.
				for(JComboBox<String> comboBox : allComboBoxes){
					if(comboBox.getSelectedIndex()<=1)
						return;
				}

				int index = vehicleList.getSelectedIndex(); //get selected index
				if (index == -1) { //no selection, so insert at beginning
					index = 0;
				} else {           //add after the selected item
					index++;
				}

				String outputString = "Vehicle -";
				addItem(index);
				/*outputString += " " + inspectionCodeComboBox.getSelectedItem();
				outputString += fourteenDayGuaranteeComboBox.getSelectedItem().equals("Y")?", Fourteen Day Guarantee":"";
				outputString += ", " + psiStatusComboBox.getSelectedItem() + " PSI";
				allPsiRequests.add(index, new PsiType(
						(String) inspectionCodeComboBox.getSelectedItem(),
						(String) fourteenDayGuaranteeComboBox.getSelectedItem(),
						(String) psiStatusComboBox.getSelectedItem()
						));*/
				listModel.insertElementAt(outputString, index);

				//Select the new item and make it visible.
				vehicleList.setSelectedIndex(index);
				vehicleList.ensureIndexIsVisible(index);

				//Make the remove button enabled.
				//btnRemoveVehicle.setEnabled(true);
			}
		});

		chckbxVerifyQlm = new JCheckBox("Verify QLM");
		GridBagConstraints gbc_chckbxVerifyQlm = new GridBagConstraints();
		gbc_chckbxVerifyQlm.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxVerifyQlm.gridx = 0;
		gbc_chckbxVerifyQlm.gridy = 0;
		add(chckbxVerifyQlm, gbc_chckbxVerifyQlm);

		chckbxVerifyQtm = new JCheckBox("Verify QTM");
		GridBagConstraints gbc_chckbxVerifyQtm = new GridBagConstraints();
		gbc_chckbxVerifyQtm.gridwidth = comboBoxCount<3?1:comboBoxCount-2;
		gbc_chckbxVerifyQtm.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxVerifyQtm.gridx = 1;
		gbc_chckbxVerifyQtm.gridy = 0;
		gbc_chckbxVerifyQtm.anchor = GridBagConstraints.CENTER;
		add(chckbxVerifyQtm, gbc_chckbxVerifyQtm);

		chckbxVerifyOds = new JCheckBox("Verify ODS");
		GridBagConstraints gbc_chckbxVerifyOds = new GridBagConstraints();
		gbc_chckbxVerifyOds.gridx = comboBoxCount<3?2:comboBoxCount-1;
		gbc_chckbxVerifyOds.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxVerifyOds.gridy = 0;
		add(chckbxVerifyOds, gbc_chckbxVerifyOds);

		GridBagConstraints gbc_btnAddVehicle = new GridBagConstraints();
		gbc_btnAddVehicle.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddVehicle.gridx = 0;
		gbc_btnAddVehicle.gridy = 2;
		add(btnAddVehicle, gbc_btnAddVehicle);

		btnRemoveVehicle = new JButton("Remove vehicle");
		btnRemoveVehicle.setEnabled(false);

		GridBagConstraints gbc_btnRemoveVehicle = new GridBagConstraints();
		gbc_btnRemoveVehicle.gridx = comboBoxCount<3?2:comboBoxCount-1;
		gbc_btnRemoveVehicle.insets = new Insets(0, 0, 5, 0);
		gbc_btnRemoveVehicle.gridy = 2;
		add(btnRemoveVehicle, gbc_btnRemoveVehicle);

		listModel = new DefaultListModel<String>();
		vehicleList = new JList<String>(listModel);
		GridBagConstraints gbc_vehicleList = new GridBagConstraints();
		gbc_vehicleList.insets = new Insets(0, 0, 0, 5);
		gbc_vehicleList.gridwidth = comboBoxCount<3?3:comboBoxCount;
		gbc_vehicleList.fill = GridBagConstraints.BOTH;
		gbc_vehicleList.gridx = 0;
		gbc_vehicleList.gridy = 3;
		add(vehicleList, gbc_vehicleList);
	}

	protected abstract void addItem(int index);

	public abstract ArrayList<JComboBox<String> > setUpComboBoxes();

	public JList<String> getList(){
		return this.vehicleList;
	}
	
	protected abstract Object getDataType();
}
