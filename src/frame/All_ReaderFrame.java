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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Reader;
import sqlTools.ReaderTools;

public class All_ReaderFrame extends JFrame {

	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JScrollPane readerScrollPane;
	public JTable readerJtable;
	private DefaultTableModel defaultModel;
	public int row;

	private JButton updateButton;
	private JButton deleteButton;
	private JButton searchButton;
	private JTextField searchtextField;

	/*	*//**
			 * Launch the application.
			 */
	public static void main(String[] args) {
		try {
			All_ReaderFrame frame = new All_ReaderFrame();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public All_ReaderFrame() {
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

		readerScrollPane = new JScrollPane();
		readerScrollPane.setBounds(302, 244, 611, 334);
		contentPane.add(readerScrollPane);

		searchtextField = new JTextField();
		searchtextField.setFont(new Font("宋体", Font.PLAIN, 18));
		searchtextField.setBounds(302, 181, 492, 35);
		contentPane.add(searchtextField);
		searchtextField.setColumns(10);

		searchButton = new JButton(new ImageIcon("image/search.jpg"));
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_search_reader();
			}
		});
		searchButton.setBounds(816, 181, 97, 35);
		contentPane.add(searchButton);

		updateButton = new JButton(new ImageIcon("image/update.jpg"));
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update_Reader();
			}
		});
		updateButton.setBounds(417, 604, 123, 40);
		contentPane.add(updateButton);

		deleteButton = new JButton(new ImageIcon("image/delete.jpg"));
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete_data();
			}
		});
		deleteButton.setBounds(628, 604, 123, 40);
		contentPane.add(deleteButton);

		show_data();

		JLabel background1 = new JLabel(new ImageIcon("image/background1.jpg"));
		background1.setBounds(0, 0, 990, 659);
		contentPane.add(background1);

	}

	/**
	 * @return 显示全部读者的操作
	 * @param Reader
	 *            读者的数据模型
	 * @param ReaderTools
	 *            数据库操作“读者数据模型”的类
	 */
	private void show_data() {

		readerJtable = new JTable();
		readerJtable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		readerJtable.setRowHeight(54);

		defaultModel = (DefaultTableModel) readerJtable.getModel();
		defaultModel.setRowCount(0);
		defaultModel.setColumnIdentifiers(new Object[] { "读者号", "姓名", "身份", "性别", "密码" });

		readerJtable.getTableHeader().setReorderingAllowed(false);
		readerJtable.setModel(defaultModel);

		readerJtable.getColumnModel().getColumn(0).setPreferredWidth(10);
		readerJtable.getColumnModel().getColumn(1).setPreferredWidth(40);
		readerJtable.getColumnModel().getColumn(2).setPreferredWidth(20);
		readerJtable.getColumnModel().getColumn(3).setPreferredWidth(20);
		readerJtable.getColumnModel().getColumn(4).setPreferredWidth(10);

		ReaderTools readerTools = new ReaderTools();
		List<Reader> readerlist = readerTools.ReaderData();

		for (Iterator<Reader> iterator = readerlist.iterator(); iterator.hasNext();) {
			Reader temp = (Reader) iterator.next();
			defaultModel.addRow(new Object[] { temp.getIdReader(), temp.getNameReader(), temp.getType(), temp.getSex(),
					temp.getPassword() });
		}
		readerScrollPane.setViewportView(readerJtable);
	}

	private void do_search_reader() {

		// 这个超级大的if语句用于按“书名”进行搜索

		readerJtable = new JTable();
		readerJtable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		readerJtable.setRowHeight(54);

		defaultModel = (DefaultTableModel) readerJtable.getModel();
		defaultModel.setRowCount(0);
		defaultModel.setColumnIdentifiers(new Object[] { "读者号", "姓名", "身份", "性别", "密码" });

		readerJtable.getTableHeader().setReorderingAllowed(false);
		readerJtable.setModel(defaultModel);

		readerJtable.getColumnModel().getColumn(0).setPreferredWidth(10);
		readerJtable.getColumnModel().getColumn(1).setPreferredWidth(40);
		readerJtable.getColumnModel().getColumn(2).setPreferredWidth(20);
		readerJtable.getColumnModel().getColumn(3).setPreferredWidth(20);
		readerJtable.getColumnModel().getColumn(4).setPreferredWidth(10);

		ReaderTools readerTools = new ReaderTools();

		String keyword = null;
		if (searchtextField.getText() != null && !"".equals(searchtextField.getText())) {
			keyword = searchtextField.getText();
		} else {
			show_data();
			JOptionPane.showMessageDialog(this, "请输入读者名", "", JOptionPane.WARNING_MESSAGE);
			return;
		}

		List<Reader> readerlist = readerTools.ReaderDataSearch(keyword);

		if (readerlist.size() == 0) {
			JOptionPane.showMessageDialog(this, "未找到有关读者 ", "", JOptionPane.WARNING_MESSAGE);
			return;
		} else {
			for (Iterator<Reader> iterator = readerlist.iterator(); iterator.hasNext();) {
				Reader temp = (Reader) iterator.next();
				defaultModel.addRow(new Object[] { temp.getIdReader(), temp.getNameReader(), temp.getType(),
						temp.getSex(), temp.getPassword() });
			}
			readerScrollPane.setViewportView(readerJtable);
		}
	}

	/**
	 * @return 进行更新读者的操作
	 * @param Reader
	 *            读者的数据模型
	 * @param ReaderTools
	 *            数据库操作“读者数据模型”的类
	 */
	private void update_Reader() {
		row = readerJtable.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(this, "请选择读者！", "", JOptionPane.WARNING_MESSAGE);
			return;
		}
		Reader_UpdateFrame reader_UpdateFrame = new Reader_UpdateFrame(All_ReaderFrame.this);
		reader_UpdateFrame.setVisible(true);
	}

	/**
	 * @return 进行删除读者的操作
	 * @param Reader
	 *            读者的数据模型
	 * @param ReaderTools
	 *            数据库操作“读者数据模型”的类
	 */
	private void delete_data() {
		int row = readerJtable.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(this, "请选择读者", "", JOptionPane.WARNING_MESSAGE);
			return;
		}
		ReaderTools readerTools = new ReaderTools();
		int i = readerTools.DeleteReader(readerJtable.getValueAt(row, 0).toString());
		if (i == 1) {
			JOptionPane.showMessageDialog(getContentPane(), "成功删除读者信息！", "", JOptionPane.WARNING_MESSAGE);
			this.show_data();
			return;
		} else {
			JOptionPane.showMessageDialog(getContentPane(), "删除读者信息失败！", "", JOptionPane.WARNING_MESSAGE);
			return;
		}
	}

	public void CloseFrame() {
		super.dispose();
	}
}
