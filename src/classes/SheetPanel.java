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
	protected abstract ArrayList<Row> addAdditionalRows(int rowCount);

	public SheetPanel(){
		additionalFields = new ArrayList<JComponent>();
		dependentSheets = new ArrayList<SheetPanel>();
	}

	private ArrayList<Row> writeAdditionalRows(int rowCount) throws RowsExceededException, WriteException{
		ArrayList<Row> additionalRows = addAdditionalRows(rowCount);
		writeSheetValues(additionalRows, dataRows);
		dataRows += rowCount;
		return additionalRows;
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
		// TODO Auto-generated method stub
		initializeValues();
		ArrayList<Row> sheetValues = getSheetValues();
		this.dataRows = 0;  

		writeDependentSheets(sheetValues.size());
	}
	
	/**
	 * Writes values to the current sheet.
	 * @param sheetValues - Values to be written.
	 * @param rowOffset - The starting row (
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	private void writeSheetValues(ArrayList<Row> sheetValues, int rowOffset) throws RowsExceededException, WriteException{

		if(sheetValues==null)
			sheetValues = getSheetValues();
		//Write the data.
		for(int i=0;i<sheetValues.size();i++){
			//Write row data.
			Object[] rowData = sheetValues.get(i).getData();
			for(int j=0;j<rowData.length;j++){
				runSheet.addCell(new Label(j,i+1+rowOffset,(String) rowData[j]));
			}
		}
	}

	protected abstract ArrayList<Row> getSheetValues();
	public void initializeValues(){
		//Please override me!
	}

	public void addDependentSheet(SheetPanel panel) {
		// TODO Auto-generated method stub
		dependentSheets.add(panel);
	}

	private ArrayList<Row> writeDependentSheets(int additionalRows) throws RowsExceededException, WriteException {
		//Initialize and get our data.
		ArrayList<Row> mSheetData = getSheetRows(additionalRows);
		ArrayList<Row> additionalData;
		
		//If no dependent sheets write and return the rows.
		if(dependentSheets.size()==0){
			//Write
			additionalData = this.getSheetRows(additionalRows);
			writeHeaders(additionalData.get(0).getHeaders());
			writeSheetValues(mSheetData,getSheetValues().size()+1);
			//Return
			return additionalData;
		}
		
		//Request data from dependent sheets.
		additionalData = dependentSheets.get(0).writeDependentSheets(additionalRows);
		//Merge additional data from dependentSheets.
		assert mSheetData.size() == additionalData.size();
		for(int i=0;i<additionalData.size();i++){
			mSheetData.get(i).putAll(additionalData.get(i));
		}
		
		//Write it to the data sheet.
		writeHeaders(mSheetData.get(0).getHeaders());
		writeSheetValues(mSheetData,dataRows);
		dataRows += additionalData.size();
		return mSheetData;
		/*
		for(SheetPanel s : dependentSheets){
			for(SheetPanel panel : s.dependentSheets){
				panel.writeAdditionalRows(additionalRows);
			}
			additionalData = s.writeAdditionalRows(mSheetData.size());
			for(int i=0;i<mSheetData.size();i++){
				mSheetData.get(i).putAll(additionalData.get(i));
			}
		}

		writeHeaders(mSheetData.get(0).getHeaders());
		writeSheetValues(mSheetData,0);*/
	}

	private ArrayList<Row> getSheetRows(int additionalRows) {
		// TODO Auto-generated method stub
		return addAdditionalRows(additionalRows);
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
	
	private ArrayList<Row> getAdditionalRows(int numberRows){
		return addAdditionalRows(numberRows);
	}
}
