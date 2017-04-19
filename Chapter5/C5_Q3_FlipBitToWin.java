
public class C5_Q3_FlipBitToWin 
{
	public static int flipBit(int n)
	{
		int curr = 0;
		int prev = 0;
		int maxL = 0;
		
		while(n != 0)
		{
			if((n & 1) == 1) curr++;
			else
			{
				if((n & 2) == 2) prev = curr;
				else prev = 0;
				curr = 0;
			}
			maxL = Math.max(maxL, curr + prev + 1);
			n >>= 1;  //>>> is also right
		}
		
		return maxL;
	}
	
	public static void main(String[] args)
	{
		int n = 1775;
		System.out.println(flipBit(n));
	}
}
