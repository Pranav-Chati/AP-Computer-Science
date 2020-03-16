package matrix;

public class Matrix {
	int r, c, r1, c1;
	Integer[][] result;

	public Matrix() {
		r = 0;
		c = 0;

		r1 = 0;
		c1 = 0;
	}

	public Matrix(int r, int c, int r1, int c1) {
		this.r = r;
		this.c = c;

		this.r1 = r1;
		this.c1 = c1;
	}

	public boolean checkAddSub() {
		if (r == r1 && c == c1)
			return true;
		else
			return false;
	}

	public Integer[][] addMatrix(int m1[][], int m2[][]) {
		result = new Integer[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				result[i][j] = m1[i][j] + m2[i][j];
			}
		}
		return result;
	}

	public Integer[][] subMatrix(int m1[][], int m2[][]) {
		result = new Integer[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				result[i][j] = m1[i][j] - m2[i][j];
			}
		}
		return result;
	}

	public Integer[][] scalarAdd(int m[][], int operation, int r, int c) {
		result = new Integer[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				result[i][j] = operation + m[i][j];
			}
		}
		return result;
	}

	public Integer[][] scalarSub(int m[][], int operation, int r, int c) {
		result = new Integer[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				result[i][j] = m[i][j] - operation;
			}
		}
		return result;
	}

	public Integer[][] scalarMult(int m[][], int operation, int r, int c) {
		result = new Integer[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				result[i][j] = operation * m[i][j];
			}
		}
		return result;
	}

	public Integer[][] transposeMatrix(int m[][], int r, int c) {
		result = new Integer[c][r];
		int i, j;
		for (i = 0; i < c; i++)
			for (j = 0; j < r; j++)
				result[i][j] = m[j][i];

		return result;
	}

	public boolean checkInverse() {
		if(r == c && r1 == c1 && r == r1 && c == c1)
			return true;
		else
			return false;
	}
	
	public Integer[][] inverseMatrix() {
		
		return result;
	}
	
	
	
	public boolean checkMultiplication() {
		if(c==r1)
			return true;
		else
			return false;
	}
	
	public Integer[][] multMatrix(int m1[][], int m2[][]) {
		result = new Integer[r][c1];
		for(int i = 0; i < r; i++) {
            for (int j = 0; j < c1; j++) {
            	result[i][j] = 0;
            }
        }
		
		for(int i = 0; i < r; i++) {
            for (int j = 0; j < c1; j++) {
                for (int k = 0; k < c; k++) {
                    result[i][j] += (m1[i][k] * m2[k][j]);
                }
            }
        }
		
		
		return result;
	}
	
	public int determinantMatrix(int[][] arr) {
		int result = 0;
		if (arr.length == 1) {
			result = arr[0][0];
			return result;
		}
		if (arr.length == 2) {
			result = arr[0][0] * arr[1][1] - arr[0][1] * arr[1][0];
			return result;
		}
		for (int i = 0; i < arr[0].length; i++) {
			int temp[][] = new int[arr.length - 1][arr[0].length - 1];

			for (int j = 1; j < arr.length; j++) {
				for (int k = 0; k < arr[0].length; k++) {

					if (k < i) {
						temp[j - 1][k] = arr[j][k];
					} else if (k > i) {
						temp[j - 1][k - 1] = arr[j][k];
					}
				}
			}
			result += arr[0][i] * Math.pow(-1, (int) i) * determinantMatrix(temp);
		}
		return result;
	}

}
