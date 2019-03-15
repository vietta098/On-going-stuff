package SleepAssign;

public class ArlamHandler {
	
	
	int hourWakeUp,minWakeUp,amOrPmWake;
	int hourGoToSleep,minGoTosleep,amOrPmSleep;
	
	String message1 = "Time to Wake Up";
	String message2 = "Time to Sleep";
	
	public ArlamHandler() {
	
	}
	
	public void setSleepTime(int hour, int min, String in) {
		hourGoToSleep = hour;
		minGoTosleep = min;
		if(in.equalsIgnoreCase("PM")) {
			amOrPmSleep = 1;
		}else {
			amOrPmSleep = 0;
		}
	}
	
	public void setWakeTime(int hour, int min, String in) {
		hourWakeUp = hour;
		minWakeUp = min;
		if(in.equalsIgnoreCase("PM")) {
			amOrPmWake = 1;
		}else {
			amOrPmWake = 0;
		}
	}

	public int getHourWakeUp() {
		return hourWakeUp;
	}

	public int getMinWakeUp() {
		return minWakeUp;
	}

	public int getAmOrPmWake() {
		return amOrPmWake;
	}

	public int getHourGoToSleep() {
		return hourGoToSleep;
	}

	public int getMinGoTosleep() {
		return minGoTosleep;
	}

	public int getAmOrPmSleep() {
		return amOrPmSleep;
	}

	public String getMessage1() {
		return message1;
	}
	
	public String getMessage2() {
		return message2;
	}
	
	
	
}
