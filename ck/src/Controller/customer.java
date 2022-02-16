package Controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.MenuDragMouseEvent;
import javax.swing.table.DefaultTableModel;



import com.toedter.calendar.JDateChooser;

import Model.ConnectDB1;
import Model.ConnectDB2;

public class customer extends JFrame {
	ImageIcon iconxoa = new ImageIcon("E:\\icon\\Actions-edit-delete-icon-16.png");
	ImageIcon iconnew = new ImageIcon("E:\\icon\\new-icon-16.png");
	ImageIcon iconsave = new ImageIcon("E:\\\\icon\\\\Save-icon.png");
	ImageIcon iconcn = new ImageIcon("E:\\\\\\\\icon\\\\\\\\search-icon-16.png");
	ImageIcon iconmo = new ImageIcon("E:\\\\icon\\\\open-file-icon-16.png");
	ImageIcon iconback = new ImageIcon("E:\\icon\\logout-icon-16.png");
	ImageIcon iconc = new ImageIcon("E:\\\\icon\\\\Fast-backward-icon-48.png");
	ImageIcon iconu = new ImageIcon("E:\\\\icon\\\\Actions-view-choose-icon-24.png");
	JFrame f2 = new JFrame("Information Customers");
	JLabel lbcmnd = new JLabel("IDCustomer");
	JTextField tfcmnd = new JTextField(20);
	JLabel lbfullname = new JLabel("Full Name");
	JTextField tffullname = new JTextField(20);
	JLabel lbaddress = new JLabel("Home Town");
	String[] address = {"Home Town","An Giang", "Bà rịa – Vũng tàu", "Bắc Giang", "Bắc Kạn", "Bạc Liêu","Bắc Ninh", "	Bến Tre", "	Bình Định"
, "	Bình Dương", "	Bình Phước", "	Bình Thuận", "	Cà Mau", "	Cần Thơ", "	Cao Bằng ", "	Đà Nẵng", "Đắk Lắk"
, "Đắk Nông", "Điện Biên", "Đồng Nai", "Đồng Tháp", "Gia Lai", "Hà Giang", "Hà Nam", "Hà Nội \r\n", "Hà Tĩnh\r\n", "Hải Dương\r\n"
, "Hải Phòng\r\n", "Hậu Giang\r\n", "Hòa Bình\r\n", "Hưng Yên\r\n", "Khánh Hòa\r\n", "Kiên Giang\r\n", "Kon Tum\r\n"
, "Lai Châu\r\n", "Lâm Đồng\r\n", "Lạng Sơn\r\n", "Lào Cai\r\n", "Long An\r\n", "Nam Định\r\n", "Nghệ An\r\n"
, "Ninh Bình\r\n", "Ninh Thuận\r\n", "Phú Thọ\r\n", "Phú Yên\r\n", "Quảng Bình\r\n", "Quảng Nam\r\n", "Quảng Ngãi\r\n"
, "Quảng Ninh\r\n", "Quảng Trị\r\n", "Sóc Trăng\r\n", "Sơn La\r\n", "Tây Ninh\r\n", "Thái Bình\r\n", "Thái Nguyên\r\n"
, "Thanh Hóa\r\n", "Thừa Thiên Huế\r\n", "Tiền Giang\r\n", "Thành phố Hồ Chí Minh\r\n", "Trà Vinh\r\n", "Tuyên Quang\r\n"
, "Vĩnh Long\r\n", "Vĩnh Phúc\r\n", "Yên Bái"};
	JComboBox jcbaddress = new JComboBox(address);
	JLabel lbtimerent = new JLabel("Time Rental");
	JTextField tftimerent = new JTextField(20);
	JLabel lbtimestart = new JLabel("Time Start");
	JDateChooser cltimestart = new JDateChooser();
	JLabel lbbirthday = new JLabel ("Birthday");
	JDateChooser clbirthday = new JDateChooser();
	JLabel lbsdt = new JLabel("Phone Number");
	JTextField tfsdt = new JTextField(20);
	JLabel lbIDH = new JLabel("ID House");
	JTextField tfID = new JTextField(20); 
	JButton btadd = new JButton ("Add",iconsave);
	JButton btdelete = new JButton ("Delete",iconxoa);
	JButton btnew = new JButton ("Reset",iconnew);
	JButton btupdate = new JButton ("Update",iconu);
	JButton btfind = new JButton ("Find",iconcn);
	JButton btcancel = new JButton ("Cancel",iconc);
	JButton btback = new JButton("Back",iconback);
	JButton btsee = new JButton("See",iconmo);
	JLabel lbinfor = new JLabel("Information of Tenant");
	JLabel lbgender = new JLabel("Gender");
	JRadioButton rmale = new JRadioButton("Male");
	JRadioButton rfemale = new JRadioButton("Female");
	ButtonGroup bg = new ButtonGroup();
	
	
	JTable tbcus = new JTable();
	JScrollPane sp = new JScrollPane(tbcus);	
	
	PreparedStatement ps;
	Connection conn;
	ResultSet rs;
	
	public customer() {
		jframecustomer();
		jbuttoncustomer();
	
		tbcus.addMouseListener(new MouseListener(){


			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				int row = tbcus.getSelectedRow();
				tfcmnd.setText((String)tbcus.getValueAt(row, 0));
				tffullname.setText((String)tbcus.getValueAt(row, 1));
				((JTextField)clbirthday.getDateEditor().getUiComponent()).setText(tbcus.getValueAt(row, 2).toString());
				String Gender = ((String)tbcus.getValueAt(row, 3));
				if (Gender.equals("Female    ")) {
					rfemale.setSelected(true);
					rmale.setSelected(false);
					}
				else{
					rmale.setSelected(true);
					rfemale.setSelected(false);
				}
				String HomeTown = ((String)tbcus.getValueAt(row, 4));
				//System.out.print(cutSpace(HomeTown));
				
				tfsdt.setText((String)tbcus.getValueAt(row,5 ));
				tftimerent.setText((String)tbcus.getValueAt(row, 6));
				((JTextField)cltimestart.getDateEditor().getUiComponent()).setText(tbcus.getValueAt(row,7 ).toString());
				tfID.setText((String)tbcus.getValueAt(row, 0));
				//tfIDH.setText((String)tbcus.getValueAt(row, 9));
				//tfcmndland.setText((String)tbcus.getValueAt(row, 10));
				
			}

			

			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});	
	}
	public void DisplayCustomer()  {
		ConnectDB2 conn = new ConnectDB2();
		rs=conn.Listcustomer("Select * from customer");
		String column[] = {"IDcustomer", "FullName","Birthday","Gender","HomeTown","PhoneNumber","TimeRental","TimeStart","IDHouse"};	
	        DefaultTableModel tm = new DefaultTableModel (column, 0);
	        try {
				while (rs.next()) {
					Object data[]= {rs.getString("IDcustomer"), rs.getString("FullName"),rs.getString("Birthday"),rs.getString("Gender"),rs.getString("HomeTown"),rs.getString("PhoneNumber"),rs.getString("TimeRental"),rs.getString("TimeStart"),rs.getString("IDHouse")};
				tm.addRow(data);
					
				}
				tbcus.setModel(tm);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
	}
	public void Customerfind() {
		ConnectDB2 conn = new ConnectDB2();
		String HomeTown = jcbaddress.getSelectedItem().toString();
		rs=conn.Listcustomer("Select * from customer where FullName = '"+tffullname.getText()+"' or "
				+ "IDcustomer = '"+tfcmnd.getText()+"'or HomeTown = '"+HomeTown+"' or PhoneNumber = '"+tfsdt.getText()+"'or IDHouse = '"+tfID.getText()+"'");
		String column[] = {"IDcustomer", "FullName","Birthday","Gender","HomeTown","PhoneNumber","TimeRental","TimeStart","IDHouse"};	
	        DefaultTableModel tm = new DefaultTableModel (column, 0);
	        try {
				while (rs.next()) {
					Object data[]= {rs.getString("IDcustomer"), rs.getString("FullName")
							,rs.getString("Birthday"),rs.getString("Gender"),rs.getString("HomeTown"),rs.getString("PhoneNumber"),rs.getString("TimeRental"),rs.getString("TimeStart"),rs.getString("IDHouse")};
					
					tm.addRow(data);
					
				}
				tbcus.setModel(tm);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
	        
	        public void jtable() {
	    		JFrame ftbcus = new JFrame();
	    		JTable tbcustomer = new JTable();
	    		JScrollPane spll = new JScrollPane(tbcustomer);
	    		JButton btback = new JButton("Back");
	    		JButton btcancel = new JButton("Cancel");
	    		ftbcus.setLocation(0,100);
	    		
	    		JPanel pntb = new JPanel();
	    		spll.setPreferredSize(new Dimension(1300, 450));
	    		Border bd2 = BorderFactory.createLineBorder(Color.CYAN);
	    		TitledBorder tbdll= BorderFactory.createTitledBorder(bd2, "Information Landlords");
	    		pntb.setBorder(tbdll);
	    		pntb.add(spll);
	    		
	    		btback.setForeground(Color.BLUE);
	    		btcancel.setForeground(Color.BLUE);
	    		btback.setBackground(Color.PINK);
	    		btcancel.setBackground(Color.PINK);
	    		JPanel pnbt = new JPanel();
	    		pnbt.add(btback);
	    		pnbt.add(btcancel);
	    		Container conttb = ftbcus.getContentPane();
	    		conttb.add(pntb);
	    		conttb.add(pnbt, BorderLayout.SOUTH);
	    		ftbcus.setSize(1350,500);
	    		ftbcus.setVisible(true);
	    		btback.addActionListener(new ActionListener(){
	    			public void actionPerformed(ActionEvent e) {
	    				new customer();
	    				ftbcus.dispose();
	    			}
	    		});
	    		btcancel.addActionListener(new ActionListener(){
	    			public void actionPerformed(ActionEvent e) {
	    				
	    				ftbcus.dispose();
	    			}
	    		});
	    
	    		
	    		ConnectDB2 con = new ConnectDB2();
	    		rs=con.Listcustomer("Select * from customer");
	    		String column[] = {"IDcustomer", "FullName","Birthday","Gender","HomeTown","PhoneNumber","TimeRental","TimeStart","IDHouse"};	
	    	        DefaultTableModel tm = new DefaultTableModel (column, 0);
	    	        try {
	    				while (rs.next()) {
	    					Object data[]= {rs.getString("IDcustomer"), rs.getString("FullName"),rs.getString("Birthday"),rs.getString("Gender"),rs.getString("HomeTown"),rs.getString("PhoneNumber"),rs.getString("TimeRental"),rs.getString("TimeStart"),rs.getString("IDHouse")};
	    					
	    					tm.addRow(data);
	    					
	    				}
	    				tbcustomer.setModel(tm);
	    			} catch (SQLException e1) {
	    				// TODO Auto-generated catch block
	    				e1.printStackTrace();
	    			}
	    		
	    	}
	        public void jframecustomer() {
	        	JPanel pncmnd = new JPanel();
	    		pncmnd.add(lbcmnd);
	    		pncmnd.add(tfcmnd);
	    		
	    		lbcmnd.setForeground(Color.BLUE);
	    		pncmnd.setLayout(new GridLayout(1,2));
	    		
	    		JPanel pnname = new JPanel();
	    		pnname.add(lbfullname);
	    		pnname.add(tffullname);
	    		lbfullname.setForeground(Color.BLUE);
	    		pnname.setLayout(new GridLayout(1,2));
	    		
	    		JPanel pnaddress = new JPanel();
	    		pnaddress.add(lbaddress);
	    		pnaddress.add(jcbaddress);
	    		lbaddress.setForeground(Color.BLUE);
	    		pnaddress.setLayout(new GridLayout(1,2));
	    		
	    		JPanel pnbirthday = new JPanel();
	    		pnbirthday.add(lbbirthday);
	    		pnbirthday.add(clbirthday);
	    		lbbirthday.setForeground(Color.BLUE);
	    		pnbirthday.setLayout(new GridLayout(1,2));
	    		
	    		JPanel pntimestart = new JPanel();
	    		pntimestart.add(lbtimestart);
	    		pntimestart.add(cltimestart);
	    		lbtimestart.setForeground(Color.BLUE);
	    		pntimestart.setLayout(new GridLayout(1,2));
	    		
	    		JPanel pntimerent = new JPanel();
	    		pntimerent.add(lbtimerent);
	    		pntimerent.add(tftimerent);
	    		lbtimerent.setForeground(Color.BLUE);
	    		pntimerent.setLayout(new GridLayout(1,2));
	    		
	    		JPanel pnsdt = new JPanel();
	    		pnsdt.add(lbsdt);
	    		pnsdt.add(tfsdt);
	    		lbsdt.setForeground(Color.BLUE);
	    		pnsdt.setLayout(new GridLayout(1,2));
	    		JPanel pngender = new JPanel();
	    		pngender.add(lbgender);
	    		pngender.add(rmale);
	    		pngender.add(rfemale);
	    		bg.add(rmale);
	    		bg.add(rfemale);
	    		lbgender.setForeground(Color.BLUE);
	    		pngender.setLayout(new GridLayout(1,3));

	    		JPanel pnID = new JPanel();
	    		pnID.add(lbIDH);
	    		pnID.add(tfID);
	    		lbIDH.setForeground(Color.BLUE);
	    		pnID.setLayout(new GridLayout(1,3));
	    	
	    	
	    		
	    		JPanel pnbton = new JPanel();
	    		pnbton.add(btadd);
	    		pnbton.add(btupdate);
	    		pnbton.add(btdelete);
	    		pnbton.add(btfind);
	    		pnbton.add(btnew);
	    		pnbton.add(btsee);
	    		pnbton.add(btcancel);
	    		pnbton.add(btback);
	    		btcancel.setBackground(Color.LIGHT_GRAY);
	    		btback.setBackground(Color.LIGHT_GRAY);
	    		btfind.setBackground(Color.LIGHT_GRAY);
	    		btupdate.setBackground(Color.LIGHT_GRAY);
	    		btnew.setBackground(Color.LIGHT_GRAY);
	    		btdelete.setBackground(Color.LIGHT_GRAY);
	    		btadd.setBackground(Color.LIGHT_GRAY);
	    		btsee.setBackground(Color.LIGHT_GRAY);
	    		pnbton.setLayout(new GridLayout(2,4));
	    		
	    		JPanel pntable = new JPanel();
	    		sp.setPreferredSize(new Dimension(720, 500));
	    		Border bd = BorderFactory.createLineBorder(Color.BLUE);
	    		TitledBorder tbdcus= BorderFactory.createTitledBorder(bd, "Information Customer");
	    		pntable.setBorder(tbdcus);
	    		pntable.add(sp);
	    		pntable.setBackground(Color.WHITE);
	    		
	    		JPanel pnall = new JPanel();
	    		pnall.add(pncmnd);
	    		pnall.add(pnname);
	    		pnall.add(pnbirthday);
	    		pnall.add(pngender);
	    		pnall.add(pnaddress);
	    		pnall.add(pnsdt);	    		
	    		pnall.add(pntimerent);
	    		pnall.add(pntimestart);
	    		pnall.add(pnID);
	    		pnall.setLayout(new GridLayout(11,1));
	    		Border bdpnall = BorderFactory.createLineBorder(Color.BLUE);
	    		TitledBorder tbdpnall= BorderFactory.createTitledBorder(bdpnall, "Customer");
	    		pnall.setBorder(tbdpnall);
	    		pnall.setBackground(Color.WHITE);
	    		
	    		f2.setLocation(100,20);
	    		
	    		Container cont2 =  f2.getContentPane();
	    		cont2.add(pnall,BorderLayout.WEST);
	    		cont2.add(pntable,BorderLayout.CENTER);
	    		cont2.add(pnbton, BorderLayout.SOUTH);
	    		
	    		f2.pack();
	    		f2.setSize(1200,600);
	    		f2.setVisible(true);
	    		DisplayCustomer();
	        	
	        }
	     public void jbuttoncustomer() {
	    		btnew.addActionListener(new ActionListener(){
	    			public void actionPerformed(ActionEvent e) {
	    				
	    				new customer();
	    				
	    				f2.dispose();
	    				
	    			}
	    		});
	    		btadd.addActionListener(new ActionListener(){
	    			public void actionPerformed(ActionEvent e) {
	    				ConnectDB2 cn =new ConnectDB2();
	    				ConnectDB1 cn1 =new ConnectDB1();
	    				conn = cn.connect();
	    				// thêm vào cơ sở dữ liệu
	    				 SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
	    			       String HomeTown = jcbaddress.getSelectedItem().toString();
	    			       String Gender ="";
	    			       if(rmale.isSelected()) Gender = rmale.getText();
	    					if(rfemale.isSelected()) Gender = rfemale.getText();
	    					Date selectedDate = (Date) clbirthday.getDate();
	    					java.sql.Date Birthday = convertUtilToSql(selectedDate);
	    					Date selectedDatestart = (Date) cltimestart.getDate();
	    					java.sql.Date TimeStart = convertUtilToSql(selectedDatestart);
	    					 try {
	    						 ResultSet rs = cn1.ListHouse("Select * from informationhouse1 where IDHouse = '"+tfID.getText()+"' and MemberMax = Member");
	    						 
	 								if (rs.next()) {
	 									JOptionPane.showMessageDialog(null, "House is full member");
	 								} else {
	    						 ps = conn.prepareStatement("exec sp_Addcustomer2 ?,?,?,?,?,?,?,?,? ");
	    							ps.setString(1, tfcmnd.getText());
	    							ps.setString(2, tffullname.getText());
	    							ps.setDate(3, Birthday);
	    							ps.setString(4, Gender);
	    							ps.setString(5, HomeTown);
	    							ps.setString(6, tfsdt.getText());
	    							ps.setString(7, tftimerent.getText());
	    							ps.setDate(8, TimeStart);
	    							ps.setString(9, tfID.getText());
	    					//		ps.setString(11, tfcmndland.getText());
	    							int record2 = ps.executeUpdate();
	    							if(record2 >0) JOptionPane.showMessageDialog(null, "Insert Success");
	    							else JOptionPane.showMessageDialog(null, "Insert Fail");
	    							if(tfID.getText().length()!=0) {
	    								cn1.executeDB1("update informationhouse1 set Member = (Member + 1) where IDHouse = '"+tfID.getText()+"'");
	 								}
	 								}} catch (SQLException e1) {
	    							// TODO Auto-generated catch block
	    							e1.printStackTrace();
	    						}
	    				DisplayCustomer();
	    					
	    				
	    			}

	    			private java.sql.Date convertUtilToSql(Date selectedDate) {
	    				java.sql.Date sDate = new java.sql.Date(selectedDate.getTime());
	    		        return sDate;
	    			}
	    		});
	    		
	    		btupdate.addActionListener(new ActionListener(){
	    			public void actionPerformed(ActionEvent e) {
	    				ConnectDB2 cn =new ConnectDB2();
	    				String HomeTown = jcbaddress.getSelectedItem().toString();
	    					  try {
	    						  if(HomeTown != "Home Town") {
	    							  int record2 = cn.executeDB2("Update customer set HomeTown = '"+HomeTown+"'"
	    										+ " where IDcustomer = '"+tfcmnd.getText()+"'");
	    							  if (record2>0);
	    							  else JOptionPane.showMessageDialog(null, "Failed");	
	    						  }
	    						  if(tfsdt.getText().length()!=0) {
	    							  int record2 = cn.executeDB2("Update customer set PhoneNumber = '"+tfsdt.getText()+"'"
	    										+ " where IDcustomer = '"+tfcmnd.getText()+"'");
	    							  if (record2>0)  ;
	    							  else JOptionPane.showMessageDialog(null, "Failed");
	    						  }
	    						
	    						  if(tffullname.getText().length()!=0) {
	    								  int record2 = cn.executeDB2("Update customer set FullName = '"+tffullname.getText()+"'"
	    											+ " where IDcustomer = '"+tfcmnd.getText()+"'");
	    								  if (record2>0)  ;
	    								 else JOptionPane.showMessageDialog(null, "Failed");
	    						  }
	    						  if(tftimerent.getText().length()!=0) {
	    							  int record2 = cn.executeDB2("Update customer set TimeRental = '"+tftimerent.getText()+"'"
	    										+ " where IDcustomer = '"+tfcmnd.getText()+"'");
	    							  if (record2>0) ;
	    							 else JOptionPane.showMessageDialog(null, "Failed");
	    					  }
	    						  if(((JTextField)clbirthday.getDateEditor().getUiComponent()).getText().length()!=0) {
	    								int record2 = cn.executeDB2("Update customer set Birthday = '"+((JTextField)clbirthday.getDateEditor().getUiComponent()).getText()+"' where IDcustomer = '"+tfcmnd.getText()+"'");
	    								if (record2>0) ;
	    								else JOptionPane.showMessageDialog(null, "Failed");
	    							}
	    						  if(((JTextField)cltimestart.getDateEditor().getUiComponent()).getText().length()!=0) {
	    								int record2 = cn.executeDB2("Update customer set TimeStart = '"+((JTextField)cltimestart.getDateEditor().getUiComponent()).getText()+"' where IDcustomer = '"+tfcmnd.getText()+"'");
	    								if (record2>0) ;
	    								else JOptionPane.showMessageDialog(null, "Failed");
	    							}
	    					} catch (Exception e1) {
	    						// TODO Auto-generated catch block
	    						e1.printStackTrace();
	    					} 
	    					  DisplayCustomer();
	    				
	    			}

	    			
	    		});
	    		btdelete.addActionListener(new ActionListener(){
	    			public void actionPerformed(ActionEvent e) {
	    				ConnectDB2 cn = new ConnectDB2();
	    				ConnectDB1 cn1 =new ConnectDB1();
	    				try {

	    					int record2 = cn.executeDB2("Delete from customer where IDcustomer = '"+tfcmnd.getText()+"'"
	    							+ "or FullName = '"+tffullname.getText()+"' or PhoneNumber = '"+tfsdt.getText()+"'"
	    									+ " or IDHouse = '"+tfID.getText()+"' ");
	    					cn1.executeDB1("update informationhouse1 set Member = (Member - 1) where IDHouse = '"+tfID.getText()+"'");
	    					if (record2>0) JOptionPane.showMessageDialog(null, "Delete Success");
	    					
	    				} catch (Exception e1) {
	    					// TODO Auto-generated catch block
	    					e1.printStackTrace();
	    				}
	    				DisplayCustomer();
	    			}
	    			
	    		});
	    		btfind.addActionListener(new ActionListener(){
	    			public void actionPerformed(ActionEvent e) {
	    				// tìm kiếm
	    				Customerfind();
	    				
	    			}
	    		});
	    	
	    		btcancel.addActionListener(new ActionListener(){
	    			public void actionPerformed(ActionEvent e) {
	    				f2.dispose();
	    			}
	    		});
	    		btback.addActionListener(new ActionListener(){
	    			public void actionPerformed(ActionEvent e) {
	    				new choose();
	    				f2.dispose();
	    			}
	    		});
	    		btsee.addActionListener(new ActionListener(){
	    			public void actionPerformed(ActionEvent e) {
	    				jtable();
	    				f2.dispose();
	    			}
	    		});
	     }
	    		 

}
