import java.util.*;
public class C6_Q10_Poison 
{
	//Optimal Approach: Using the 10 strips to represent the 10 digits of each bottle's binary expression
	//Seven days later, we concatenate the 10 bits and get the ID of the poisoned bottle
	
	
	int findPoisonedBottle(ArrayList<Bottle> bottles, ArrayList<TestStrip> strips)
	{
		runTests(bottles, strips);
		ArrayList<Integer> positive = getPositiveOnDay(strips, 7);
		return setBits(positive);
	}
	
	void runTests(ArrayList<Bottle> bottles, ArrayList<TestStrip> strips)
	{
		for(Bottle bottle : bottles)
		{
			int id = bottle.getId();
			int bitIndex = 0;
			while(id > 0)
			{
				if((id & 1) == 1) strips.get(bitIndex).addDropOnDay(0, bottle);
				bitIndex++;
				id >>= 1;
			}
		}
	}
	
	ArrayList<Integer> getPositiveOnDay(ArrayList<TestStrip> strips, int day)
	{
		ArrayList<Integer> result = new ArrayList<>();
		for(TestStrip strip : strips)
		{
			int id = strip.getId();
			if(strip.isPositiveOnDay(day)) result.add(id);
		}
		return result;
	}
	
	int setBits(ArrayList<Integer> result)
	{
		int resultId = 0;
		for(Integer bitIndex : result)
			resultId |= (1 << bitIndex);
		return resultId;
	}
	
}
