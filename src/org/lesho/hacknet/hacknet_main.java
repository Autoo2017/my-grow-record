package org.lesho.hacknet;

import java.io.*;
import java.util.*;

public class hacknet_main {
	
	static Scanner sc = new Scanner(System.in);
	static Random rand = new Random();
	static String actorIP;
	
	
	public static void main(String[] args)  {

		System.out.println("��ӭʹ�úڿ���");
		System.out.println("==============\n1.��½��Ϸ\n2.ע���˺�\n3.�˳���Ϸ\n==============");
		//���ָ��
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
					System.out.println("�������ָ�������������");
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("==============\n1.��½��Ϸ\n2.ע���˺�\n3.�˳���Ϸ\n==============");
				}
			}
	
		System.out.println("��½�ɹ�");
		System.out.println("���ڻ�ȡIP��ַ");
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
		System.out.println("=================================\n�������䵽��ipΪ��" + actorIP + " \n=================================");	
		
	}
	public static void registerSystem() {//ע��ϵͳ
		
		String registerUsername;
		String registerPassword;
		String registerIP;
		
		System.out.println("�����Ǻڿ���ע������\n�����������Ұ���ע���Ա�˺�");
		try {
			File passwd = new File(".\\.passwd");
			passwd.createNewFile();
			BufferedWriter buffw = new BufferedWriter(new FileWriter(passwd));
			System.out.print("�������û�����"); registerUsername = sc.next();
			System.out.print("���룺"); registerPassword = sc.next();
			buffw.write(registerUsername+":");
			buffw.write(registerPassword+":");
			registerIP = generateIP();
			buffw.write(registerIP);
			buffw.flush();
			buffw.close();
			System.out.println("ע��ɹ�����Ϊ����ת����¼����");
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
			  BufferedReader br = new BufferedReader(new FileReader(file));//����һ��BufferedReader������ȡ�ļ�
			  String s = null;
			 while((s = br.readLine())!=null){//ʹ��readLine������һ�ζ�һ��
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
				System.out.print("�˺ţ�"); loginUsername = sc.next();
				
				System.out.print("���룺"); loginPassword = sc.next();
				
					if (loginUsername.equals(registerUsername)  && loginPassword.equals(registerPassword)) {
						break;
					}else{
						System.out.println("��������ȷ���˺�����");
						countErrorPassword += 1;
					if (countErrorPassword == 3) {
						System.out.println("����������Σ��Զ��˳�����");
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
