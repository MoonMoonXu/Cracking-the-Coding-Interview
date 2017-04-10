
public class C1_Q3_URLify 
{
	//Time: O(n)
	public static String replaceSpace(String str, int trueLength)
	{
		char[] charset = str.toCharArray();
		int countSpace = 0;
		
		for(int i = 0; i < trueLength; i++)
			if(charset[i] == ' ') countSpace++;
		
		int newLength = trueLength + 2 * countSpace;
		int j = newLength - 1;
		for(int i = trueLength - 1; i >= 0; i--)
		{
			if(charset[i] == ' ')
			{
				charset[j--] = '0';
				charset[j--] = '2';
				charset[j--] = '%';
			}
			else charset[j--] = charset[i];
		}
		
		str = String.valueOf(charset);   //This is not in-place, but easy to revise by changing the input(String str -> char[] charset)
		return str;
	}
	
	public static void main(String[] args) 
	{
		String str = "Mr John Smith    ";
		int length = 13;
		str = replaceSpace(str, length);
		System.out.println(str);
	}
}
