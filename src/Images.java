import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;

import javax.swing.JFrame;

public class Images extends JFrame {
	public static void main(String args[]) {
		DisplayMode dm = new DisplayMode(800, 600, 16,
				DisplayMode.REFRESH_RATE_UNKNOWN);
		Images i = new Images();
		i.run(dm);

	}

	private Screen s;
	private Image bg;
	private Image pic;
	private boolean loaded;

	// run method
	public void run(DisplayMode dm) {// this is user defined method
		// TODO Auto-generated method stub

		setBackground(Color.PINK);
		setForeground(Color.WHITE);
		setFont(new Font("Arial", Font.PLAIN, 24));

		loaded = false;

		s = new Screen();
		try {
			s.setFullScreen(dm, this);
			loadpics();
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		} finally {
			s.restoreScreen();

		}
	}

	// loads pastures
	public void loadpics() {
		bg = new ImageIcon("B:\\movies\\pics\\png pictures\\cartman.png")
				.getImage();
		pic = new ImageIcon("B:\\movies\\pics\\png pictures\\elephantass.png")
				.getImage();
		loaded = true;
		repaint();// built in method
	}

	public void paint(Graphics g) {
		if (g instanceof Graphics2D) {
			Graphics2D g2 = (Graphics2D) g;// type casting g into graphics2d
			g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
					RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		}
		if (loaded) {
			g.drawImage(bg, 0, 0, null);
			g.drawImage(pic, 0, 0, null);

		}

	}
}