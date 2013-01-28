package ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import classes.Row;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RegisterPanel extends SheetPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField saleNumber;
	private NumberTextField sellerNumber;
	private NumberTextField milesRangeLow;
	private NumberTextField milesRangeHigh;
	private JTextField vehicleCount;
	private JTextField saleYear;
	private JTextField startingEntryNumber;
	private JCheckBox chckbxNewCheckBox;
	private ArrayList<JComponent> additionalFields;
	private JLabel lblInteriorColor;
	private JTextField interiorColor;
	private JTextField bodyColor;
	private JLabel lblBodyColor;
	private JComboBox titleComboBox;
	private JLabel lblTitle;

	/**
	 * Create the panel.
	 */
	public RegisterPanel() {
		additionalFields = new ArrayList<JComponent>();
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		JLabel lblVehicleCount = new JLabel("Vehicle Count");
		GridBagConstraints gbc_lblVehicleCount = new GridBagConstraints();
		gbc_lblVehicleCount.insets = new Insets(0, 0, 5, 5);
		gbc_lblVehicleCount.anchor = GridBagConstraints.EAST;
		gbc_lblVehicleCount.gridx = 0;
		gbc_lblVehicleCount.gridy = 0;
		add(lblVehicleCount, gbc_lblVehicleCount);

		vehicleCount = new NumberTextField();
		vehicleCount.setColumns(3);

		GridBagConstraints gbc_vehicleCount = new GridBagConstraints();
		gbc_vehicleCount.fill = GridBagConstraints.HORIZONTAL;
		gbc_vehicleCount.insets = new Insets(0, 0, 5, 5);
		gbc_vehicleCount.gridx = 1;
		gbc_vehicleCount.gridy = 0;
		add(vehicleCount, gbc_vehicleCount);
		
		lblInteriorColor = new JLabel("Interior Color");
		additionalFields.add(lblInteriorColor);
		GridBagConstraints gbc_lblInteriorColor = new GridBagConstraints();
		gbc_lblInteriorColor.anchor = GridBagConstraints.EAST;
		gbc_lblInteriorColor.insets = new Insets(0, 0, 5, 5);
		gbc_lblInteriorColor.gridx = 3;
		gbc_lblInteriorColor.gridy = 0;
		add(lblInteriorColor, gbc_lblInteriorColor);
		
		interiorColor = new JTextField();
		additionalFields.add(interiorColor);
		GridBagConstraints gbc_interiorColor = new GridBagConstraints();
		gbc_interiorColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_interiorColor.insets = new Insets(0, 0, 5, 5);
		gbc_interiorColor.gridx = 4;
		gbc_interiorColor.gridy = 0;
		add(interiorColor, gbc_interiorColor);
		interiorColor.setColumns(10);

		JLabel lblStartingEntryNumber = new JLabel("Starting Entry Number");
		GridBagConstraints gbc_lblStartingEntryNumber = new GridBagConstraints();
		gbc_lblStartingEntryNumber.anchor = GridBagConstraints.EAST;
		gbc_lblStartingEntryNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblStartingEntryNumber.gridx = 0;
		gbc_lblStartingEntryNumber.gridy = 1;
		add(lblStartingEntryNumber, gbc_lblStartingEntryNumber);

		startingEntryNumber = new JTextField();
		GridBagConstraints gbc_startingEntryNumber = new GridBagConstraints();
		gbc_startingEntryNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_startingEntryNumber.insets = new Insets(0, 0, 5, 5);
		gbc_startingEntryNumber.gridx = 1;
		gbc_startingEntryNumber.gridy = 1;
		add(startingEntryNumber, gbc_startingEntryNumber);
		startingEntryNumber.setColumns(10);
		
		lblBodyColor = new JLabel("Body Color");
		additionalFields.add(lblBodyColor);
		GridBagConstraints gbc_lblBodyColor = new GridBagConstraints();
		gbc_lblBodyColor.insets = new Insets(0, 0, 5, 5);
		gbc_lblBodyColor.anchor = GridBagConstraints.EAST;
		gbc_lblBodyColor.gridx = 3;
		gbc_lblBodyColor.gridy = 1;
		add(lblBodyColor, gbc_lblBodyColor);
		
		bodyColor = new JTextField();
		additionalFields.add(bodyColor);
		GridBagConstraints gbc_bodyColor = new GridBagConstraints();
		gbc_bodyColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_bodyColor.insets = new Insets(0, 0, 5, 5);
		gbc_bodyColor.gridx = 4;
		gbc_bodyColor.gridy = 1;
		add(bodyColor, gbc_bodyColor);
		bodyColor.setColumns(10);

		JLabel lblSaleNumber = new JLabel("Sale Number");
		GridBagConstraints gbc_lblSaleNumber = new GridBagConstraints();
		gbc_lblSaleNumber.anchor = GridBagConstraints.EAST;
		gbc_lblSaleNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblSaleNumber.gridx = 0;
		gbc_lblSaleNumber.gridy = 2;
		add(lblSaleNumber, gbc_lblSaleNumber);

		saleNumber = new NumberTextField();
		lblSaleNumber.setLabelFor(saleNumber);

		GridBagConstraints gbc_saleNumber = new GridBagConstraints();
		gbc_saleNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_saleNumber.insets = new Insets(0, 0, 5, 5);
		gbc_saleNumber.gridx = 1;
		gbc_saleNumber.gridy = 2;
		add(saleNumber, gbc_saleNumber);
		saleNumber.setColumns(10);
		
		lblTitle = new JLabel("Title");
		additionalFields.add(lblTitle);
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.anchor = GridBagConstraints.EAST;
		gbc_lblTitle.gridx = 3;
		gbc_lblTitle.gridy = 2;
		add(lblTitle, gbc_lblTitle);
		
		titleComboBox = new JComboBox();
		additionalFields.add(titleComboBox);
		titleComboBox.setModel(new DefaultComboBoxModel(new String[] {"X"}));
		GridBagConstraints gbc_titleComboBox = new GridBagConstraints();
		gbc_titleComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_titleComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_titleComboBox.gridx = 4;
		gbc_titleComboBox.gridy = 2;
		add(titleComboBox, gbc_titleComboBox);

		JLabel lblSaleYear = new JLabel("Sale Year");
		GridBagConstraints gbc_lblSaleYear = new GridBagConstraints();
		gbc_lblSaleYear.anchor = GridBagConstraints.EAST;
		gbc_lblSaleYear.insets = new Insets(0, 0, 5, 5);
		gbc_lblSaleYear.gridx = 0;
		gbc_lblSaleYear.gridy = 3;
		add(lblSaleYear, gbc_lblSaleYear);

		saleYear = new JTextField();
		Calendar c = Calendar.getInstance();
		c.get(Calendar.YEAR);
		SimpleDateFormat s = new SimpleDateFormat("yyyy");
		String currentYear = s.format(c.getTime());
		saleYear.setText(currentYear);
		GridBagConstraints gbc_saleYear = new GridBagConstraints();
		gbc_saleYear.fill = GridBagConstraints.HORIZONTAL;
		gbc_saleYear.insets = new Insets(0, 0, 5, 5);
		gbc_saleYear.gridx = 1;
		gbc_saleYear.gridy = 3;
		add(saleYear, gbc_saleYear);
		saleYear.setColumns(10);

		JLabel lblSellerNumber = new JLabel("Seller Number");
		additionalFields.add(lblSellerNumber);
		GridBagConstraints gbc_lblSellerNumber = new GridBagConstraints();
		gbc_lblSellerNumber.anchor = GridBagConstraints.EAST;
		gbc_lblSellerNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblSellerNumber.gridx = 0;
		gbc_lblSellerNumber.gridy = 4;
		add(lblSellerNumber, gbc_lblSellerNumber);

		sellerNumber = new NumberTextField();
		additionalFields.add(sellerNumber);
		GridBagConstraints gbc_dealerNumber = new GridBagConstraints();
		gbc_dealerNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_dealerNumber.insets = new Insets(0, 0, 5, 5);
		gbc_dealerNumber.gridx = 1;
		gbc_dealerNumber.gridy = 4;
		add(sellerNumber, gbc_dealerNumber);
		sellerNumber.setColumns(10);

		JLabel lblMiles = new JLabel("Miles Range");
		GridBagConstraints gbc_lblMiles = new GridBagConstraints();
		gbc_lblMiles.anchor = GridBagConstraints.EAST;
		gbc_lblMiles.insets = new Insets(0, 0, 5, 5);
		gbc_lblMiles.gridx = 0;
		gbc_lblMiles.gridy = 5;
		add(lblMiles, gbc_lblMiles);

		milesRangeLow = new NumberTextField();
		GridBagConstraints gbc_milesRangeLow = new GridBagConstraints();
		gbc_milesRangeLow.fill = GridBagConstraints.HORIZONTAL;
		gbc_milesRangeLow.insets = new Insets(0, 0, 5, 5);
		gbc_milesRangeLow.gridx = 1;
		gbc_milesRangeLow.gridy = 5;
		add(milesRangeLow, gbc_milesRangeLow);
		milesRangeLow.setColumns(10);

		JLabel lblTo = new JLabel("to");
		GridBagConstraints gbc_lblTo = new GridBagConstraints();
		gbc_lblTo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTo.anchor = GridBagConstraints.EAST;
		gbc_lblTo.gridx = 2;
		gbc_lblTo.gridy = 5;
		add(lblTo, gbc_lblTo);

		milesRangeHigh = new NumberTextField();
		GridBagConstraints gbc_milesRangeHigh = new GridBagConstraints();
		gbc_milesRangeHigh.insets = new Insets(0, 0, 5, 5);
		gbc_milesRangeHigh.fill = GridBagConstraints.HORIZONTAL;
		gbc_milesRangeHigh.gridx = 3;
		gbc_milesRangeHigh.gridy = 5;
		add(milesRangeHigh, gbc_milesRangeHigh);
		milesRangeHigh.setColumns(10);
		
		chckbxNewCheckBox = new JCheckBox("Set additional fields");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected()){
					for(JComponent field : additionalFields)
						field.setVisible(true);
				}else{
					for(JComponent field : additionalFields)
						field.setVisible(false);
				}
			}
		});
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.anchor = GridBagConstraints.NORTH;
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxNewCheckBox.gridx = 0;
		gbc_chckbxNewCheckBox.gridy = 6;
		add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);

		initializeAdditionalFields();
	}

	private void initializeAdditionalFields() {
		// TODO Auto-generated method stub
		for(JComponent field : additionalFields){
			field.setVisible(false);
		}
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Register";
	}

	@Override
	protected ArrayList<Row> getSheetValues() {
		// TODO Auto-generated method stub
		ArrayList<Row> sheetValues = new ArrayList<Row>();

		for(int i=0;i<Integer.valueOf(vehicleCount.getText());i++){
			Row sheetRow = new Row();
			sheetRow.setData("EntryNumber", String.format( "0%1d", Integer.valueOf(startingEntryNumber.getText())+i ) );
			sheetRow.setData("SaleYear", saleYear.getText());
			sheetRow.setData("RegisterType", "REGIST");
			sheetRow.setData("SBLU", "");
			sheetRow.setData("WorkOrderNumber", "");
			sheetRow.setData("VIN", "");
			sheetRow.setData("SaleNumber", saleNumber.getText());
			sheetRow.setData("SellerNumber", sellerNumber.getText());
			sheetRow.setData("Miles", getRandomMileage());
			sheetRow.setData("BU", "I");
			sheetRow.setData("Transmission", "A");
			sheetRow.setData("Title", "X");
			sheetRow.setData("InteriorColor", "GRN");
			sheetRow.setData("Color", "BLUE");
			sheetRow.setData("Offsite", "N");
			sheetRow.setData("LocationName", "");
			sheetRow.setData("Address1", "");
			sheetRow.setData("Address2", "");
			sheetRow.setData("City", "");
			sheetRow.setData("State", "");
			sheetRow.setData("Country", "");
			sheetRow.setData("ZipCode", "");
			sheetRow.setData("ContactName", "");
			sheetRow.setData("Phone", "");
			sheetRow.setData("Fax", "");
			sheetRow.setData("VerifyDatabase", "");
			sheetRow.setData("UploadToGoogle", "N");
			sheetValues.add(sheetRow);
		}

		return sheetValues;
	}

	private String getRandomMileage() {
		// TODO Auto-generated method stub
		Random rng = new Random();
		return String.valueOf(rng.nextInt(Integer.valueOf(milesRangeHigh.getText())-Integer.valueOf(milesRangeLow.getText()))+Integer.valueOf(milesRangeLow.getText()));
	}

}
