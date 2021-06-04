package swing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JPanel;

public class S06_JPanel extends MyFrame {
	/*
		# JPanel
		- �����̳� ������ �ϴ� ������Ʈ
		- ������ ���� �ٿ��� ����ϴ� �����̳�
		- ���̾ƿ��� ������ �� �ִ�
	*/
	JPanel main_panel;
	JPanel sub_panel;
	
	public S06_JPanel() {
		setLayout(new BorderLayout(5, 5));
		
		ArrayList<JButton> main_panel_btns = new ArrayList<>();
		ArrayList<JButton> sub_panel_btns = new ArrayList<>();
		
		for (int i = 0; i < 4; i++) {
			main_panel_btns.add(new JButton("Button" + i));
		}
		
		for (int i = 0; i < 10; i++) {
			sub_panel_btns.add(new JButton("Sub" + i));
		}
		
		main_panel = new JPanel();
		sub_panel = new JPanel();
		
		main_panel.setLayout(new GridLayout(2, 2));
		for (int i = 0; i < 4; i++) {
			main_panel.add(main_panel_btns.get(i));
		}
		
		sub_panel.setLayout(new GridLayout(5, 2));
		for (int i = 0; i < 10; i++) {
			sub_panel.add(sub_panel_btns.get(i));
		}
		
		
		add(main_panel, BorderLayout.CENTER);
		add(sub_panel, BorderLayout.WEST);
		add(new JButton("Hello!"), BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new S06_JPanel();
	}
	
}
