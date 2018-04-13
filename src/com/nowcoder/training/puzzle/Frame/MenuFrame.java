//MenuFrame.java
package com.nowcoder.training.puzzle.Frame;
import com.nowcoder.training.puzzle.Arg.Arg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.KeyStroke;
@SuppressWarnings("serial")
public abstract class MenuFrame	extends JFrame
{
	public final static int heightTitle = 30;
	public final static int widthTitle = 6;
	public final static int heightMenu = 27;
	private JMenu [] m = {
		new JMenu("��ʼ"),
		new JMenu("ѡ��"),
		new JMenu("����") 
	};
	private JMenu [] mm = {
		new JMenu("�ȼ�"),
		new JMenu("��ϷͼƬ"),
	};
	private JMenuItem addp = new JMenuItem("����ͼƬ");
	private boolean update;
	private int type=3;
	private String filename;
	protected ButtonGroup bgrp = new ButtonGroup();
	protected ButtonGroup fgrp = new ButtonGroup();
	public JLabel re1=new JLabel("");//ʱ��
	public JLabel re2=new JLabel("");//����
	public JLabel re4=new JLabel("");
	public JLabel re3=new JLabel("");
	public MenuFrame()
	{
		super("ƴͼ��Ϸ");
		addMenu();
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(widthTitle, heightTitle+heightMenu);
		this.setLocation(
			this.getToolkit().getScreenSize().width/3 - this.getWidth()/3,
			this.getToolkit().getScreenSize().height/3 - this.getHeight()/3
		);
	}
	private void addMenu()
	{
		JMenuBar mBar = new JMenuBar();
		this.setJMenuBar(mBar);
		mBar.add(m[0]);
		mBar.add(m[1]);
		mBar.add(m[2]);
		
		m[0].setMnemonic('B');
		m[1].setMnemonic('O');
		m[2].setMnemonic('A');
		initMenuBegin();
		initMenuOption();
		initMenuAbout();
		mBar.add(re3);
		mBar.add(re1);
		mBar.add(re4);
		mBar.add(re2);
		update = false;
	}
	public abstract void menuNewClick();
	public abstract void menuGradesClick();
	public abstract void menuShowClick() throws IOException;
	public abstract void menuExitClick();

	private void menuLevelClick(String nm)
	{
		type = 3;
		if (nm.equals("����"))
			type = 0;
		else if (nm.equals("��ͨ"))
			type = 1;
		else if (nm.equals("��"))
			type = 2;
	}
	private void menuBackgroundClick(String nm)
	{
		filename = nm;
	}
	public abstract void menuHelpClick();
	public abstract void menuAboutClick();
	public abstract void addClick();

	public int gettype()
	{
		return type;
	}
	public String getFilename()
	{
		return filename;
	}
	private void initMenuBegin()
	{
		JMenuItem [] mI = {
			new JMenuItem("����Ϸ"),
			new JMenuItem("�ɼ���¼"),
			new JMenuItem("�˳���Ϸ")
		};
		mI[0].setMnemonic('N');
		mI[1].setMnemonic('G');
		mI[2].setMnemonic('E');

		mI[0].addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					menuNewClick();
				}
			}
		);
		mI[1].addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					menuGradesClick();
				}
			}
		);
		mI[2].addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					menuExitClick();
				}
			}
		);
		m[0].add(mI[0]);
		m[0].add(mI[1]);
		m[0].add(mI[2]);
		m[0].insertSeparator(2);
	}

	private void initMenuOption()
	{
		
		m[1].add(mm[0]);
		m[1].add(mm[1]);
		m[1].add(addp);
		initMenuLevel();
		initMenuBackground();
		addPicture();
		
	}
	private void addPicture()
	{
		addp.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				addClick();
				
			}
		});
	
	}
	private void initMenuLevel()
	{
		JRadioButtonMenuItem [] mi = {
			new JRadioButtonMenuItem("����"),
			new JRadioButtonMenuItem("��ͨ"),
			new JRadioButtonMenuItem("��") 
		};
		for (int i = 0; i < 3; i++)
		{
			mi[i].addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						JRadioButtonMenuItem mi = (JRadioButtonMenuItem)e.getSource();
						menuLevelClick(mi.getText());
					}
				}
			);
			bgrp.add(mi[i]);
			mm[0].add(mi[i]);
		}
		mi[1].setSelected(true);
		menuLevelClick(mi[1].getText());
	}
	public void initMenuBackground()
	{
		mm[1].removeAll();
		File bkg = new File(Arg.path);
		if (!bkg.exists())
			return;
		File [] list = bkg.listFiles();
		JRadioButtonMenuItem mi;
		int j = 0;
		for (int i = 0; i < list.length; i++)
		{
			if (!list[i].isFile() || list[i].isHidden())
				continue;
			mi = new JRadioButtonMenuItem(list[i].getName());
			mi.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						JRadioButtonMenuItem 
mi = (JRadioButtonMenuItem)e.getSource();
						menuBackgroundClick(mi.getText());
					}
				}
			);
			fgrp.add(mi);
			mm[1].add(mi);
			mi.setSelected(j == 0);
			if (j == 0)
				menuBackgroundClick(mi.getText());
			j++;
		}
	}
	private void initMenuAbout()
	{
		JMenuItem [] mI = {
			new JMenuItem("��Ϸ����"),
			new JMenuItem("����")
		};
		
		mI[0].addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					menuHelpClick();
				}
			}
		);
		mI[1].addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					menuAboutClick();
				}
			}
		);
		m[2].add(mI[0]);
		m[2].add(mI[1]);
	}
	public void updateMenuBegin()
	{
		update = !update;
		if (!update)
		{
			m[0].remove(2);
			return;
		}
		JMenuItem mi = new JMenuItem("ͼƬԤ��");
	
		mi.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					try {
						menuShowClick();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		);
		m[0].insert(mi, 2);
		re3.setText("                                    ");
		re1.setText("");
		re1.setForeground(Color.GREEN);
		re4.setText("        ");
		re2.setText("");
		re2.setForeground(Color.GREEN);
		
		
		
	}
}
	