import java.util.Random;

//Optimized solution
//Time: O(log n)
//Call random.nextIn() only once

public class C4_Q11_RandomNode 
{
	TreeNode root = null;
	
	public TreeNode getRandomNode()
	{
		if(root == null) return null;
		
		Random random = new Random();
		int i = random.nextInt(root.size);
		return root.getIthNode(i);
	}
	
	public void treeInsert(int d)
	{
		if(root == null) root = new TreeNode(d);
		else root.insert(d);
	}
	
	class TreeNode
	{
		TreeNode left;
		TreeNode right;
		int data;
		int size = 0;
		
		public TreeNode(int d)
		{
			data = d;
			size = 1;
		}
		
		//Key point
		public TreeNode getIthNode(int i)
		{
			int leftSize = left == null ? 0 : left.size;
			if(i < leftSize) return left.getIthNode(i);
			else if(i == leftSize) return this;
			else return right.getIthNode(i - leftSize - 1);
		}
		
		public void insert(int d)
		{
			if(d <= data)
			{
				if(left == null) left = new TreeNode(d);
				else left.insert(d);
			}
			else
			{
				if(right == null) right = new TreeNode(d);
				else right .insert(d);
			}
		}
		
		public TreeNode find(int d)
		{
			if(d == data) return this;
			else if(d < data) return left == null ? null : left.find(d);
			else return right ==  null ? null : right.find(d);
		}
		
	}
	
}
