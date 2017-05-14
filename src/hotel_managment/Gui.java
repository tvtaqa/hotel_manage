package hotel_managment;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;

 
 //主类
public class Gui extends JFrame {
	static JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	public JButton btnNewButton;
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
		setBackground(new Color(51, 204, 204));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 726, 497);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUser = new JLabel("user:");
		lblUser.setBounds(216, 185, 72, 18);
		contentPane.add(lblUser);
		textField = new JTextField();
		textField.setBounds(298, 182, 138, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("password:");
		lblPassword.setBounds(216, 235, 72, 18);
		contentPane.add(lblPassword);
		
		 btnNewButton = new JButton("sign in");
		btnNewButton.setBounds(298, 286, 113, 27);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(298, 232, 138, 24);
		contentPane.add(passwordField);
		
		JLabel label = new JLabel("\u9152\u5E97\u7BA1\u7406\u7CFB\u7EDF");
		label.setForeground(Color.DARK_GRAY);
		label.setFont(new Font("宋体", Font.PLAIN, 30));
		label.setBounds(273, 84, 256, 88);
		contentPane.add(label);
		
		
	}
	//注册监听器的方法
	void setSignListener()
		{
			/*
			 * 匿名类
			 */
			Signinlistener listener = new Signinlistener()
			{
				final String user1="1551426";//正确的用户名
				final String password1="123";//正确的密码
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
		}
	
}

