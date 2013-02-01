package ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;

import classes.Row;
import classes.SheetPanel;

public class PsiPanel extends SheetPanel {
	private JList<String> vehicleList;
	private DefaultListModel<String> listModel;
	private JButton btnRemoveVehicle;
	private JComboBox<String> inspectionCodeComboBox;
	private JComboBox<String> fourteenDayGuaranteeComboBox;
	private JComboBox<String> psiStatusComboBox;
	private ArrayList<JComboBox<String> > allComboBoxes;

	public PsiPanel() {
		allComboBoxes = new ArrayList<JComboBox<String> >();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		inspectionCodeComboBox = new JComboBox<String>();
		allComboBoxes.add(inspectionCodeComboBox);
		inspectionCodeComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Inspection Code", "-----------------", "PSI01", "PSI02", "PSI03"}));
		GridBagConstraints gbc_inspectionCodeComboBox = new GridBagConstraints();
		gbc_inspectionCodeComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_inspectionCodeComboBox.gridx = 0;
		gbc_inspectionCodeComboBox.gridy = 0;
		add(inspectionCodeComboBox, gbc_inspectionCodeComboBox);
		
		fourteenDayGuaranteeComboBox = new JComboBox<String>();
		allComboBoxes.add(fourteenDayGuaranteeComboBox);
		fourteenDayGuaranteeComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Fourteen Day Guarantee", "-------------------------", "Y", "N"}));
		GridBagConstraints gbc_fourteenDayGuaranteeComboBox = new GridBagConstraints();
		gbc_fourteenDayGuaranteeComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_fourteenDayGuaranteeComboBox.gridx = 1;
		gbc_fourteenDayGuaranteeComboBox.gridy = 0;
		add(fourteenDayGuaranteeComboBox, gbc_fourteenDayGuaranteeComboBox);
		
		psiStatusComboBox = new JComboBox<String>();
		allComboBoxes.add(psiStatusComboBox);
		psiStatusComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"PSI Status", "----------", "Request", "Complete", "Cancel"}));
		GridBagConstraints gbc_psiStatusComboBox = new GridBagConstraints();
		gbc_psiStatusComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_psiStatusComboBox.gridx = 2;
		gbc_psiStatusComboBox.gridy = 0;
		add(psiStatusComboBox, gbc_psiStatusComboBox);
		
		JButton btnAddVehicle = new JButton("Add vehicle");
		btnAddVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Make sure we actually selected a valid value.
				for(JComboBox<String> comboBox : allComboBoxes){
					if(comboBox.getSelectedIndex()<=1)
						return;
				}
				
				int vehicleNumber = listModel.getSize()+1;
				
			    int index = vehicleList.getSelectedIndex(); //get selected index
			    if (index == -1) { //no selection, so insert at beginning
			        index = 0;
			    } else {           //add after the selected item
			        index++;
			    }

			    String outputString = "Vehicle "+vehicleNumber+" -";
				for(JComboBox<String> comboBox : allComboBoxes){
					outputString += " " + comboBox.getSelectedItem();
				}
			    listModel.insertElementAt(outputString, index);

			    //Select the new item and make it visible.
			    vehicleList.setSelectedIndex(index);
			    vehicleList.ensureIndexIsVisible(index);
			    
			    //Make the remove button enabled.
			    btnRemoveVehicle.setEnabled(true);
			}
		});
		GridBagConstraints gbc_btnAddVehicle = new GridBagConstraints();
		gbc_btnAddVehicle.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddVehicle.gridx = 0;
		gbc_btnAddVehicle.gridy = 1;
		add(btnAddVehicle, gbc_btnAddVehicle);
		
		listModel = new DefaultListModel<String>();
		
		btnRemoveVehicle = new JButton("Remove vehicle");
		btnRemoveVehicle.setEnabled(false);
		btnRemoveVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = vehicleList.getSelectedIndex();
				listModel.remove(vehicleList.getSelectedIndex());
				
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
		gbc_btnRemoveVehicle.gridy = 1;
		add(btnRemoveVehicle, gbc_btnRemoveVehicle);
		vehicleList = new JList<String>(listModel);
		GridBagConstraints gbc_vehicleList = new GridBagConstraints();
		gbc_vehicleList.gridwidth = 3;
		gbc_vehicleList.fill = GridBagConstraints.BOTH;
		gbc_vehicleList.gridx = 0;
		gbc_vehicleList.gridy = 2;
		add(vehicleList, gbc_vehicleList);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -3117695920724543684L;

	@Override
	protected ArrayList<Row> addAdditionalRows(int rowCount) {
		// TODO Auto-generated method stub
		ArrayList<Row> sheetValues = new ArrayList<Row>();
		for(int i=0;i<listModel.getSize();i++){
			sheetValues.add(writeDataRow("PSI01","Y","Request"));
		}
		return sheetValues;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "PSI";
	}

	@Override
	protected ArrayList<Row> getSheetValues() {
		// TODO Auto-generated method stub
		ArrayList<Row> sheetValues = new ArrayList<Row>();
		for(int i=0;i<listModel.getSize();i++){
			sheetValues.add(writeDataRow("PSI01","Y","Request"));
		}
		return sheetValues;
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

}
