package Session_4;

import java.util.Arrays;

public class ArrayExp1 {
 public static void main(String[] args){
	 int a[]={10,3,5,8};
	 Arrays.sort(a);
	 for(int out:a)
	 {
		 System.out.println(out);
	 }
	 
	 String k ="big "; 
     k.concat("crowded ");
     k += "city";
     System.out.println(k);
 }
 String[][] names = {
         {"Mr.", "Mrs.", "Ms."},
         {"John", "Gupta", "Hegde", "Khan"},
         {":M", ":F"}
 };
 System.out.println(names[0][2] + names[1][2]+ names[2][1]);
}
}