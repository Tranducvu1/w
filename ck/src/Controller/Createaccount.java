package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class Createaccount extends JFrame{
	JFrame fcus= new JFrame("Sign Up for Customer");
	JLabel lbsignup = new JLabel("Sign Up");
	JLabel lb = new JLabel();
	JLabel lbusernamecus = new JLabel("Username ");
	JTextField tfusernamecus = new JTextField(15);
	JLabel lbpasswordcus = new JLabel("Password ");
	JTextField tfpasswordcus = new JTextField(15);
	JButton btforget = new JButton("Forgotten Password");
	JButton btsignup = new JButton("Sign Up");
	JButton btcreateacA = new JButton("Create Account");
	JButton btcancel = new JButton("Cancel");
	public Createaccount() {
		fcus.setLocation(300,20);
		fcus.setLayout(new GridLayout(5,2));
		Container contc = fcus.getContentPane();
		contc.add(lbsignup);
		contc.add(lb);
		contc.add(lbusernamecus);
		contc.add(tfusernamecus);
		contc.add(lbpasswordcus);
		contc.add(tfpasswordcus);
		contc.add(btforget);
		contc.add(btsignup);
		contc.add(btcreateacA);
		contc.add(btcancel);
	
		fcus.setSize(400,200);
		fcus.setVisible(true);
		btcancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				fcus.dispose();
			}
		});
		btsignup.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new SignUp();
				fcus.dispose();
			}
		});
		btcreateacA.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new Createaccount();
				fcus.dispose();
				
			}
		});
		btforget.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new forgotpass();
				fcus.dispose();
				
			}
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new Createaccount();
	}

}

