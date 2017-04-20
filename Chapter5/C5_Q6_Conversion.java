
public class C5_Q6_Conversion 
{
	public static int conversion(int a, int b)
	{
		int count = 0;
		for(int c = a ^ b; c != 0; c &= (c - 1))	//c &= (c - 1) can clear the least 1 bit in c
			count++;
		return count;
	}
	
	public static void main(String[] args)
	{
		System.out.println(conversion(29, 15));
	}
}
