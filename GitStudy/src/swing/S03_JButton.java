package swing;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import swing.quiz.S03_KakaoImageButton;

public class S03_JButton extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public S03_JButton() {
		setLayout(null);
		
		
		JButton btn1 = new JButton("눌러보세요");
		
		// setBounds(x, y, width, height) : 버튼의 위치와 크기 설정을 한 번에 한다
		btn1.setBounds(100, 100, 150, 150);
		
		// setText() : 해당 컴포넌트의 텍스트를 변경한다
		btn1.setText("Push this button!");
		
		// setEnabled() : 해당 컴포넌트를 활성화/비활성화 한다
		btn1.setEnabled(true);
		
		// setBackground() : 해당 컴포넌트의 배경색을 변경한다
		btn1.setBackground(new Color(255, 255, 0));
//		btn1.setBackground(Color.BLACK);
		
		// setIcon() : 해당 컴포넌트의 아이콘을 설정한다
		btn1.setIcon(new ImageIcon("./data/kakao.jpg"));
		
		add(btn1);
//		add(new S03_KakaoImageButton(S03_KakaoImageButton.RYON, 100, 300, 100, 100));
//		add(new S03_KakaoImageButton(S03_KakaoImageButton.APEACH, 100, 400, 100, 100));
//		add(new S03_KakaoImageButton(S03_KakaoImageButton.MUJI, 100, 500, 100, 100));
//		add(new S03_KakaoImageButton(S03_KakaoImageButton.TUBE, 100, 600, 100, 100));
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 800);
		setLocation(1000, 50);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new S03_JButton();
	}

}
