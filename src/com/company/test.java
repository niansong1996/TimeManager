package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Mail mail = new Mail();
		mail.getMailInfo(3);
		for(String s : Mail.MailInfoList){
			System.out.println("OUT COMES :"+s);
		}
	}

}
