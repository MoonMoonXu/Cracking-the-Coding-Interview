
public class C1_Q6_StringCompression 
{
	public static String stringCompression(String str)
	{
		//Check if we need to build a new string in advance
		int newLength = countLength(str);
		if(newLength >= str.length()) return str;
		
		StringBuilder sb = new StringBuilder(newLength);
		int length = 0;
		
		for(int i = 0; i < str.length(); i++)
		{
			length++;
			if(i == str.length() - 1 || str.charAt(i) != str.charAt(i + 1))
			{
				sb.append(str.charAt(i));
				sb.append(length);
				length = 0;
			}
		}
		
		return sb.length() < str.length() ? sb.toString() : str;
	}
	
	private static int countLength(String str)
	{
		int length = 0;
		int newLength = 0;
		
		for(int i = 0; i < str.length(); i++)
		{
			length++;
			if(i == str.length() - 1 || str.charAt(i) != str.charAt(i + 1))
			{
				//
				newLength += 1 + String.valueOf(length).length();
				length = 0;
			}
		}
		
		return newLength;
	}
	
	public static void main(String[] args) 
	{
		String str = "aabcccccaaa";
		System.out.println(stringCompression(str));
		
		str = "aabccaa";
		System.out.println(stringCompression(str));
	}
}
