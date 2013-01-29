package classes;

import java.util.TreeMap;

public class Row {
	int rowNumber;
	TreeMap<String, String> rowData;

	public Row(Row row){
		this.rowNumber = row.rowNumber;
		this.rowData = new TreeMap<String, String>(row.rowData);
	}
	public Row(){
		this.rowNumber = 0;
		this.rowData = new TreeMap<String, String>();
	}

	public Row(int rowNumber, TreeMap<String, String> rowData){
		this.rowNumber = rowNumber;
		this.rowData = rowData;
	}

	public void setData(String key, String data){
		rowData.put(key, data);

	}
	public String getData(String key){
		return rowData.get(key);
	}
	public void putAll(Row row){
		rowData.putAll(row.rowData);
	}

	public String[] getHeaders(){
		return rowData.keySet().toArray(new String[rowData.keySet().size()]);
	}
	public String[] getData(){
		return rowData.values().toArray(new String[rowData.size()]);
	}
}
