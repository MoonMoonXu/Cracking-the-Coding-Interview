import java.util.Arrays;

public class C1_Q1_IsUnique
{
	public static boolean isUnique_First(String str)
	{
		//Assume 128 characters of ASCII
		//Time: O(n) Space: O(128)
		if(str.length() > 128) return false;
		
		int[] charset = new int[128];
		
		for(int i = 0; i < str.length(); i++)
		{
			if(charset[str.charAt(i)] == 1) return false;
			charset[str.charAt(i)] = 1;
		}
		
		return true;
	}
	
	public static boolean isUnique_Second(String str)
	{
		//Assume 26 lowercase letters
		//Bit Manipulation
		//Time: O(n) Space: O(1)
		if(str.length() > 26) return false;
		
		int flag = 0;
		
		for(int i = 0; i < str.length(); i++)
		{
			int value = str.charAt(i) - 'a';
			if((flag & (1 << value)) != 0) return false;
			flag |= (1 << value);
		}
		
		return true;
	}
	
	public static void main(String[] args) 
	{
		String str = "aefhjfiones";
		
		if(isUnique_First(str) == true) System.out.print("yes");
		else System.out.println("no");
		
		if(isUnique_Second(str) == true) System.out.print("yes");
		else System.out.println("no");
	}

}
