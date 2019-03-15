package SleepAssign;

import javax.swing.JFrame;

public class main {
	public static void main(String[] args) {
		gui app = new gui();
		app.run();
		
		createFile g = new createFile();
		g.openFile();
		g.addRecords();
		g.closeFile();
	}
}
