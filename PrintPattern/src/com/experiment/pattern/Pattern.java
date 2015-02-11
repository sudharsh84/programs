package com.experiment.pattern;

/**
 * This class is responsible for traversing in a spiral form
 * @author SS
 *
 */
public class Pattern {
	private Input input;
	private int pendingLineCountTobeTraversed;

	public Pattern(String inputArray[][]){
		this.input=new Input(inputArray);
		
		this.pendingLineCountTobeTraversed=getLineCount();
	}
	
	/**
	 * Traverse method takes input of the respective coordinates and directions it requires and does the traversing
	 * @param rowBegin
	 * @param rowEnd
	 * @param columnBegin
	 * @param columnEnd
	 * @param traversalDirection
	 * @return
	 */
		private boolean traverse(int rowBegin,int rowEnd,int columnBegin,int columnEnd,Direction traversalDirection){
			
			if(pendingLineCountTobeTraversed<0){
				return false;
			}else{
				
			switch (traversalDirection) {
			case RIGHT:
				for(int i=columnBegin;i<=columnEnd;i++){
					System.out.print(input.getInputArray()[rowBegin][i]);
					System.out.print("\t");
				}
				
				break;
			case LEFT:
				for(int i=columnEnd;i>=columnBegin;i--){
					System.out.print(input.getInputArray()[rowEnd][i]);
					System.out.print("\t");
				}
				break;
			case DOWN:
				for(int i=rowBegin;i<=rowEnd;i++){
					System.out.print(input.getInputArray()[i][columnEnd]);
					System.out.print("\t");
				}
				break;
			case UP:
				for(int i=rowEnd;i>=rowBegin;i--){
					System.out.print(input.getInputArray()[i][columnBegin]);
					System.out.print("\t");
				}
				break;
			default:
				break;
			} 
			this.pendingLineCountTobeTraversed=this.pendingLineCountTobeTraversed-1;
			return true;
			}
	}
		/**
		 * The output of this method drives the core logic of how many times the array need to be traversed to make sure all elements are covered.
		 * Here the logic is, I am considering each of the traversal in a particular direction as a line , 
		 * for ex: in 3X3 matrix, the number of lines to be traversed are 5 and in a 4X3 matrix the number of lines traversed in 6, and so on. 
		 * 
		 
		 * 
		 * @return
		 */
		private int getLineCount(){
			int rowCount=input.getRowTotalCount();
			int columnCount=input.getColumnTotalCount();
			int lineCount;		
			if(rowCount>columnCount){
				lineCount=columnCount*2;
			}else{
				lineCount=(rowCount*2)-1;
			}
			return lineCount;
		}
		
		/**
		 * This is the core method which does the spiral traversal and coming with necessary coordinates of the line,
		 * so that it ensures no two elements are repeated again.
		 */
	public void displaySpiral(){
		System.out.println("\n");
		System.out.println("################printing the sprial output##############");
		int rowBegin=0;
		int columnBegin=0;
		int rowEnd=input.getRowTotalCount()-1;
		int columnEnd=input.getColumnTotalCount()-1;
		
		
		
		
		while(true){
			
			if(!traverse(rowBegin, 0, columnBegin, columnEnd, Direction.RIGHT))
				break;
			
			rowBegin=rowBegin+1;
			
			if(!traverse(rowBegin, rowEnd, 0, columnEnd, Direction.DOWN))
				break;
			
			columnEnd=columnEnd-1;
			if(!traverse(0, rowEnd, columnBegin, columnEnd, Direction.LEFT))
				break;
			
			rowEnd=rowEnd-1;
			if(!traverse(rowBegin, rowEnd, columnBegin, 0, Direction.UP))
				break;
			
			columnBegin=columnBegin+1;
			
		}
		System.out.print("\n");
		System.out.println("################printing the sprial output##############");
		
	}
	
	/**
	 * This method is a simple method which prints matrix input
	 */
	
	public void displayMatrixInput(){
		System.out.println("################printing the matrix input##############");
		int rowCountTotal=input.getRowTotalCount();
		int columnCountTotal=input.getColumnTotalCount();
				for (int i=0;i<rowCountTotal;i++){
					for(int j=0;j<columnCountTotal;j++){
						System.out.print(input.getInputArray()[i][j]+"\t");
					}
					System.out.print("\n");
				}
				System.out.println("################printing the matrix input##############");
	}
}
