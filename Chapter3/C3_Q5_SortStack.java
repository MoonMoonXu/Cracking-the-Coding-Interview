import java.util.Stack;
public class C3_Q5_SortStack 
{
	public static void sortStack(Stack<Integer> stack)
	{
		Stack<Integer> result = new Stack<Integer>();
		while(!stack.isEmpty())
		{
			int temp = stack.pop();
			while(!result.isEmpty() && temp < result.peek())
				stack.push(result.pop());
			result.add(temp);
		}
		
		//copy: can not use "stack = result;"
		while(!result.isEmpty())
			stack.push(result.pop());
	}
	
	public static void main(String[] args)
	{
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(7);
		stack.push(5);
		stack.push(10);
		stack.push(8);
		
		sortStack(stack);
		
		while(!stack.isEmpty())
			System.out.print(stack.pop() + " ");
		
	}
}
