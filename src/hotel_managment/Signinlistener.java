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
import javax.swing.JPasswordField;
import java.awt.Color;

//登录的子接口 继承ActionListener接口
public interface Signinlistener extends ActionListener{
	public void setUserField(JTextField user);
	public void setPasswordField(JPasswordField  password);
}
