package org.lesho.hacknet;

import java.io.*;
import java.util.*;

public class hacknet_main {
	
	static Scanner sc = new Scanner(System.in);
	static Random rand = new Random();
	static String actorIP;
	
	
	public static void main(String[] args)  {

		System.out.println("欢迎使用黑客网");
		System.out.println("==============\n1.登陆游戏\n2.注册账号\n3.退出游戏\n==============");
		//检测指令
			while(true) {
				String startMenu = sc.next();
				if (startMenu.equals("1")) {
					loginSystem();
					break;
				} 	else if (startMenu.equals("2")) {
					registerSystem();
					break;
				} 	else if (startMenu.equals("3")) {
					System.exit(0);
				}	else {
					System.out.println("您输入的指令不对请重新输入");
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("==============\n1.登陆游戏\n2.注册账号\n3.退出游戏\n==============");
				}
			}
	
		System.out.println("登陆成功");
		System.out.println("正在获取IP地址");
			try {
				System.out.println(".");
				Thread.sleep(1000);
				System.out.println(".");
				Thread.sleep(1000);
				System.out.println(".");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("=================================\n您被分配到的ip为：" + actorIP + " \n=================================");	
		
	}
	public static void registerSystem() {//注册系统
		
		String registerUsername;
		String registerPassword;
		String registerIP;
		
		System.out.println("这里是黑客网注册中心\n接下来请让我帮您注册会员账号");
		try {
			File passwd = new File(".\\.passwd");
			passwd.createNewFile();
			BufferedWriter buffw = new BufferedWriter(new FileWriter(passwd));
			System.out.print("请输入用户名："); registerUsername = sc.next();
			System.out.print("密码："); registerPassword = sc.next();
			buffw.write(registerUsername+":");
			buffw.write(registerPassword+":");
			registerIP = generateIP();
			buffw.write(registerIP);
			buffw.flush();
			buffw.close();
			System.out.println("注册成功正在为您跳转到登录界面");
			try {
				System.out.println(".");
				Thread.sleep(1000);
				System.out.println(".");
				Thread.sleep(1000);
				System.out.println(".");
				Thread.sleep(1000);
				loginSystem();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}
			
	public static void loginSystem() {
				
		String loginUsername ;
		String registerUsername = null ;
		String loginPassword ;
		String registerPassword = null ;
		int countErrorPassword = 0;
		File file = new File(".\\.passwd");
		
		 StringBuilder result = new StringBuilder();
		 try{
			  BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
			  String s = null;
			 while((s = br.readLine())!=null){//使用readLine方法，一次读一行
			 result.append(System.lineSeparator()+s);
			 String[] temp = s.split(":");
			 for (int i = 0; i < temp.length; i++) {
				 
				if(i == 0) {
					registerUsername = temp[i];
				}else if (i == 1) {
					registerPassword = temp[i];
				}else if(i == 2) {
					actorIP = temp[i];
				}
				
				
			 }
			 }
			 	br.close(); 
			 	
		 }catch(Exception e){
	            e.printStackTrace();
	        }
			
			while(true) {
				System.out.print("账号："); loginUsername = sc.next();
				
				System.out.print("密码："); loginPassword = sc.next();
				
					if (loginUsername.equals(registerUsername)  && loginPassword.equals(registerPassword)) {
						break;
					}else{
						System.out.println("请输入正确的账号密码");
						countErrorPassword += 1;
					if (countErrorPassword == 3) {
						System.out.println("密码错误三次，自动退出程序");
						System.exit(0);
						}
				}	
			}	
	}
	
	public static String generateIP() {
		
		String ip ;

		ip = Math.abs(rand.nextInt() % 255) + "." + Math.abs(rand.nextInt() % 255)+ "." + Math.abs(rand.nextInt() % 255)+ "." + Math.abs(rand.nextInt() % 255);
		
		return ip;
	}
}
