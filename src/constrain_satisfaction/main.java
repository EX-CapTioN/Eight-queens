
package constrain_satisfaction;
import java.util.Scanner;
public class main {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
      //  System.out.println("Enter number of queens");
	//	int numQueens = reader.nextInt();
        int numQueens = 13;
		//Branch_N_Bound ahmed = new Branch_N_Bound(numQueens);
        Back_Tracking ahmed = new Back_Tracking(numQueens);
       // Recursion ahmed = new Recursion(numQueens);
        long startTime = System.nanoTime()/1000;
        ahmed.start();
        long endTime = System.nanoTime()/1000;
		int[][] solution = ahmed.returnBoard();
		 for (int i = 0; i < numQueens; i++) {
	            for (int j = 0; j < numQueens; j++) {
	                System.out.print(solution[i][j]+ " ");
	            }
	            System.out.println();
		 }

        System.out.println("That took " + (endTime - startTime) + " microseconds");
	}
     	

	}


