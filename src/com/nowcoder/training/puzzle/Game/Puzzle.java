//Puzzle.java ������

package com.nowcoder.training.puzzle.Game;

import com.nowcoder.training.puzzle.Frame.CardFrame;
import com.nowcoder.training.puzzle.Function.Copy;
import com.nowcoder.training.puzzle.Function.GameOver;
import com.nowcoder.training.puzzle.Function.Grades;
import com.nowcoder.training.puzzle.PictureOperation.Matrix;
import com.nowcoder.training.puzzle.PictureOperation.ShowImage;
import com.nowcoder.training.puzzle.PictureOperation.Split;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Puzzle extends CardFrame {
	private boolean start;
	private int fWidth = this.getWidth();
	private int fHeight = this.getHeight();
	private GameOver gOver;
	private boolean index = true;
	public timeing tt = new timeing();

	public Puzzle() {
		start = false;
		ImageIcon icon = new ImageIcon("icon/Ok.png");
		this.setSize(200 + fWidth, 200 + fHeight);
		this.setIconImage(icon.getImage());
		this.setVisible(true);
	}

	// ���߳���ʾʱ��
	class timeing implements Runnable {
		public boolean isrunning = false;
		private long begin;
		private long wait;
		private long now;

		public void stop() {
			begin = System.currentTimeMillis();
			wait = 0;
			now = 0;
			isrunning = false;
		}

		public void run() {
			isrunning = true;

			begin = System.currentTimeMillis();
			wait = 0;
			now = 0;
			while (gOver.result == false) {

				try {
					Thread.sleep(500);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (index ) {
					now = System.currentTimeMillis();
					re1.setText("ʱ�䣺" + (now - begin - wait) / 1000);
					re2.setText("������" + gOver.getStep());
				} else {

					wait = System.currentTimeMillis() - now;
				}

			}

		}
	}

	private void startGame() {
		if (start)
			return;
		start = true;
		updateMenuBegin();

	}

	public void endGame() {
		updateMenuBegin();
		initMenuBackground();

		start = false;
		JOptionPane.showMessageDialog(null, "ʱ��:" + gOver.getTime() + "s\n"
				+ "����:" + gOver.getStep());
		Grades g = new Grades(this);
		g.set((int) gOver.getTime(), gOver.getStep());
		this.dispose();
		new Puzzle();
	}

	protected void FrameLostFocus() {
		if (start && index) {
			nextCard();
			if (gOver != null)
				gOver.pause();
			index = false;
		}
	}

	protected void FrameGetFocus() {
		nextCard();
		if (gOver != null)
			gOver.pause();
		index = true;
	}

	public void menuNewClick() {
		Split sp = Split.get();
		BufferedImage[][] image;
		if (!sp.set(getFilename()) || (image = sp.divid(gettype())) == null) {
			JOptionPane.showMessageDialog(null, "ͼƬ�����ڣ�\n������ѡ��~");
			return;
		}
		startGame();

		this.setSize(fWidth, fHeight);
		this.setVisible(true);
		int len = Split.level[gettype()];
		int row = image.length;
		int cal = image[0].length;
		gOver = new GameOver(this);

		JButton[][] button = new JButton[row][cal];
		Matrix matrix = new Matrix(button, panel[0], len, gOver);
		matrix.init(image);
		this.setSize(cal * len + fWidth, row * len + fHeight);
		this.setVisible(true);
		if (tt.isrunning)
			tt.stop();
		else
			new Thread(tt).start();
	}

	public void menuGradesClick() {
		Grades g = new Grades(this);
		g.show();
	}

	public void menuShowClick() throws IOException {
		new ShowImage(getFilename());
	}

	public void menuExitClick() {
		System.exit(0);
	}

	public void menuHelpClick() {
		String help0 = "ͨ���ƶ�ÿһ��СͼƬ������ƴΪԭ��������ͼƬ.\n\n";
		String help1 = "�����Ե����հ�����Χ��СͼƬ������ʹ���ƶ����հ�����";
		JOptionPane.showMessageDialog(null, help0 + help1);
	}

	public void menuAboutClick() {
		String version = "�汾: ver  1.0.0 \n";
		String author = "����: ������  ����  ����ʢ\n";
		String email = "��ϵ��ַ: �ֿƴ�԰22��208 ";
		JOptionPane.showMessageDialog(null, version + author + email);
	}

	public void addClick() {

		FileDialog fd = new FileDialog(this, "ͼƬѡ��", FileDialog.LOAD);
		fd.setVisible(true);
		if (fd.getFile() == null)
			return;
		String imagename = fd.getDirectory() + fd.getFile();// �ļ�·��+�ļ���

		Copy ff = new Copy(imagename, "background\\" + fd.getFile());

		JOptionPane.showMessageDialog(this, "ͼƬ�Ѿ��ɹ���ӣ�", "��ʾ",
				JOptionPane.INFORMATION_MESSAGE);
		dispose();
		Puzzle app = new Puzzle();

	}// ����ͼƬ

	public static void main(String[] args) {
		Puzzle app = new Puzzle();
	}

}
