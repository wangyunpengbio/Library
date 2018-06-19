package frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Reader;
import sqlTools.ReaderTools;

public class Reader_RegisterFrame extends JFrame {

	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JTextField idReadertextField;
	private JTextField nameReadertextField;
	private JTextField typetextField;
	private JTextField sextextField;
	private JTextField passwordtextField;

	private JLabel idReaderLabel;
	private JLabel nameReaderLabel;
	private JLabel typeLabel;
	private JLabel sexLabel;
	private JLabel passwordLabel;

	private JButton insertButton;

	/*	*//**
			 * Launch the application.
			 */
/*	public static void main(String[] args) {
		try {
			Reader_RegisterFrame frame = new Reader_RegisterFrame();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the frame.
	 */
	public Reader_RegisterFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 996, 699);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton reader_Registerbutton = new JButton("读者注册");
		reader_Registerbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reader_RegisterFrame reader_RegisterFrame = new Reader_RegisterFrame();
				reader_RegisterFrame.setVisible(true);
				CloseFrame();
			}
		});
		reader_Registerbutton.setBounds(60, 197, 123, 29);
		contentPane.add(reader_Registerbutton);

		JButton book_Registerbutton = new JButton("书籍入库");
		book_Registerbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Book_RegisterFrame book_RegisterFrame = new Book_RegisterFrame();
				book_RegisterFrame.setVisible(true);
				CloseFrame();
			}
		});
		book_Registerbutton.setBounds(60, 292, 123, 29);
		contentPane.add(book_Registerbutton);

		JButton all_Readerbutton = new JButton("读者库管理");
		all_Readerbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				All_ReaderFrame all_ReaderFrame = new All_ReaderFrame();
				all_ReaderFrame.setVisible(true);
				CloseFrame();
			}
		});
		all_Readerbutton.setBounds(60, 375, 123, 29);
		contentPane.add(all_Readerbutton);

		JButton all_Bookbutton = new JButton("书库管理");
		all_Bookbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				All_BookFrame all_BookFrame = new All_BookFrame();
				all_BookFrame.setVisible(true);
				CloseFrame();
			}
		});
		all_Bookbutton.setBounds(60, 459, 123, 29);
		contentPane.add(all_Bookbutton);

		JButton checkReader_button = new JButton("借阅管理");
		checkReader_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckReaderFrame checkReaderFrame = new CheckReaderFrame();
				checkReaderFrame.setVisible(true);
				CloseFrame();
			}
		});
		checkReader_button.setBounds(60, 545, 123, 29);
		contentPane.add(checkReader_button);

		JButton log_out_Button = new JButton("登出");
		log_out_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrame loginframe = new LoginFrame();
				loginframe.setVisible(true);
				CloseFrame();
			}
		});
		log_out_Button.setBounds(817, 102, 85, 29);
		contentPane.add(log_out_Button);


		idReaderLabel = new JLabel("借阅证号");
		idReaderLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		idReaderLabel.setBounds(445, 180, 149, 55);
		contentPane.add(idReaderLabel);

		nameReaderLabel = new JLabel("姓名");
		nameReaderLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		nameReaderLabel.setBounds(470, 264, 113, 34);
		contentPane.add(nameReaderLabel);

		typeLabel = new JLabel("职位");
		typeLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		typeLabel.setBounds(470, 328, 90, 34);
		contentPane.add(typeLabel);

		sexLabel = new JLabel("性别");
		sexLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		sexLabel.setBounds(470, 386, 106, 47);
		contentPane.add(sexLabel);

		passwordLabel = new JLabel("登录密码");
		passwordLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		passwordLabel.setBounds(445, 459, 120, 55);
		contentPane.add(passwordLabel);

		idReadertextField = new JTextField();
		idReadertextField.setFont(new Font("宋体", Font.PLAIN, 30));
		idReadertextField.setBounds(640, 184, 139, 47);
		contentPane.add(idReadertextField);
		idReadertextField.setColumns(10);

		nameReadertextField = new JTextField();
		nameReadertextField.setFont(new Font("宋体", Font.PLAIN, 30));
		nameReadertextField.setBounds(640, 258, 137, 47);
		contentPane.add(nameReadertextField);
		nameReadertextField.setColumns(10);

		typetextField = new JTextField();
		typetextField.setFont(new Font("宋体", Font.PLAIN, 30));
		typetextField.setBounds(640, 322, 139, 47);
		contentPane.add(typetextField);
		typetextField.setColumns(10);

		sextextField = new JTextField();
		sextextField.setFont(new Font("宋体", Font.PLAIN, 30));
		sextextField.setBounds(640, 386, 139, 47);
		contentPane.add(sextextField);
		sextextField.setColumns(10);

		passwordtextField = new JTextField();
		passwordtextField.setFont(new Font("宋体", Font.PLAIN, 30));
		passwordtextField.setBounds(640, 463, 139, 47);
		contentPane.add(passwordtextField);
		passwordtextField.setColumns(10);

		insertButton = new JButton(new ImageIcon("image/register.jpg"));
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_insertButton_AddReader();
			}
		});
		insertButton.setBounds(555, 545, 106, 47);
		contentPane.add(insertButton);

		JLabel background1 = new JLabel(new ImageIcon("image/background1.jpg"));
		background1.setBounds(0, 0, 990, 659);
		contentPane.add(background1);
	}

	/**
	 * @return 进行增加读者的操作
	 * @param Reader
	 *            读者的数据模型
	 * @param ReaderTools
	 *            数据库操作“读者数据模型”的类
	 */
	protected void do_insertButton_AddReader() {

		ReaderTools readerTools = new ReaderTools();
		Reader reader = new Reader();

		if (idReadertextField.getText() != null && !"".equals(idReadertextField.getText())
				&& nameReadertextField.getText() != null && !"".equals(nameReadertextField.getText())
				&& typetextField.getText() != null && !"".equals(typetextField.getText())
				&& sextextField.getText() != null && !"".equals(sextextField.getText())
				&& passwordtextField.getText() != null && !"".equals(passwordtextField.getText())) {
			reader.setIdReader(idReadertextField.getText());
			reader.setNameReader(nameReadertextField.getText());
			reader.setType(typetextField.getText());
			reader.setSex(sextextField.getText());
			reader.setPassword(passwordtextField.getText());
			int i = readerTools.AddReader(reader);
			if (i == 1) {
				JOptionPane.showMessageDialog(getContentPane(), "成功新增读者信息！", "", JOptionPane.WARNING_MESSAGE);
				return;
			} else {
				JOptionPane.showMessageDialog(getContentPane(), "新增读者信息失败！", "", JOptionPane.WARNING_MESSAGE);
				return;
			}
		} else {
			JOptionPane.showMessageDialog(getContentPane(), "请输入完整资料", "", JOptionPane.WARNING_MESSAGE);
			return;
		}
	}

	public void CloseFrame() {
		super.dispose();
	}
}
