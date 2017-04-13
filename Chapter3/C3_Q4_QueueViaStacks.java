import java.util.Stack;

//I have met this question in the Princeton Algorithms lesson, it's amazing that I still remember the solution.....
//Using two stacks
public class C3_Q4_QueueViaStacks 
{
	Stack<Integer> stack1;
	Stack<Integer> stack2;
	
	public C3_Q4_QueueViaStacks()
	{
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}
	
	public int size()
	{
		return stack1.size() + stack2.size();
	}
	
	public void offer(int value)
	{
		stack1.push(value);
	}
	
	public int poll()
	{
		if(!stack2.isEmpty()) return stack2.pop();
		else
		{
			while(!stack1.isEmpty())
			{
				stack2.push(stack1.pop());
			}
			return stack2.pop();
		}
	}
	
	public int peek()
	{
		if(!stack2.isEmpty()) return stack2.peek();
		else
		{
			while(!stack1.isEmpty())
			{
				stack2.push(stack1.pop());
			}
			return stack2.peek();
		}
	}
}
