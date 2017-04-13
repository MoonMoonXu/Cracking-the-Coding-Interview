
public class C2_Q7_Intersection
{
	//Another Solution:
	//https://discuss.leetcode.com/topic/28067/java-solution-without-knowing-the-difference-in-len
	
	public static LinkedListNode intersection(LinkedListNode node1, LinkedListNode node2)
	{
		LinkedListNode curr1 = node1;
		int length1 = 1;
		while(curr1.next != null)
		{
			length1++;
			curr1 = curr1.next;
		}
		
		LinkedListNode curr2 = node2;
		int length2 = 1;
		while(curr2.next != null)
		{
			length2++;
			curr2 = curr2.next;
		}
		
		if(curr1 != curr2) return null;  //compare the tails
		
		curr1 = node1;
		curr2 = node2;
		if(length1 > length2)
		{
			for(int i = 0; i < length1 - length2; i++)
				curr1 = curr1.next;
		}
		else
		{
			for(int i = 0; i < length2 - length1; i++)
				curr2 = curr2.next;
		}
		
		while(curr1 != curr2)
		{
			curr1 = curr1.next;
			curr2 = curr2.next;
		}
		
		return curr1;
	}
	
	public static void main(String[] args)
	{
		LinkedListNode node1 = new LinkedListNode(3);
		node1.appendToTail(1);
		node1.appendToTail(5);
		node1.appendToTail(9);
		
		LinkedListNode node2 = new LinkedListNode(4);
		node2.appendToTail(6);
		
		LinkedListNode node3 = new LinkedListNode(7);
		node3.appendToTail(2);
		node3.appendToTail(1);
		
		LinkedListNode curr1 = node1;
		while(curr1.next != null)
			curr1 = curr1.next;
		curr1.next = node3;
		
		LinkedListNode curr2 = node2;
		while(curr2.next != null)
			curr2 = curr2.next;
		curr2.next = node3;
		
		LinkedListNode result = intersection(node1, node2);
		if(result == null) System.out.println("Not intersected");
		else System.out.println("The intersected node is: " + result.data);
	}
}
