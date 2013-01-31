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
	protected abstract ArrayList<Row> addAdditionalRows(int rowCount);

	public SheetPanel(){
		additionalFields = new ArrayList<JComponent>();
		dependentSheets = new ArrayList<SheetPanel>();
	}

	private ArrayList<Row> writeAdditionalRows(int rowCount) throws RowsExceededException, WriteException{
		ArrayList<Row> additionalRows = addAdditionalRows(rowCount);
		writeSheetValues(additionalRows, getSheetValues().size());
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
		ArrayList<Row> sheetValues = getSheetValues();

		writeHeaders(sheetValues.size()>0?sheetValues.get(0).getHeaders():getHeaders());
		writeSheetValues(sheetValues,0);
		
		if(dependentSheets.size()>0)
			writeDependentSheets();
	}
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

	public void addDependentSheet(SheetPanel panel) {
		// TODO Auto-generated method stub
		dependentSheets.add(panel);
	}

	private void writeDependentSheets() throws RowsExceededException, WriteException {
		// TODO Auto-generated method stub
		ArrayList<Row> mSheetData = getSheetValues();
		ArrayList<Row> additionalData = new ArrayList<Row>();
		for(SheetPanel s : dependentSheets){
			additionalData = s.writeAdditionalRows(mSheetData.size());
			for(int i=0;i<mSheetData.size();i++){
				mSheetData.get(i).putAll(additionalData.get(i));
			}
		}

		writeHeaders(mSheetData.get(0).getHeaders());
		writeSheetValues(mSheetData,0);
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
}
