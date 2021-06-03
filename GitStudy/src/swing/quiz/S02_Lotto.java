package swing.quiz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JFrame;

public class S02_Lotto extends JFrame {
	/*
		"�̱�" ��ư�� ���� ������ 6���� �ߺ����� ���� ���ڸ� ���� ��ư��
		�����ӿ� ���� ���α׷��� ��������
	*/
	public S02_Lotto() {
		setLayout(null);
		
		ArrayList<JButton> btns = new ArrayList<>();
		
		btns.add(new S02_NumberButton(100, 100));
		btns.add(new S02_NumberButton(200, 100));
		btns.add(new S02_NumberButton(300, 100));
		btns.add(new S02_NumberButton(400, 100));
		btns.add(new S02_NumberButton(500, 100));
		btns.add(new S02_NumberButton(600, 100));
		
		JButton nextBtn = new S02_NextButton(100, 300, btns);
		
		for (JButton btn : btns) {
			add(btn);
		}
		add(nextBtn);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(700,50);
		setSize(1000, 500);
		setVisible(true);
		
//		JFrame frame = new JFrame();
//		JButton btn = new JButton("�̱�");
//		JButton result1 = new JButton();
//		JButton result2 = new JButton();
//		JButton result3 = new JButton();
//		JButton result4 = new JButton();
//		JButton result5 = new JButton();
//		JButton result6 = new JButton();
//		
//		btn.setLocation(140, 100);
//		btn.setSize(200, 100);
//		result1.setLocation(90, 220);
//		result1.setSize(50, 50);
//		result2.setLocation(140, 220);
//		result2.setSize(50, 50);
//		result3.setLocation(190, 220);
//		result3.setSize(50, 50);
//		result4.setLocation(240, 220);
//		result4.setSize(50, 50);
//		result5.setLocation(290, 220);
//		result5.setSize(50, 50);
//		result6.setLocation(340, 220);
//		result6.setSize(50, 50);
//		
//		frame.add(btn);
//		frame.add(result1);
//		frame.add(result2);
//		frame.add(result3);
//		frame.add(result4);
//		frame.add(result5);
//		frame.add(result6);
//		
//		btn.setFont(new Font("���� ���", Font.BOLD, 20));
//		
//		btn.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if (e.getActionCommand().equals("�̱�")) {
//					HashSet<Integer> lottoSet = new HashSet<>();
//					
//					while (lottoSet.size() < 7) {
//						lottoSet.add((int)(Math.random() * 45 + 1));
//					}
//					result1.setText(new ArrayList<>(lottoSet).get(0).toString());
//					result2.setText(new ArrayList<>(lottoSet).get(1).toString());
//					result3.setText(new ArrayList<>(lottoSet).get(2).toString());
//					result4.setText(new ArrayList<>(lottoSet).get(3).toString());
//					result5.setText(new ArrayList<>(lottoSet).get(4).toString());
//					result6.setText(new ArrayList<>(lottoSet).get(5).toString());
//				}
//			}
//		});
//		
//		frame.setLocation(700, 50);
//		frame.setLayout(null);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(500, 500);
//		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new S02_Lotto();
	}

}
