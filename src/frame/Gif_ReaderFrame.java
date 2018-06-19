package frame;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Gif_ReaderFrame extends JFrame implements Runnable {

	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	public Gif_ReaderFrame() {
		setUndecorated(true);
		setResizable(false);
		setSize(529, 527);
//		JLabel gif_Label = new JLabel(new ImageIcon("image/Reader.gif"));
		JLabel gif_Label = new JLabel(new ImageIcon("image/goodReader.gif"));
		getContentPane().add(gif_Label, BorderLayout.CENTER);
	}

	public void run() {
		Gif_ReaderFrame frame = new Gif_ReaderFrame();
		frame.setVisible(true);
		try {
			Thread.sleep(1800);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}// 睡1800 (即1.8秒)
		frame.setVisible(false);// 隐藏了.
		// 以下那句是响应关闭的,如果在期间不用到关窗口,不用这句也行的.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.dispose();
		Login_ReaderFrame login_ReaderFrame = new Login_ReaderFrame();
		login_ReaderFrame.setVisible(true);

	}

}