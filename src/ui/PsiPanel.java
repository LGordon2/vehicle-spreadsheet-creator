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
		allPsiRequests = new ArrayList<PsiType>();
	}

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
	@Override
	protected Object getDataType() {
		// TODO Auto-generated method stub
		return null;
	}

}
