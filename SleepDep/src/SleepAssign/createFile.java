package SleepAssign;
import java.io.*;
import java.lang.*;
import java.util.*;

public class createFile {
	
	private Formatter x;
	
	public void openFile() {
		try {
			x = new Formatter("file.txt");
			
		}catch(Exception e) {
			System.out.println("Error");
		}
	}
	
	public void addRecords() {
		x.format("\n%s%s%s%s", "Arlam Set For", "Hour",  "Time" , "Wake Up");
	}
	
	public void closeFile() {
		x.close();
	}
}
