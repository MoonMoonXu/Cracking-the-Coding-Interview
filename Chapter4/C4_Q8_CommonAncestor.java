
public class C4_Q8_CommonAncestor 
{
	//Test on Leetcode
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        if(root == null) return null;
        if(root == p || root == q) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left == null) return right;  //p and q are both in the right subtree
        else if(right == null) return left;  //p and q are both in the left subtree
        else return root;  //p and q are in different subtrees 
    }
}
