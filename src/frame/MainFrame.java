package frame;

import java.awt.EventQueue;

/**
 * @author lygwangyp
 *
 */
public class MainFrame {

	/**
	 * @category ‘À––≥Ã–Ú
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
