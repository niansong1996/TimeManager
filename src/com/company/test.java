package com.company;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);

		TextFactory textFactory=new TextFactory(scanner.nextLine());
		textFactory.stringdealing();
		System.out.print("tset");
	}

}
