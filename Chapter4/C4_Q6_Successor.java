
public class C4_Q6_Successor 
{
	//In-Order, find the next
	public static Node successor(Node root)
	{
		if(root.right != null) return root.right;
		else
		{
			Node parent = root.parent;
			while(parent != null && root == parent.right)  //if root is on the right of its parent
			{
				root = parent;
				parent = root.parent;
			}
			return parent;  //parent might be null, but it's still right
		}
	}
	
	class Node
	{
		Node left;
		Node right;
		Node parent;
		int value;
		
		public Node(int value)
		{
			this.value = value;
			this.left = null;
			this.right = null;
			this.parent = null;
		}
	}
}
