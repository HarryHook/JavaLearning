//CardFrame.java
package com.nowcoder.training.puzzle.Frame;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
public abstract class CardFrame extends MenuFrame//��ʼ����
{
	private CardLayout card;
	private Container con;
	protected JPanel [] panel = {
		new JPanel(), new JPanel()
	};//0 ��ʼ����  1��Ϸ����
	public CardFrame()
	{
		//��ʼ����
		con = this.getContentPane();
		card = new CardLayout();
		con.setLayout(card);
		panel[0].setOpaque(false);
		panel[0].setLayout(null);
		
		JLabel label = new JLabel(new ImageIcon("rc\\b1.jpg"));   
		label.setBounds(0, 0, 200, 200);
		panel[0].add(label);
	
		
		//��Ϸ����
		panel[1].setLayout(new BorderLayout());
		JButton button = new JButton("��  ��");
		button.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					FrameGetFocus();
				}
			}
		);
		panel[1].add(button, BorderLayout.CENTER);
		con.add(panel[0], "��Ϸ");
		con.add(panel[1], "��ͣ");
		card.show(con, "��Ϸ");
		this.addWindowListener(new WindowAdapter()
			{
				public void windowDeactivated(WindowEvent e)
				{
					FrameLostFocus();
				}
			}
		);
	}
	protected void nextCard()
	{
		card.next(con);
	}
	protected abstract void FrameLostFocus();
	protected abstract void FrameGetFocus();
}