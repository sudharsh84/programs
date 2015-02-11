package com.experiment.pattern;

import java.util.Scanner;

/**
 * This class is responsible for getting the user inputs from the console,
 * providing interactive features and handling the input logistics.
 * This class is a singleton class.
 * @author SS
 *
 */
public class UserInputService implements InputService{

  private  volatile static UserInputService userInputService;
  
  private UserInputService(){
	  
  }
  
  
  public static UserInputService getInstance(){
	  if(userInputService==null){
		  synchronized (UserInputService.class) {
			  if(userInputService==null){
				  userInputService=new UserInputService();
			  }
		}
	  }
	  return userInputService; 
  }
  
  /**
   * Gets the user input and makes it more interative
   */
	public String[][] getUserInputArray(){
		String[][] array=null;
		Scanner inputFromUser=new Scanner(System.in);
		try{
		
		boolean proceed=true;
		System.out.println("Welcome to see the spiral output pattern!!!");
		
		printInstructions();
		String content=inputFromUser.nextLine();
		int userTryCount=0;
		while (true){
			
		if("y".equalsIgnoreCase(content)){
			break;
		}else if("n".equalsIgnoreCase(content)){
			System.out.println("Ok lets see the instructions once again...");
			printInstructions();
		}else{
			System.out.println("Enter valid option only: Ready ? (y/n)");
		}
		
		if(userTryCount==3){
			System.out.println("I guess you are trying to play with this program right? But lets plays someother time... ");
			System.out.println(" Ok lets try that one more last time.. , otherwise the program is going to exit..");
			printInstructions();
			
		}
		if(userTryCount>4){
			System.out.println(" Ok buddy.. lets play/work together some other time.. see you!!");
			proceed=false;
			break;
		}
		content=inputFromUser.nextLine();
		userTryCount++;
		}
		
		if(proceed){
		
		System.out.println("Before letting you type the matrix contents, we would like to know your matrix size..");
		System.out.println("How many rows your matrix will contain? ");
		int rowCountTotal=inputFromUser.nextInt();
		System.out.println("okay...How many columns your matrix will contain? ");
		int columnCountTotal=inputFromUser.nextInt();
		System.out.println("Great!! Please start typing the matrix as per the instructions mentioned earlier...");
		boolean inputIssue=false;
		do{
		inputIssue=false;
		array=new String[rowCountTotal][columnCountTotal];
		int row=0;
		
		
		while (row<rowCountTotal){
			content=inputFromUser.nextLine();
			int column=0;
			if(content!=null&&!(content.isEmpty())){
			String rowInput[]=content.split(",");
			if(rowInput.length!=columnCountTotal){
				inputIssue=true;
				array=null;
				break;
			}
			while(column<rowInput.length){
			array[row][column]=rowInput[column];
			column++;
			}
			row++;
			}
		}
		if(inputIssue){
			System.out.println("probably something gone wrong while typing the input...so please enter the inputs again..");
		}
		}while(inputIssue);
		}
		}catch(Exception e){
			System.out.println("Some technical issue has occured in this program execution...so exiting...");
			
			
		}finally{
			inputFromUser.close();
		}
		return array;
	}
		private  void printInstructions(){
			System.out.println("Instructions:");
			System.out.println("1. Start typing the contents of the matrix row wise");
			System.out.println("2. please use \',\' to separate the contents of a matrix row");
			System.out.println("3. When done typing the contents for the row, press enter to type the next row and so on");
			System.out.println("4. When completed typing all the contents of matrix input, press enter ");
			System.out.println("Ready ? (y/n)");
		}
		
		
	
}
