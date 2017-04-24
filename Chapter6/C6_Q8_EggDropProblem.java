import java.util.Random;
public class C6_Q8_EggDropProblem 
{
	//The key is worst case balancing
	//Our goal is find the first floor we drop egg1, so that the total number of drops of egg1 and egg2 is always the same.
	//suppose the first floor we drop egg1 is X, then X + X - 1 + X - 2 +...+ 1 =100, X = 14 (13 is wrong)
	
	static int count = 1;
	public static int findN(int randN)
	{
		int egg1_total = 14;
		int egg1_each = 14;
		
		while(egg1_total < randN)
		{
			egg1_each -= 1;
			egg1_total += egg1_each;
			count++;
		}
		
		int i = 0;
		
		for(i = egg1_total - egg1_each + 1; i < egg1_total; i++)
		{
			count++;
			if(i >= randN) break;
		}
		
		return i;
	}
	
	public static void main(String[] args)
	{
		Random rand = new Random();
		System.out.println("N: " + findN(rand.nextInt(101)));
		System.out.println("The number of drops: " + count);
	}
}
