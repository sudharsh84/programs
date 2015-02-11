package com.experiment.pattern;

/**
 * This class is reponsible for holding the input array and providing  necessary utilities on the array
 * @author SS
 *
 */
public class Input {
private String[][] inputArray;
private int rowTotalCount; 
public String[][] getInputArray() {
	return inputArray;
}
public void setInputArray(String[][] input) {
	this.inputArray = input;
}
public int getRowTotalCount() {
	return rowTotalCount;
}
public void setRowTotalCount(int rowTotalCount) {
	this.rowTotalCount = rowTotalCount;
}
public int getColumnTotalCount() {
	return columnTotalCount;
}
public void setColumnTotalCount(int columnTotalCount) {
	this.columnTotalCount = columnTotalCount;
}
private int columnTotalCount;
	public Input(String[][] input){
		this.inputArray=input;
		this.rowTotalCount=(this.inputArray!=null)?this.inputArray.length:0;
		this.columnTotalCount=(input[0]!=null)?input[0].length:0;
	}
}
