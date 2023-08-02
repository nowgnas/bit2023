package day02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=  new Scanner(System.in);
		while (true) {
			System.out.println("Input cmd...");
			String cmd = sc.next();
			if(cmd.equals("q")) {
				System.out.println("Bye");
				break;
			}else if (cmd.equals("a")) {
				System.out.println(cmd);
			}else if(cmd.equals("b")) {
				System.out.println("Input cmd2...");
				
				while(true) {
					String cmd2 = sc.next();
					if (cmd2.equals("q")) {
						System.out.println("Bye2... ");
						break;
					}else if(cmd2.equals("a2")) {
						System.out.println(cmd2);
					}
				}
			}
		}
		System.out.println("End...");
		sc.close();

	}

}
