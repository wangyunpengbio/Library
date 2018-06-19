package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Librarian;
import model.Reader;
import sqlTools.LibrarianTools;
import sqlTools.ReaderTools;

public class LoginFrame extends JFrame implements ItemListener {

	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private boolean readerLogin = true;
	private boolean librarianLogin = false;
	public static String idReader;
	public static String nameReader;
	public static String nameUser;
	private Librarian lib;
	private Reader reader;

	private JTextField nameUserTextField;
	private JPasswordField passwordField;
	private JButton loginButton;
	private JButton view_Password_Button;

	private JRadioButton readerRadioButton;
	private JRadioButton librarianRadioButton;
	private ButtonGroup group;

	private JLabel userNameLabel;
	private JLabel passwordLabel;

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 389, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		userNameLabel = new JLabel("用户名");
		userNameLabel.setForeground(Color.WHITE);
		userNameLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		userNameLabel.setBounds(64, 188, 55, 20);
		contentPane.add(userNameLabel);

		passwordLabel = new JLabel("密码");
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		passwordLabel.setBounds(64, 267, 55, 18);
		contentPane.add(passwordLabel);

		nameUserTextField = new JTextField();
		nameUserTextField.setFont(new Font("Dialog", Font.PLAIN, 15));
		nameUserTextField.setBounds(128, 188, 167, 22);
		contentPane.add(nameUserTextField);
		nameUserTextField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Dialog", Font.PLAIN, 15));
		passwordField.setBounds(128, 265, 167, 22);
		contentPane.add(passwordField);

		loginButton = new JButton(new ImageIcon("image/loginbutton.jpg"));
		loginButton.setFont(new Font("Dialog", Font.BOLD, 17));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check_login();
			}
		});
		loginButton.setBounds(129, 386, 98, 36);
		contentPane.add(loginButton);

		// 为单选按钮JRadioButton加上事件监听，默认选中readerRadioButton
		readerRadioButton = new JRadioButton("读者");
		readerRadioButton.setForeground(Color.WHITE);
		readerRadioButton.setBounds(57, 323, 121, 26);
		contentPane.add(readerRadioButton);
		readerRadioButton.addItemListener(this);
		readerRadioButton.setSelected(true);
		readerRadioButton.setContentAreaFilled(false);

		librarianRadioButton = new JRadioButton("管理员");
		librarianRadioButton.setForeground(Color.WHITE);
		librarianRadioButton.setBounds(198, 323, 121, 26);
		contentPane.add(librarianRadioButton);
		librarianRadioButton.addItemListener(this);
		librarianRadioButton.setContentAreaFilled(false);
		
		// 将单选按钮加入到一个组里
		group = new ButtonGroup();
		group.add(this.readerRadioButton);
		group.add(this.librarianRadioButton);
		
		view_Password_Button = new JButton(new ImageIcon("image/review.jpg"));
		view_Password_Button.setBounds(302, 267, 31, 20);
		view_Password_Button.addMouseListener(new MouseAdapter(){
		char echoChar=passwordField.getEchoChar();
			public void mousePressed(MouseEvent e){
				passwordField.setEchoChar((char)0);
			}
			public void mouseReleased(MouseEvent e){
				passwordField.setEchoChar(echoChar);
				passwordField.requestFocus();				
			}
		});
		contentPane.add(view_Password_Button);
		
		JLabel background1 = new JLabel(new ImageIcon("image/Login.jpg"));
		background1.setBounds(0, 0, 383, 520);
		contentPane.add(background1);
		
	}

	/***
	 * @return 进行登录信息的确认
	 * @param Librarian
	 *            图书管理员的数据模型
	 * @param LibrarianTools
	 *            数据库操作“图书管理员模型”的类
	 * @param passwordField
	 *            passwordField.getText()已经过时，不推荐使用。
	 *            passwordField.getPassword()返回char数组，用String类构造方法，
	 *            将char数组转化为String
	 */
	private void check_login() {
		if (this.readerLogin == true) {
			ReaderTools rTools = new ReaderTools();
			reader = new Reader();
			reader.setIdReader(nameUserTextField.getText());
			reader.setPassword(new String(passwordField.getPassword()));
			if (nameUserTextField.getText() != null && !"".equals(nameUserTextField.getText())
					&& passwordField.getPassword() != null && !("".equals(new String(passwordField.getPassword())))) {

				boolean whether_login = rTools.ReaderLogin(reader.getIdReader(), reader.getPassword());
				nameReader = rTools.ReaderData(reader.getIdReader()).get(0).getNameReader();
				if (whether_login == true) {
					idReader = reader.getIdReader();
					
					Gif_ReaderFrame frame = new Gif_ReaderFrame();
					new Thread(frame,"Reader线程").start();
					
					CloseFrame();
					return;
				} else {
					JOptionPane.showMessageDialog(this, "用户名或密码错误", "", JOptionPane.WARNING_MESSAGE);
					return;
				}

			} else {
				JOptionPane.showMessageDialog(this, "请填写用户名和密码", "", JOptionPane.WARNING_MESSAGE);
				return;
			}

		}
		if (this.librarianLogin == true) {
			LibrarianTools libTools = new LibrarianTools();
			lib = new Librarian();
			lib.setNameUser(nameUserTextField.getText());
			lib.setPassword(new String(passwordField.getPassword()));
			if (nameUserTextField.getText() != null && !"".equals(nameUserTextField.getText())
					&& passwordField.getPassword() != null && !("".equals(new String(passwordField.getPassword())))) {

				boolean whether_login = libTools.LibrarianLogin(lib.getNameUser(), lib.getPassword());
				if (whether_login == true) {
					nameUser = lib.getNameUser();
					
					Gif_LibrarianFrame frame = new Gif_LibrarianFrame();
					new Thread(frame,"Reader线程").start();
					
					CloseFrame();
					return;
				} else {
					JOptionPane.showMessageDialog(this, "用户名或密码错误", "", JOptionPane.WARNING_MESSAGE);
					return;
				}

			} else {
				JOptionPane.showMessageDialog(this, "请填写用户名和密码", "", JOptionPane.WARNING_MESSAGE);
				return;
			}
		}
	}


	/**
	 * 奇怪的是，在All_BookFrame也有一个相似的选项框，我在All_BookFrame那里用RadioButton.isSelected()
	 * 是可以的，
	 * 然后粘贴过来，改一改，在这里用就会报空指针异常，我一开始以为是构造方法的问题，可是我把构造方法弄好以后，依旧报错：空指针异常，我也就放弃了
	 * 改换成这种也是可以当做标志的。
	 */
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == readerRadioButton) {
			this.readerLogin = true;
			this.librarianLogin = false;
			// System.out.println("readerLogin"+this.readerLogin+"\nlibrarianLogin"+this.librarianLogin);
			// System.out.println();
		} else {
			this.readerLogin = false;
			this.librarianLogin = true;
			// System.out.println("readerLogin"+this.readerLogin+"\nlibrarianLogin"+this.librarianLogin);
			// System.out.println();
		}
	}
	public void CloseFrame() {
		super.dispose();
	}
}
