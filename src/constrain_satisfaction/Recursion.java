package constrain_satisfaction;

public class Recursion {
    
	private static int board[][]; 
	private static int numQueens; //no of queens needed
	private int no_of_queens;     //no of queens added 
	
	public Recursion(int numQueens){
	this.numQueens = numQueens;
	board = new int[numQueens][numQueens];
			}
    
	public int  getNumQueens(){ //if number of queens at recent needed
		return no_of_queens;
	}
	
	public void start(){
		solve(0); //start the algorithm 
	}
	
	public boolean solve(int no_of_queens){
        if(no_of_queens == numQueens)  //finished 
        {
        	System.out.println("DONE");
        	this.returnBoard();
        	return true;
        }
        else
        {
        for(int i = 0; i < numQueens; i++)	
        	for (int j = 0; j < numQueens; j++)
        	{
        		
        		if(validMove(j,i) == 0){
        			board[j][i] = 1;
        			no_of_queens++;
        		/*	for (int k = 0; k < numQueens; k++) {
        	            for (int l = 0; l < numQueens; l++) {
        	                System.out.print(board[k][l]+ " ");
        	            }
        	            System.out.println();
        		}
        			System.out.println();*/
        			if(solve(no_of_queens)){
        				return true;
        				
        			}
        			else{
        				
        				board[j][i] = 0;
        				no_of_queens--;
        			}
        			
    	           // System.out.println();
    	            //System.out.println();

        		
        	}
       
        }
        }
        
        return false;
	}
	
	public static int validMove(int x, int y){      //check if this position is valid
		for (int j = 0; j < numQueens; j++)
		{
			//check row
			if(get(x,j) == 1)    
			{
				return -1;
			}
			//check col
			if(get(j,y) == 1)
			{
				return -1;
			}
		}
		//check diagonal
		for(int j =0; j < numQueens; j++)
		{
			if(get(x-j, y-j) == 1)
			{
				return -1;
			}
		/*	if(get(x-j, y+j) == 1)
			{
				return -1;
			}*/
			/*if(get(x+j, y-j) == 1)
			{
				return -1;
			}*/
			if(get(x+j, y+j) == 1)
			{
				return -1;
			}	
		}
		
			return 0;
		
	}
	

	
	public static int get(int x, int y){
		if(x < 0 || y < 0 || x > numQueens - 1 || y > numQueens - 1)
		{
		//	System.out.println("error!!");
			return -1;
		}
		return board[x][y];
	}
	
	public int[][]  returnBoard(){
		return board;
	}
	
	
	
}
