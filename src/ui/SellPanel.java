package ui;

import java.util.ArrayList;

import classes.Row;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;

public class SellPanel extends SheetPanel {
	public SellPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblVehicleCount = new JLabel("Vehicle Count");
		GridBagConstraints gbc_lblVehicleCount = new GridBagConstraints();
		gbc_lblVehicleCount.insets = new Insets(0, 0, 0, 5);
		gbc_lblVehicleCount.anchor = GridBagConstraints.EAST;
		gbc_lblVehicleCount.gridx = 0;
		gbc_lblVehicleCount.gridy = 0;
		add(lblVehicleCount, gbc_lblVehicleCount);
		
		vehicleCount = new NumberTextField();
		GridBagConstraints gbc_vehicleCount = new GridBagConstraints();
		gbc_vehicleCount.fill = GridBagConstraints.HORIZONTAL;
		gbc_vehicleCount.gridx = 1;
		gbc_vehicleCount.gridy = 0;
		add(vehicleCount, gbc_vehicleCount);
		vehicleCount.setColumns(10);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 3093256490043231886L;
	private JTextField vehicleCount;

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Sell";
	}

	@Override
	protected ArrayList<Row> getSheetValues() {
		// TODO Auto-generated method stub
		ArrayList<Row> rows = new ArrayList<Row>();
		Row row = new Row();
		row.setData("EntryNumber", "");
		rows.add(row);
		return rows;
	}

}
