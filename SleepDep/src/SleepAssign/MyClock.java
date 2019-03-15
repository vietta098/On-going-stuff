package SleepAssign;
import java.util.*;

public class MyClock {
	int hour,min,sec,date,month,year,amOrPm;
	int Ahour,Amin;
	int redAlert, yellowAlert;
	

	String message = "aa";
	String timeOfTheDay;
	
	
	ArlamHandler arlam;
	
	public MyClock() {
		run();
		arlam = new ArlamHandler();
	}
	
	public void run() {
		
		Thread MyClock = new Thread() {
			public void run() {
				try {
					while(true) {
					//Calendar rightNow = Calendar.getInstance();
					Calendar rightNow = new GregorianCalendar();

					
					date = rightNow.get(Calendar.DATE);
					month = rightNow.get(Calendar.MONTH);
					year = rightNow.get(Calendar.YEAR);
					
					amOrPm = rightNow.get(Calendar.AM_PM);
					hour = rightNow.get(Calendar.HOUR);
					min = rightNow.get(Calendar.MINUTE);
					sec = rightNow.get(Calendar.SECOND);
					
					if(amOrPm == 1) {
						timeOfTheDay = "PM";
					}
					else
					{
						timeOfTheDay = "AM";
					}
					
					Check();
					
					sleep(1000);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
		
		MyClock.start();
	
	}
	
	public void setArlamWakeUp(int hour, int time, String in) {
		arlam.setWakeTime(hour, time, in);
	}
	
	
	public void setArlamSleep(int hour, int time, String in) {
		arlam.setSleepTime(hour, time, in);
	}
	
	public void Check() {
		if(arlam.getHourWakeUp() == hour && arlam.getMinWakeUp() == min &&arlam.getAmOrPmWake()==amOrPm) {
			message = arlam.getMessage1();
		}
		else if (arlam.getHourGoToSleep() == hour && arlam.getMinGoTosleep() == min &&arlam.getAmOrPmSleep()==amOrPm){
			message = arlam.getMessage2();
		}
		else {
			message = "";
		}
		
	}
	
	public int getDate() {
		return date;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}
	
	public	String getMess() {
		return message;
	}
	
	public int getHour() {
		return hour;
	}

	public int getMin() {
		return min;
	}

	public int getSec() {
		return sec;
	}
	public String getTimeOfTheDay() {
		return timeOfTheDay;
	}
}
