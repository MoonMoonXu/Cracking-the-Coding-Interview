
public class C1_Q9_StringRotation
{
	//Quite smart solution
	 public static boolean isRotation(String str1, String str2)
	 {
		 String str = str1 + str1;
		 if(isSubstring(str, str2))
			 return true;
		 return false;
	 }
	 
	 private static boolean isSubstring(String str1, String str2)
	 {
		 for(int i = 0; i <= str1.length() - str2.length(); i++)
		 {
			 if(str1.startsWith(str2, i))
				 return true;
		 }
		 return false;
	 }
	 
	 public static void main(String[] args) 
	 {
		 String str1 = "waterbottle";
		 String str2 = "erbottlewat";
		 if(isRotation(str1, str2) == true)
			 System.out.println("yes");
		 else
			 System.out.println("no");
	 }	
}
