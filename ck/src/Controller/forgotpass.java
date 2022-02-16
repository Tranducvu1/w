package Controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class forgotpass extends JFrame {
	JFrame f = new JFrame("Forgotten Password");
	JLabel lbforgotpass = new JLabel("Forgotten Password");
	JLabel lb1 = new JLabel();
	JLabel lbfind = new JLabel("Find your acount");
	JTextField tffind = new JTextField(10);//Nhap username
	JButton btcancel = new JButton("Cancel");
	JButton btsearch = new JButton("Search");
	//frame 2
	JFrame f2 = new JFrame();
	JLabel lbsendcode = new JLabel("Send code your email");
	JTextField tfemail = new JTextField(10);
	//kiem tra email do co phai cua username khong
	JButton btContinue = new JButton ("Continue");
	JButton btBack = new JButton ("Back");
	//frame 3
	JFrame f3 = new JFrame();
	JLabel lbEnter = new JLabel("Enter code");
	JTextField tfenter = new JTextField(10);
	JButton btCancel3 = new JButton("Cancel");
	JButton btContinue3 = new JButton("Continue");
	public forgotpass() {
		f.setLocation(250,250);
		f.setLayout(new GridLayout(3,2));
		Container con = f.getContentPane();
		con.add(lbforgotpass);
		con.add(lb1);
		con.add(lbfind);
		con.add(tffind);
		con.add(btcancel);
		con.add(btsearch);
		f.pack();
		f.setSize(500,200);
		f.setVisible(true);
		btsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jframe2();
				f.dispose();
			}
		});
		btcancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new forgotpass();
	}
	public void jframe2() {
		f2.setLocation(300,300);
		f2.setLayout(new GridLayout(2,2));
		Container con2 = f2.getContentPane();
		con2.add(lbsendcode);
		con2.add(tfemail);
		con2.add(btContinue);
		con2.add(btBack);
		f2.pack();
		f2.setSize(200,200);
		f2.setVisible(true);
		btContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				jframe3();
				f2.dispose();
			}
		});
		btBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				new forgotpass();
				f2.dispose();
			}
		});
	}
	public void jframe3() {
		f3.setLocation(400,400);
		f3.setLayout(new GridLayout(2,2));
		Container con3 = f3.getContentPane();
		con3.add(lbEnter);
		con3.add(tfenter);
		con3.add(btCancel3);
		con3.add(btContinue3);
		f3.pack();
		f3.setSize(300,200);
		f3.setVisible(true);
		btCancel3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				
				f3.dispose();
			}
		});
		btContinue3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				//kiem tra code xem co dung voi code gui ve khong
				new SignUp();
			
			f3.dispose();
			}
	
		});
	}
	
	
	

}