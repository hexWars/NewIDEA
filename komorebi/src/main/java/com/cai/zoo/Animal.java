package com.cai.zoo;

public class Animal {
	protected String name;
	protected String wow;
	
	public Animal(String name) {
		super();
		this.name = name;
	}
	
	public void print() {
		// TODO Auto-generated method stub
		System.out.println(this.name+" is "+this.wow);
	}
	
	
}
