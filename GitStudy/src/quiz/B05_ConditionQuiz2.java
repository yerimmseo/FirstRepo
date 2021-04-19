package quiz;

import java.util.Scanner;

public class B05_ConditionQuiz2 {
		
	/*
	    [ ¾Ë¸ÂÀº Á¶°Ç½ÄÀ» ¸¸µé¾îº¸¼¼¿ä ]
	    1. charÇü º¯¼ö a°¡ 'q'¶Ç´Â 'Q'ÀÏ ¶§ true
	    2. charÇü º¯¼ö b°¡ °ø¹éÀÌ³ª ÅÇÀÌ ¾Æ´Ò ¶§ true
	    3. charÇü º¯¼ö c°¡ ¹®ÀÚ('0' ~ '9')ÀÏ ¶§ true
	    4. charÇü º¯¼ö d°¡ ¿µ¹®ÀÚ(´ë¹®ÀÚ ¶Ç´Â ¼Ò¹®ÀÚ)ÀÏ ¶§ true
	    
	    ¡Ø À¯´ÏÄÚµå Ç¥ ÂüÁ¶
	    5. charÇü º¯¼ö e°¡ ÇÑ±ÛÀÏ ¶§ true
	    6. charÇü º¯¼ö f°¡ ÀÏº»¾îÀÏ ¶§ true
	    
	    7. »ç¿ëÀÚ°¡ ÀÔ·ÂÇÑ ¹®ÀÚ¿­ÀÌ exitÀÏ¶§ true 
	*/
	public static void main(String[] args) {
		
		char a = 'Q';
		char b = '1';
		char c = 'a';
		char d = '3';
		char e = 'ÆP';
		char f;
		String user;
		
		System.out.println(a == 'q' || a == 'Q');
		System.out.println(b != ' ' && b != '	');
		System.out.println(c >= '0' && c <= '9');
		System.out.println((d >= 'a' && d <= 'z') || (d >= 'A' && d <= 'Z'));
		System.out.println(e >= '°¡' && e <= 'ÆR');
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("»ç¿ëÀÚ°¡ ÀÔ·ÂÇÑ ¹®ÀÚ > ");
		user = sc.next();
		System.out.println(user.equals("exit"));
		
	}
	
}
