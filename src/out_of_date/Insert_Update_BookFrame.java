package out_of_date;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Author;
import model.Book;
import model.Publisher;
import sqlTools.AuthorTools;
import sqlTools.BookTools;
import sqlTools.PublisherTools;

public class Insert_Update_BookFrame extends JFrame {

	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTextField idBooktextField;
	private JTextField nameBooktextField;
	private JTextField priceField;
	private JTextField typetextField;
	private JTextField authortextField;
	private JTextField publishertextField;	
	private JTextField authorWorkplaceField;
	private JTextField publisherAddressField;

	private JLabel idBookLabel;
	private JLabel nameBookLabel;
	private JLabel priceLabel;
	private JLabel typeLabel;
	private JLabel authorLabel;
	private JLabel publisherLabel;
	private JLabel authorWorkplaceLabel;
	private JLabel publisherAddressLabel;
	
	private JButton insertButton;
	private JButton updateButton;
/*	*//**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insert_Update_BookFrame frame = new Insert_Update_BookFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Insert_Update_BookFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		idBookLabel = new JLabel("书籍编号");
		idBookLabel.setBounds(82, 25, 81, 21);
		contentPane.add(idBookLabel);
		
		nameBookLabel = new JLabel("书名");
		nameBookLabel.setBounds(82, 77, 81, 21);
		contentPane.add(nameBookLabel);
		
		priceLabel = new JLabel("价格");
		priceLabel.setBounds(67, 124, 81, 21);
		contentPane.add(priceLabel);
		
		typeLabel = new JLabel("种类");
		typeLabel.setBounds(82, 181, 81, 21);
		contentPane.add(typeLabel);
		
		authorLabel = new JLabel("作者");
		authorLabel.setBounds(82, 234, 81, 21);
		contentPane.add(authorLabel);
		
		publisherLabel = new JLabel("出版社");
		publisherLabel.setBounds(67, 288, 81, 21);
		contentPane.add(publisherLabel);
		
		
		idBooktextField = new JTextField();
		idBooktextField.setBounds(218, 22, 96, 27);
		contentPane.add(idBooktextField);
		idBooktextField.setColumns(10);
		
		nameBooktextField = new JTextField();
		nameBooktextField.setBounds(218, 74, 96, 27);
		contentPane.add(nameBooktextField);
		nameBooktextField.setColumns(10);
	
		
		priceField = new JTextField();
		priceField.setBounds(218, 116, 96, 27);
		contentPane.add(priceField);
		priceField.setColumns(10);
		
		typetextField = new JTextField();
		typetextField.setBounds(218, 178, 96, 27);
		contentPane.add(typetextField);
		typetextField.setColumns(10);
		
		authortextField = new JTextField();
		authortextField.setBounds(218, 231, 96, 27);
		contentPane.add(authortextField);
		authortextField.setColumns(10);
		
		publishertextField = new JTextField();
		publishertextField.setBounds(218, 285, 96, 27);
		contentPane.add(publishertextField);
		publishertextField.setColumns(10);
		
		insertButton = new JButton("新增");
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_insertButton_AddBook();
			}
		});
		insertButton.setBounds(82, 373, 106, 37);
		contentPane.add(insertButton);
		
		updateButton = new JButton("更新");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_updateButton_UpdateBook();
			}
		});
		updateButton.setBounds(271, 373, 106, 37);
		contentPane.add(updateButton);
		
		authorWorkplaceLabel = new JLabel("作者单位");
		authorWorkplaceLabel.setBounds(404, 234, 81, 21);
		contentPane.add(authorWorkplaceLabel);
		
		publisherAddressLabel = new JLabel("出版社地址");
		publisherAddressLabel.setBounds(404, 288, 112, 21);
		contentPane.add(publisherAddressLabel);
		
		authorWorkplaceField = new JTextField();
		authorWorkplaceField.setBounds(531, 231, 104, 27);
		contentPane.add(authorWorkplaceField);
		authorWorkplaceField.setColumns(10);
		
		publisherAddressField = new JTextField();
		publisherAddressField.setBounds(531, 285, 104, 27);
		contentPane.add(publisherAddressField);
		publisherAddressField.setColumns(10);

	}

	/**
	 * 由于数据库建立时，Book中author和publisher字段分别参照Author和Publisher表
	 * 因此代码书写时候应该先更新Author和Publisher表
	 * @return 进行增加书籍的操作
	 * @param Book 书籍的数据模型
	 * @param Author 作者的数据模型
	 * @param Publisher 出版社的数据模型
	 * @param BookTools 数据库操作“书籍数据模型”的类
	 * @param AuthorTools 数据库操作“作者数据模型”的类
	 * @param PublisherTools 数据库操作“出版社数据模型”的类
	 */
	protected void do_insertButton_AddBook() {
		// TODO Auto-generated method stub
		BookTools bookTools = new BookTools();
		Book book = new Book();
		
		Author author = new Author();
		AuthorTools authorTools = new AuthorTools();
		
		Publisher publisher= new Publisher();
		PublisherTools publisherTools = new PublisherTools();
		
		if ( idBooktextField.getText() != null && !"".equals(idBooktextField.getText()) 
				&& nameBooktextField.getText() != null && !"".equals(nameBooktextField.getText())
				&& priceField.getText() != null && !"".equals(priceField.getText())
				&& typetextField.getText() != null && !"".equals(typetextField.getText())
				&& authortextField.getText() != null && !"".equals(authortextField.getText())
				&& publishertextField.getText() != null && !"".equals(publishertextField.getText())
				&& authorWorkplaceField.getText()!= null && !"".equals(authorWorkplaceField.getText())
				&& publisherAddressField.getText() != null && !"".equals(publisherAddressField.getText())) {
			book.setIdBook(idBooktextField.getText());
			book.setNameBook(nameBooktextField.getText());
			book.setPrice(Integer.parseInt(priceField.getText()));
			book.setType(typetextField.getText());
			book.setAuthor(authortextField.getText());
			book.setPublisher(publishertextField.getText());
			author.setName(authortextField.getText());
			author.setWorkplace(authorWorkplaceField.getText());
			publisher.setName(publishertextField.getText());
			publisher.setAddress(publisherAddressField.getText());
			int j = publisherTools.AddPublisher(publisher);
			int k = authorTools.AddAuthor(author);
			int i = bookTools.AddBook(book);
			if ( i == 1 && j==1 && k==1) {
	            JOptionPane.showMessageDialog(getContentPane(), "成功新增图书信息！", "", JOptionPane.WARNING_MESSAGE);
	            return;
			} else {
	            JOptionPane.showMessageDialog(getContentPane(), "新增图书信息失败！", "", JOptionPane.WARNING_MESSAGE);
	            return;
			}
		} else {
            JOptionPane.showMessageDialog(getContentPane(), "请输入完整资料", "", JOptionPane.WARNING_MESSAGE);
            return;
		}
	}

	/**
	 * 由于数据库建立时，Book中author和publisher字段分别参照Author和Publisher表
	 * 因此代码书写时候应该先更新Author和Publisher表
	 * @return 进行更新书籍的操作
	 * @param Book 书籍的数据模型
	 * @param Author 作者的数据模型
	 * @param Publisher 出版社的数据模型
	 * @param BookTools 数据库操作“书籍数据模型”的类
	 * @param AuthorTools 数据库操作“作者数据模型”的类
	 * @param PublisherTools 数据库操作“出版社数据模型”的类
	 */
	protected void do_updateButton_UpdateBook() {
		// TODO Auto-generated method stub
		BookTools bookTools = new BookTools();
		Book book = new Book();
		
		Author author = new Author();
		AuthorTools authorTools = new AuthorTools();
		
		Publisher publisher= new Publisher();
		PublisherTools publisherTools = new PublisherTools();
		
		if ( idBooktextField.getText() != null && !"".equals(idBooktextField.getText()) 
				&& nameBooktextField.getText() != null && !"".equals(nameBooktextField.getText())
				&& priceField.getText() != null && !"".equals(priceField.getText())
				&& typetextField.getText() != null && !"".equals(typetextField.getText())
				&& authortextField.getText() != null && !"".equals(authortextField.getText())
				&& publishertextField.getText() != null && !"".equals(publishertextField.getText())
				&& authorWorkplaceField.getText()!= null && !"".equals(authorWorkplaceField.getText())
				&& publisherAddressField.getText() != null && !"".equals(publisherAddressField.getText())) {
			book.setIdBook(idBooktextField.getText());
			book.setNameBook(nameBooktextField.getText());
			book.setPrice(Integer.parseInt(priceField.getText()));
			book.setType(typetextField.getText());
			book.setAuthor(authortextField.getText());
			book.setPublisher(publishertextField.getText());
			author.setName(authortextField.getText());
			author.setWorkplace(authorWorkplaceField.getText());
			publisher.setName(publishertextField.getText());
			publisher.setAddress(publisherAddressField.getText());
			int j = publisherTools.UpdatePublisher(publisher);
			int k = authorTools.UpdateAuthor(author);
			int i = bookTools.UpdateBook(book);
			if ( i == 1 && j==1 && k==1) {
	            JOptionPane.showMessageDialog(getContentPane(), "成功新增图书信息！", "", JOptionPane.WARNING_MESSAGE);
	            return;
			} else {
	            JOptionPane.showMessageDialog(getContentPane(), "新增图书信息失败！", "", JOptionPane.WARNING_MESSAGE);
	            return;
			}
		} else {
            JOptionPane.showMessageDialog(getContentPane(), "请输入完整资料", "", JOptionPane.WARNING_MESSAGE);
            return;
		}
	}
}
