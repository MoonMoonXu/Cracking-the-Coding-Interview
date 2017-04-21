import java.util.Random;
public class C6_Q1_TheHeavyPill 
{
	//This questions means the pill in one bottle is heavier than the other bottles,
	//not the amount of pills is larger than the other.
	
	public static int theHeavyPill(double[] pill, double light_weight, double heavy_weight)
	{
		double weight = 0;
		for(int i = 0; i < pill.length; i++)
			weight += pill[i] * (i + 1);  //take i + 1 pills from the ith bottle
		
		double weight_normal = light_weight * pill.length * (pill.length + 1) / 2;
		return (int) ((weight - weight_normal) / (heavy_weight - light_weight));
	}
	
	public static void main(String[] args)
	{
		double[] pill = new double[20];
		double light_weight = 1.0;
		double heavy_weight = 1.1;
		
		Random rand = new Random();
		int heavy_id = rand.nextInt(20);
		
		for(int i = 0; i < 20; i++)
		{
			if(i == heavy_id)
				pill[i] = heavy_weight;
			else
				pill[i] = light_weight;
		}
		
		System.out.println("The heavy pill is num: " + theHeavyPill(pill, light_weight, heavy_weight));
	}
}
