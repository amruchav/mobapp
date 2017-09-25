//matcher class


package Session_4;

import java.util.regex.*;

public class RegExp {
	
	public static void main(String[] args)

	{
		Pattern p=Pattern.compile("[0-9]{1}[a-zA-Z]{3}");
		Matcher m=p.matcher("0abc");
		boolean b=m.matches();
		System.out.println(b);
	}
}
