
public class C2_Q3_DeleteMiddleNode
{
	public static void deleteMiddleNode(LinkedListNode n)
	{
		if(n == null || n.next == null) return;
		
		n.data = n.next.data;
		n.next = n.next.next;
	}
	
	public static void main(String[] args)
	{
		LinkedListNode node = new LinkedListNode(1);
		node.appendToTail(2);
		node.appendToTail(3);
		node.appendToTail(4);
		node.appendToTail(5);
		node.appendToTail(6);
	
		deleteMiddleNode(node.next.next);
		
		while(node != null)
		{
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
}
