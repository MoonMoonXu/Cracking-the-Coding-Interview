import java.util.HashSet;
public class C2_Q1_RemoveDups 
{
	//Time: O(n)
	public static void removeDups(LinkedListNode n)
	{
		HashSet<Integer> hashset = new HashSet<Integer>();
		hashset.add(n.data);
		
		while(n.next != null)
		{
			if(hashset.contains(n.next.data))
				n.next = n.next.next;
			else
			{
				hashset.add(n.data);
				n = n.next;
			}	
		}	

	}
	
	//No buffer allowed 
	//Time: O(n ^ 2)
	public static void removeDups2(LinkedListNode n)
	{
		while(n != null)
		{
			LinkedListNode nextN = n;
			while(nextN.next != null)
			{
				if(nextN.next.data == n.data)
					nextN.next = nextN.next.next;
				else
					nextN = nextN.next;
			}
			n = n.next;
		}
	}
	
	public static void main(String[] args)
	{
		LinkedListNode node = new LinkedListNode(2);
		node.appendToTail(1);
		node.appendToTail(3);
		node.appendToTail(1);
		node.appendToTail(4);
		node.appendToTail(3);
		
		removeDups(node);
		//removeDups2(node);
		
		while(node != null)
		{
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
}


