package frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Book;
import model.Reader;
import sqlTools.BorrowTools;
import sqlTools.ReaderTools;

public class CheckReaderFrame extends JFrame {

	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLayeredPane layeredPane;

	private JScrollPane bookScrollPane;
	private JTable bookJtable;
	private DefaultTableModel defaultModel;

	private JLabel idReaderLabel;
	private JLabel nameReaderLabel;
	private JLabel typeLabel;
	private JLabel sexLabel;
	private JLabel passwordLabel;
	private JTextField idReadertextField;

	private JLabel showNameReaderLabel;
	private JLabel showTypeLabel;
	private JLabel showSexLabel;
	private JLabel showPasswordLabel;

	/*	*//**
			 * Launch the application.
			 */
/*	public static void main(String[] args) {
		try {
			CheckReaderFrame frame = new CheckReaderFrame();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the frame.
	 */
	public CheckReaderFrame() {
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

		layeredPane = new JLayeredPane();
		layeredPane.setBounds(128, 61, 862, 598);
		contentPane.add(layeredPane);

		idReaderLabel = new JLabel("借阅证号");
		idReaderLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		idReaderLabel.setBounds(311, 102, 158, 43);
		layeredPane.add(idReaderLabel);

		nameReaderLabel = new JLabel("姓名");
		nameReaderLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		nameReaderLabel.setBounds(241, 171, 81, 32);
		layeredPane.add(nameReaderLabel);

		typeLabel = new JLabel("职位");
		typeLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		typeLabel.setBounds(507, 171, 93, 32);
		layeredPane.add(typeLabel);

		sexLabel = new JLabel("性别");
		sexLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		sexLabel.setBounds(241, 218, 81, 38);
		layeredPane.add(sexLabel);

		passwordLabel = new JLabel("密码");
		passwordLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		passwordLabel.setBounds(507, 224, 81, 32);
		layeredPane.add(passwordLabel);

		idReadertextField = new JTextField();
		idReadertextField.setFont(new Font("宋体", Font.PLAIN, 30));
		idReadertextField.setBounds(491, 102, 146, 43);
		idReadertextField.setColumns(10);
		layeredPane.add(idReadertextField);

		showNameReaderLabel = new JLabel("");
		showNameReaderLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		showNameReaderLabel.setBounds(348, 171, 144, 32);
		layeredPane.add(showNameReaderLabel);

		showTypeLabel = new JLabel("");
		showTypeLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		showTypeLabel.setBounds(604, 170, 137, 33);
		layeredPane.add(showTypeLabel);

		showSexLabel = new JLabel("");
		showSexLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		showSexLabel.setBounds(355, 218, 137, 38);
		layeredPane.add(showSexLabel);

		showPasswordLabel = new JLabel("");
		showPasswordLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		showPasswordLabel.setBounds(604, 222, 137, 34);
		layeredPane.add(showPasswordLabel);

		JButton btnNewButton = new JButton(new ImageIcon("image/query.jpg"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show_data();
			}
		});
		btnNewButton.setBounds(401, 540, 105, 43);
		layeredPane.add(btnNewButton);

		bookScrollPane = new JScrollPane(bookJtable);
		bookScrollPane.setBounds(197, 271, 576, 260);
		layeredPane.add(bookScrollPane);

		JLabel background1 = new JLabel(new ImageIcon("image/background1.jpg"));
		background1.setBounds(0, 0, 990, 659);
		contentPane.add(background1);

	}

	/**
	 * @return 显示读者信息
	 * @param Reader
	 *            读者的数据模型
	 * @param ReaderTools
	 *            数据库操作“读者模型”的类
	 */
	private void show_data() {

		bookJtable = new JTable();
		bookJtable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		bookJtable.setRowHeight(54);

		defaultModel = (DefaultTableModel) bookJtable.getModel();
		defaultModel.setRowCount(0);
		defaultModel.setColumnIdentifiers(new Object[] { "编号", "书名", "价格", "种类", "作者", "出版商" });

		bookJtable.getTableHeader().setReorderingAllowed(false);
		bookJtable.setModel(defaultModel);

		bookJtable.getColumnModel().getColumn(0).setPreferredWidth(10);
		bookJtable.getColumnModel().getColumn(1).setPreferredWidth(80);
		bookJtable.getColumnModel().getColumn(2).setPreferredWidth(20);
		bookJtable.getColumnModel().getColumn(3).setPreferredWidth(20);
		bookJtable.getColumnModel().getColumn(4).setPreferredWidth(10);
		bookJtable.getColumnModel().getColumn(5).setPreferredWidth(90);

		ReaderTools readerTools = new ReaderTools();
		Reader reader = new Reader();
		BorrowTools borrowtools = new BorrowTools();

		if (idReadertextField.getText() != null && !"".equals(idReadertextField.getText())) {
			reader.setIdReader(idReadertextField.getText());
		} else {
			JOptionPane.showMessageDialog(this, "请输入读者编号", "", JOptionPane.WARNING_MESSAGE);
			return;
		}
		List<Reader> readerlist = readerTools.ReaderData(reader.getIdReader());
		List<Book> booklist = borrowtools.BookData(reader.getIdReader());

		// Check the idReader

		if (readerlist.size() == 0) {
			JOptionPane.showMessageDialog(this, "读者编号错误，请输入正确的读者编号 ", "", JOptionPane.WARNING_MESSAGE);
			return;
		} else {
			for (Iterator<Reader> iterator = readerlist.iterator(); iterator.hasNext();) {
				Reader temp = (Reader) iterator.next();
				showNameReaderLabel.setText(temp.getNameReader());
				showTypeLabel.setText(temp.getType());
				showSexLabel.setText(temp.getSex());
				showPasswordLabel.setText(temp.getPassword());
			}
			for (Iterator<Book> iterator = booklist.iterator(); iterator.hasNext();) {
				Book temp = (Book) iterator.next();
				defaultModel.addRow(new Object[] { temp.getIdBook(), temp.getNameBook(), temp.getPrice() + "元",
						temp.getType(), temp.getAuthor(), temp.getPublisher() });
			}
		}
		bookScrollPane.setViewportView(bookJtable);
	}

	public void CloseFrame() {
		super.dispose();
	}
}
