package frame;

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
import java.awt.Color;
import java.awt.Font;

public class Reader_UpdateFrame extends JFrame {

	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTextField nameReadertextField;
	private JTextField typetextField;
	private JTextField sextextField;
	private JTextField passwordtextField;	

	private JLabel idReader_showLabel;
	private JLabel idReaderLabel;
	private JLabel nameReaderLabel;
	private JLabel typeLabel;
	private JLabel sexLabel;
	private JLabel passwordLabel;
	private JButton updateButton;
	
	/**
	 * Create the frame.
	 */
	public Reader_UpdateFrame(All_ReaderFrame all_readerFrame) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 937, 663);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		idReaderLabel = new JLabel("借阅证号");
		idReaderLabel.setForeground(Color.WHITE);
		idReaderLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		idReaderLabel.setBounds(258, 79, 148, 38);
		contentPane.add(idReaderLabel);
		
		nameReaderLabel = new JLabel("姓名");
		nameReaderLabel.setForeground(Color.WHITE);
		nameReaderLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		nameReaderLabel.setBounds(283, 162, 91, 29);
		contentPane.add(nameReaderLabel);
		
		typeLabel = new JLabel("职位");
		typeLabel.setForeground(Color.WHITE);
		typeLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		typeLabel.setBounds(283, 232, 81, 38);
		contentPane.add(typeLabel);
		
		sexLabel = new JLabel("性别");
		sexLabel.setForeground(Color.WHITE);
		sexLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		sexLabel.setBounds(283, 319, 81, 38);
		contentPane.add(sexLabel);
		
		passwordLabel = new JLabel("登录密码");
		passwordLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setBounds(258, 393, 130, 48);
		contentPane.add(passwordLabel);
		
		idReader_showLabel = new JLabel();
		idReader_showLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		idReader_showLabel.setForeground(Color.WHITE);
		idReader_showLabel.setBounds(467, 79, 156, 38);
		contentPane.add(idReader_showLabel);
		idReader_showLabel.setText(all_readerFrame.readerJtable.getValueAt(all_readerFrame.row, 0).toString());
		
		nameReadertextField = new JTextField();
		nameReadertextField.setFont(new Font("宋体", Font.PLAIN, 30));
		nameReadertextField.setBounds(467, 162, 156, 38);
		contentPane.add(nameReadertextField);
		nameReadertextField.setColumns(10);
		nameReadertextField.setText(all_readerFrame.readerJtable.getValueAt(all_readerFrame.row, 1).toString());
		
		typetextField = new JTextField();
		typetextField.setFont(new Font("宋体", Font.PLAIN, 30));
		typetextField.setBounds(467, 232, 156, 48);
		contentPane.add(typetextField);
		typetextField.setColumns(10);
		typetextField.setText(all_readerFrame.readerJtable.getValueAt(all_readerFrame.row, 2).toString());
		
		sextextField = new JTextField();
		sextextField.setFont(new Font("宋体", Font.PLAIN, 30));
		sextextField.setBounds(467, 315, 156, 48);
		contentPane.add(sextextField);
		sextextField.setColumns(10);
		sextextField.setText(all_readerFrame.readerJtable.getValueAt(all_readerFrame.row, 3).toString());
		
		passwordtextField = new JTextField();
		passwordtextField.setFont(new Font("宋体", Font.PLAIN, 30));
		passwordtextField.setBounds(467, 394, 161, 48);
		contentPane.add(passwordtextField);
		passwordtextField.setColumns(10);
		passwordtextField.setText(all_readerFrame.readerJtable.getValueAt(all_readerFrame.row, 4).toString());
		
		updateButton = new JButton(new ImageIcon("image/update.jpg"));
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_updateButton_UpdateReader();
			}
		});
		updateButton.setBounds(376, 498, 106, 37);
		contentPane.add(updateButton);
		
		JLabel background = new JLabel(new ImageIcon("image/updateReaderbackground.jpg"));
		background.setBounds(0, 0, 931, 623);
		contentPane.add(background);
		
	}

	/**
	 * @return 进行更新读者的操作
	 * @param Reader 读者的数据模型
	 * @param ReaderTools 数据库操作“读者数据模型”的类
	 */
	protected void do_updateButton_UpdateReader() {

		ReaderTools readerTools = new ReaderTools();
		Reader reader = new Reader();
		
		if ( idReader_showLabel.getText() != null && !"".equals(idReader_showLabel.getText()) 
				&& nameReadertextField.getText() != null && !"".equals(nameReadertextField.getText())
				&& typetextField.getText() != null && !"".equals(typetextField.getText())
				&& sextextField.getText() != null && !"".equals(sextextField.getText())
				&& passwordtextField.getText() != null && !"".equals(passwordtextField.getText()) ) {
			reader.setIdReader(idReader_showLabel.getText());
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
