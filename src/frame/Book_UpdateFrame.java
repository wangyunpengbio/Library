package frame;

import java.awt.Color;
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

import model.Author;
import model.Book;
import model.Publisher;
import sqlTools.AuthorTools;
import sqlTools.BookTools;
import sqlTools.PublisherTools;

public class Book_UpdateFrame extends JFrame {

	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTextField nameBooktextField;
	private JTextField priceField;
	private JTextField typetextField;
	private JTextField authortextField;
	private JTextField publishertextField;	
	private JTextField authorWorkplaceField;
	private JTextField publisherAddressField;

	private JLabel idBookLabel;
	private JLabel idBook_showLabel;
	private JLabel nameBookLabel;
	private JLabel priceLabel;
	private JLabel typeLabel;
	private JLabel authorLabel;
	private JLabel publisherLabel;
	private JLabel authorWorkplaceLabel;
	private JLabel publisherAddressLabel;
	private JButton updateButton;
	
	/**
	 * Create the frame.
	 */
	public Book_UpdateFrame(All_BookFrame all_BookFrame) {
		setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 608, 743);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		idBookLabel = new JLabel("书籍编号");
		idBookLabel.setForeground(Color.WHITE);
		idBookLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		idBookLabel.setBounds(137, 111, 137, 39);
		contentPane.add(idBookLabel);
		
		nameBookLabel = new JLabel("书名");
		nameBookLabel.setForeground(Color.WHITE);
		nameBookLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		nameBookLabel.setBounds(137, 190, 103, 39);
		contentPane.add(nameBookLabel);
		
		priceLabel = new JLabel("价格");
		priceLabel.setForeground(Color.WHITE);
		priceLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		priceLabel.setBounds(137, 256, 81, 39);
		contentPane.add(priceLabel);
		
		typeLabel = new JLabel("种类");
		typeLabel.setForeground(Color.WHITE);
		typeLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		typeLabel.setBounds(137, 335, 81, 39);
		contentPane.add(typeLabel);
		
		authorLabel = new JLabel("作者");
		authorLabel.setForeground(Color.WHITE);
		authorLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		authorLabel.setBounds(29, 426, 81, 39);
		contentPane.add(authorLabel);
		
		publisherLabel = new JLabel("出版社");
		publisherLabel.setForeground(Color.WHITE);
		publisherLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		publisherLabel.setBounds(29, 520, 103, 43);
		contentPane.add(publisherLabel);
		
		
		idBook_showLabel = new JLabel();
		idBook_showLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		idBook_showLabel.setForeground(Color.WHITE);
		idBook_showLabel.setBounds(307, 112, 117, 37);
		contentPane.add(idBook_showLabel);
		idBook_showLabel.setText(all_BookFrame.bookJtable.getValueAt(all_BookFrame.row, 0).toString());
		
		nameBooktextField = new JTextField();
		nameBooktextField.setFont(new Font("宋体", Font.PLAIN, 30));
		nameBooktextField.setBounds(307, 191, 113, 37);
		contentPane.add(nameBooktextField);
		nameBooktextField.setColumns(10);
		nameBooktextField.setText(all_BookFrame.bookJtable.getValueAt(all_BookFrame.row, 1).toString());
		
		priceField = new JTextField();
		priceField.setFont(new Font("宋体", Font.PLAIN, 30));
		priceField.setBounds(307, 256, 117, 39);
		contentPane.add(priceField);
		priceField.setColumns(10);
		priceField.setText(all_BookFrame.bookJtable.getValueAt(all_BookFrame.row, 2).toString());
		
		typetextField = new JTextField();
		typetextField.setFont(new Font("宋体", Font.PLAIN, 30));
		typetextField.setBounds(307, 336, 117, 37);
		contentPane.add(typetextField);
		typetextField.setColumns(10);
		typetextField.setText(all_BookFrame.bookJtable.getValueAt(all_BookFrame.row, 3).toString());
		
		authortextField = new JTextField();
		authortextField.setFont(new Font("宋体", Font.PLAIN, 25));
		authortextField.setBounds(137, 426, 127, 39);
		contentPane.add(authortextField);
		authortextField.setColumns(10);
		authortextField.setText(all_BookFrame.bookJtable.getValueAt(all_BookFrame.row, 4).toString());
		
		publishertextField = new JTextField();
		publishertextField.setFont(new Font("宋体", Font.PLAIN, 20));
		publishertextField.setBounds(137, 518, 127, 45);
		contentPane.add(publishertextField);
		publishertextField.setColumns(10);
		publishertextField.setText(all_BookFrame.bookJtable.getValueAt(all_BookFrame.row, 5).toString());
		
		updateButton = new JButton(new ImageIcon("image/update.jpg"));
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_updateButton_UpdateBook();
			}
		});
		updateButton.setBounds(209, 602, 106, 37);
		contentPane.add(updateButton);
		
		authorWorkplaceLabel = new JLabel("作者单位");
		authorWorkplaceLabel.setForeground(Color.WHITE);
		authorWorkplaceLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		authorWorkplaceLabel.setBounds(287, 428, 127, 34);
		contentPane.add(authorWorkplaceLabel);
		
		publisherAddressLabel = new JLabel("出版社地址");
		publisherAddressLabel.setForeground(Color.WHITE);
		publisherAddressLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		publisherAddressLabel.setBounds(274, 520, 150, 43);
		contentPane.add(publisherAddressLabel);
		
		authorWorkplaceField = new JTextField();
		authorWorkplaceField.setFont(new Font("宋体", Font.PLAIN, 25));
		authorWorkplaceField.setBounds(442, 426, 145, 39);
		contentPane.add(authorWorkplaceField);
		authorWorkplaceField.setColumns(10);
		authorWorkplaceField.setText(all_BookFrame.bookJtable.getValueAt(all_BookFrame.row, 6).toString());
		
		publisherAddressField = new JTextField();
		publisherAddressField.setFont(new Font("宋体", Font.PLAIN, 20));
		publisherAddressField.setBounds(442, 518, 145, 45);
		contentPane.add(publisherAddressField);
		publisherAddressField.setColumns(10);
		publisherAddressField.setText(all_BookFrame.bookJtable.getValueAt(all_BookFrame.row, 7).toString());

		JLabel background = new JLabel(new ImageIcon("image/updatebackground.jpg"));
		background.setBounds(0, 0, 602, 703);
		contentPane.add(background);
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

		BookTools bookTools = new BookTools();
		Book book = new Book();
		
		Author author = new Author();
		AuthorTools authorTools = new AuthorTools();
		
		Publisher publisher= new Publisher();
		PublisherTools publisherTools = new PublisherTools();
		
		if ( idBook_showLabel.getText() != null && !"".equals(idBook_showLabel.getText()) 
				&& nameBooktextField.getText() != null && !"".equals(nameBooktextField.getText())
				&& priceField.getText() != null && !"".equals(priceField.getText())
				&& typetextField.getText() != null && !"".equals(typetextField.getText())
				&& authortextField.getText() != null && !"".equals(authortextField.getText())
				&& publishertextField.getText() != null && !"".equals(publishertextField.getText())
				&& authorWorkplaceField.getText()!= null && !"".equals(authorWorkplaceField.getText())
				&& publisherAddressField.getText() != null && !"".equals(publisherAddressField.getText())) {
			book.setIdBook(idBook_showLabel.getText());
			book.setNameBook(nameBooktextField.getText());
			book.setPrice(Integer.parseInt(priceField.getText()));
			book.setType(typetextField.getText());
			book.setAuthor(authortextField.getText());
			book.setPublisher(publishertextField.getText());
			author.setName(authortextField.getText());
			author.setWorkplace(authorWorkplaceField.getText());
			publisher.setName(publishertextField.getText());
			publisher.setAddress(publisherAddressField.getText());
			
			//下面这四个句子是尝试更新，插入出版商和作者的信息
			//由于四个句子都执行了，所以产生的结果是：“有信息就改掉，没信息就插入”
			
			publisherTools.UpdatePublisher(publisher);
			publisherTools.AddPublisher(publisher);				
			authorTools.UpdateAuthor(author);
			authorTools.AddAuthor(author);
			
			int i = bookTools.UpdateBook(book);
			if ( i == 1) {
	            JOptionPane.showMessageDialog(getContentPane(), "成功更新图书信息！", "", JOptionPane.WARNING_MESSAGE);
	            return;
			} else {
	            JOptionPane.showMessageDialog(getContentPane(), "更新图书信息失败！", "", JOptionPane.WARNING_MESSAGE);
	            return;
			}
		} else {
            JOptionPane.showMessageDialog(getContentPane(), "请输入完整资料", "", JOptionPane.WARNING_MESSAGE);
            return;
		}
	}
	public void CloseFrame(){
	    super.dispose();
	} 
}
