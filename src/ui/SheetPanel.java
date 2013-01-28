package ui;

import java.util.ArrayList;

import javax.swing.JPanel;

import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import classes.Row;

public abstract class SheetPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WritableSheet runSheet;
	public void createSheet(WritableWorkbook workbook, int sheetNumber){
		runSheet = workbook.createSheet(this.getDescription(),sheetNumber);
	}
	public abstract String getDescription();
	public void writeSheet() throws RowsExceededException, WriteException {
		// TODO Auto-generated method stub
		ArrayList<Row> sheetValues = getSheetValues();
		assert sheetValues.size()>0;

		//Write the headers.
		String [] headers = sheetValues.get(0).getHeaders();
		for(int i=0;i<headers.length;i++){
			runSheet.addCell(new Label(i,0,headers[i]));
		}

		//Write the data.
		for(int i=0;i<sheetValues.size();i++){
			//Write row data.
			Object[] rowData = sheetValues.get(i).getData();
			for(int j=0;j<rowData.length;j++){
				runSheet.addCell(new Label(j,i+1,(String) rowData[j]));
			}
		}
	}
	protected abstract ArrayList<Row> getSheetValues();
}
