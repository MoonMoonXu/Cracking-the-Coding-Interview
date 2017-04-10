
public class C1_Q5_OneAway
{
	//first compare the lengths of str1 and str2, this is quite easy to think
	public static boolean isOneWay(String str1, String str2)
	{
		if(str1.compareTo(str2) == 0) return true;  //zero edits
		
		if(str1.length() == str2.length()) return isOneReplace(str1, str2);
		if(str1.length() == str2.length() + 1) return isOneInsertOrRemove(str2, str1);
		if(str1.length() == str2.length() - 1) return isOneInsertOrRemove(str1, str2);
		return false;
	}
	
	private static boolean isOneReplace(String str1, String str2)
	{
		int count = 0;
		for(int i = 0; i < str1.length(); i++)
		{
			if(str1.charAt(i) != str2.charAt(i)) count++;
			if(count > 1) return false;
		}
		return true;
	}
	
	private static boolean isOneInsertOrRemove(String str1, String str2)
	{
		int i = 0, j = 0;
		
		while(i < str1.length() && j < str2.length())
		{
			if(str1.charAt(i) != str2.charAt(j))
			{
				if(j - i == 1) return false;
				j++;
			}
			else
			{
				i++;
				j++;
			}
		}		
		return true;
	}
	
	public static void main(String[] args) 
	{
		String str1 = "pale";
		String str2 = "ple";
		if(isOneWay(str1, str2) == true) System.out.println("yes");
		else System.out.println("no");
		
		str1 = "pales";
		str2 = "pale";
		if(isOneWay(str1, str2) == true) System.out.println("yes");
		else System.out.println("no");
		
		str1 = "pale";
		str2 = "bale";
		if(isOneWay(str1, str2) == true) System.out.println("yes");
		else System.out.println("no");
		
		str1 = "pale";
		str2 = "bae";
		if(isOneWay(str1, str2) == true) System.out.println("yes");
		else System.out.println("no");
	}
}
