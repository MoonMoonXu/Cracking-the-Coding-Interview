
public class C2_Q8_LoopDetection 
{
	public static LinkedListNode loopDetection(LinkedListNode node)
	{
		LinkedListNode slow = node;
		LinkedListNode fast = node;
		
		while(fast != null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) break;
		}
		
		//Error check!
		if(fast == null || fast.next == null) return null;
		
		slow = node;
		while(slow != fast)
		{
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow;
	}
	
	public static void main(String[] args)
	{
		LinkedListNode node = new LinkedListNode(1);
		node.appendToTail(2);
		LinkedListNode node1 = new LinkedListNode(3);
		node.next.next = node1;
		node.appendToTail(4);
		node.appendToTail(5);
		LinkedListNode curr = node;
		while(curr.next != null)
			curr = curr.next;
		curr.next = node1;
		
		System.out.println(loopDetection(node).data);
	}
}
