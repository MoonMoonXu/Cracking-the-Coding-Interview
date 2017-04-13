import java.util.LinkedList;

public class C3_Q6_AnimalShelter 
{
	abstract class Animal
	{
		private int order;

		public int getOrder() 
		{
			return order;
		}

		public void setOrder(int order) 
		{
			this.order = order;
		}
	}
	
	class Dog extends Animal{}
	
	class Cat extends Animal{}
	
	class AnimalQueue
	{
		LinkedList<Dog> dogs = new LinkedList<Dog>();
		LinkedList<Cat> cats = new LinkedList<Cat>();
		private int order = 0;
		
		public void enqueue(Animal a)
		{
			a.setOrder(order);
			order++;
			if(a instanceof Dog) dogs.add((Dog) a);  //change Animal a to Dog a 
			else cats.add((Cat) a);
		}
		
		public Animal dequeueAny()
		{
			if(dogs.size() == 0) return dequeuCat();
			if(cats.size() == 0) return dequeueDog();
			
			if(dogs.peek().getOrder() < cats.peek().getOrder())
				return dequeueDog();
			else
				return dequeuCat();	
		}
		
		public Dog dequeueDog()
		{
			return dogs.poll();
		}
		
		public Cat dequeuCat()
		{
			return cats.poll();
		}
		
		
	}
	
	
	
}
