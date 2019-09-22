package com.ustglobal.hotell_billing;

import java.util.ArrayList;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.ustglobal.hotell_billing.Initialise_objects;

public class HotelImplementation implements HotelInterface {
	Initialise_objects initialise_objects;
	Scanner sc=new Scanner(System.in);
	Hotel hotel=new Hotel();
	double totalBill=0;
	double customerbill[]=new double[10];
	int i=1;
	ArrayList<Hotel> arrayList=new ArrayList<Hotel>();
	int notfound=0;
	public boolean showAllFood() {
		initialise_objects=new Initialise_objects();
		System.out.println("Todays Hotel Menu are..");
		System.out.println("*************************");
		Query query=Initialise_objects.entityManager.createQuery("from Hotel");
		arrayList=(ArrayList<Hotel>) query.getResultList();
		for(Hotel hotel: arrayList)
		{
			System.out.println("Item Code:: "+hotel.getItemCode());
			System.out.println("Food Name:: "+hotel.getFoodName());
			System.out.println("Food Price:: "+hotel.getPrice());
			System.out.println("****************************");
		}
		System.out.println("Have Enjoy Your Food..!");
		return true;
	}
	public boolean takeOrder() {
		initialise_objects=new Initialise_objects();
		Query query=Initialise_objects.entityManager.createQuery("select price from Hotel where itemCode=:args1");
		System.out.println("******Welcome to the Hotel..*******");
		int item_code[]=new int[10];
		item_code[1]=1;
		double localpayment=0;
		int order=1;
		do {
			System.out.println("Enter Food Item Code");
			hotel=Initialise_objects.entityManager.find(Hotel.class, sc.nextInt());
			arrayList.add(hotel);
			System.out.println(hotel.getItemCode()+"  "+hotel.getFoodName()+"  "+hotel.getPrice());
			localpayment=localpayment + hotel.getPrice();
			System.out.println("Add More item to the List..\n Press 0 for No\n Press 1 for yes");
			order=sc.nextInt();
			customerbill[i]=localpayment;
			i++;
		}while(order==1);
		System.out.println("Total Payment to Pay is ::"+localpayment);
		for(int j=1;j<=i;j++)
		{		
			Initialise_objects.transaction.begin();
			query.setParameter("args1", item_code[i]);
			Initialise_objects.transaction.commit();
			arrayList=(ArrayList<Hotel>) query.getResultList();
			totalBill=(int) (totalBill+hotel.getPrice());				
		}
		return true;	
	}
	public boolean operateFood() {
		initialise_objects=new Initialise_objects();
		System.out.println("A. Add Food Items\nB. Remove Food Item\nC. Modify Food Item");
		String ch=sc.next();
		String ch1=ch;
		switch(ch1.toUpperCase())
		{
		case "A":
			int itemCode;
			String foodName;
			double price;
			String k;
			System.out.println("Enter Food Item Code..");
			itemCode=sc.nextInt();
			System.out.println("Enter Food Name..");
			foodName=sc.next();
			System.out.println("Enter Food Price..");
			k=sc.next();
			price=Double.parseDouble(k);	
			Initialise_objects.transaction.begin();
			hotel.setItemCode(itemCode);
			hotel.setFoodName(foodName);
			hotel.setPrice(price);
			try {
				Initialise_objects.entityManager.persist(hotel);
				Initialise_objects.transaction.commit();
				System.out.println("Successfully added food in menu card");
			} catch (Exception e) {
				System.out.println("food could not added food in menu card");
			}
			break;
		case "B":
			System.out.println("Enter Item code to Remove food");
			int itemCode1=sc.nextInt();
			hotel=Initialise_objects.entityManager.find(Hotel.class, itemCode1);
			Initialise_objects.transaction.begin();
			System.out.println("Are you Sure..!\n Y or N");
			String confirmation=sc.next();
			switch(confirmation.toUpperCase())
			{
			case "Y":
				Initialise_objects.entityManager.remove(hotel);
				Initialise_objects.transaction.commit();
				System.out.println("Successfully Removed Item from Menu Card...");
				break;
			case "N":
				break;
			}
			System.out.println("");
			break;
		case "C":
			System.out.println("Enter itemCode to Modify Food Item");
			int itemCode2=sc.nextInt();
			System.out.println("Enter New Food Name");
			String FoodName=sc.next();
			System.out.println("Before Update..");
			Initialise_objects.transaction.begin();
			hotel=Initialise_objects.entityManager.find(Hotel.class, itemCode2);
			Initialise_objects.transaction.commit();
			System.out.println(hotel.getFoodName());
			Query query=Initialise_objects.entityManager.createQuery("Update Hotel h set h.foodName=:arg1 where h.itemCode=:arg2");
			query.setParameter("arg1", FoodName);
			query.setParameter("arg2", itemCode2);
			Initialise_objects.transaction.begin();
			int count=query.executeUpdate();
			Initialise_objects.transaction.commit();
			Initialise_objects.transaction.begin();
			hotel=Initialise_objects.entityManager.find(Hotel.class, itemCode2);
			Initialise_objects.transaction.commit();
			hotel.setFoodName(FoodName);
			System.out.println("After Update..");
			System.out.println("*********************");	
			System.out.println("Item Code:: "+hotel.getItemCode());
			System.out.println("Food Name:: "+hotel.getFoodName());
			System.out.println("Food Price:: "+hotel.getPrice());
			System.out.println("****************************");
		}	
		return true;
	}
	public boolean totalBill() {
		System.out.println("****************************");
		System.out.println("Total Bill of the Day is");
		for(int j=1;j<=i;j++)
		{
			totalBill=totalBill+customerbill[i];
		}
		System.out.println("Rs. "+totalBill);
		return false;
	}
}
