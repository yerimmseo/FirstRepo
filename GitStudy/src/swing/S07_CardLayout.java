package swing;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class S07_CardLayout extends MyFrame {
	/*
		# CardLayout
		- ������Ʈ�� ī��ó�� �ѱ�鼭 ����ϴ� ���̾ƿ�
		
		# methods
		- CardLayout.first(parent) : �� ó�� ī�� ����
		- CardLayout.last(parent) : ������ ī�� ����
		- CardLayout.next(parent) : ���� ī�� ����
		- CardLayout.previous(parent) : ���� ī�� ����
		- CardLayout.show(parent, card_name) : ���ϴ� ī�� ����
	*/
	public S07_CardLayout() {
		setLayout(new BorderLayout());
		
		JPanel center = new JPanel();
		
		// JLabel : ������ �׳�  ����ϴ� ��
		JLabel label1 = new JLabel("Hello!");
		JLabel label2 = new JLabel("Nice to meet you!");
		JLabel label3 = new JLabel("Good bye!");
		
		label1.setIcon(new ImageIcon("./data/kakao.jpg"));
		
		// ī�� ���̾ƿ��� ������Ʈ�� �߰��� ���� ������Ʈ�� �̸��� ������ ���� ���� ����
		center.setLayout(new CardLayout(5, 5));
		center.add("card1", label1);
		center.add("card2", label2);
		center.add("card3", label3);
		
		JPanel south = new JPanel();
		
		JButton prev = new JButton("prev");
		JButton next = new JButton("next");
		next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ���� ī��� �ѱ�� (���̾ƿ��� ������ �����̳��� �ν��Ͻ��� �ʿ��ϴ�)
				CardLayout card = (CardLayout)center.getLayout();
				card.next(center);
				
//				if (!label3.isVisible()) {
//					card.next(center);
//				}
			}
		});
		
		south.setLayout(new GridLayout(1, 2));
		south.add(prev);
		south.add(next);
		
		add(center, BorderLayout.CENTER);
		add(south, BorderLayout.SOUTH);
		
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new S07_CardLayout();
	}
	
}
