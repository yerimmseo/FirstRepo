package swing;

import javax.swing.JButton;
import javax.swing.JFrame;

public class S01_JavaSwing {
	/*
 		# Swing
 		- Java로 윈도우 GUI 프로그램을 만들 수 있는 API
 		
 		# Container
 		- 컴포넌트를 추가할 수 있는 판
 		- JFrame, JPanel, JDialog .. 등
 		- 컨테이너마다 원하는 레이아웃을 지정할 수 있다
 		
 		# Component
 		- 컨테이너에 추가할 수 있는 부품
 		- JButton, JTable, JSlider, JMenu .. 등
	*/
	public static void main(String[] args) {
		/*
			# JFrame
			- 프레임 컨테이너. 다양한 컴포넌트들을 추가할 수 있다.
		*/
		JFrame frame = new JFrame();
		
		JButton btn1 = new JButton("This is button");
		btn1.setLocation(100, 100);
		btn1.setSize(200, 50);
		
		frame.add(btn1);
		
		frame.setLocation(700, 50);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setVisible(true);
	}

}
