package classes;

import java.util.HashMap;

public class Row {
	int rowNumber;
	HashMap<String, String> rowData;
	
	public Row(){
		this.rowNumber = 0;
		this.rowData = new HashMap<String, String>();
	}
	
	public Row(int rowNumber, HashMap<String, String> rowData){
		this.rowNumber = rowNumber;
		this.rowData = rowData;
	}
	
	public void setData(String key, String data){
		rowData.put(key, data);
	}
	
	public String[] getHeaders(){
		return rowData.keySet().toArray(new String[rowData.keySet().size()]);
	}
	public String[] getData(){
		return rowData.values().toArray(new String[rowData.size()]);
	}
}
