package frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Author;
import model.Book;
import model.Publisher;
import sqlTools.AuthorTools;
import sqlTools.BookTools;
import sqlTools.BorrowTools;
import sqlTools.PublisherTools;

public class All_BookFrame extends JFrame implements ItemListener {

	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JScrollPane bookScrollPane;
	public JTable bookJtable;
	private DefaultTableModel defaultModel;
	public int row;

	private JButton updateButton;
	private JButton deleteButton;
	private JButton searchButton;

	private String searchType = "idBook";
	private JRadioButton nameBookRadioButton;
	private JRadioButton idBookRadioButton;
	private ButtonGroup group;

	private JTextField searchtextField;

	/*	*//**
			 * Launch the application.
			 */
/*	public static void main(String[] args) {
		try {
			All_BookFrame frame = new All_BookFrame();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
	/**
	 * Create the frame.
	 */
	public All_BookFrame() {
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

		bookScrollPane = new JScrollPane();
		bookScrollPane.setBounds(293, 253, 658, 332);
		contentPane.add(bookScrollPane);

		deleteButton = new JButton(new ImageIcon("image/delete.jpg"));
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete_Book();
			}
		});
		deleteButton.setBounds(641, 600, 128, 44);
		contentPane.add(deleteButton);

		searchtextField = new JTextField();
		searchtextField.setFont(new Font("宋体", Font.PLAIN, 18));
		searchtextField.setBounds(300, 166, 492, 35);
		contentPane.add(searchtextField);
		searchtextField.setColumns(10);

		searchButton = new JButton(new ImageIcon("image/search.jpg"));
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_search_book();
			}
		});
		searchButton.setBounds(838, 166, 97, 35);
		contentPane.add(searchButton);

		idBookRadioButton = new JRadioButton("按编号搜索");
		idBookRadioButton.setFont(new Font("宋体", Font.PLAIN, 18));
		idBookRadioButton.setBounds(346, 213, 177, 29);
		contentPane.add(idBookRadioButton);
		idBookRadioButton.setSelected(true);
		idBookRadioButton.addItemListener(this);
		idBookRadioButton.setContentAreaFilled(false);

		nameBookRadioButton = new JRadioButton("按书名搜索");
		nameBookRadioButton.setFont(new Font("宋体", Font.PLAIN, 18));
		nameBookRadioButton.setBackground(UIManager.getColor("Button.disabledShadow"));
		nameBookRadioButton.setBounds(568, 213, 177, 29);
		contentPane.add(nameBookRadioButton);
		nameBookRadioButton.addItemListener(this);
		nameBookRadioButton.setContentAreaFilled(false);

		// 将单选按钮加入到一个组里
		group = new ButtonGroup();
		group.add(this.idBookRadioButton);
		group.add(this.nameBookRadioButton);

		updateButton = new JButton(new ImageIcon("image/update.jpg"));
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update_book();
			}
		});
		updateButton.setBounds(437, 600, 128, 44);
		contentPane.add(updateButton);

		// 显示全部图书信息
		show_data();

		JLabel background1 = new JLabel(new ImageIcon("image/background1.jpg"));
		background1.setBounds(0, 0, 990, 659);
		contentPane.add(background1);

	}

	/**
	 * @return 显示全部图书的信息
	 * @param Book
	 *            书籍的数据模型
	 * @param BookTools
	 *            数据库操作“书籍模型”的类
	 */
	private void show_data() {

		bookJtable = new JTable();
		bookJtable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		bookJtable.setRowHeight(54);

		defaultModel = (DefaultTableModel) bookJtable.getModel();
		defaultModel.setRowCount(0);
		defaultModel
				.setColumnIdentifiers(new Object[] { "编号", "书名", "价格", "种类", "作者", "出版商", "作者单位", "出版社地址", "是否在库" });
		bookJtable.getTableHeader().setReorderingAllowed(false);
		bookJtable.setModel(defaultModel);

		bookJtable.getColumnModel().getColumn(0).setPreferredWidth(20);
		bookJtable.getColumnModel().getColumn(1).setPreferredWidth(80);
		bookJtable.getColumnModel().getColumn(2).setPreferredWidth(30);
		bookJtable.getColumnModel().getColumn(3).setPreferredWidth(40);
		bookJtable.getColumnModel().getColumn(4).setPreferredWidth(40);
		bookJtable.getColumnModel().getColumn(5).setPreferredWidth(90);
		bookJtable.getColumnModel().getColumn(6).setPreferredWidth(40);
		bookJtable.getColumnModel().getColumn(7).setPreferredWidth(80);
		bookJtable.getColumnModel().getColumn(8).setPreferredWidth(30);

		BookTools bookTools = new BookTools();
		AuthorTools authorTools = new AuthorTools();
		PublisherTools publisherTools = new PublisherTools();

		List<Book> booklist = bookTools.BookData();
		BorrowTools borrowtools = new BorrowTools();

		for (Iterator<Book> iterator = booklist.iterator(); iterator.hasNext();) {
			Book temp = (Book) iterator.next();
			// Check the idReader
			String whetherInStock = null;

			if (borrowtools.whetherInStock(temp.getIdBook()) == true) {
				whetherInStock = "在库";
			} else {
				whetherInStock = "借出";
			}
			List<Author> authorlist = authorTools.AuthorData(temp.getAuthor());
			Publisher publisher = publisherTools.PublisherData((temp.getPublisher()));
			defaultModel.addRow(new Object[] { temp.getIdBook(), temp.getNameBook(), temp.getPrice(), temp.getType(),
					temp.getAuthor(), temp.getPublisher(), authorlist.get(0).getWorkplace(), publisher.getAddress(),
					whetherInStock });
		}
		bookScrollPane.setViewportView(bookJtable);
	}

	/**
	 * @author lygwangyp
	 * @param idBookRadioButton
	 * @param nameBookRadioButton
	 *            检测进行搜索的方式，按书编号搜索，或者按书名搜索
	 */
	public void itemStateChanged(ItemEvent e) {
		if (idBookRadioButton.isSelected()) {
			this.searchType = "idBook";
			// System.out.println(this.searchType);
		}
		if (nameBookRadioButton.isSelected()) {
			this.searchType = "nameBook";
			// System.out.println(this.searchType);
		}
	}

	/**
	 * @return 搜索图书信息
	 * @param Book
	 *            书籍的数据模型
	 * @param BookTools
	 *            数据库操作“书籍模型”的类
	 */
	private void do_search_book() {

		// 这个超级大的if语句用于按“书名”进行搜索

		if ("nameBook".equals(searchType)) {

			bookJtable = new JTable();
			bookJtable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
			bookJtable.setRowHeight(54);

			defaultModel = (DefaultTableModel) bookJtable.getModel();
			defaultModel.setRowCount(0);
			defaultModel.setColumnIdentifiers(
					new Object[] { "编号", "书名", "价格", "种类", "作者", "出版商", "作者单位", "出版社地址", "是否在库" });

			bookJtable.getTableHeader().setReorderingAllowed(false);
			bookJtable.setModel(defaultModel);

			bookJtable.getColumnModel().getColumn(0).setPreferredWidth(20);
			bookJtable.getColumnModel().getColumn(1).setPreferredWidth(80);
			bookJtable.getColumnModel().getColumn(2).setPreferredWidth(30);
			bookJtable.getColumnModel().getColumn(3).setPreferredWidth(40);
			bookJtable.getColumnModel().getColumn(4).setPreferredWidth(40);
			bookJtable.getColumnModel().getColumn(5).setPreferredWidth(90);
			bookJtable.getColumnModel().getColumn(6).setPreferredWidth(40);
			bookJtable.getColumnModel().getColumn(7).setPreferredWidth(80);
			bookJtable.getColumnModel().getColumn(8).setPreferredWidth(30);

			BookTools booktools = new BookTools();
			AuthorTools authorTools = new AuthorTools();
			PublisherTools publisherTools = new PublisherTools();

			BorrowTools borrowtools = new BorrowTools();

			String keyword = null;
			if (searchtextField.getText() != null && !"".equals(searchtextField.getText())) {
				keyword = searchtextField.getText();
			} else {
				show_data();
				JOptionPane.showMessageDialog(this, "请输入书名", "", JOptionPane.WARNING_MESSAGE);
				return;
			}

			List<Book> booklist = booktools.BookData(keyword);

			if (booklist.size() == 0) {
				JOptionPane.showMessageDialog(this, "未找到有关书籍 ", "", JOptionPane.WARNING_MESSAGE);
				return;
			} else {
				for (Iterator<Book> iterator = booklist.iterator(); iterator.hasNext();) {
					Book temp = (Book) iterator.next();
					String whetherInStock = null;
					if (borrowtools.whetherInStock(temp.getIdBook()) == true) {
						whetherInStock = "在库";
					} else {
						whetherInStock = "借出";
					}
					List<Author> authorlist = authorTools.AuthorData(temp.getAuthor());
					Publisher publisher = publisherTools.PublisherData((temp.getPublisher()));
					defaultModel.addRow(new Object[] { temp.getIdBook(), temp.getNameBook(), temp.getPrice(),
							temp.getType(), temp.getAuthor(), temp.getPublisher(), authorlist.get(0).getWorkplace(),
							publisher.getName(), whetherInStock });
				}
				bookScrollPane.setViewportView(bookJtable);
			}
		}

		// 这个超级大的if语句用于按“书编号”进行搜索

		if ("idBook".equals(searchType)) {

			bookJtable = new JTable();
			bookJtable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
			bookJtable.setRowHeight(54);

			defaultModel = (DefaultTableModel) bookJtable.getModel();
			defaultModel.setRowCount(0);
			defaultModel.setColumnIdentifiers(
					new Object[] { "编号", "书名", "价格", "种类", "作者", "出版商", "作者单位", "出版社地址", "是否在库" });

			bookJtable.getTableHeader().setReorderingAllowed(false);
			bookJtable.setModel(defaultModel);

			bookJtable.getColumnModel().getColumn(0).setPreferredWidth(20);
			bookJtable.getColumnModel().getColumn(1).setPreferredWidth(80);
			bookJtable.getColumnModel().getColumn(2).setPreferredWidth(30);
			bookJtable.getColumnModel().getColumn(3).setPreferredWidth(40);
			bookJtable.getColumnModel().getColumn(4).setPreferredWidth(40);
			bookJtable.getColumnModel().getColumn(5).setPreferredWidth(90);
			bookJtable.getColumnModel().getColumn(6).setPreferredWidth(40);
			bookJtable.getColumnModel().getColumn(7).setPreferredWidth(80);
			bookJtable.getColumnModel().getColumn(8).setPreferredWidth(30);
			BorrowTools borrowtools = new BorrowTools();
			AuthorTools authorTools = new AuthorTools();
			PublisherTools publisherTools = new PublisherTools();

			String keyword = null;
			if (searchtextField.getText() != null && !"".equals(searchtextField.getText())) {
				keyword = searchtextField.getText();
			} else {
				show_data();
				JOptionPane.showMessageDialog(this, "请输入书编号", "", JOptionPane.WARNING_MESSAGE);
				return;
			}

			List<Book> booklist = borrowtools.BookData_Search_idBook(keyword);

			if (booklist.size() == 0) {
				JOptionPane.showMessageDialog(this, "未找到有关书籍 ", "", JOptionPane.WARNING_MESSAGE);
				return;
			} else {
				for (Iterator<Book> iterator = booklist.iterator(); iterator.hasNext();) {
					Book temp = (Book) iterator.next();
					String whetherInStock = null;
					if (borrowtools.whetherInStock(temp.getIdBook()) == true) {
						whetherInStock = "在库";
					} else {
						whetherInStock = "借出";
					}
					List<Author> authorlist = authorTools.AuthorData(temp.getAuthor());
					Publisher publisher = publisherTools.PublisherData((temp.getPublisher()));
					defaultModel.addRow(new Object[] { temp.getIdBook(), temp.getNameBook(), temp.getPrice() + "元",
							temp.getType(), temp.getAuthor(), temp.getPublisher(), authorlist.get(0).getWorkplace(),
							publisher.getName(), whetherInStock });
				}
				bookScrollPane.setViewportView(bookJtable);
			}
		}
	}

	/**
	 * @return 更新所选书籍
	 * @param Book
	 *            书籍的数据模型
	 * @param BookTools
	 *            数据库操作“书籍模型”的类
	 */
	private void update_book() {

		row = bookJtable.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(this, "请选择书籍！", "", JOptionPane.WARNING_MESSAGE);
			return;
		}
		Book_UpdateFrame book_UpdateFrame = new Book_UpdateFrame(All_BookFrame.this);
		book_UpdateFrame.setVisible(true);

	}

	/**
	 * @return 刪除所选书籍
	 * @param Book
	 *            书籍的数据模型
	 * @param BookTools
	 *            数据库操作“书籍模型”的类
	 */
	private void delete_Book() {
		row = bookJtable.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(this, "请选择书籍", "", JOptionPane.WARNING_MESSAGE);
			return;
		}
		BookTools bookTools = new BookTools();
		int i = bookTools.DeleteBook(bookJtable.getValueAt(row, 0).toString());
		if (i == 1) {
			JOptionPane.showMessageDialog(getContentPane(), "成功删除书籍信息！", "", JOptionPane.WARNING_MESSAGE);
			this.show_data();
			return;
		} else {
			JOptionPane.showMessageDialog(getContentPane(), "删除书籍信息失败！", "", JOptionPane.WARNING_MESSAGE);
			return;
		}
	}

	public void CloseFrame() {
		super.dispose();
	}
}
