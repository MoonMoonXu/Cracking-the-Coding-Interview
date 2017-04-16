
public class C4_Q5_ValidateBST
{
	//In-Order Traverse
	//Bottom to Top
	public boolean isBST(TreeNode root)
	{
		int[] value = {Integer.MIN_VALUE};
		return helper(root, value);
	}
	
	private boolean helper(TreeNode root, int[] value)
	{
		if(root == null) return true;
		
		if(!helper(root.left, value)) return false;
		
		if(root.value < value[0]) return false;
		else value[0] = root.value;
		
		if(!helper(root.right, value)) return false;
		
		return true;
	}
	
	//Solution 2: 
	//Top to Bottom 
	public boolean isBST2(TreeNode root)
	{
		return helper2(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private boolean helper2(TreeNode root, int min, int max)
	{
		if(root == null) return true;
		
		if(root.value <= min || root.value > max) return false;
		
		if(!helper2(root.left, min, root.value) || !helper2(root.right, root.value, max))
			return false;
		
		return true;
	}
	
}
