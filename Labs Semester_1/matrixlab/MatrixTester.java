/*Name: Pranav Chati
 *Grade:
 *This is a matrix tester class which passes in the matrix class
 *which essentially adds matrici together through the numbers put through
 *
 *Date of Completion: 11/12
 */
package matrixlab;

import java.util.Scanner;

public class MatrixTester {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		Matrix m;
		int r, c, r1, c1; //int rows and columns
		int[][][] numbers;
		int ans;
		
		
		do {
			System.out.print("Input Rows: ");
			r = input.nextInt();
			
			System.out.print("Input Columns: ");
			c = input.nextInt();
		
			System.out.print("Input Rows: ");
			r1 = input.nextInt();
			
			System.out.print("Input Columns: ");
			c1 = input.nextInt();
			
			
			numbers = new int[2][r][c];
			
			m = new Matrix(r,c,r1,c1);
			
			boolean check = m.CheckAdd();
			//if add has worked
			if(check) {
				for(int n = 0; n < 2; n++) {
					for(int i = 0; i < r; i++) {
						for(int j = 0; j < c; j++) {
							System.out.print("Input Number: ");
							numbers[n][i][j] = input.nextInt();
						}
					}
				}
				
				m.AddMatrix(numbers, r, c);
				System.out.println("");
			}
			else
			{
				//error statement for when the rows != columns
				System.out.println("In Order to add 2 matricies, the rows and columns have to be equal.");
			}
			
			System.out.println("Run Again? \n1-Yes\n2-No");
			ans = input.nextInt();
		}while(ans == 1); //run again
		
	}
}
