package demo;

import java.util.Date;

public class date {
	public static void main(String[] args) {
		Date date=new Date();
		//System.out.println(date);
		String cdate = date.toString().replace(" ", "_").replace(":", "_");
		System.out.println(cdate);
	}

}
