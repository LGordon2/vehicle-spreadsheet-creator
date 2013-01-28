package ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JTextField;

import classes.Row;

public class RegisterPanel extends SheetPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField saleNumber;
	private NumberTextField dealerNumber;
	private NumberTextField milesRangeLow;
	private NumberTextField milesRangeHigh;
	private JTextField vehicleCount;
	private JTextField saleYear;
	private JTextField startingEntryNumber;

	/**
	 * Create the panel.
	 */
	public RegisterPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
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

		JLabel lblStartingEntryNumber = new JLabel("Starting Entry Number");
		GridBagConstraints gbc_lblStartingEntryNumber = new GridBagConstraints();
		gbc_lblStartingEntryNumber.anchor = GridBagConstraints.EAST;
		gbc_lblStartingEntryNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblStartingEntryNumber.gridx = 0;
		gbc_lblStartingEntryNumber.gridy = 1;
		add(lblStartingEntryNumber, gbc_lblStartingEntryNumber);

		startingEntryNumber = new JTextField();
		GridBagConstraints gbc_startingEntryNumber = new GridBagConstraints();
		gbc_startingEntryNumber.insets = new Insets(0, 0, 5, 5);
		gbc_startingEntryNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_startingEntryNumber.gridx = 1;
		gbc_startingEntryNumber.gridy = 1;
		add(startingEntryNumber, gbc_startingEntryNumber);
		startingEntryNumber.setColumns(10);

		JLabel lblSaleNumber = new JLabel("Sale Number");
		GridBagConstraints gbc_lblSaleNumber = new GridBagConstraints();
		gbc_lblSaleNumber.anchor = GridBagConstraints.EAST;
		gbc_lblSaleNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblSaleNumber.gridx = 0;
		gbc_lblSaleNumber.gridy = 2;
		add(lblSaleNumber, gbc_lblSaleNumber);

		saleNumber = new NumberTextField();

		GridBagConstraints gbc_saleNumber = new GridBagConstraints();
		gbc_saleNumber.anchor = GridBagConstraints.WEST;
		gbc_saleNumber.insets = new Insets(0, 0, 5, 5);
		gbc_saleNumber.gridx = 1;
		gbc_saleNumber.gridy = 2;
		add(saleNumber, gbc_saleNumber);
		saleNumber.setColumns(10);

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
		gbc_saleYear.anchor = GridBagConstraints.WEST;
		gbc_saleYear.insets = new Insets(0, 0, 5, 5);
		gbc_saleYear.gridx = 1;
		gbc_saleYear.gridy = 3;
		add(saleYear, gbc_saleYear);
		saleYear.setColumns(10);

		JLabel lblDealerNumber = new JLabel("Dealer Number");
		GridBagConstraints gbc_lblDealerNumber = new GridBagConstraints();
		gbc_lblDealerNumber.anchor = GridBagConstraints.EAST;
		gbc_lblDealerNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblDealerNumber.gridx = 0;
		gbc_lblDealerNumber.gridy = 4;
		add(lblDealerNumber, gbc_lblDealerNumber);

		dealerNumber = new NumberTextField();
		GridBagConstraints gbc_dealerNumber = new GridBagConstraints();
		gbc_dealerNumber.anchor = GridBagConstraints.WEST;
		gbc_dealerNumber.insets = new Insets(0, 0, 5, 5);
		gbc_dealerNumber.gridx = 1;
		gbc_dealerNumber.gridy = 4;
		add(dealerNumber, gbc_dealerNumber);
		dealerNumber.setColumns(10);

		JLabel lblMiles = new JLabel("Miles Range");
		GridBagConstraints gbc_lblMiles = new GridBagConstraints();
		gbc_lblMiles.anchor = GridBagConstraints.EAST;
		gbc_lblMiles.insets = new Insets(0, 0, 5, 5);
		gbc_lblMiles.gridx = 0;
		gbc_lblMiles.gridy = 5;
		add(lblMiles, gbc_lblMiles);

		milesRangeLow = new NumberTextField();
		GridBagConstraints gbc_milesRangeLow = new GridBagConstraints();
		gbc_milesRangeLow.anchor = GridBagConstraints.WEST;
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
			sheetRow.setData("DealerNumber", dealerNumber.getText());
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
