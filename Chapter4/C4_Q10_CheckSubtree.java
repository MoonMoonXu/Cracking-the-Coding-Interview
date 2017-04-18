
public class C4_Q10_CheckSubtree
{
	//Solution 1: Using pre-order traverse to construct the two trees, and then compare the two strings
	//Time: O(m + n), Space: O(m + n)
	
	//Solution 2: 
	//Time: O(mn) in the worst case, O(n + km) k = n/p in average
	//Space: (logm + logn)  —— I don't know why。。。
	
	boolean checkSubtree(TreeNode node1, TreeNode node2)
	{
		if(node2 == null) return true;
		if(node1 == null) return false;
		
		if(node1.value== node2.value && matchTree(node1, node2)) return true;
		return checkSubtree(node1.left, node2) || checkSubtree(node1.right, node2);
	}
	
	boolean matchTree(TreeNode node1, TreeNode node2)
	{
		if(node1 == null && node2 == null) return true;
		else if(node1 == null || node2 == null) return false;
		else if(node1.value != node2.value) return false;
		else return matchTree(node1.left, node2.left) && matchTree(node1.right, node2.right);
	}
}
