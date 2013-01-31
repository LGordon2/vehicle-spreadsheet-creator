package ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import classes.Constants;
import classes.Row;
import classes.SheetPanel;
import database.DatabaseConnection;

public class RegisterPanel extends SheetPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private NumberTextField saleNumber;
	private NumberTextField sellerNumber;
	private NumberTextField milesRangeLow;
	private NumberTextField milesRangeHigh;
	private NumberTextField vehicleCount;
	private NumberTextField saleYear;
	private JCheckBox chckbxNewCheckBox;
	private JLabel lblInteriorColor;
	private JTextField interiorColor;
	private JTextField bodyColor;
	private JLabel lblBodyColor;
	private JComboBox<String> titleComboBox;
	private JLabel lblTitle;
	private JLabel lblRegisterType;
	private JComboBox<String> registerType;
	private Set<String> entryNumbers;

	/**
	 * Create the panel.
	 */
	public RegisterPanel() {
		this.entryNumbers = new LinkedHashSet<String>();

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		JLabel lblVehicleCount = new JLabel("Vehicle Count");
		GridBagConstraints gbc_lblVehicleCount = new GridBagConstraints();
		gbc_lblVehicleCount.insets = new Insets(0, 0, 5, 5);
		gbc_lblVehicleCount.anchor = GridBagConstraints.EAST;
		gbc_lblVehicleCount.gridx = 0;
		gbc_lblVehicleCount.gridy = 0;
		add(lblVehicleCount, gbc_lblVehicleCount);

		vehicleCount = new NumberTextField();
		vehicleCount.setText("0");
		vehicleCount.setColumns(3);

		GridBagConstraints gbc_vehicleCount = new GridBagConstraints();
		gbc_vehicleCount.fill = GridBagConstraints.HORIZONTAL;
		gbc_vehicleCount.insets = new Insets(0, 0, 5, 5);
		gbc_vehicleCount.gridx = 1;
		gbc_vehicleCount.gridy = 0;
		add(vehicleCount, gbc_vehicleCount);

		lblInteriorColor = new JLabel("Interior Color");

		GridBagConstraints gbc_lblInteriorColor = new GridBagConstraints();
		gbc_lblInteriorColor.anchor = GridBagConstraints.EAST;
		gbc_lblInteriorColor.insets = new Insets(0, 0, 5, 5);
		gbc_lblInteriorColor.gridx = 3;
		gbc_lblInteriorColor.gridy = 0;
		add(lblInteriorColor, gbc_lblInteriorColor);

		interiorColor = new JTextField();

		GridBagConstraints gbc_interiorColor = new GridBagConstraints();
		gbc_interiorColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_interiorColor.insets = new Insets(0, 0, 5, 5);
		gbc_interiorColor.gridx = 4;
		gbc_interiorColor.gridy = 0;
		add(interiorColor, gbc_interiorColor);
		interiorColor.setColumns(10);

		JLabel lblSaleNumber = new JLabel("Sale Number");
		GridBagConstraints gbc_lblSaleNumber = new GridBagConstraints();
		gbc_lblSaleNumber.anchor = GridBagConstraints.EAST;
		gbc_lblSaleNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblSaleNumber.gridx = 0;
		gbc_lblSaleNumber.gridy = 1;
		add(lblSaleNumber, gbc_lblSaleNumber);
		lblSaleNumber.setLabelFor(saleNumber);

		saleNumber = new NumberTextField();
		saleNumber.setText("1");

		GridBagConstraints gbc_saleNumber = new GridBagConstraints();
		gbc_saleNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_saleNumber.insets = new Insets(0, 0, 5, 5);
		gbc_saleNumber.gridx = 1;
		gbc_saleNumber.gridy = 1;
		add(saleNumber, gbc_saleNumber);
		saleNumber.setColumns(10);

		lblBodyColor = new JLabel("Body Color");

		GridBagConstraints gbc_lblBodyColor = new GridBagConstraints();
		gbc_lblBodyColor.insets = new Insets(0, 0, 5, 5);
		gbc_lblBodyColor.anchor = GridBagConstraints.EAST;
		gbc_lblBodyColor.gridx = 3;
		gbc_lblBodyColor.gridy = 1;
		add(lblBodyColor, gbc_lblBodyColor);

		bodyColor = new JTextField();

		GridBagConstraints gbc_bodyColor = new GridBagConstraints();
		gbc_bodyColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_bodyColor.insets = new Insets(0, 0, 5, 5);
		gbc_bodyColor.gridx = 4;
		gbc_bodyColor.gridy = 1;
		add(bodyColor, gbc_bodyColor);
		bodyColor.setColumns(10);

		JLabel lblSaleYear = new JLabel("Sale Year");
		GridBagConstraints gbc_lblSaleYear = new GridBagConstraints();
		gbc_lblSaleYear.anchor = GridBagConstraints.EAST;
		gbc_lblSaleYear.insets = new Insets(0, 0, 5, 5);
		gbc_lblSaleYear.gridx = 0;
		gbc_lblSaleYear.gridy = 2;
		add(lblSaleYear, gbc_lblSaleYear);

		Calendar c = Calendar.getInstance();
		c.get(Calendar.YEAR);
		SimpleDateFormat s = new SimpleDateFormat("yyyy");
		String currentYear = s.format(c.getTime());
		saleYear = new NumberTextField();
		saleYear.setText(currentYear);
		GridBagConstraints gbc_saleYear = new GridBagConstraints();
		gbc_saleYear.fill = GridBagConstraints.HORIZONTAL;
		gbc_saleYear.insets = new Insets(0, 0, 5, 5);
		gbc_saleYear.gridx = 1;
		gbc_saleYear.gridy = 2;
		add(saleYear, gbc_saleYear);
		saleYear.setColumns(10);

		lblTitle = new JLabel("Title");

		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.anchor = GridBagConstraints.EAST;
		gbc_lblTitle.gridx = 3;
		gbc_lblTitle.gridy = 2;
		add(lblTitle, gbc_lblTitle);

		titleComboBox = new JComboBox<String>();

		titleComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"X"}));
		GridBagConstraints gbc_titleComboBox = new GridBagConstraints();
		gbc_titleComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_titleComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_titleComboBox.gridx = 4;
		gbc_titleComboBox.gridy = 2;
		add(titleComboBox, gbc_titleComboBox);


		JLabel lblSellerNumber = new JLabel("Seller Number");

		GridBagConstraints gbc_lblSellerNumber = new GridBagConstraints();
		gbc_lblSellerNumber.anchor = GridBagConstraints.EAST;
		gbc_lblSellerNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblSellerNumber.gridx = 0;
		gbc_lblSellerNumber.gridy = 3;
		add(lblSellerNumber, gbc_lblSellerNumber);

		//Set up additional fields.
		this.addAdditionalField(lblSellerNumber);

		sellerNumber = new NumberTextField();

		GridBagConstraints gbc_dealerNumber = new GridBagConstraints();
		gbc_dealerNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_dealerNumber.insets = new Insets(0, 0, 5, 5);
		gbc_dealerNumber.gridx = 1;
		gbc_dealerNumber.gridy = 3;
		add(sellerNumber, gbc_dealerNumber);
		sellerNumber.setColumns(10);
		this.addAdditionalField(sellerNumber);

		lblRegisterType = new JLabel("Register Type");
		GridBagConstraints gbc_lblRegisterType = new GridBagConstraints();
		gbc_lblRegisterType.anchor = GridBagConstraints.EAST;
		gbc_lblRegisterType.insets = new Insets(0, 0, 5, 5);
		gbc_lblRegisterType.gridx = 3;
		gbc_lblRegisterType.gridy = 3;
		add(lblRegisterType, gbc_lblRegisterType);

		registerType = new JComboBox<String>();
		registerType.setModel(new DefaultComboBoxModel<String>(new String[] {"REGIST", "RECON1", "AT_AUCTION"}));
		GridBagConstraints gbc_registerType = new GridBagConstraints();
		gbc_registerType.insets = new Insets(0, 0, 5, 5);
		gbc_registerType.fill = GridBagConstraints.HORIZONTAL;
		gbc_registerType.gridx = 4;
		gbc_registerType.gridy = 3;
		add(registerType, gbc_registerType);


		JLabel lblMiles = new JLabel("Miles Range");
		GridBagConstraints gbc_lblMiles = new GridBagConstraints();
		gbc_lblMiles.anchor = GridBagConstraints.EAST;
		gbc_lblMiles.insets = new Insets(0, 0, 5, 5);
		gbc_lblMiles.gridx = 0;
		gbc_lblMiles.gridy = 4;
		add(lblMiles, gbc_lblMiles);

		milesRangeLow = new NumberTextField();
		GridBagConstraints gbc_milesRangeLow = new GridBagConstraints();
		gbc_milesRangeLow.fill = GridBagConstraints.HORIZONTAL;
		gbc_milesRangeLow.insets = new Insets(0, 0, 5, 5);
		gbc_milesRangeLow.gridx = 1;
		gbc_milesRangeLow.gridy = 4;
		add(milesRangeLow, gbc_milesRangeLow);
		milesRangeLow.setColumns(10);

		JLabel lblTo = new JLabel("to");
		GridBagConstraints gbc_lblTo = new GridBagConstraints();
		gbc_lblTo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTo.anchor = GridBagConstraints.EAST;
		gbc_lblTo.gridx = 2;
		gbc_lblTo.gridy = 4;
		add(lblTo, gbc_lblTo);

		milesRangeHigh = new NumberTextField();
		GridBagConstraints gbc_milesRangeHigh = new GridBagConstraints();
		gbc_milesRangeHigh.insets = new Insets(0, 0, 5, 5);
		gbc_milesRangeHigh.fill = GridBagConstraints.HORIZONTAL;
		gbc_milesRangeHigh.gridx = 3;
		gbc_milesRangeHigh.gridy = 4;
		add(milesRangeHigh, gbc_milesRangeHigh);
		milesRangeHigh.setColumns(10);

		chckbxNewCheckBox = new JCheckBox("Set additional fields");
		chckbxNewCheckBox.addActionListener(this);
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.anchor = GridBagConstraints.NORTH;
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 0;
		gbc_chckbxNewCheckBox.gridy = 5;
		add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);

		this.addAdditionalField(lblInteriorColor);
		this.addAdditionalField(interiorColor);
		this.addAdditionalField(lblBodyColor);
		this.addAdditionalField(bodyColor);
		this.addAdditionalField(lblTitle);
		this.addAdditionalField(titleComboBox);
		this.addAdditionalField(lblRegisterType);
		this.addAdditionalField(registerType);
		initializeAdditionalFields();
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Register";
	}

	private class QueryDBTask implements Runnable{

		private int laneNumber;
		private int runNumber;
		private int saleNumber;
		private int saleYear;

		public QueryDBTask(int laneNumber, int runNumber, int saleNumber,
				int saleYear) {
			// TODO Auto-generated constructor stub
			this.laneNumber = laneNumber;
			this.runNumber = runNumber;
			this.saleNumber = saleNumber;
			this.saleYear = saleYear;
		}

		@Override
		public void run() {
			try {
				if(RegisterPanel.this.entryNumbers.contains(String.format("%1$02d%2$04d", laneNumber, runNumber)))
					return;
				Connection conn = null;
				Properties connectionProps = new Properties();
				connectionProps.put("user", "lgordon");
				connectionProps.put("password", "orasi101");

				conn = DriverManager.getConnection(DatabaseConnection.getInstance().url, connectionProps);
				Statement stmt = conn.createStatement();
				ResultSet rs;
				rs = stmt.executeQuery("select count(*) from macsf.pfvehicle where srun#="+runNumber+" and slane#="+laneNumber+" and ssleyr="+saleYear+" and ssale#="+saleNumber);
				rs.next();
				if(rs.getInt(1)==0){
					synchronized(this){
						RegisterPanel.this.entryNumbers.add(String.format("%1$02d%2$04d", laneNumber, runNumber));
						System.out.println("Entry numbers size: "+RegisterPanel.this.entryNumbers.size());
					}
				}
				notifyPanel();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//System.err.println("DB connection issue.");
			}

		}

	}

	@Override
	protected ArrayList<Row> getSheetValues() {
		// TODO Auto-generated method stub
		ArrayList<Row> sheetValues = new ArrayList<Row>();
		//if(entryNumbers.size()<1)
		this.entryNumbers = getNextUnregisteredVehicles(vehicleCount.getNumber(),this.entryNumbers);
		System.out.println("****Entry numbers size: "+this.entryNumbers.size());
		Iterator<String> itr = this.entryNumbers.iterator();

		for(int i=0;i<Integer.valueOf(vehicleCount.getText());i++){
			Row sheetRow = new Row();
			sheetRow.setData("EntryNumber", itr.next());
			sheetRow.setData("SaleNumber", saleNumber.getText());
			sheetRow.setData("SaleYear", saleYear.getText());
			sheetRow.setData("VIN", "");
			sheetRow.setData("RegisterType", "REGIST");
			sheetRow.setData("SBLU", "");
			sheetRow.setData("WorkOrderNumber", "");
			sheetRow.setData("SellerNumber", sellerNumber.getText());
			sheetRow.setData("Miles", String.valueOf(this.getRandomNumberInRange(milesRangeLow, milesRangeHigh)));
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


	@Override
	protected ArrayList<Row> addAdditionalRows(int rowCount) {
		// TODO Auto-generated method stub
		ArrayList<Row> sheetValues = new ArrayList<Row>();
		this.entryNumbers = getNextUnregisteredVehicles(rowCount+vehicleCount.getNumber(),this.entryNumbers);
		System.out.println("****Entry numbers size: "+this.entryNumbers.size());
		Iterator<String> itr = this.entryNumbers.iterator();
		for(int i=0;i<this.entryNumbers.size()-rowCount;i++){
			itr.next();
		}

		for(int i=0;i<rowCount;i++){
			Row sheetRow = new Row();
			sheetRow.setData("EntryNumber", itr.next());
			sheetRow.setData("SaleNumber", saleNumber.getText());
			sheetRow.setData("SaleYear", saleYear.getText());
			sheetRow.setData("VIN", "");
			sheetRow.setData("RegisterType", "REGIST");
			sheetRow.setData("SBLU", "");
			sheetRow.setData("WorkOrderNumber", "");
			sheetRow.setData("SellerNumber", sellerNumber.getText());
			sheetRow.setData("Miles", String.valueOf(this.getRandomNumberInRange(milesRangeLow, milesRangeHigh)));
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

	@Override
	public String[] getHeaders() {
		// TODO Auto-generated method stub
		return new String[]{"EntryNumber", "SaleYear", "RegisterType", "SBLU", "WorkOrderNumber", "VIN", "SaleNumber",
				"SellerNumber", "Miles", "BU", "Transmission", "Title", "InteriorColor", "Color", "Offsite",
				"LocationName", "Address1", "Address2", "City", "State", "Country", "ZipCode", "ContactName",
				"Phone", "Fax", "VerifyDatabase", "UploadToGoogle"};
	}

	private synchronized Set<String> findUnregisteredVehiclesEntryNumbers(Connection conn, int saleNumber, int saleYear, int requestedCount, Set<String> entryNumbers){
		if(entryNumbers==null)
			this.entryNumbers.clear();
		if(requestedCount<1)
			return this.entryNumbers;
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(Constants.MAX_THREAD_COUNT, Constants.MAX_THREAD_COUNT, 5, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>(), new ThreadPoolExecutor.DiscardPolicy());
		for(int laneNumber=1;laneNumber<=Constants.LARGEST_LANE_NUMBER;laneNumber++){
			for(int runNumber=1;runNumber<=Constants.LARGEST_RUN_NUMBER;runNumber++){
				threadPool.execute(new QueryDBTask(laneNumber, runNumber, saleNumber, saleYear));
				if(this.entryNumbers.size()>=requestedCount){
					threadPool.shutdownNow();
					return this.entryNumbers;
				}
			}
		}
		while(this.entryNumbers.size()<requestedCount){
			try{
				MainApp.setProgressBarVisible("EntryNumbers",true);
				MainApp.setProgress("EntryNumbers", this.entryNumbers.size()*100/requestedCount, "Entry numbers: "+this.entryNumbers.size()+"/"+requestedCount);
				wait();
			}catch(InterruptedException e){}
		}
		MainApp.setProgressBarVisible("EntryNumbers",false);
		MainApp.setProgress("EntryNumbers", 0, "");
		threadPool.shutdownNow();
		return this.entryNumbers;
	}

	public synchronized void notifyPanel(){
		notifyAll();
	}


	private Set<String> getNextUnregisteredVehicles(int requestedCount, Set<String> entryNumbers){
		Connection conn = DatabaseConnection.getInstance().getConnection();
		try {
			Statement stmt = conn.createStatement();
			if(saleNumber.getText().equals("")){
				ResultSet rs = stmt.executeQuery("select slane#, srun#, ssale# from macsf.pfvehicle where slane# > 0 and srun# > 100 and ssale# < 10");
				rs.next();
				saleNumber.setText(rs.getString("ssale#"));
			}
			return findUnregisteredVehiclesEntryNumbers(conn, saleNumber.getNumber(), saleYear.getNumber(), requestedCount, entryNumbers);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;

	}
}
