import java.util.Stack;
public class C3_Q2_StackMin extends Stack<Integer>
{
	Stack<Integer> min;
	public C3_Q2_StackMin()
	{
		min = new Stack<Integer>();
	}
	
	public void push(int value)
	{
		super.push(value);
		if(value < min()) min.push(value);
	}
	
	public Integer pop()  //the return type is Integer, not int
	{
		int value = super.pop();
		if(min() == value) min.pop();
		return value;
	}
	
	public int min()
	{
		if(!min.isEmpty()) return min.peek();
		else return Integer.MAX_VALUE;
	}
	
	public static void main(String[] args)
	{
		C3_Q2_StackMin stack = new C3_Q2_StackMin();
		stack.push(5);
		System.out.println(stack.min());
		stack.push(6);
		System.out.println(stack.min());
		stack.push(3);
		System.out.println(stack.min());
		stack.push(7);
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());
	}
}
