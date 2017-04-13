import java.util.ArrayList;
public class C2_Q2_KthToLast
{
	//We define k = 1 as the last element
	
	//Solution 1: don't return the node, just return the index of it
	public static int kthToLast(LinkedListNode node, int k)
	{
		if(node == null) return 0;
		int index = kthToLast(node.next, k) + 1;
		if(index == k) System.out.println(k + "th to last node is: " + node.data);
		return index;
	}
	
	//Solution 2: use ArrayList to store the index
	//the updated index and node can be seen in each layer of recursion
	public static LinkedListNode kthToLast2(LinkedListNode node, int k)
	{
		ArrayList<Integer> index = new ArrayList<Integer>();
		return helper(node, index, k);
	}
	
	private static LinkedListNode helper(LinkedListNode node, ArrayList<Integer> index, int k)
	{
		if(node == null) return null;
		
		LinkedListNode result = helper(node.next, index, k);
		index.add(1);
		if(index.size() == k)
			return node;
		return result;
	}
	
	
	//Solution 3: using iteration
	public static LinkedListNode kthToLast3(LinkedListNode node, int k)
	{
		LinkedListNode p1 = node;
		LinkedListNode p2 = node;
		
		//Move p1 kth node into the list
		for(int i = 0; i < k; i++)
			p1 = p1.next;
		
		//When p1 reaches the end, p2 is the kth node to last
		while(p1 != null)
		{
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p2;
	}
	
	public static void main(String[] args)
	{
		LinkedListNode node = new LinkedListNode(1);
		node.appendToTail(2);
		node.appendToTail(3);
		node.appendToTail(4);
		node.appendToTail(5);
		node.appendToTail(6);
		
		kthToLast(node, 2);
		
		System.out.println(2 + "th to last node is: " + kthToLast2(node, 2).data);
		
		System.out.println(2 + "th to last node is: " + kthToLast3(node, 2).data);
	}
}
