package com.ustglobal.hotell_billing;

import java.io.FileReader;
import java.sql.Connection;

public interface HotelInterface {
	
	public boolean showAllFood();
	public boolean takeOrder();
	public boolean operateFood();
	public boolean totalBill();

	}
