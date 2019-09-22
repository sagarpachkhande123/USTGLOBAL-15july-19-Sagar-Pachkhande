package com.ustglobal.hotell_billing;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HotelImplementation hotel_Implementation = new HotelImplementation();
		int ch = 0;
		while (true) {
			System.out.println("DO you want to Continue or not?\n Press Y or N");
			String y = sc.next();
			y = y.toUpperCase();
			if (y.equals("Y")) {
				System.out.println(
						"Enter Your Choice\n1. Show All Food\n2. Order your food\n3. Operate on food\n4. Total Bill\n5. Exit ");
				ch = sc.nextInt();
				System.out.println("******************************");
				switch (ch) {
				case 1:
					hotel_Implementation.showAllFood();
					break;
				case 2:
					hotel_Implementation.takeOrder();
					break;
				case 3:
					hotel_Implementation.operateFood();
					break;
				case 4:
					hotel_Implementation.totalBill();
					break;
				case 5:
					System.out.println("Exited..");
					return;
				}
			} else if (y.equals("N")) {
				System.out.println("Exited..");
				return;
			}

		}
	}// End Main
}// End Class
