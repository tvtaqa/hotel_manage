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

 
 //����
public class Gui extends JFrame {
	static JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	public JButton btnNewButton;
	Signinlistener listener;//ActionListener���ӽӿڣ�Signinlistener����listener����

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
					frame.setVisible(true);
					frame.setSignListener();//���÷���������ťע��Ϊ������
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame.
	 */
	
	//����Ĺ��캯������ʼ�����棩
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
		label.setFont(new Font("����", Font.PLAIN, 30));
		label.setBounds(273, 84, 256, 88);
		contentPane.add(label);
		
		
	}
	//ע��������ķ���
	void setSignListener()
		{
			/*
			 * ������
			 */
			Signinlistener listener = new Signinlistener()
			{
				final String user1="1551426";//��ȷ���û���
				final String password1="123";//��ȷ������
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
					String inputuser=user.getText();//inputuser�õ�user�ı��������
					String inputpassword=password.getText();//inputpassword�õ�password�ı��������
					System.out.println(inputuser+"\n"+inputpassword);
					if(inputuser.equals(user1))
					{
						if(inputpassword.equals(password1))
						{
							System.out.println("�ɹ���¼");
							contentPane.removeAll();
							contentPane.repaint();  
						}
						
						else
						{
							JOptionPane.showMessageDialog(null,"�������","Warnning!",JOptionPane.WARNING_MESSAGE);
							password.setText(null);	
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null,"�˻����������","Warnning!",JOptionPane.WARNING_MESSAGE);
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

