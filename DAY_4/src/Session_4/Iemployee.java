package com.cg.main;

public class Iemployee implements employeeImp{
	
	@Override
	public void display() {
		System.out.println("DISPLAY");
	}
	
	@Override
	public void retrival() {
			System.out.println("RETRIVAL");
		}
		
		

	@Override
	public void insert() {
			System.out.println("INSERT");
		}
		
public static void main(String[] args){
	Iemployee i=new Iemployee();
	i.display();
	i.retrival();
	i.insert();
}
}
