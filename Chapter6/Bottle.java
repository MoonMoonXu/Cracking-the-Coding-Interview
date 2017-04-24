class Bottle
{
	boolean poisoned = false;
	int id;
		
	public Bottle(int id) { this.id = id; }
	public int getId() { return id; }
	public void setPoisoned() { poisoned = true; };
	public boolean isPoisoned() { return poisoned; }
}
	
