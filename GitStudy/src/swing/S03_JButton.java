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
		
		
		JButton btn1 = new JButton("����������");
		
		// setBounds(x, y, width, height) : ��ư�� ��ġ�� ũ�� ������ �� ���� �Ѵ�
		btn1.setBounds(100, 100, 150, 150);
		
		// setText() : �ش� ������Ʈ�� �ؽ�Ʈ�� �����Ѵ�
		btn1.setText("Push this button!");
		
		// setEnabled() : �ش� ������Ʈ�� Ȱ��ȭ/��Ȱ��ȭ �Ѵ�
		btn1.setEnabled(true);
		
		// setBackground() : �ش� ������Ʈ�� ������ �����Ѵ�
		btn1.setBackground(new Color(255, 255, 0));
//		btn1.setBackground(Color.BLACK);
		
		// setIcon() : �ش� ������Ʈ�� �������� �����Ѵ�
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
