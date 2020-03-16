package matrixlab;

public class Matrix {
	int[] rows = new int[2];
	int[] columns = new int[2];
	
	public Matrix() {
		rows[0] = 0;
		columns[0] = 0;
		
		rows[1] = 0;
		columns[1] = 0;
	}

	public Matrix(int r, int c, int r1, int c1) {
		rows[0] = r;
		columns[0] = c;
		
		rows[1] = r1;
		columns[1] = c1;
	}
	
	public boolean CheckAdd() {
		if(rows[0] == rows[1] && columns[0] == columns[1])
			return true;
		else 
			return false;
	}
	
	public void AddMatrix(int n[][][], int r, int c) {
		int sum = 0;
		System.out.print("[ ");
		
		for(int i = 0; i < r; i ++)  {
			for(int j = 0; j < c; j ++) {
				sum = n[0][i][j] + n[1][i][j];
				System.out.print(sum);
				
				if( j == (c-1)) {
					if(i == (r-1))
					{
						System.out.println(" ]");
					}
					else
					System.out.print(" ]\n[ ");
				}
				else {
					System.out.print(" , ");
				}
			}
		}
	}
}
