//ButtonClick.java
package com.nowcoder.training.puzzle.Function;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
public class ButtonClick implements ActionListener//������¼���������ʹͼƬ��ո�λ
{
	private JButton [][] button;//������ť��ͼƬ�ָ��ÿ���������һ����ť
	private point pint;
	private int row;
	private int col;
	private int [][] matrix;
	private GameOver gOver;
	private boolean end;
	
	public ButtonClick(JButton [][] b, point p, int [][] m, int r, int c, GameOver g)
	{
		button = b;
		pint = p;
		matrix = m;
		row = r;
		col = c;
		gOver = g;
		end = false;
	}//��ʼ��
	public void actionPerformed(ActionEvent e)//����ƶ�ͼƬ�¼�
	{
		if (end || !pint.neighbor(row, col))//�����������ͼƬ��Χû�пո�ʱ
			return;
		
		int r = pint.getRow();//��ȡ���ͼƬ��ť������
		int c = pint.getCol();//��ȡ���ͼƬ��ť������
		
		//ͼƬ��հ׽���
		button[r][c].setIcon(button[row][col].getIcon());
		button[row][col].setIcon(null);
		pint.set(row, col);
		
		//ͼƬ��źͿհ���Ž���
		int t = matrix[r][c];
		matrix[r][c] = matrix[row][col];
		matrix[row][col] = t;
		
		end = gOver.judge();//�ж���Ϸ�Ƿ����
		
		
	}
}	
