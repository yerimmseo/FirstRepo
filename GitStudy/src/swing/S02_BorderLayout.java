package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class S02_BorderLayout extends javax.swing.JFrame {
	/*
		# BorderLayout
		- �������ϰ� ����� �̷���� ���̾ƿ�
		- ������Ʈ�� �߰��� �� ��ġ�� �Բ� �������� �� �ִ�
	*/
	public S02_BorderLayout() {
		
		// �� �������� ���̾ƿ� ����
		setLayout(new BorderLayout());
		
		// �� ���̾ƿ� ���� �� �߰��ؾ� ��
		JButton quit_btn = new JButton("Quit");
		JButton save_btn = new JButton("Save");
		JButton load_btn = new JButton("Load");
		JButton delete_btn = new JButton("Delete");
		JButton update_btn = new JButton("Update");
		
		// ��ư�� ��Ʈ ����
		quit_btn.setFont(new Font("�ü�ü", Font.BOLD, 35));
		save_btn.setFont(new Font("�ü�ü", Font.BOLD, 35));
		load_btn.setFont(new Font("�ü�ü", Font.BOLD, 35));
		delete_btn.setFont(new Font("�ü�ü", Font.BOLD, 35));
		update_btn.setFont(new Font("�ü�ü", Font.BOLD, 35));
		
		// ��ư�� �̺�Ʈ�� �߰�
		quit_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// �ش� ������Ʈ�� action �߻��� e�� �̺�Ʈ ����� ������ �Ѿ�´�.
				System.out.println("������ ����1: " + e.getActionCommand());
				System.out.println("������ ����2: " + e.getID());
				System.out.println("������ ����3: " + e.getModifiers());
				System.out.println("������ ����4: " + e.getWhen());
				System.out.println("������ ����5: " + e.getSource());
				
				// e.getSource()���� �׼��� �߻��� ������Ʈ�� �ν��Ͻ��� ����ְ�
				// �ٿ�ĳ�����Ͽ� ����ؾ� �Ѵ�.
				((JButton)e.getSource()).setText("������!");;
			}
		});
		
		save_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((JButton)e.getSource()).setBackground(Color.BLUE);
			}
		});
		
		load_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((JButton)e.getSource()).setBackground(Color.PINK);
			}
		});
		
		delete_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((JButton)e.getSource()).setText("����");
			}
		});
		
		update_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((JButton)e.getSource()).setText("������Ʈ");
			}
		});
		
		add(save_btn, BorderLayout.CENTER);
		add(load_btn, BorderLayout.EAST);
		add(delete_btn, BorderLayout.WEST);
		add(update_btn, BorderLayout.NORTH);
		add(quit_btn, BorderLayout.SOUTH);
		
		// ��ġ ����
		setLocation(700, 50);
		
		// ������ ũ�� ����
		setSize(600, 600);
		
		// X��ư�� ������ ���� ���� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// �������� ���̰� ���� (ȭ�鿡 �׸���)
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new S02_BorderLayout();
	}

}
