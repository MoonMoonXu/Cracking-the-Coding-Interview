
public class C5_Q4_NextNumber 
{
	//find the rightmost 0 which has 1 on the right
	public static int nextLargest(int n)
	{
		int temp = n;
		int num0 = 0;
		int num1 = 0;
		
		while(temp != 0 && (temp & 1) == 0)  //temp == 0 might happen when all the bits are 0
		{
			num0++; 
			temp >>= 1;
		}
		
		while((temp & 1) == 1)
		{
			num1++;
			temp >>= 1;
		}
		
		//if there is no such a 0 which has 1 on the right, like 1...10....0, return false
		//num0 + num1 == 0 means n is 0
		if(num0 + num1 == 31 || num0 + num1 == 0) return -1;
		//why 31, not 32? 
		
		int position = num1 + num0;
		//change the 0 to 1
		n |= (1 << position);
		//clear all the bits on the right of the 0
		n &= ~((1 << position) - 1);
		//change the rightmost num1 - 1 0s into 1s
		n |= (1 << (num1 - 1)) - 1;
		
		return n;
	}
	
	public static int nextSmallest(int n)
	{
		int temp = n;
		int num0 = 0;
		int num1 = 0;
		
		while((temp & 1) == 1)
		{
			num1++;
			temp >>= 1;
		}
		
		//like 0...01...1
		if(temp == 0) return -1;
		
		while(temp != 0 && (temp & 1) == 0)  //temp == 0 might happen when all the bits are 0
		{
			num0++;
			temp >>= 1;
		}
		
		int position = num0 + num1;
		//change the 1 to 0
		n &= ~(1 << position);
		//change all the bits on the right of the 1 to 1
		n |= (1 << position) - 1;
		//change the rightmost num0 - 1 1s into 0s
		n &= ~((1 << (num0 - 1)) - 1);
		
		return n;
	}
}
