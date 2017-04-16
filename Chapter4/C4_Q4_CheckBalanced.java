
public class C4_Q4_CheckBalanced 
{
	//This question is also on Leetcode
	//This solution is bottom-to-up. Each node is traversed only  once
	
	public boolean isbalanced(TreeNode root)
	{
		return height(root) != -1;
	}
	
	private int height(TreeNode root)
	{
		if(root == null) return 0;
		int left = height(root.left);
		if(left == -1) return -1;
		int right = height(root.right);
		if(right == -1) return -1;
		
		if(left - right > 1 || right - left > 1) return -1;
		return Math.max(left, right) + 1;
	}
}
