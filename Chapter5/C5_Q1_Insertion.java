
public class C5_Q1_Insertion 
{
	public static int insertion(int n, int m, int i, int j)
	{
		//First: Clear the bits j through i in n
		
		//Create 11100000
		int left = ~0 << (j + 1);
		
		//Create 00000011 = 00000100 - 1
		int right = (1 << i) - 1;
		
		//Create 11100011
		int mask = left | right;
		
		//Clear the bits j through i in n
		n = n & mask;
		
		//Shift m so that it lines up with bits j and i
		m = m << i;
		
		//Merge m and n
		return m | n;
	}
	
	public static void main(String[] args)
	{
		int n = 0b10101001;
		int m = 0b111;
		System.out.println(Integer.toBinaryString(insertion(n, m, 2, 4)));
	}
}
