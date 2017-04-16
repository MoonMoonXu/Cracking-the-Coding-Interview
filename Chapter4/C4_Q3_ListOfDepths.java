import java.util.*;
public class C4_Q3_ListOfDepths
{
	//This question is also on Leetcode
	
	//BFS
	public ArrayList<LinkedList<TreeNode>> bfs(TreeNode root)
	{
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		
		while(!queue.isEmpty())
		{
			int layerSize = queue.size();
			LinkedList<TreeNode> layer = new LinkedList<>();
			for(int i = 0; i < layerSize; i++)
			{
				TreeNode curr = queue.poll();
				if(curr.left != null) queue.offer(curr.left);
				if(curr.right != null) queue.offer(curr.right);
				layer.add(curr);
			}
			result.add(layer);
		}
		
		return result;
	}
	
	//DFS
	public ArrayList<LinkedList<TreeNode>> dfs(TreeNode root)
	{
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
		helper(root, result, 0);
		return result;
	}
	
	private void helper(TreeNode root, ArrayList<LinkedList<TreeNode>> result, int depth)
	{
		if(root == null) return;
		if(result.size() == depth)
			result.add(new LinkedList<TreeNode>());
		result.get(depth).add(root);
		helper(root.left, result, depth + 1);
		helper(root.right, result, depth + 1);
	}
	
}
