import java.util.Random;
public class C6_Q7_Apocalypse 
{
	public static double nFamilies(int n)
	{
		int boys = 0;
		int girls = 0;
		
		for(int i = 0; i < n; i++)
		{
			Random rand = new Random();
			while(!rand.nextBoolean())
				boys++;
			girls++;
		}
		
		return (double) girls / boys;
	}
	
	public static void main(String[] args)
	{
		System.out.println("girls : boys = " + nFamilies(100000));
	}
}
