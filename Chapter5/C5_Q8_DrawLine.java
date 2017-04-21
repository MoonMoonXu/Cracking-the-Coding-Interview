
public class C5_Q8_DrawLine 
{
	/*
	 * First, set all the full bytes between x1 and x2
	 * Second, set the first and last byte that are not full
	 */
	void drawLine(byte[] screen, int width, int x1, int x2, int y)
	{
		int first_left = x1 % 8;
		int first_num = x1 / 8;
		int last_left = x2 % 8;
		int last_num = x2 / 8;
		
		int first_full = first_left == 0 ? first_num : first_num++;
		int last_full = last_left == 0 ? last_num : last_num--;
		
		//set all the full bytes
		for(int i = first_full; i <= last_full; i++)
		{
			screen[width / 8 * y + i] |= (byte) 0xff;	//byte type has 8 bits
		}
		
		//create masks for the first and last byte
		byte first_mask = (byte) (0xff >> first_left);
		byte last_mask = (byte) (0xff << (8 - last_left));
		
		//set the first and last byte
		
		//if x1 and x2 are in the same byte
		if(first_num == last_num)
		{
			byte mask = (byte) (first_mask & last_mask);
			screen[width / 8 * y + first_num] |= mask;
		}
		else
		{
			screen[width / 8 * y + first_num] |= first_mask;
			screen[width / 8 * y + last_num] |= last_mask;
		}
	}
}
