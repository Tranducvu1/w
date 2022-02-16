package Controller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Model.ConnectDB3;
import Model.ConnectDB;
import Model.ConnectDB1;
public class lanlords extends JFrame{
	ImageIcon iconnew = new ImageIcon("E:\\icon\\new-icon-16.png");
	ImageIcon iconsave = new ImageIcon("E:\\\\icon\\\\Save-icon.png");
	ImageIcon iconcn = new ImageIcon("E:\\\\\\\\icon\\\\\\\\search-icon-16.png");
	ImageIcon iconxoa = new ImageIcon("E:\\icon\\Actions-edit-delete-icon-16.png");
	ImageIcon iconmo = new ImageIcon("E:\\\\icon\\\\open-file-icon-16.png");
	ImageIcon iconback = new ImageIcon("E:\\icon\\logout-icon-16.png");
	ImageIcon iconc = new ImageIcon("E:\\\\icon\\\\Fast-backward-icon-48.png");
	ImageIcon iconu = new ImageIcon("E:\\\\icon\\\\Actions-view-choose-icon-24.png");
	JFrame f4 = new JFrame("Information Landlords");
	JLabel lb =new JLabel();
	JLabel lbCMll = new JLabel(" IDLandlord");
	JTextField tfCMll = new JTextField(10);
	JLabel lbnamell = new JLabel("Full Name");
	JTextField tfnamell = new JTextField(10);
	JLabel lbaddressll = new JLabel("Address");
	JTextField tfaddressll = new JTextField(10);
	JLabel lbbirthdayll = new JLabel ("Birthday");
	JDateChooser dcbirthdayll = new JDateChooser();
	JLabel lbsdt = new JLabel("Phone Number");
	JTextField tfsdt = new JTextField(15);
//	JLabel lbll = new JLabel(" IDLandlord");
//	JTextField tfll = new JTextField(10);
	JButton btadd = new JButton ("Add",iconsave);
	JButton btdelete = new JButton ("Delete",iconxoa);
	JButton btnew = new JButton ("New",iconnew);
	JButton btupdate = new JButton ("Update",iconu);
	JButton btfind = new JButton ("Find",iconcn);
	JButton btSee = new JButton ("See",iconmo);
	JButton btcancel = new JButton ("Cancel",iconc);
	JLabel lbIDHouse = new JLabel("IDHouse");	
	JTextField tfIDHouse = new JTextField(15);
	JButton btback = new JButton("Back",iconback);
	PreparedStatement ps;
	Connection conn;
	ResultSet rs;
	JTable tbland = new JTable();
	JScrollPane sp = new JScrollPane(tbland);
	public lanlords() {
		jframelandlords();
		buttonlandlord();
		tbland.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				int row = tbland.getSelectedRow();
				tfCMll.setText((String)tbland.getValueAt(row, 0));
				tfnamell.setText((String)tbland.getValueAt(row, 1));
				tfaddressll.setText((String)tbland.getValueAt(row, 2));
				((JTextField)dcbirthdayll.getDateEditor().getUiComponent()).setText(tbland.getValueAt(row,3).toString());
				tfsdt.setText((String)tbland.getValueAt(row, 4));
				tfIDHouse.setText((String)tbland.getValueAt(row, 5));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	
	}
	
	public void jframelandlords() {
		JPanel pncmnd = new JPanel();
		pncmnd.add(lbCMll);
		pncmnd.add(tfCMll);
		lbCMll.setForeground(Color.BLUE);
		pncmnd.setLayout(new GridLayout(1,2));
		
		JPanel pnnamell = new JPanel();
		pnnamell.add(lbnamell);
		pnnamell.add(tfnamell);
		lbnamell.setForeground(Color.BLUE);
		pnnamell.setLayout(new GridLayout(1,2));
		
		JPanel pnaddress = new JPanel();
		pnaddress.add(lbaddressll);
		pnaddress.add(tfaddressll);
		lbaddressll.setForeground(Color.BLUE);
		pnaddress.setLayout(new GridLayout(1,2));
		
		JPanel pnemail = new JPanel();
		pnemail.add(lbIDHouse);
		pnemail.add(tfIDHouse);
		lbIDHouse.setForeground(Color.BLUE);
		pnemail.setLayout(new GridLayout(1,2));
		
		JPanel pnbirthdayl = new JPanel();
		pnbirthdayl.add(lbbirthdayll);
		pnbirthdayl.add(dcbirthdayll);
		lbbirthdayll.setForeground(Color.BLUE);
		pnbirthdayl.setLayout(new GridLayout(1,2));
		
		JPanel pnsdt = new JPanel();
		pnsdt.add(lbsdt);
		pnsdt.add(tfsdt);
		lbsdt.setForeground(Color.BLUE);
		pnsdt.setLayout(new GridLayout(1,2));
		
		JPanel pnbt = new JPanel();
		pnbt.add(btadd);
		pnbt.add(btupdate);
		pnbt.add(btdelete);
		pnbt.add(btfind);
		pnbt.add(btnew);
		pnbt.add(btSee);
		pnbt.add(btcancel);
		pnbt.add(btback);
		
		btfind.setBackground(Color.LIGHT_GRAY);
		btupdate.setBackground(Color.LIGHT_GRAY);
		btSee.setBackground(Color.LIGHT_GRAY);
		btnew.setBackground(Color.LIGHT_GRAY);
		btdelete.setBackground(Color.LIGHT_GRAY);
		btadd.setBackground(Color.LIGHT_GRAY);
		btcancel.setBackground(Color.LIGHT_GRAY);
		btback.setBackground(Color.LIGHT_GRAY);
		pnbt.setLayout(new GridLayout(2,4));
		
		JPanel pnall = new JPanel();
		pnall.add(pncmnd);
		pnall.add(pnnamell);
		pnall.add(pnaddress);
		pnall.add(pnbirthdayl);
		pnall.add(pnsdt);
		pnall.add(pnemail);
		pnall.setLayout(new GridLayout(6,1));
		Border bdpnall = BorderFactory.createLineBorder(Color.CYAN);
		TitledBorder tbdpnall= BorderFactory.createTitledBorder(bdpnall, "Landlords");
		pnall.setBorder(tbdpnall);
		pnall.setBackground(Color.WHITE);
		
		JPanel pntable = new JPanel();
		Border bd = BorderFactory.createLineBorder(Color.CYAN);
		TitledBorder tbdcus= BorderFactory.createTitledBorder(bd, "Landlords");
		pntable.setBorder(tbdcus);
		pntable.add(sp);
		pntable.setBackground(Color.WHITE);
		f4.setLocation(200,100);
		
		Container cont4 = f4.getContentPane();
		cont4.add(pnall, BorderLayout.CENTER);
		cont4.add(pntable, BorderLayout.EAST);
		cont4.add(pnbt, BorderLayout.SOUTH);
		f4.pack();
		f4.setSize(900,500);
		f4.setVisible(true);
		DisplayLandlords();
	}
	public void buttonlandlord() {
		btnew.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new lanlords();
				f4.dispose();
			}
		});
		btadd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ConnectDB3 cn =new ConnectDB3();
				ConnectDB1 cn1 = new ConnectDB1();
				 SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
				 try {
				 Date selectedDate = (Date) dcbirthdayll.getDate();
					java.sql.Date Birthday = convertUtilToSql(selectedDate);
					//ResultSet rs = cn1.ListHouse("Select * from informationhouse1 where IDHouse = '"+tfIDHouse.getText()+"' and MemberMax = Member");
				
					int record3 = cn.executeDB3("Insert into landlords1 values('"+tfCMll.getText()+"','"+tfnamell.getText()+"','"+tfaddressll.getText()+"','"+Birthday+"','"+tfsdt.getText()+"','"+tfIDHouse.getText()+"')");
					
					if (record3>0) JOptionPane.showMessageDialog(null, "Insert Success");
				 }catch(Exception e1) {
					 e1.printStackTrace();
				 }
					DisplayLandlords();
				
			}

			private java.sql.Date convertUtilToSql(Date selectedDate) {
				// TODO Auto-generated method stub
				java.sql.Date sDate = new java.sql.Date(selectedDate.getTime());
		        return sDate;
			}
		});
		btdelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ConnectDB3 cn = new ConnectDB3();
				try {
					int record3 = cn.executeDB3("Delete from landlords1 where IDlandlords = '"+tfCMll.getText()+"' or "
							+ "FullName = '"+tfnamell+"' or PhoneNumber = '"+tfsdt.getText()+"' or IDHouse = '"+tfIDHouse.getText()+"'");
					if (record3>0) JOptionPane.showMessageDialog(null, "Delete Success");
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				DisplayLandlords();
			}
		});
		btupdate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ConnectDB3 cn = new ConnectDB3();
				try {
					if(tfnamell.getText().length() !=0) {
						int record3 = cn.executeDB3("Update landlords1 set FullName = '"+tfnamell.getText()+"' where IDlandlords = '"+tfCMll.getText()+"'");
						if (record3>0) ;
						else JOptionPane.showMessageDialog(null, "Failed");
					}
					if(tfaddressll.getText().length()!=0) {
						int record3 = cn.executeDB3("Update landlords1 set Address = '"+tfaddressll.getText()+"' where IDlandlords = '"+tfCMll.getText()+"'");
						if (record3>0) ;
						else JOptionPane.showMessageDialog(null, "Failed");
					}
					if(tfIDHouse.getText().length()!=0) {
						int record3 = cn.executeDB3("Update landlords1 set IDHouse = '"+tfIDHouse.getText()+"' where IDlandlords = '"+tfCMll.getText()+"'");
						if (record3>0) ;
						else JOptionPane.showMessageDialog(null, "Failed");
					}
					if (tfsdt.getText().length()!=0) {
						int record3 = cn.executeDB3("Update landlords1 set PhoneNumber = '"+tfsdt.getText()+"' where IDlandlords = '"+tfCMll.getText()+"'");
						if (record3>0) ;
						else JOptionPane.showMessageDialog(null, "Failed");
					}
					if(((JTextField)dcbirthdayll.getDateEditor().getUiComponent()).getText().length()!=0) {
						int record3 = cn.executeDB3("Update landlords1 set Birthday = '"+((JTextField)dcbirthdayll.getDateEditor().getUiComponent()).getText()+"' where IDlandlords = '"+tfCMll.getText()+"'");
						if (record3>0) ;
						else JOptionPane.showMessageDialog(null, "Failed");
					}
					}catch(Exception e2) {
					e2.printStackTrace();
				}
				DisplayLandlords();
			}
		});
		btfind.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				DisplayLandlordsfind();
			}
		});
		btSee.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				jtable1();
				f4.dispose();
			}
		});
		btcancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//xem dữ liệu
				f4.dispose();
			}
		});
		btback.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new choose();
				f4.dispose();
			}
		});
		
	}
	public void DisplayLandlords() {
		ConnectDB3 conn = new ConnectDB3();
	// trong sql thì phải dùng DefaultTableModel nếu k sẽ bị trùng dữ liệu
		rs=conn.ListLanlords("Select * from landlords1");
		String column[] = {"IDLandLords", "Full Name","Address","Birthday","Phone Number","IDHouse"};
        DefaultTableModel tm = new DefaultTableModel (column, 0);
        try {
			while (rs.next()) {
				Object data[]= {rs.getString("IDLandlords"), rs.getString("FullName"),rs.getString("Address"),rs.getString("Birthday"),rs.getString("PhoneNumber"),rs.getString("IDHouse")};    
				
				
				tm.addRow(data);
			
			}
			tbland.setModel(tm);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void DisplayLandlordsfind() {
		ConnectDB3 conn = new ConnectDB3();
	// trong sql thì phải dùng DefaultTableModel nếu k sẽ bị trùng dữ liệu
		rs=conn.ListLanlords("Select * from landlords1 where IDLandlords = '"+tfCMll.getText()+"'"
				+ "or FullName = '"+tfnamell.getText()+"' or Address = '"+tfaddressll.getText()+"'"
						+ "or PhoneNumber = '"+tfsdt.getText()+"' or IDHouse = '"+tfIDHouse.getText()+"'");
		String column[] = {"IDLandLords", "Full Name","Address","Birthday","Phone Number","IDHouse"};
        DefaultTableModel tm = new DefaultTableModel (column, 0);
       
		
        try {
			while (rs.next()) {
				Object data[]= {rs.getString("IDlandlords"), rs.getString("FullName"),rs.getString("Address"),rs.getString("Birthday")
						,rs.getString("PhoneNumber"),rs.getString("IDHouse")};    
				tm.addRow(data);
			}
			tbland.setModel(tm);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void jtable1() {
		JFrame ftb = new JFrame();
		JTable tblandlord = new JTable();
		JScrollPane lanlord = new JScrollPane(tblandlord);
		JButton btback = new JButton("Back");
		JButton btcancel = new JButton("Cancel");
		ftb.setLocation(200,100);
		
		JPanel pntb = new JPanel();
		lanlord.setPreferredSize(new Dimension(850, 450));
		Border bd2 = BorderFactory.createLineBorder(Color.CYAN);
		TitledBorder tbdll= BorderFactory.createTitledBorder(bd2, "Landlords");
		pntb.setBorder(tbdll);
		pntb.add(lanlord);
		
		btback.setForeground(Color.BLUE);
		btcancel.setForeground(Color.BLUE);
		btback.setBackground(Color.PINK);
		btcancel.setBackground(Color.PINK);
		JPanel pnbt = new JPanel();
		pnbt.add(btback);
		pnbt.add(btcancel);
		Container conttb = ftb.getContentPane();
		conttb.add(pntb);
		conttb.add(pnbt, BorderLayout.SOUTH);
		ftb.setSize(900,500);
		ftb.setVisible(true);
		btback.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new lanlords();
				ftb.dispose();
			}
		});
		btcancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				ftb.dispose();
			}
		});
		ConnectDB3 con = new ConnectDB3();
		// trong sql thì phải dùng DefaultTableModel nếu k sẽ bị trùng dữ liệu
			rs=con.ListLanlords("Select * from landlords1");
			String column[] = {"IDLandLords", "Full Name","Address","Birthday","Phone Number","IDHouse"};
	        DefaultTableModel tm = new DefaultTableModel (column, 0);
	        try {
				while (rs.next()) {
					Object data[]= {rs.getString("IDlandlords"), rs.getString("FullName"),rs.getString("Address"),rs.getString("Birthday")
							,rs.getString("PhoneNumber"),rs.getString("IDHouse")};    
					
					
					tm.addRow(data);
				
				}
				tblandlord.setModel(tm);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}