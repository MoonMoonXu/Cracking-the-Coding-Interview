import java.util.LinkedList;
import java.util.Queue;

class TreeNode
	{
		TreeNode left;
		TreeNode right;
		int value;
		
		public TreeNode(int value)
		{
			this.value = value;
			left = null;
			right = null;
		}
		
		public void printTree()
		{
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.offer(this);
			while(!queue.isEmpty())
			{
				TreeNode curr = queue.poll();
				if(curr != null)
				{
					queue.offer(curr.left);
					queue.offer(curr.right);
					System.out.print(curr.value + " ");
				}
			}
		}
	}