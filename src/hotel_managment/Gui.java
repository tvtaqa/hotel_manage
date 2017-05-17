package hotel_managment;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

 
 //主类
public class Gui extends JFrame {
	static JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	public JButton btnNewButton;
	public JTable table;
	Signinlistener listener;//ActionListener的子接口（Signinlistener）的listener对象

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
					frame.setVisible(true);
					frame.setSignListener();//调用方法，将按钮注册为监视器
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	//主类的构造函数（初始化界面）
	public Gui() {
		setTitle("Hotel Management");
		setBackground(new Color(51, 204, 204));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 897, 589);
		contentPane = new JPanel(){
            
           private static final long serialVersionUID = 1L;

           @Override
           protected void paintComponent(Graphics g) {
        	   super.paintComponent(g);
        	   ImageIcon icon = new ImageIcon("E:\\1.jpg");
        	   g.drawImage(icon.getImage(), 0, 0, null);
        	   }  
       };
		contentPane.setBackground(new Color(0, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUser = new JLabel("user:");
		lblUser.setBounds(337, 185, 72, 18);
		contentPane.add(lblUser);
		textField = new JTextField();
		textField.setBounds(403, 182, 138, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("password:");
		lblPassword.setBounds(317, 245, 72, 18);
		contentPane.add(lblPassword);
		
		 btnNewButton = new JButton("sign in");
		btnNewButton.setBounds(403, 309, 113, 27);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(403, 242, 138, 24);
		contentPane.add(passwordField);
		
		JLabel lblHotelManagementSystem = new JLabel("Hotel Management System");
		lblHotelManagementSystem.setForeground(Color.DARK_GRAY);
		lblHotelManagementSystem.setFont(new Font("宋体", Font.PLAIN, 30));
		lblHotelManagementSystem.setBounds(283, 28, 371, 118);
		contentPane.add(lblHotelManagementSystem);	
	}
	//注册监听器的方法
	void setSignListener()
		{
			Signinlistener listener = new Signinlistener()        //匿名类
			{
				final String user1="1551426";                     //正确的用户名
				final String password1="123";                     //正确的密码
				JTextField user;
				JPasswordField  password;
				
				public void setUserField(JTextField a)
				{
					user=a;
				}
				public void setPasswordField(JPasswordField  b)
				{
					password=b;
				}
				public void actionPerformed(ActionEvent e)
				{
					String inputuser=user.getText();//inputuser得到user文本框的内容
					String inputpassword=password.getText();//inputpassword得到password文本框的内容
					System.out.println(inputuser+"\n"+inputpassword);
					if(inputuser.equals(user1))
					{
						if(inputpassword.equals(password1))
						{
							System.out.println("成功登录");
							contentPane.removeAll();
							secondact();
							contentPane.repaint();  
						}
						
						else
						{
							JOptionPane.showMessageDialog(null,"密码错误！","Warnning!",JOptionPane.WARNING_MESSAGE);
							password.setText(null);	
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null,"账户和密码错误！","Warnning!",JOptionPane.WARNING_MESSAGE);
						password.setText(null);	
						user.setText(null);	
					}
					
				}
			};
			listener.setUserField(textField);
			listener.setPasswordField(passwordField);
			btnNewButton.addActionListener(listener);
			passwordField.addActionListener(listener);
		}
	
	void secondact()
	{
		JButton button = new JButton("\u767B\u8BB0\u5165\u4F4F");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBounds(514, 13, 100, 30);
		contentPane.add(button);
		
		JButton btnNewButton = new JButton("\u9000\u623F\u529E\u7406");
		btnNewButton.setBounds(753, 13, 100, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(266, 13, 100, 30);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(91, 10, 161, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCheckOut = new JLabel("check in:");
		lblCheckOut.setBounds(409, 16, 91, 24);
		contentPane.add(lblCheckOut);
		
		JLabel lblNewLabel = new JLabel("check out:");
		lblNewLabel.setBounds(648, 10, 91, 36);
		contentPane.add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(90, 84, 747, 447);
		contentPane.add(table);
		
		JLabel label = new JLabel("\u6240\u6709\u4FE1\u606F\uFF1A");
		label.setBounds(4, 84, 83, 24);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		label_1.setBounds(4, 13, 83, 30);
		contentPane.add(label_1);
		
		
		
	}
}



