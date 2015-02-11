package com.experiment.pattern;

/**
 * This class holds the main method and is the starting point of execution
 * @author SS
 *
 */
public class PrintPattern {

	public static void main(String args[]){
		
		
		InputService userInputService=UserInputService.getInstance();
		
		String inputArray[][]=userInputService.getUserInputArray();
		Pattern pattern=new Pattern(inputArray);
		pattern.displayMatrixInput();
		pattern.displaySpiral();
		
		}
		
		
	

}
