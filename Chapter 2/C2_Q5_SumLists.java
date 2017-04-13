
public class C2_Q5_SumLists
{
	//My own solution
	
	//Align to left if node1 and node2 have different lengths
	public static LinkedListNode sumLists(LinkedListNode node1, LinkedListNode node2)
	{
		LinkedListNode sum = null;
		
		int addOne = 0; //if we need to add 1 to the digit 
		int value = 0;
		
		while(node1 != null || node2 != null)
		{
			if(node1 == null || node2 == null)
			{
				if(node1 != null) value = node1.data + addOne;
				else value = node2.data + addOne;
			}
			else value = node1.data + node2.data + addOne;
			
			if(value >= 10) 
			{
				value -= 10;
				addOne = 1;
			}
			else
				addOne = 0;
			
			if(sum == null)
				sum = new LinkedListNode(value);
			else
				sum.appendToTail(value);	
			
			if(node1 != null) node1 = node1.next;
			if(node2 != null) node2 = node2.next;
		}
		
		if(addOne == 1)
			sum.appendToTail(1);
		
		return sum;
	}
	
	//Follow-up
	//Align to left if node1 and node2 have different lengths, adding 0 to the head of the shorter node
	//My own solution
	//Using recursion
	public static LinkedListNode sumLists2(LinkedListNode node1, LinkedListNode node2, int len1, int len2)
	{
		if(len1 < len2)
		{
			for(int i = 0; i < len2 - len1; i++)
			{
				LinkedListNode head = new LinkedListNode(0);
				head.next = node1;
				node1 = head;
			}
		}
		else if(len1 > len2)
		{
			for(int i = 0; i < len1 - len2; i++)
			{
				LinkedListNode head = new LinkedListNode(0);
				head.next = node2;
				node2 = head;
			}
		}
		
		int[] addOne = {0};  //indicates if we need to add 1 to the digit
		LinkedListNode sum = null;
		return helper(node1, node2, sum, addOne);
	}
	
	private static LinkedListNode helper(LinkedListNode node1, LinkedListNode node2, LinkedListNode sum, int[] addOne)
	{
		if(node1 == null || node2 == null)
			return null;
		
		sum = helper(node1.next, node2.next, sum, addOne);
		int value = node1.data + node2.data + addOne[0];
		
		if(sum == null)
			sum = new LinkedListNode(value >=10 ? value - 10 : value);
		else
		{
			LinkedListNode node = new LinkedListNode(value >= 10 ? value - 10 : value);
			node.next = sum;
			sum = node;
		}
		
		addOne[0] = (value >= 10 ? 1 : 0);
		
		return sum;
	}
	
	
	public static void main(String[] args)
	{
		LinkedListNode node1 = new LinkedListNode(7);
		node1.appendToTail(1);
		node1.appendToTail(6);
		
		LinkedListNode node2 = new LinkedListNode(5);
		node2.appendToTail(9);
		node2.appendToTail(2);
		node2.appendToTail(4);
		
		LinkedListNode sum = sumLists(node1, node2);
		while(sum != null)
		{
			System.out.print(sum.data + " ");
			sum = sum.next;
		}
		
		System.out.println();
		
		node1 = new LinkedListNode(6);
		node1.appendToTail(1);
		node1.appendToTail(7);
		
		node2 = new LinkedListNode(4);
		node2.appendToTail(2);
		node2.appendToTail(9);
		node2.appendToTail(5);
		
		sum = sumLists2(node1, node2, 3, 4);
		while(sum != null)
		{
			System.out.print(sum.data + " ");
			sum = sum.next;
		}
	}
}
