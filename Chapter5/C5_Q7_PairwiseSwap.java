
public class C5_Q7_PairwiseSwap
{
	/*
	 * First, clear all even bits, and shift odd bits right to the even bits;
	 * Second, clear all odd bits, and shift even bits left to the odd bits;
	 * Combine the two values
	 */
	
	public static int pairWiseSwap(int n)
	{
		//32-bits
		//a = 1010, 5 = 0101
		//use >>> instead of >> because we want the sign bit to be filled with a 0
		return (((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1));
	}
	
	public static void main(String[] args)
	{
		System.out.println(Integer.toBinaryString(0x99));
		System.out.println(Integer.toBinaryString(pairWiseSwap(0x99)));
	}
	
}
