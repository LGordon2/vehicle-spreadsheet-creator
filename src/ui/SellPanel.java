package ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JLabel;

import classes.Row;
import classes.SheetPanel;

public class SellPanel extends SheetPanel {
	public SellPanel() {
		checkBoxes = new ArrayList<JCheckBox>();

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 49, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		JLabel lblVehicleCount = new JLabel("Vehicle Count");
		GridBagConstraints gbc_lblVehicleCount = new GridBagConstraints();
		gbc_lblVehicleCount.insets = new Insets(0, 0, 5, 5);
		gbc_lblVehicleCount.anchor = GridBagConstraints.EAST;
		gbc_lblVehicleCount.gridx = 0;
		gbc_lblVehicleCount.gridy = 0;
		add(lblVehicleCount, gbc_lblVehicleCount);

		vehicleCount = new NumberTextField();
		GridBagConstraints gbc_vehicleCount = new GridBagConstraints();
		gbc_vehicleCount.fill = GridBagConstraints.HORIZONTAL;
		gbc_vehicleCount.insets = new Insets(0, 0, 5, 5);
		gbc_vehicleCount.gridx = 1;
		gbc_vehicleCount.gridy = 0;
		add(vehicleCount, gbc_vehicleCount);
		vehicleCount.setColumns(10);

		JLabel lblBuyerNumber = new JLabel("Buyer Number");

		GridBagConstraints gbc_lblBuyerNumber = new GridBagConstraints();
		gbc_lblBuyerNumber.anchor = GridBagConstraints.EAST;
		gbc_lblBuyerNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblBuyerNumber.gridx = 0;
		gbc_lblBuyerNumber.gridy = 1;
		add(lblBuyerNumber, gbc_lblBuyerNumber);

		buyerNumber = new NumberTextField();

		GridBagConstraints gbc_buyerNumber = new GridBagConstraints();
		gbc_buyerNumber.insets = new Insets(0, 0, 5, 5);
		gbc_buyerNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_buyerNumber.gridx = 1;
		gbc_buyerNumber.gridy = 1;
		add(buyerNumber, gbc_buyerNumber);
		buyerNumber.setColumns(10);

		JLabel lblBuyerId = new JLabel("Buyer Id");

		GridBagConstraints gbc_lblBuyerId = new GridBagConstraints();
		gbc_lblBuyerId.anchor = GridBagConstraints.EAST;
		gbc_lblBuyerId.insets = new Insets(0, 0, 5, 5);
		gbc_lblBuyerId.gridx = 2;
		gbc_lblBuyerId.gridy = 1;
		add(lblBuyerId, gbc_lblBuyerId);

		buyerId = new NumberTextField();
		buyerId.setText("00");

		GridBagConstraints gbc_buyerId = new GridBagConstraints();
		gbc_buyerId.insets = new Insets(0, 0, 5, 5);
		gbc_buyerId.fill = GridBagConstraints.HORIZONTAL;
		gbc_buyerId.gridx = 3;
		gbc_buyerId.gridy = 1;
		add(buyerId, gbc_buyerId);
		buyerId.setColumns(10);

		JLabel lblSalePrice = new JLabel("Sale Price Range");
		GridBagConstraints gbc_lblSalePrice = new GridBagConstraints();
		gbc_lblSalePrice.anchor = GridBagConstraints.EAST;
		gbc_lblSalePrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblSalePrice.gridx = 0;
		gbc_lblSalePrice.gridy = 2;
		add(lblSalePrice, gbc_lblSalePrice);

		salePriceLow = new NumberTextField();
		GridBagConstraints gbc_salePriceLow = new GridBagConstraints();
		gbc_salePriceLow.insets = new Insets(0, 0, 5, 5);
		gbc_salePriceLow.fill = GridBagConstraints.HORIZONTAL;
		gbc_salePriceLow.gridx = 1;
		gbc_salePriceLow.gridy = 2;
		add(salePriceLow, gbc_salePriceLow);
		salePriceLow.setColumns(10);

		JLabel lblTo = new JLabel("to");
		GridBagConstraints gbc_lblTo = new GridBagConstraints();
		gbc_lblTo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTo.gridx = 2;
		gbc_lblTo.gridy = 2;
		add(lblTo, gbc_lblTo);

		salePriceHigh = new NumberTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 2;
		add(salePriceHigh, gbc_textField);
		salePriceHigh.setColumns(10);

		JCheckBox chckbxVerifyqlm = new JCheckBox("VerifyQLM");
		GridBagConstraints gbc_chckbxVerifyqlm = new GridBagConstraints();
		gbc_chckbxVerifyqlm.anchor = GridBagConstraints.WEST;
		gbc_chckbxVerifyqlm.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxVerifyqlm.gridx = 0;
		gbc_chckbxVerifyqlm.gridy = 4;
		add(chckbxVerifyqlm, gbc_chckbxVerifyqlm);
		checkBoxes.add(chckbxVerifyqlm);

		JCheckBox chckbxVerifyqtm = new JCheckBox("VerifyQTM");
		GridBagConstraints gbc_chckbxVerifyqtm = new GridBagConstraints();
		gbc_chckbxVerifyqtm.anchor = GridBagConstraints.WEST;
		gbc_chckbxVerifyqtm.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxVerifyqtm.gridx = 0;
		gbc_chckbxVerifyqtm.gridy = 5;
		add(chckbxVerifyqtm, gbc_chckbxVerifyqtm);
		checkBoxes.add(chckbxVerifyqtm);

		JCheckBox chckbxVerifyods = new JCheckBox("VerifyODS");
		GridBagConstraints gbc_chckbxVerifyods = new GridBagConstraints();
		gbc_chckbxVerifyods.anchor = GridBagConstraints.WEST;
		gbc_chckbxVerifyods.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxVerifyods.gridx = 0;
		gbc_chckbxVerifyods.gridy = 6;
		add(chckbxVerifyods, gbc_chckbxVerifyods);
		checkBoxes.add(chckbxVerifyods);

		JCheckBox chckbxSetAdditionalFields = new JCheckBox("Set additional fields");
		chckbxSetAdditionalFields.addActionListener(this);
		GridBagConstraints gbc_chckbxSetAdditionalFields = new GridBagConstraints();
		gbc_chckbxSetAdditionalFields.anchor = GridBagConstraints.WEST;
		gbc_chckbxSetAdditionalFields.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxSetAdditionalFields.gridx = 0;
		gbc_chckbxSetAdditionalFields.gridy = 7;
		add(chckbxSetAdditionalFields, gbc_chckbxSetAdditionalFields);

		//Set up additional fields.
		this.addAdditionalField(lblBuyerId);
		this.addAdditionalField(buyerNumber);
		this.addAdditionalField(lblBuyerNumber);
		this.addAdditionalField(buyerId);
		this.initializeAdditionalFields();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 3093256490043231886L;
	private NumberTextField vehicleCount;
	private NumberTextField buyerNumber;
	private NumberTextField salePriceLow;
	private NumberTextField buyerId;
	private NumberTextField salePriceHigh;
	private ArrayList<JCheckBox> checkBoxes;

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Sell";
	}

	@Override
	protected ArrayList<Row> getSheetValues() {
		// TODO Auto-generated method stub
		ArrayList<Row> sheetValues = new ArrayList<Row>();
		for(int i=0;i<Integer.valueOf(vehicleCount.getText());i++){
			Row sheetRow = new Row();
			sheetRow.setData("BuyerNumber", buyerNumber.getText());
			sheetRow.setData("BuyerID", buyerId.getText().equals("")?"00":buyerId.getText());
			sheetRow.setData("SalePrice", String.valueOf(this.getRandomNumberInRange(salePriceLow, salePriceHigh)));
			sheetRow.setData("TimeCreated", "");
			for(JCheckBox c : checkBoxes){
				sheetRow.setData(c.getText(), c.isSelected()?"Y":"N");
			}
			sheetValues.add(sheetRow);
		}
		return sheetValues;
	}

	@Override
	public ArrayList<Row> addAdditionalRows(int rowCount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getHeaders() {
		// TODO Auto-generated method stub
		Row sheetRow = new Row();
		sheetRow.setData("BuyerNumber", buyerNumber.getText());
		sheetRow.setData("BuyerID", buyerId.getText());
		sheetRow.setData("SalePrice", salePriceLow.getText());
		sheetRow.setData("TimeCreated", "");
		for(JCheckBox c : checkBoxes){
			sheetRow.setData(c.getText(), c.isSelected()?"Y":"N");
		}
		return sheetRow.getHeaders();
	}

}
