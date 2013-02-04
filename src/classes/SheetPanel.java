package classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.AbstractButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import ui.NumberTextField;

public abstract class SheetPanel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8726972994288164262L;
	private WritableSheet runSheet;
	private ArrayList<SheetPanel> dependentSheets;
	private ArrayList<JComponent> additionalFields;
	private int dataRows;
	
	protected abstract ArrayList<Row> getDataRows(int rowCount);

	public SheetPanel(){
		additionalFields = new ArrayList<JComponent>();
		dependentSheets = new ArrayList<SheetPanel>();
	}

	public void createSheet(WritableWorkbook workbook, int sheetNumber){
		runSheet = workbook.createSheet(this.getDescription(),sheetNumber);
	}
	public abstract String getDescription();
	private void writeHeaders(String[] headers) throws RowsExceededException, WriteException{
		for(int i=0;i<headers.length;i++){
			runSheet.addCell(new Label(i,0,headers[i]));
		}
	}
	public void writeSheet() throws RowsExceededException, WriteException {
		// Initialize values in the sheet.
		this.dataRows=0;
		initializeValues();
		writeDataSheets(getRequestedRowCount());
	}

	public abstract int getRequestedRowCount();

	/**
	 * Writes values to the current sheet.
	 * @param sheetValues - Values to be written.
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	private void writeSheetValues(ArrayList<Row> sheetValues) throws RowsExceededException, WriteException{

		if(sheetValues==null)
			sheetValues = getSheetValues();
		//Write the data.
		for(int i=0;i<sheetValues.size();i++){
			//Write row data.
			Object[] rowData = sheetValues.get(i).getData();
			for(int j=0;j<rowData.length;j++){
				runSheet.addCell(new Label(j,i+1+this.dataRows,(String) rowData[j]));
			}
		}
		this.dataRows += sheetValues.size();
	}

	private ArrayList<Row> getSheetValues(){
		return getDataRows(getRequestedRowCount());
	}
	public void initializeValues(){
		//Please override me!
	}

	public void addDependentSheet(SheetPanel panel) {
		dependentSheets.add(panel);
	}

	private ArrayList<Row> writeDataSheets(int additionalRows) throws RowsExceededException, WriteException {
		//Get additional data.
		if(dependentSheets.size()==0){
			ArrayList<Row> additionalData = getDataRows(additionalRows);
			writeHeaders(getHeaders());
			this.writeSheetValues(additionalData);
			return additionalData;
		}
		//Add specified rows.
		ArrayList<Row> sheetValues = getDataRows(additionalRows);

		//Recursive call to get additional data.
		for(SheetPanel s : dependentSheets){
			ArrayList<Row> additionalData = s.writeDataSheets(additionalRows);
			for(int i=0;i<additionalData.size();i++){
				sheetValues.get(i).putAll(additionalData.get(i));
			}
		}
		writeHeaders(sheetValues.size()==0?getHeaders():sheetValues.get(0).getHeaders());
		writeSheetValues(sheetValues);
		return sheetValues;
	}

	public abstract String[] getHeaders();

	public int getRandomNumberInRange(NumberTextField numberFieldLow, NumberTextField numberFieldHigh) {
		// TODO Auto-generated method stub
		Random rng = new Random();
		return rng.nextInt(numberFieldHigh.getNumber()-numberFieldLow.getNumber())+numberFieldLow.getNumber();
	}

	public void initializeAdditionalFields() {
		// TODO Auto-generated method stub
		for(JComponent field : additionalFields){
			field.setVisible(false);
		}
	}

	public void addAdditionalField(JComponent component){
		additionalFields.add(component);
	}

	public void actionPerformed(ActionEvent e) {
		if(((AbstractButton) e.getSource()).isSelected()){
			for(JComponent field : additionalFields)
				field.setVisible(true);
		}else{
			for(JComponent field : additionalFields){
				if(field instanceof JTextField){
					((JTextField) field).setText("");
				}else if(field instanceof JComboBox){
					((JComboBox<?>) field).setSelectedIndex(0);
				}
				field.setVisible(false);
			}
		}
	}
	public synchronized void notifyPanel(){
		notifyAll();
	}

}
