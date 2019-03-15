package SleepAssign;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class gui {
	
	public gui() {
		
	}
	public void run() {
		JFrame f = new AppFrame();
		
	}
}

class AppFrame extends JFrame{
	JPanel  panel;
	
	public AppFrame() {
	
	}
	
	public void frameInit() {
		
		
		super.frameInit();
		this.setLayout(new BorderLayout());
		panel = new AppPanel();
		this.add(panel, BorderLayout.CENTER);
		this.setSize(800,400);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	
	
	}
	
}

class AppPanel extends JPanel{
	
	
	//initialize
	
	private MyClock clock = new MyClock();
	
	private JTextField timerF,mess,hourSet,minSet,amOrPmSet,statusDisplay,
						hourSet1,minSet1,amOrPmSet1,statusDisplay1;
	private JButton btnStart,btnSetArlam,btnSetArlam1,btnAWake,btnSleep;
	private JPanel clockPan,arlamPan,arlamPan1,messPan,btnAndDisplay;
	
	
	//create a timer for a clock
	Timer t = new Timer(1000, new Listener());
	
	public AppPanel() {
		super();
		setup();
	}
	
	private void setup() {
		
		//Initialize panels and button
		clockPan = new JPanel();
		messPan = new JPanel();
		arlamPan = new JPanel();
		arlamPan1 = new JPanel();
		
		btnStart = new JButton("Start");
		btnSetArlam = new JButton("SET WAKE UP");
		btnSetArlam1 = new JButton("SET SLEEP TIME");
		btnAWake = new JButton("WAKE UP");
		btnSleep = new JButton("SLEEP");
		
		
		
		//Set all Text Field
		timerF = new JTextField(18);
		timerF.setFont(new Font("Arial", Font.PLAIN,40));
		mess = new JTextField(10);
		mess.setFont(new Font("Arial", Font.PLAIN, 45));
		
		hourSet = new JTextField(5);
		hourSet.setText("hour");
		minSet = new JTextField(5);
		minSet.setText("min");
		amOrPmSet = new JTextField(5);
		amOrPmSet.setText("AM or PM");
		statusDisplay = new JTextField(7);
		
		hourSet1 = new JTextField(5);
		hourSet1.setText("hour");
		minSet1 = new JTextField(5);
		minSet1.setText("min");
		amOrPmSet1 = new JTextField(5);
		amOrPmSet1.setText("AM or PM");
		statusDisplay1 = new JTextField(7);
		
		
		
		//Setip All Panel
		clockPan.setLayout(new BorderLayout());
		clockPan.add(btnStart, BorderLayout.EAST);
		clockPan.add(timerF, BorderLayout.WEST);
		clockPan.setBorder(BorderFactory.createTitledBorder("THE CLOCK"));
		
		arlamPan.setLayout(new BorderLayout());
		arlamPan.add(hourSet, BorderLayout.WEST);
		arlamPan.add(minSet, BorderLayout.CENTER);
		arlamPan.add(amOrPmSet, BorderLayout.EAST);
		arlamPan.add(btnSetArlam, BorderLayout.NORTH);
		arlamPan.add(statusDisplay, BorderLayout.AFTER_LAST_LINE);
		
		arlamPan1.setLayout(new BorderLayout());
		arlamPan1.add(hourSet1, BorderLayout.WEST);
		arlamPan1.add(minSet1, BorderLayout.CENTER);
		arlamPan1.add(amOrPmSet1, BorderLayout.EAST);
		arlamPan1.add(btnSetArlam1, BorderLayout.NORTH);
		arlamPan1.add(statusDisplay1, BorderLayout.AFTER_LAST_LINE);
		
		
		messPan.setLayout(new BorderLayout());
		messPan.add(mess,BorderLayout.NORTH);
		messPan.add(btnSleep, BorderLayout.EAST);
		messPan.add(btnAWake, BorderLayout.WEST);
		messPan.setBorder(BorderFactory.createTitledBorder("DISPLAY MESSAGE"));
		
		
		//Adding all panels to the big AppPanel
		this.setLayout(new BorderLayout());
		this.add(clockPan, BorderLayout.NORTH);
		this.add(arlamPan, BorderLayout.WEST);
		this.add(arlamPan1, BorderLayout.AFTER_LINE_ENDS);
		this.add(messPan, BorderLayout.CENTER);
		
		
		
		//Addin action listener for button
		addIn();
	
		
	}
	
	public void addIn() {
		btnAWake.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int hour = Integer.parseInt(hourSet.getText());
				int min = Integer.parseInt(minSet.getText());
	
			}		
		});
		
		
		btnStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				t.start();
			}		
		});
		
		
		btnSetArlam.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int hour = Integer.parseInt(hourSet.getText());
				int min = Integer.parseInt(minSet.getText());
				clock.setArlamWakeUp(hour, min, amOrPmSet.getText());
				statusDisplay.setText("Wake Up time set " + hour + ":" + min + " " +amOrPmSet.getText());
			}		
		});
		
		btnSetArlam1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int hour = Integer.parseInt(hourSet1.getText());
				int min = Integer.parseInt(minSet1.getText());
				clock.setArlamSleep(hour, min, amOrPmSet1.getText());
				statusDisplay1.setText("Sleep time set " + hour + ":" + min + " " +amOrPmSet1.getText());
			}		
		});
	}
	
	
	class Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			timerF.setText(clock.getHour()+":"+clock.getMin()+":"+clock.getSec()+" "+clock.getTimeOfTheDay()
			+"\t"+clock.getMonth()+"/"+clock.getDate()+"/"+clock.getYear());
			mess.setText("" + clock.getMess());
		}
	
	}
}


	