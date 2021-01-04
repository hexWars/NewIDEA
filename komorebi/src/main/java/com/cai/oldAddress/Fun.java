package com.cai.oldAddress;

import java.util.Scanner;


public class Fun {//姓名，性别，电话，邮箱，微信号//功能:新建,查询,删除,列表或者打开文件

	static void show() {
		System.out.println("============================================");
		System.out.println("===============欢迎使用BNUZ通讯录===============");
		System.out.println("==============按下数字后回车选择功能==============");
		System.out.println("==================1新增联系人==================");
		System.out.println("==================2查询联系人==================");
		System.out.println("==================3删除联系人==================");
		System.out.println("================4编辑联系人信息=================");
		System.out.println("================5查看所有联系人=================");
		System.out.println("============================================");
	}

	public static void main(String[] args) {

		while(true)
		{
			show();
			Scanner in = new Scanner(System.in);
			int a = in.nextInt();
			switch(a){
				case 1 ://加入联系人
					System.out.println("请按格式输入");
					System.out.println("姓名 性别 电话 邮箱 微信号");
					Scanner a1 = new Scanner(System.in);
					People.name = a1.next();
					People.sex = a1.next();
					People.phone = a1.next();
					People.e_mail = a1.next();
					People.WeChat = a1.next();
					InputFile.input( People.name, People.sex, People.phone,
							People.e_mail, People.WeChat);
					break;
				case 2://查询联系人
					System.out.println("请输入姓名");
					Scanner b = new Scanner(System.in);
					String www = b.next();
					NewSeek.fun(www);

					break;
				case 3://删除联系人
					System.out.println("请输入你要删除的联系人的姓名");
					Scanner k = new Scanner(System.in);
					String wl = k.next();
					try {
						Delete.delete(wl);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 4://编辑联系人
					System.out.println("请输入你要编辑的联系人的姓名");
					Scanner r = new Scanner(System.in);
					String indexstr = r.next();

					System.out.println("请输入你要改动的信息(按照姓名 性别 电话 邮箱 微信号的顺序来改)");
					Scanner q = new Scanner(System.in);
					String aa = q.next(),bb = q.next();
					String cc = q.next(),dd = q.next(),ee = q.next();

					try {
						Change.change(indexstr,aa,bb,cc,dd,ee);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 5://列表或者打开txt
					List.fun();
					break;
				default :
					System.out.println("--输入格式错误--");
			}
			System.out.println("--操作成功--");
		}
	}
}
