package com.cai.zoo;

import java.util.Scanner;

public class Game {
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		//用户输入动物园名称 管理员名称 老虎名1 老虎名2 蛇名1 蛇名2（名字之间不允许空格）
		
		System.out.println("输入 动物园名称 管理员名称 老虎名1 老虎名2 蛇名1 蛇名2");
		Scanner input = new Scanner(System.in);
		
//		while (input.hasNext()) {
		
			// 创建一个动物园
			Zoo zoo = new Zoo(input.next());
			
			// 有个管理员
			Manager manager = new Manager(input.next());
			
			// 管理刚才创建的动物园
			manager.setManage(zoo);
			
			// 创建2只老虎
			Animal tiger1 = new Tiger(input.next());
			Animal tiger2 = new Tiger(input.next());
			
			// 创建2条蛇
			Animal snake1 = new Snake(input.next());
			Animal snake2 = new Snake(input.next());
			
			// 管理员将他们放到动物园.每次放动物到动物园时，动物都会发出叫声
			//叫声的格式：动物名 is 叫声！
			//老虎叫声用roaring,蛇叫声hissing
			Zoo.add(tiger1);
			Zoo.add(tiger2);
			Zoo.add(snake1);
			Zoo.add(snake2);
			
			// 查看动物园里有多少动物，和列出所有动物
			
			zoo.print();
			
			zoo.list();

		
	}
}