package Session_4;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExample {
	
	public static void main(String[] args){
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of elements=");
		int n=sc.nextInt();
		System.out.println("Elemets are=");
		int a[]=new int[n];
		for(int i=0;i<a.length;i++)
		{
			a[i]=sc.nextInt();
		}
		Arrays.sort(a);
		System.out.println("After sorting=\n");
		for(int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}
		int min=a[0];
		int max=a[a.length-1];
		System.out.println("Middle element="+a[a.length/2]);
		System.out.println("Addition of min and max="+(min+max));
		
	}

}
