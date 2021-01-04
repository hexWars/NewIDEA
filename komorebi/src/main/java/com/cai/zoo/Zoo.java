package com.cai.zoo;

import java.util.ArrayList;

public class Zoo {
	public static ArrayList<Animal> listAnimals = new ArrayList<Animal>();
	private String name;
	
	public Zoo(String next) {
		// TODO Auto-generated constructor stub
		this.name = next;
	}
	
	public static void add(Animal a) {
		// TODO Auto-generated method stub
		listAnimals.add(a);
	}
	
	public static void list() {
		for( Animal a : listAnimals) {
			a.print();
		}
	}
	
	public void print() {
		System.out.println("��ӭ����"+this.name+"����԰");
		System.out.println("���ǹ���Ա"+Manager.name);
	}
}
