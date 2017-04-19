
public class C1_Q7_RotateMatrix 
{
	//in-place solution: from outer layers to inner layers
	public static int[][] rotateMatrix(int[][] matrix)
	{
		int n = matrix.length;
		
		for(int i = 0; i < n / 2; i++)
		{
			for(int j = i; j < n - i - 1; j++)
			{
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n - j - 1][i];
				matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
				matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
				matrix[j][n - i - 1] = temp;
			}
		}
		
		return matrix;
	}
	
	public static void main(String[] args) 
	{
		int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		matrix = rotateMatrix(matrix);
		
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix.length; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.println();
		}
	}
	
}
