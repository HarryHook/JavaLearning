//point.java
package com.nowcoder.training.puzzle.Function;
public class point//����
{
	int row;//������
	int col;//������
	public point(int r, int c)
	{
		row = r;
		col = c;
	}//���캯����ʼ��
	public void set(int r, int c)
	{
		row = r;
		col = c;
	}//��������
	public int getRow()
	{
		return row;
	}//��ȡ������
	public int getCol()
	{
		return col;
	}//��ȡ������
	public boolean neighbor(int r, int c)
	{
		int n = Math.abs(row - r) + Math.abs(col - c);
		return n == 1;
	}//�ж�(r,c)��(row,col)�Ƿ����ڣ������򷵻�true
}
