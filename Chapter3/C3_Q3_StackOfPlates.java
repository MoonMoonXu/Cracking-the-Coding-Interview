import java.util.Stack;


import java.util.ArrayList;

public class C3_Q3_StackOfPlates
{
	private int capacity;
	ArrayList<NewStack> stacks = new ArrayList<NewStack>();
	
	public C3_Q3_StackOfPlates(int capacity)
	{
		this.capacity = capacity;
	}
	
	public void push(int value)
	{
		NewStack last = lastStack();
		if(last != null && !last.isFull())
			last.push(value);
		else
		{
			NewStack stack = new NewStack(capacity);
			stack.push(value);
			stacks.add(stack);
		}
	}
	
	public int pop()
	{
		NewStack last = lastStack();
		int value = last.pop();
		if(last.size == 0) stacks.remove(stacks.size() - 1);
		return value;
	}
	
	public int popAt(int index)
	{
		return leftShift(index, true);
	}
	
	//After removing the element if the middle stack, we need to shift the elements in the next stack
	//left into the middle stack to fill the blank!
	public int leftShift(int index, boolean removeTop)
	{
		NewStack stack = stacks.get(index);
		int value;
		if(removeTop) value = stack.pop();
		else value = stack.removeBottom();
		if(stack.isEmpty()) stacks.remove(stacks.size() - 1);
		else if(stacks.size() > index + 1)
			stack.push(leftShift(index + 1, false));
		
		return value;
	}
	
	public NewStack lastStack()
	{
		if(stacks.size() == 0) return null;
		return stacks.get(stacks.size() - 1);
	}
	

class NewStack 
{
	private int capacity;
	private Node top, bottom;
	public int size = 0;
	
	public NewStack(int capacity)
	{
		this.capacity = capacity;
	}
	
	public boolean isFull()
	{
		return size == capacity;
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}
	public void push(int value)
	{
		Node node = new Node(value);
		if(size == 0) 
			bottom = node;
		join(node, top);
		top = node;
		size++;
	}
	
	public int pop()
	{
		Node node = top;
		top = top.below;
		size--;
		return node.value;
	}
	
	public int removeBottom()
	{
		Node b = bottom;
		bottom = bottom.above;
		if(bottom != null) bottom.below = null;
		size--;
		return b.value;
	}
	
	public void join(Node above, Node below)
	{
		if(below != null) below.above = above;
		if(above != null) above.below = below;
	}
	
	class Node
	{
		Node below;
		Node above;
		int value;
		
		public Node(int value)
		{
			value = this.value;
		}
	}
	
}

}
