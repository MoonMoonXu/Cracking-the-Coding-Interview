import java.util.HashMap;
public class C1_Q4_PalindromePermutation
{
	//Easy to think of
	public static boolean isPalindromePermutation(String str)
	{
		char[] charset = str.toCharArray();
		HashMap<Character, Integer> hashmap = new HashMap<>();
		
		for(char c : charset)
		{
			if(c < 'a' || c > 'z') continue;  //skip the non-letter characters
			if(!hashmap.containsKey(c)) hashmap.put(c, 1);
			else hashmap.put(c, hashmap.get(c) + 1); 
		}
		
		int numberOfOne = 0;
		
		for(char c : hashmap.keySet())
		{
			if(hashmap.get(c) % 2 != 0 && numberOfOne != 0) return false;
			else if(hashmap.get(c) == 1) numberOfOne++;
		}
		
		return true;
	}
	
	//Bit Maniputation, similar to Q1
	//no need to record the count of each character
	public static boolean isPalindromePermutation2(String str)
	{
		int flag = 0;
		for(int i = 0; i < str.length(); i++)
		{
			int value = str.charAt(i) - 'a';
			if(value < 0 || value > 25) continue;
			if((flag & (1 << value)) == 0) flag |= 1 << value;
			else flag &= ~(1 << value);
		}
		
		if(flag == 0 || (flag & (flag - 1)) == 0) return true;
		else return false;	
	}
	
	public static void main(String[] args) 
	{
		String str = "taco cat";
		if(isPalindromePermutation(str) == true) System.out.println("yes");
		else System.out.println("no");
		if(isPalindromePermutation2(str) == true) System.out.println("yes");
		else System.out.println("no");
	}
}
