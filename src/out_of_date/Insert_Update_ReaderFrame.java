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

import model.Reader;
import sqlTools.ReaderTools;

public class Insert_Update_ReaderFrame extends JFrame {

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
	private JButton updateButton;
/*	*//**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insert_Update_ReaderFrame frame = new Insert_Update_ReaderFrame();
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
	public Insert_Update_ReaderFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		idReaderLabel = new JLabel("借阅证号");
		idReaderLabel.setBounds(123, 93, 81, 21);
		contentPane.add(idReaderLabel);
		
		nameReaderLabel = new JLabel("姓名");
		nameReaderLabel.setBounds(123, 140, 81, 21);
		contentPane.add(nameReaderLabel);
		
		typeLabel = new JLabel("职位");
		typeLabel.setBounds(123, 185, 81, 21);
		contentPane.add(typeLabel);
		
		sexLabel = new JLabel("性别");
		sexLabel.setBounds(123, 231, 81, 21);
		contentPane.add(sexLabel);
		
		passwordLabel = new JLabel("登录密码");
		passwordLabel.setBounds(123, 289, 81, 21);
		contentPane.add(passwordLabel);
		
		idReadertextField = new JTextField();
		idReadertextField.setBounds(292, 90, 96, 27);
		contentPane.add(idReadertextField);
		idReadertextField.setColumns(10);
		
		nameReadertextField = new JTextField();
		nameReadertextField.setBounds(292, 137, 96, 27);
		contentPane.add(nameReadertextField);
		nameReadertextField.setColumns(10);
		
		typetextField = new JTextField();
		typetextField.setBounds(292, 182, 96, 27);
		contentPane.add(typetextField);
		typetextField.setColumns(10);
		
		sextextField = new JTextField();
		sextextField.setBounds(292, 228, 96, 27);
		contentPane.add(sextextField);
		sextextField.setColumns(10);
		
		passwordtextField = new JTextField();
		passwordtextField.setBounds(292, 286, 96, 27);
		contentPane.add(passwordtextField);
		passwordtextField.setColumns(10);
		
		insertButton = new JButton("新增");
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_insertButton_AddReader();
			}
		});
		insertButton.setBounds(82, 373, 106, 37);
		contentPane.add(insertButton);
		
		updateButton = new JButton("更新");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_updateButton_UpdateReader();
			}
		});
		updateButton.setBounds(271, 373, 106, 37);
		contentPane.add(updateButton);
	}

	/**
	 * @return 进行增加读者的操作
	 * @param Reader 读者的数据模型
	 * @param ReaderTools 数据库操作“读者数据模型”的类
	 */
	protected void do_insertButton_AddReader() {
		// TODO Auto-generated method stub
		ReaderTools readerTools = new ReaderTools();
		Reader reader = new Reader();
		
		if ( idReadertextField.getText() != null && !"".equals(idReadertextField.getText()) 
				&& nameReadertextField.getText() != null && !"".equals(nameReadertextField.getText())
				&& typetextField.getText() != null && !"".equals(typetextField.getText())
				&& sextextField.getText() != null && !"".equals(sextextField.getText())
				&& passwordtextField.getText() != null && !"".equals(passwordtextField.getText()) ) {
			reader.setIdReader(idReadertextField.getText());
			reader.setNameReader(nameReadertextField.getText());
			reader.setType(typetextField.getText());
			reader.setSex(sextextField.getText());
			reader.setPassword(passwordtextField.getText());
			int i = readerTools.AddReader(reader);
			if ( i == 1 ) {
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

	/**
	 * @return 进行更新读者的操作
	 * @param Reader 读者的数据模型
	 * @param ReaderTools 数据库操作“读者数据模型”的类
	 */
	protected void do_updateButton_UpdateReader() {
		// TODO Auto-generated method stub
		ReaderTools readerTools = new ReaderTools();
		Reader reader = new Reader();
		
		if ( idReadertextField.getText() != null && !"".equals(idReadertextField.getText()) 
				&& nameReadertextField.getText() != null && !"".equals(nameReadertextField.getText())
				&& typetextField.getText() != null && !"".equals(typetextField.getText())
				&& sextextField.getText() != null && !"".equals(sextextField.getText())
				&& passwordtextField.getText() != null && !"".equals(passwordtextField.getText()) ) {
			reader.setIdReader(idReadertextField.getText());
			reader.setNameReader(nameReadertextField.getText());
			reader.setType(typetextField.getText());
			reader.setSex(sextextField.getText());
			reader.setPassword(passwordtextField.getText());
			int i = readerTools.UpdateReader(reader);
			if ( i == 1 ) {
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
}
