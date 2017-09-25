package Session_4;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ThrowsTest {
	
	public static void main(String[] args) 
	{
		String s="10-12-2012";
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		
		 Date d;
		try {
			d = sdf.parse(s);
			System.out.println(d);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
			
	}
}
		
			
	

