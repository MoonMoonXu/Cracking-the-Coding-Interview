import java.util.HashMap;
public class C1_Q2_CheckPermutations
{
	//Using HashMap (or array with a size of 128)
	//Time: O(n)
	public static boolean isPermutation(String str1, String str2)
	{
		 if(str1.length() != str2.length()) return false;
		 char[] charset1 = str1.toCharArray();
		 char[] charset2 = str2.toCharArray();
		 HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();
		 
		 for(char c : charset1)
		 {
			 if(!hashmap.containsKey(c)) hashmap.put(c, 1);
			 else hashmap.put(c, hashmap.get(c) + 1);
		 }
		 
		 for(char c : charset2)
		 {
			 if(!hashmap.containsKey(c) || hashmap.get(c) == 0) return false; 
			 hashmap.put(c, hashmap.get(c) - 1);
		 }
		 
		 return true;
	}
	
	public static void main(String[] args) 
	{
		String str1 = "apple";
		String str2 = "papel";
		
		if(isPermutation(str1, str2) == true) System.out.print("yes");
		else System.out.println("no");
	}
}
