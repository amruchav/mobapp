package Session_4;

public class TestTryCatch {
	 
		  public static void main(String args[]){  
		   try{  
		      int data=50/0;  
			  // String s=null;
			  // System.out.println(s.length());
		   }catch(ArithmeticException e)
		   {
			   System.out.println(e);
		   }
		   catch(NullPointerException e)
		   {
		   System.out.println(e);  
		  }
		  
		  }

}
