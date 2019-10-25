package com.dev.ust2Contact;

import java.util.Scanner;

import com.dev.dao.ContactDAO;
import com.dev.dao.ContactDAOJPAImpl;

public class Main {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		ContactDAO dao=new ContactDAOJPAImpl();


		System.out.println("Enter Your Choice\n1. Show All Contacts");
		System.out.println("2. Search for Contact");
		System.out.println("3. Operate on Contact");

		int ch=sc.nextInt();
		switch(ch)
		{
			case 1:
				dao.showAll();
				break;
			case 2:
				dao.searchContact();
				break;
			case 3:
				dao.operateContact();
				break;
		}
	}
}
