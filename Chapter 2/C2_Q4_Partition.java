
public class C2_Q4_Partition 
{
	/*
	 * My first thought: can we just exchange the value of two nodes without exchanging their positions?
	 * If yes, we can set two pointers: left and right;
	 * left indicates the node less than x, right indicates the node larger than x;
	 * Initialize left as the first node, right as null;
	 * When left < x, move on, otherwise, stop there, set right as left.next
	 * when right >=x, move on, otherwise, stop there, exchange the value of left with right
	 * continue moving left and right until right reaches the end.
	 */

	//Solution 1: stable
	public static LinkedListNode partition(LinkedListNode node, int x)
	{
		LinkedListNode beforeHead = null;
		LinkedListNode beforeEnd = null;
		LinkedListNode afterHead = null;
		LinkedListNode afterEnd = null;
		
		while(node != null)
		{
			LinkedListNode temp = node.next;
			node.next = null; //Important! Otherwise, node is a list of nodes, so beforeHead will also be list of nodes
			//But what we want is just a single node
			
			if(node.data < x)
			{
				if(beforeHead == null)
				{
					beforeHead = node;
					beforeEnd = beforeHead;
				}
				else
				{
					beforeEnd.next = node;
					beforeEnd = beforeEnd.next;
				}
			}
			else
			{
				if(afterHead == null)
				{
					afterHead = node;
					afterEnd = afterHead;
				}
				else
				{
					afterEnd.next = node;
					afterEnd = afterEnd.next;
				}
			}
			
			node = temp;
		}
		
		//Merge before and after
		beforeEnd.next = afterHead;
		return beforeHead;
	}
	
	
	//Solution 2: Unstable
	//Nodes less than x will be added to the head, nodes larger than x will be added to the end
	public static LinkedListNode partition2(LinkedListNode node, int x)
	{
		LinkedListNode newHead = null;
		LinkedListNode newEnd = null;
		
		while(node != null)
		{
			LinkedListNode temp = node.next;
			node.next = null; //node becomes a single node
			
			if(newHead == null)
			{
				newHead = node;
				newEnd = newHead;
			}
			
			if(node.data < x)
			{
				node.next = newHead;
				newHead = node;
			}
			else
			{
				newEnd.next = node;
				newEnd = newEnd.next;
			}
			
			node = temp;
		}
		return newHead;
	}
	
	public static void main(String[] args)
	{
		LinkedListNode node = new LinkedListNode(3);
		node.appendToTail(5);
		node.appendToTail(8);
		node.appendToTail(5);
		node.appendToTail(10);
		node.appendToTail(2);
		node.appendToTail(1);
		
		LinkedListNode result = partition(node, 5);
		while(result != null)
		{
			System.out.print(result.data + " ");
			result = result.next;
		}

		System.out.println();
		
		result = partition2(node, 5);
		while(result != null)
		{
			System.out.print(result.data + " ");
			result = result.next;
		}
	}
	

}
