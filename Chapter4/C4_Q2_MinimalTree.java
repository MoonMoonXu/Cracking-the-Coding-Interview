
public class C4_Q2_MinimalTree
{
	//Similar to Binary Search
	public static TreeNode minimalTree(int[] array)
	{
		return helper(array, 0, array.length - 1);
	}
	
	private static TreeNode helper(int[] array, int left, int right)
	{
		if(left > right) return null;
		int mid = (left + right) / 2;
		TreeNode root = new TreeNode(array[mid]);
		root.left = helper(array, left, mid - 1);
		root.right = helper(array, mid + 1, right);
		
		return root;
	}
	
	public static void main(String[] args)
	{
		int[] array = {1, 2, 3, 4, 5, 6, 7};
		TreeNode root = minimalTree(array);
		root.printTree();
	}

}
