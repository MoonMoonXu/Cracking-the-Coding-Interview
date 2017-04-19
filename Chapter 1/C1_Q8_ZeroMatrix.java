import java.util.Arrays;

public class C1_Q8_ZeroMatrix 
{
	/*
	 * my own solution, a little different from that in the book: 
	 * Instead of using the first row and the first col to store the zero information,
	 * I use the row and col of the first zero discovered
	*/
	 public static int[][] zeroMatrix(int[][] matrix)
	 {
		 int n = matrix.length;
		 //the row and col of the first zero discovered, initialized as -1
		 int firstZeroRow = -1;
		 int firstZeroCol = -1;
		 
		 for(int i = 0; i < n; i++)
			 for(int j = 0; j < n; j++)
				 if(matrix[i][j] == 0)
					 if(firstZeroRow == -1) 
					 {
						 firstZeroRow = i;
						 firstZeroCol = j;
					 }
					 else
					 {
						 matrix[firstZeroRow][i] = -1;
						 matrix[j][firstZeroCol] = -1;
					 }
				 		 
		 
		 for(int i = 0; i < n; i++)
		 {
			 if(i == firstZeroCol) continue;  //leave firstZeroRow and firstZeroCol for last
			 if(matrix[firstZeroRow][i] == -1)
				 Arrays.fill(matrix[i], 0); 
		 }
		 
		 for(int i = 0; i < n; i++)
		 {
			 if(i == firstZeroRow) continue;
			 if(matrix[i][firstZeroCol] == -1)
			 {
				 for(int j = 0; j < n; j++)
					 matrix[j][i] = 0;
			 }
		 }
		 
		 Arrays.fill(matrix[firstZeroRow], 0);
		 for(int i = 0; i < n; i++)
			 matrix[i][firstZeroCol] = 0;
		 
		 return matrix;
	 }
	 
	 public static void main(String[] args) 
		{
			int[][] matrix = {{1, 1, 1, 1}, {1, 0, 1, 1}, {1, 1, 1, 1}, {1, 0, 1, 1}};
			matrix = zeroMatrix(matrix);
			
			for(int i = 0; i < matrix.length; i++)
			{
				for(int j = 0; j < matrix.length; j++)
					System.out.print(matrix[i][j] + " ");
				System.out.println();
			}
		}
}
