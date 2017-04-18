import java.util.*;
public class C4_Q9_BSTSequences 
{
	//Hard, two different recursive algorithms
	//trust and focus: focus on the one you are dealing with and trust that the others do the right thing
	public ArrayList<LinkedList<Integer>> allSequences(TreeNode node)
	{
		ArrayList<LinkedList<Integer>> result = new ArrayList<>();
		if(node == null) 
		{
			result.add(new LinkedList<Integer>());
			return result;
		}
		
		ArrayList<LinkedList<Integer>> left = allSequences(node.left);
		ArrayList<LinkedList<Integer>> right = allSequences(node.right);
		
		LinkedList<Integer> prefix = new LinkedList<>();
		prefix.add(node.value);
		
		for(LinkedList<Integer> l : left)
		{
			for(LinkedList<Integer> r : right)
			{
				ArrayList<LinkedList<Integer>> tempResult = new ArrayList<>();
				weaveLists(l, r, prefix, tempResult);
				result.addAll(tempResult);
			}
		}
		
		return result;
	}
	
	private void weaveLists(LinkedList<Integer> l, LinkedList<Integer> r, LinkedList<Integer> prefix, ArrayList<LinkedList<Integer>> tempResult)
	{
		if(l.size() == 0 || r.size() == 0)  //we can concatenate them directly
		{
			LinkedList<Integer> weaved = (LinkedList<Integer>)prefix.clone(); //(LinkedList<Integer>) is required for type casting
			weaved.addAll(l);
			weaved.addAll(r);
			tempResult.add(weaved);
			return;
		}
		
		//add the head of l to prefix
		int lhead = l.removeFirst();
		prefix.add(lhead);
		weaveLists(l, r, prefix, tempResult);
		prefix.remove();
		l.addFirst(lhead);
		
		//add the head of r to prefix
		int rhead = r.removeFirst();
		prefix.add(rhead);
		weaveLists(l, r, prefix, tempResult);
		prefix.remove();
		r.addFirst(rhead);
	}
}
