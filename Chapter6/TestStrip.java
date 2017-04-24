import java.util.ArrayList;

class TestStrip
	{
		ArrayList<ArrayList<Bottle>> dropsByDay = new ArrayList<>();
		int id;
		
		public TestStrip(int id) { this.id = id; }
		public int getId() { return id; }
		
		void addDropOnDay(int day, Bottle bottle)
		{
			while(dropsByDay.size() <= day) dropsByDay.add(new ArrayList<Bottle>());
			dropsByDay.get(day).add(bottle);
		}
		
		boolean isPositiveOnDay(int day)
		{
			day -= 7;
			for(int i = 0; i < day; i++)
			{
				if(hasPoison(dropsByDay.get(day))) return true;
			}
			return false;
		}
		
		boolean hasPoison(ArrayList<Bottle> bottles)
		{
			for(Bottle bottle : bottles)
			{
				if(bottle.isPoisoned()) return true;
			}
			return false;
		}
	}
	
