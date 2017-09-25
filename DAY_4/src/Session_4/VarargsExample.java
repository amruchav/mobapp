package Session_4;

public class VarargsExample {
	
	public static void fun(int a,String...s)
	{
		System.out.println(a);

		for(String out:s)
		{
			System.out.println(out);
		}
	}
	public static void main(String[] args)
	{
		fun(60,"20","amruta","sujata","dipen");
	}
	

}
