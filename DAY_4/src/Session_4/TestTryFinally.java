package Session_4;

public class TestTryFinally {
	public static void main(String[] args){
	try{  
	      //int data=50/0;  
		  // String s=null;
		  // System.out.println(s.length());
		 int a[]=new int[5];
				 a[6]=90;
		//String s="abc";
		//int i=Integer.parseInt(s);
	 }
	   catch(ArithmeticException e)
	   {
		   System.out.println(e);
	   }
	   catch(NullPointerException e)
	   {
	   System.out.println(e);  
	  }
	
	 catch(ArrayIndexOutOfBoundsException e)
	{
		System.out.println(e); 
	}
	
	 catch(NumberFormatException e)
		{
			System.out.println(e); 
		}
	catch(Exception b)
	{
		System.out.println("Invalid Input");
	}
	
     finally 
     {
	 
	 System.out.println("Always executed");
	System.exit(0);
       }
	}
}

