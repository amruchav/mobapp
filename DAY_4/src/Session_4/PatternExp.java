
package Session_4;
import java.util.regex.*;

class PatternExp {
	
	public static void main(String[] args){
		String d="capgemini";
		String d1="8123456785";
		String d2="5";
		String d3="Amruta";
		
		String  pattern="[a-z]{2,}";//regex input
		String  pattern1="[789]{1}[0-9]{9}";
		String  pattern2="[0-9]"; //digit only
		String  pattern3="[A-Z]{1}[a-z]{2,}";
		
		boolean b=Pattern.matches(pattern, d);//Pattern matching and store in
		boolean b1=Pattern.matches(pattern1, d1);//boolean as it returns true false
		boolean b2=Pattern.matches(pattern2, d2);
		boolean b3=Pattern.matches(pattern3, d3);
		
		System.out.println(b);
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		
	}

}
