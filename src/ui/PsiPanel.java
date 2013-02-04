package ui;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JList;

import classes.ComboBoxSheetPanel;
import classes.Row;

public class PsiPanel extends ComboBoxSheetPanel {
	private JComboBox<String> inspectionCodeComboBox;
	private JComboBox<String> fourteenDayGuaranteeComboBox;
	private JComboBox<String> psiStatusComboBox;
	private ArrayList<PsiType> allPsiRequests;
	private DefaultListModel<String> listModel;
	private JList<String> vehicleList;
	private class PsiType{
		public PsiType(String inspectionCode, String fourteenDayGuarantee,
				String PSIStatus) {
			// TODO Auto-generated constructor stub
			this.inspectionCode = inspectionCode;
			this.fourteenDayGuarantee = fourteenDayGuarantee;
			this.PSIStatus = PSIStatus;
		}
		public final String inspectionCode;
		public final String fourteenDayGuarantee;
		public final String PSIStatus;
	}
	public ArrayList<JComboBox<String> > setUpComboBoxes(){
		ArrayList<JComboBox<String>> allComboBoxes = new ArrayList<JComboBox<String> >();
		inspectionCodeComboBox = new JComboBox<String>();
		allComboBoxes.add(inspectionCodeComboBox);
		inspectionCodeComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Inspection Code", "-----------------", "PSI01", "PSI02", "PSI03"}));
		GridBagConstraints gbc_inspectionCodeComboBox = new GridBagConstraints();
		gbc_inspectionCodeComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_inspectionCodeComboBox.gridx = 0;
		gbc_inspectionCodeComboBox.gridy = 1;
		add(inspectionCodeComboBox, gbc_inspectionCodeComboBox);

		fourteenDayGuaranteeComboBox = new JComboBox<String>();
		allComboBoxes.add(fourteenDayGuaranteeComboBox);
		fourteenDayGuaranteeComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Fourteen Day Guarantee", "-------------------------", "Y", "N"}));
		GridBagConstraints gbc_fourteenDayGuaranteeComboBox = new GridBagConstraints();
		gbc_fourteenDayGuaranteeComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_fourteenDayGuaranteeComboBox.gridx = 1;
		gbc_fourteenDayGuaranteeComboBox.gridy = 1;
		add(fourteenDayGuaranteeComboBox, gbc_fourteenDayGuaranteeComboBox);

		psiStatusComboBox = new JComboBox<String>();
		allComboBoxes.add(psiStatusComboBox);
		psiStatusComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"PSI Status", "----------", "Request", "Complete", "Cancel"}));
		GridBagConstraints gbc_psiStatusComboBox = new GridBagConstraints();
		gbc_psiStatusComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_psiStatusComboBox.gridx = 2;
		gbc_psiStatusComboBox.gridy = 1;
		add(psiStatusComboBox, gbc_psiStatusComboBox);
		
		return allComboBoxes;
	}
	public PsiPanel(){
		super(3);
	}
	/*public PsiPanel() {
		allPsiRequests = new ArrayList<PsiType>();
		allComboBoxes = new ArrayList<JComboBox<String> >();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		setUpComboBoxes();

		JButton btnAddVehicle = new JButton("Add vehicle");
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
			    outputString += " " + inspectionCodeComboBox.getSelectedItem();
			    outputString += fourteenDayGuaranteeComboBox.getSelectedItem().equals("Y")?", Fourteen Day Guarantee":"";
			    outputString += ", " + psiStatusComboBox.getSelectedItem() + " PSI";
				allPsiRequests.add(index, new PsiType(
								(String) inspectionCodeComboBox.getSelectedItem(),
								(String) fourteenDayGuaranteeComboBox.getSelectedItem(),
								(String) psiStatusComboBox.getSelectedItem()
								));
			    listModel.insertElementAt(outputString, index);

			    //Select the new item and make it visible.
			    vehicleList.setSelectedIndex(index);
			    vehicleList.ensureIndexIsVisible(index);

			    //Make the remove button enabled.
			    btnRemoveVehicle.setEnabled(true);
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
		gbc_chckbxVerifyQtm.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxVerifyQtm.gridx = 1;
		gbc_chckbxVerifyQtm.gridy = 0;
		add(chckbxVerifyQtm, gbc_chckbxVerifyQtm);

		chckbxVerifyOds = new JCheckBox("Verify ODS");
		GridBagConstraints gbc_chckbxVerifyOds = new GridBagConstraints();
		gbc_chckbxVerifyOds.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxVerifyOds.gridx = 2;
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
		btnRemoveVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = vehicleList.getSelectedIndex();
				listModel.remove(index);
				allPsiRequests.remove(index);

				int size = listModel.getSize();

			    if (size == 0) { //Nobody's left, disable firing.
			        btnRemoveVehicle.setEnabled(false);

			    } else { //Select an index.
			        if (index == listModel.getSize()) {
			            //removed item in last position
			            index--;
			        }

			        vehicleList.setSelectedIndex(index);
			        vehicleList.ensureIndexIsVisible(index);
			    }
			}
		});
		GridBagConstraints gbc_btnRemoveVehicle = new GridBagConstraints();
		gbc_btnRemoveVehicle.insets = new Insets(0, 0, 5, 0);
		gbc_btnRemoveVehicle.gridx = 2;
		gbc_btnRemoveVehicle.gridy = 2;
		add(btnRemoveVehicle, gbc_btnRemoveVehicle);
		vehicleList = new JList<String>(listModel);
		GridBagConstraints gbc_vehicleList = new GridBagConstraints();
		gbc_vehicleList.gridwidth = 3;
		gbc_vehicleList.fill = GridBagConstraints.BOTH;
		gbc_vehicleList.gridx = 0;
		gbc_vehicleList.gridy = 3;
		add(vehicleList, gbc_vehicleList);
	}*/

	/**
	 * 
	 */
	private static final long serialVersionUID = -3117695920724543684L;
	private JCheckBox chckbxVerifyQtm;
	private JCheckBox chckbxVerifyOds;
	private JCheckBox chckbxVerifyQlm;

	@Override
	protected ArrayList<Row> getDataRows(int rowCount) {
		// TODO Auto-generated method stub
		ArrayList<Row> sheetValues = new ArrayList<Row>();
		for(PsiType request : allPsiRequests){
			sheetValues.add(writeDataRow(request.inspectionCode,request.fourteenDayGuarantee,request.PSIStatus));
		}
		return sheetValues;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "PSI";
	}

	public Row writeDataRow(String inspectionCode, String fourteenDayGuarantee, String PSIStatus){
		Row sheetRow = new Row();
		sheetRow.setData("InspectionCode", inspectionCode);
		sheetRow.setData("FourteenDayGuarantee", fourteenDayGuarantee);
		sheetRow.setData("PSIStatus", PSIStatus);
		return sheetRow;
	}

	@Override
	public String[] getHeaders() {
		// TODO Auto-generated method stub
		Row sheetRow = new Row();
		sheetRow.setData("InspectionCode", "");
		sheetRow.setData("FourteenDayGuarantee", "");
		sheetRow.setData("PSIStatus", "");
		return sheetRow.getHeaders();
	}
	@Override
	public int getRequestedRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	protected void addItem(int index) {
		// TODO Auto-generated method stub
		allPsiRequests.add(index, new PsiType(
				(String) inspectionCodeComboBox.getSelectedItem(),
				(String) fourteenDayGuaranteeComboBox.getSelectedItem(),
				(String) psiStatusComboBox.getSelectedItem()
				));
	}

}
