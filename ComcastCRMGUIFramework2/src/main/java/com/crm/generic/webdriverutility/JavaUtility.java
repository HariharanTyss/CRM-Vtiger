package com.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility 
{
	public String getSystemData() 
	{
		Date date=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String actualdate=sim.format(date);
		return actualdate;
	}
	
	public int getrandomnumber() {
		Random r=new Random();
		return r.nextInt(5000);
		
	}
	

}
