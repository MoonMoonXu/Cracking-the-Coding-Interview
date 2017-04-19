import java.util.HashMap;

public class C4_Q12_PathsWithSum 
{
	/*
	 * Time: O(n)
	 * We use DFS to traverse each node only once. In every route(from root to leaf), we put every node
	 * on the route to hashmap which maps currentsum to the number of times we have seem that sum. 
	 * When currentSum - targetSum is found in the hashmap, we add the total sum with the sum in the hashmap
	 * When currentSum == targetSum, we add the total sum by 1.
	*/
	
	public int pathsWithSum(TreeNode root, int targetSum)
	{
		return helper(root, targetSum, 0, new HashMap<Integer, Integer>());
	}
	
	private int helper(TreeNode root, int targetSum, int currentSum, HashMap<Integer, Integer> hashmap)
	{
		if(root == null) return 0;
		
		currentSum += root.value;
		int num = hashmap.getOrDefault(currentSum - targetSum, 0);
		if(currentSum == targetSum) num++;
		
		incrementHashMap(hashmap, currentSum, 1);
		num += helper(root.left, targetSum, currentSum, hashmap);
		num += helper(root.right, targetSum, currentSum, hashmap);
		incrementHashMap(hashmap, currentSum, -1);  //recover hashmap
		
		return num;
	}
	
	private void incrementHashMap(HashMap<Integer, Integer> hashmap, int currentSum, int value)
	{
		value += hashmap.getOrDefault(currentSum, 0);
		if(value == 0) hashmap.remove(currentSum);
		else hashmap.put(currentSum, value);
	}
}
