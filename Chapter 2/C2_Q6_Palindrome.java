
public class C2_Q6_Palindrome 
{
	//Solution 1: Reverse the linked list and compare the reversed list to the original list
	//Solution 2: Iterative approach using a stack and two runners: fast/slow runner
	//Solution 3: Recursive approach with a new class
	
	public static boolean isPalindrome(LinkedListNode node, int length)
	{
		return helper(node, length).result;
	}
	
	private static Result helper(LinkedListNode node, int length)
	{
		if(length == 0) return new Result(node, true);
		else if(length == 1) return new Result(node.next, true);
		
		Result res = helper(node.next, length - 2);
		if(res.result == false)
			return res;
		
		res.result = res.node.data == node.data;
		res.node = res.node.next;
		return res;
	}
	
	public static void main(String[] args)
	{
		LinkedListNode node = new LinkedListNode(1);
		node.appendToTail(2);
		node.appendToTail(3);
		node.appendToTail(3);
		node.appendToTail(2);
		node.appendToTail(1);
		
		if(isPalindrome(node, 6) == true)
			System.out.println("yes");
		else
			System.out.println("no");
	}
}
