package sampleTestExecution;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalenderPrints {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("ddMMYY");
		String format1 = sdf1.format(cal.getTime());
		System.out.println(format1);// 260325
		SimpleDateFormat sdf2 = new SimpleDateFormat("ddMMYY_hhmmss");
		String format2 = sdf2.format(cal.getTime());
		System.out.println(format2);// 260325_080733
		SimpleDateFormat sdf3 = new SimpleDateFormat("hhmmss");
		String format3 = sdf3.format(cal.getTime());
		System.out.println(format3);// 080733
		SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy_hhmmss");
		String format4 = sdf4.format(cal.getTime());
		System.out.println(format4);// 2025_080733
		SimpleDateFormat sdf5 = new SimpleDateFormat("dddMMM");
		String format5 = sdf5.format(cal.getTime());
		System.out.println(format5);// 026Mar
		SimpleDateFormat sdf6 = new SimpleDateFormat("dd_MMM_hhmmss");
		String format6 = sdf6.format(cal.getTime());
		System.out.println(format6);// 26_Mar_082626
		SimpleDateFormat sdf7 = new SimpleDateFormat("dd_MMM_hhmmss");
		String format7 = sdf7.format(cal.getTime());
		System.out.println(format7);// 26_Mar_082626
		SimpleDateFormat sdf8 = new SimpleDateFormat("dd_MMM_hhmmss");
		String format8 = sdf8.format(cal.getTime());
		System.out.println(format8);// 26_Mar_082626
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		System.out.println(time); // Thu_Mar_27_20_25_44_IST_2025
	}
}
