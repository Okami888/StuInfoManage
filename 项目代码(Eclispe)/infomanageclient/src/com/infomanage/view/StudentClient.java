package com.infomanage.view;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import com.infomanage.model.CardModel;
import com.infomanage.model.Message;
import com.infomanageclient.control.InfoManageConnection;



public class StudentClient extends JFrame implements ActionListener,MouseListener {
	private static final long serialVersionUID = 1L;
	private String username,password;
	
	private Container container;
	
	private JPanel leftJpanel,rightJpanel;
		
	private JButton jB1,jB2,jB3,jB4,jB5,jB6,jB7,jB8,jB9,jB10,jB11,jB12,jB13,jB14;
	private JButton[] jButtons=new JButton[14];
	
	private CardLayout card;
	private JPanel Card1;//卡片1
	private JScrollPane Card2,Card3,Card4,Card5,Card6,Card7,Card8,Card9,Card10,Card11,Card12,Card13;
	private JPanel Card14;
	private JLabel omima,nmima,queren,bt1,bt2,bt3;JButton baocun,chouzhi;
	private JPasswordField p1,p2,p3;
	
	
	private Object[] columnName2= {"序号","原班级","原在校","原单位","新专业","新班级","新状态","新在校","异动类型","终审状态"};
	private Object[] columnName3= {"奖励年度","奖励名称","颁奖单位","奖励等级"};
	private Object[] columnName4= {"课程代码","课程名称","学分","课程性质","授课老师","总成绩"};
	private Object[] columnName5= {"序号","学年学期","违纪日期","违纪简况","违纪类别","处分名称","处分原因","处分文号","处分撤销日期","处分撤销文号","操作"};//不搞
	private Object[] columnName6= {"序号","申请毕业届别","主修/辅修","培养方案名称","毕业审查结论","毕业审查结果","学位审查结果","证书编号","学位证书编号","申请类型","操作"};//不搞
	
	private Object[][] rowData5={
			{"无"," "," "," "," "," "," "," "," "," "," "},
	};
	private Object[][] rowData6={
			{"01","2024","主修","2020级数据科学与大数据技术指导计划"," "," "," "," "," "," ","毕业申请 结业申请"},
	};
	
	
	private Object[] columnName7= {"作者","日期","课程","班级"};
	private Object[][] rowData7={
			{"HLS","20220523","数据库概论","20大数据01"},
	};
		
	
	public StudentClient(Message ms){
		
		username=ms.getUserName();password=ms.getPassWord();
		
		String[] data1=ms.getTable1();
		String[][] rowData2=ms.getTable2();
		String[][] rowData3=ms.getTable3();
		String[][] rowData4=ms.getTable4();
		
		container=this.getContentPane();	
		container.setLayout(null);
		
		leftJpanel=new JPanel();
		rightJpanel=new JPanel();
		
		card=new CardLayout();
		Card1=new CardModel(data1).getpanel();
		//
		Card2=createTable(rowData2, columnName2);
		Card3=createTable(rowData3, columnName3);
		Card4=createTable(rowData4, columnName4);
		Card5=createTable(rowData5, columnName5);
		Card6=createTable(rowData6, columnName6);
		//
		Card7=createTable(rowData7, columnName7);Card8=createTable(rowData7, columnName7);
		Card9=createTable(rowData7, columnName7);Card10=createTable(rowData7, columnName7);
		Card11=createTable(rowData7, columnName7);Card12=createTable(rowData7, columnName7);
		Card13=createTable(rowData7, columnName7);	
		//
		Card14=new JPanel();
		Card14.setLayout(null);
		
		omima=new JLabel("旧密码：",SwingConstants.RIGHT);omima.setFont(new Font("黑体", Font.PLAIN, 17));
		nmima=new JLabel("新密码：",SwingConstants.RIGHT);nmima.setFont(new Font("黑体", Font.PLAIN, 17));
		queren=new JLabel("确认新密码：",SwingConstants.RIGHT);queren.setFont(new Font("黑体", Font.PLAIN, 17));
		bt1=new JLabel("*必填");bt1.setForeground(Color.RED);
		bt2=new JLabel("*必填");bt2.setForeground(Color.RED);
		bt3=new JLabel("*必填");bt3.setForeground(Color.RED);
		baocun=new JButton(new ImageIcon("src/images/bc.png"));baocun.addActionListener(this);
		chouzhi=new JButton(new ImageIcon("src/images/cz.png"));chouzhi.addActionListener(this);
		p1=new JPasswordField();p2=new JPasswordField();p3=new JPasswordField();
		
		omima.setBounds(70, 100, 100, 30);p1.setBounds(180, 100, 200, 30);bt1.setBounds(380, 100, 80, 30);
		nmima.setBounds(70, 130, 100, 30);p2.setBounds(180, 130, 200, 30);bt2.setBounds(380, 130, 80, 30);
		queren.setBounds(20, 160, 150, 30);p3.setBounds(180, 160, 200, 30);bt3.setBounds(380, 160, 80, 30);
		baocun.setBounds(190, 215, 59, 36);chouzhi.setBounds(280, 215, 59, 36);
		
		Card14.add(omima);Card14.add(nmima);Card14.add(queren);
		Card14.add(bt1);Card14.add(bt2);Card14.add(bt3);
		Card14.add(baocun);Card14.add(chouzhi);
		Card14.add(p1);Card14.add(p2);Card14.add(p3);
		
		
		rightJpanel.setLayout(card);
		rightJpanel.add(Card1,"1");rightJpanel.add(Card2,"2");rightJpanel.add(Card3,"3");
		rightJpanel.add(Card4,"4");rightJpanel.add(Card5,"5");rightJpanel.add(Card6,"6");
		rightJpanel.add(Card7,"7");rightJpanel.add(Card8,"8");rightJpanel.add(Card9,"9");
		rightJpanel.add(Card10,"10");rightJpanel.add(Card11,"11");rightJpanel.add(Card12,"12");
		rightJpanel.add(Card13,"13");rightJpanel.add(Card14,"14");
		
		
		jB1=new JButton("学籍个人信息");
		setButton(jB1);jB1.setBackground(new Color(185,204,237));	
		jB2=new JButton("学籍异动信息");
		setButton(jB2);
		jB3=new JButton("奖励情况");
		setButton(jB3);
		jB4=new JButton("课程学习信息");
		setButton(jB4);
		jB5=new JButton("处分撤销申请");
		setButton(jB5);
		jB6=new JButton("学生毕业信息");
		setButton(jB6);
		//
		jB7=new JButton();setButton(jB7);
		jB8=new JButton();setButton(jB8);
		jB9=new JButton();setButton(jB9);
		jB10=new JButton();setButton(jB10);
		jB11=new JButton();setButton(jB11);
		jB12=new JButton();setButton(jB12);
		jB13=new JButton();setButton(jB13);
		//
		jB14=new JButton("密码更改");
		setButton(jB14);
			
		jButtons[0]=jB1;jButtons[1]=jB2;jButtons[2]=jB3;jButtons[3]=jB4;jButtons[4]=jB5;jButtons[5]=jB6;
		jButtons[6]=jB7;jButtons[7]=jB8;jButtons[8]=jB9;jButtons[9]=jB10;jButtons[10]=jB11;jButtons[11]=jB12;
		jButtons[12]=jB13;jButtons[13]=jB14;

		leftJpanel.setLayout(new GridLayout(14,0));
		leftJpanel.add(jB1);leftJpanel.add(jB2);leftJpanel.add(jB3);leftJpanel.add(jB4);
		leftJpanel.add(jB5);leftJpanel.add(jB6);leftJpanel.add(jB7);leftJpanel.add(jB8);
		leftJpanel.add(jB9);leftJpanel.add(jB10);leftJpanel.add(jB11);leftJpanel.add(jB12);
		leftJpanel.add(jB13);leftJpanel.add(jB14);

		leftJpanel.setBounds(0,0, 180, 340);
		rightJpanel.setBounds(180,0,540,320);
		
		container.add(leftJpanel);
		container.add(rightJpanel);		
		
		this.setSize(735,380);
		this.setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon("src/images/index_04.png").getImage());
		this.setTitle("学生端");
		//this.setResizable(false);		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	

	public static void main(String[] args) {
		//new StudentClient(new Message());
		
	}
	
	
	public JScrollPane createTable(Object[][] rowData,Object[] columnName) {
		JTable jTable=new JTable(rowData,columnName) {
			private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int row, int column) { 
				 	 return false;
				  }
		};
		jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jTable.getTableHeader().setBackground(new Color(243, 250, 255));//表头颜色
		jTable.getTableHeader().setFont(new Font("宋体", Font.BOLD, 10));
		jTable.getTableHeader().setReorderingAllowed(false);
		jTable.setGridColor(new Color(211, 232, 247));
		jTable.setSelectionBackground(Color.lightGray);
		jTable.setSelectionForeground(Color.RED);
		JScrollPane jScrollPane=new JScrollPane(jTable);
		return jScrollPane;
	}
	
	public void setWhite() {
		
		//JButton[] jButtons= {jB1,jB2,jB3,jB4,jB5,jB6,jB7,jB8,jB9,jB10,jB11,jB12,jB13,jB14};
		for(JButton jbs:jButtons) {
			if(jbs.getBackground().equals(new Color(185,204,237))) {
				
			}else {
				jbs.setBackground(Color.WHITE);
			}
		}
	}

	public void setButton(JButton jButton) {
		jButton.addActionListener(this);
		jButton.addMouseListener(this);
		jButton.setBackground(Color.WHITE);
		jButton.setFocusPainted(false);
		jButton.setBorderPainted(false);
		jButton.setFont(new Font("黑体", Font.PLAIN, 12));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jB1) {
			card.show(rightJpanel,"1");
			jB1.setBackground(new Color(185,204,237));
			
			jB2.setBackground(Color.WHITE);jB3.setBackground(Color.WHITE);jB4.setBackground(Color.WHITE);
			jB5.setBackground(Color.WHITE);jB6.setBackground(Color.WHITE);jB7.setBackground(Color.WHITE);
			jB8.setBackground(Color.WHITE);jB9.setBackground(Color.WHITE);jB10.setBackground(Color.WHITE);
			jB11.setBackground(Color.WHITE);jB12.setBackground(Color.WHITE);jB13.setBackground(Color.WHITE);
			jB14.setBackground(Color.WHITE);
		}
		if(e.getSource()==jB2) {
			card.show(rightJpanel,"2");
			jB2.setBackground(new Color(185,204,237));
			
			jB1.setBackground(Color.WHITE);jB3.setBackground(Color.WHITE);jB4.setBackground(Color.WHITE);
			jB5.setBackground(Color.WHITE);jB6.setBackground(Color.WHITE);jB7.setBackground(Color.WHITE);
			jB8.setBackground(Color.WHITE);jB9.setBackground(Color.WHITE);jB10.setBackground(Color.WHITE);
			jB11.setBackground(Color.WHITE);jB12.setBackground(Color.WHITE);jB13.setBackground(Color.WHITE);
			jB14.setBackground(Color.WHITE);
		}
		if(e.getSource()==jB3) {
			card.show(rightJpanel,"3");
			jB3.setBackground(new Color(185,204,237));
			
			jB1.setBackground(Color.WHITE);jB2.setBackground(Color.WHITE);jB4.setBackground(Color.WHITE);
			jB5.setBackground(Color.WHITE);jB6.setBackground(Color.WHITE);jB7.setBackground(Color.WHITE);
			jB8.setBackground(Color.WHITE);jB9.setBackground(Color.WHITE);jB10.setBackground(Color.WHITE);
			jB11.setBackground(Color.WHITE);jB12.setBackground(Color.WHITE);jB13.setBackground(Color.WHITE);
			jB14.setBackground(Color.WHITE);
		}
		if(e.getSource()==jB4) {
			card.show(rightJpanel,"4");
			jB4.setBackground(new Color(185,204,237));
			
			jB1.setBackground(Color.WHITE);jB3.setBackground(Color.WHITE);jB2.setBackground(Color.WHITE);
			jB5.setBackground(Color.WHITE);jB6.setBackground(Color.WHITE);jB7.setBackground(Color.WHITE);
			jB8.setBackground(Color.WHITE);jB9.setBackground(Color.WHITE);jB10.setBackground(Color.WHITE);
			jB11.setBackground(Color.WHITE);jB12.setBackground(Color.WHITE);jB13.setBackground(Color.WHITE);
			jB14.setBackground(Color.WHITE);
		}
		if(e.getSource()==jB5) {
			card.show(rightJpanel,"5");
			jB5.setBackground(new Color(185,204,237));
			
			jB1.setBackground(Color.WHITE);jB3.setBackground(Color.WHITE);jB4.setBackground(Color.WHITE);
			jB2.setBackground(Color.WHITE);jB6.setBackground(Color.WHITE);jB7.setBackground(Color.WHITE);
			jB8.setBackground(Color.WHITE);jB9.setBackground(Color.WHITE);jB10.setBackground(Color.WHITE);
			jB11.setBackground(Color.WHITE);jB12.setBackground(Color.WHITE);jB13.setBackground(Color.WHITE);
			jB14.setBackground(Color.WHITE);
		}
		if(e.getSource()==jB6) {
			card.show(rightJpanel,"6");
			jB6.setBackground(new Color(185,204,237));
			
			jB1.setBackground(Color.WHITE);jB3.setBackground(Color.WHITE);jB4.setBackground(Color.WHITE);
			jB5.setBackground(Color.WHITE);jB2.setBackground(Color.WHITE);jB7.setBackground(Color.WHITE);
			jB8.setBackground(Color.WHITE);jB9.setBackground(Color.WHITE);jB10.setBackground(Color.WHITE);
			jB11.setBackground(Color.WHITE);jB12.setBackground(Color.WHITE);jB13.setBackground(Color.WHITE);
			jB14.setBackground(Color.WHITE);
		}
		if(e.getSource()==jB7) {
			card.show(rightJpanel,"7");
			jB7.setBackground(new Color(185,204,237));
			
			jB1.setBackground(Color.WHITE);jB3.setBackground(Color.WHITE);jB4.setBackground(Color.WHITE);
			jB5.setBackground(Color.WHITE);jB6.setBackground(Color.WHITE);jB2.setBackground(Color.WHITE);
			jB8.setBackground(Color.WHITE);jB9.setBackground(Color.WHITE);jB10.setBackground(Color.WHITE);
			jB11.setBackground(Color.WHITE);jB12.setBackground(Color.WHITE);jB13.setBackground(Color.WHITE);
			jB14.setBackground(Color.WHITE);
		}
		if(e.getSource()==jB8) {
			card.show(rightJpanel,"8");
			jB8.setBackground(new Color(185,204,237));
			
			jB1.setBackground(Color.WHITE);jB3.setBackground(Color.WHITE);jB4.setBackground(Color.WHITE);
			jB5.setBackground(Color.WHITE);jB6.setBackground(Color.WHITE);jB7.setBackground(Color.WHITE);
			jB2.setBackground(Color.WHITE);jB9.setBackground(Color.WHITE);jB10.setBackground(Color.WHITE);
			jB11.setBackground(Color.WHITE);jB12.setBackground(Color.WHITE);jB13.setBackground(Color.WHITE);
			jB14.setBackground(Color.WHITE);
		}
		if(e.getSource()==jB9) {
			card.show(rightJpanel,"9");
			jB9.setBackground(new Color(185,204,237));
			
			jB1.setBackground(Color.WHITE);jB3.setBackground(Color.WHITE);jB4.setBackground(Color.WHITE);
			jB5.setBackground(Color.WHITE);jB6.setBackground(Color.WHITE);jB7.setBackground(Color.WHITE);
			jB8.setBackground(Color.WHITE);jB2.setBackground(Color.WHITE);jB10.setBackground(Color.WHITE);
			jB11.setBackground(Color.WHITE);jB12.setBackground(Color.WHITE);jB13.setBackground(Color.WHITE);
			jB14.setBackground(Color.WHITE);
		}
		if(e.getSource()==jB10) {
			card.show(rightJpanel,"10");
			jB10.setBackground(new Color(185,204,237));
			
			jB1.setBackground(Color.WHITE);jB3.setBackground(Color.WHITE);jB4.setBackground(Color.WHITE);
			jB5.setBackground(Color.WHITE);jB6.setBackground(Color.WHITE);jB7.setBackground(Color.WHITE);
			jB8.setBackground(Color.WHITE);jB9.setBackground(Color.WHITE);jB2.setBackground(Color.WHITE);
			jB11.setBackground(Color.WHITE);jB12.setBackground(Color.WHITE);jB13.setBackground(Color.WHITE);
			jB14.setBackground(Color.WHITE);
		}
		if(e.getSource()==jB11) {
			card.show(rightJpanel,"11");
			jB11.setBackground(new Color(185,204,237));
			
			jB1.setBackground(Color.WHITE);jB3.setBackground(Color.WHITE);jB4.setBackground(Color.WHITE);
			jB5.setBackground(Color.WHITE);jB6.setBackground(Color.WHITE);jB7.setBackground(Color.WHITE);
			jB8.setBackground(Color.WHITE);jB9.setBackground(Color.WHITE);jB10.setBackground(Color.WHITE);
			jB2.setBackground(Color.WHITE);jB12.setBackground(Color.WHITE);jB13.setBackground(Color.WHITE);
			jB14.setBackground(Color.WHITE);
		}
		if(e.getSource()==jB12) {
			card.show(rightJpanel,"12");
			jB12.setBackground(new Color(185,204,237));
			
			jB1.setBackground(Color.WHITE);jB3.setBackground(Color.WHITE);jB4.setBackground(Color.WHITE);
			jB5.setBackground(Color.WHITE);jB6.setBackground(Color.WHITE);jB7.setBackground(Color.WHITE);
			jB8.setBackground(Color.WHITE);jB9.setBackground(Color.WHITE);jB10.setBackground(Color.WHITE);
			jB11.setBackground(Color.WHITE);jB2.setBackground(Color.WHITE);jB13.setBackground(Color.WHITE);
			jB14.setBackground(Color.WHITE);
		}
		if(e.getSource()==jB13) {
			card.show(rightJpanel,"13");
			jB13.setBackground(new Color(185,204,237));
			
			jB1.setBackground(Color.WHITE);jB3.setBackground(Color.WHITE);jB4.setBackground(Color.WHITE);
			jB5.setBackground(Color.WHITE);jB6.setBackground(Color.WHITE);jB7.setBackground(Color.WHITE);
			jB8.setBackground(Color.WHITE);jB9.setBackground(Color.WHITE);jB10.setBackground(Color.WHITE);
			jB11.setBackground(Color.WHITE);jB12.setBackground(Color.WHITE);jB2.setBackground(Color.WHITE);
			jB14.setBackground(Color.WHITE);
		}
		if(e.getSource()==jB14) {
			card.show(rightJpanel,"14");
			jB14.setBackground(new Color(185,204,237));
			
			jB1.setBackground(Color.WHITE);jB3.setBackground(Color.WHITE);jB4.setBackground(Color.WHITE);
			jB5.setBackground(Color.WHITE);jB6.setBackground(Color.WHITE);jB7.setBackground(Color.WHITE);
			jB8.setBackground(Color.WHITE);jB9.setBackground(Color.WHITE);jB10.setBackground(Color.WHITE);
			jB11.setBackground(Color.WHITE);jB12.setBackground(Color.WHITE);jB13.setBackground(Color.WHITE);
			jB2.setBackground(Color.WHITE);
		}
		if(e.getSource()==chouzhi) {
			p1.setText("");p2.setText("");p3.setText("");		
		}
		if(e.getSource()==baocun) {
			String password1=p1.getText();
			String password2=p2.getText();
			if(password.equals("")||password==null) {
				JOptionPane.showMessageDialog(this, "请输入原密码！");
			}else if(!password.equals(password1)) {
				JOptionPane.showMessageDialog(this, "原密码错误！");
			}else {
				if(password2.equals("")||password2==null) {
					JOptionPane.showMessageDialog(this, "请设置新密码！");
				}
				if(!password2.equals(p2.getText())) {
					JOptionPane.showMessageDialog(this, "密码不一致！");
				}else {
					Message ms2=new Message();
					ms2.setUserName(username);
					ms2.setPassWord(password2);
					ms2.setMessageType(Message.CHANGE_PW);
					new InfoManageConnection().changepw(ms2);
					JOptionPane.showMessageDialog(this, "修改成功！");
				}		
			}
							
		}
		
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		if(e.getSource()==jB1) {
			if(jB1.getBackground().equals(new Color(185,204,237))) {			
			}else {
				jB1.setBackground(new Color(243,250,255));
			}		
			
		}
		if(e.getSource()==jB2) {
			if(jB2.getBackground().equals(new Color(185,204,237))) {			
			}else {
				jB2.setBackground(new Color(243,250,255));
			}	
		}
		if(e.getSource()==jB3) {
			if(jB3.getBackground().equals(new Color(185,204,237))) {			
			}else {
				jB3.setBackground(new Color(243,250,255));
			}	
		}
		if(e.getSource()==jB4) {
			if(jB4.getBackground().equals(new Color(185,204,237))) {			
			}else {
				jB4.setBackground(new Color(243,250,255));
			}	
		}

		if(e.getSource()==jB5) {
			if(jB5.getBackground().equals(new Color(185,204,237))) {			
			}else {
				jB5.setBackground(new Color(243,250,255));
			}	
		}

		if(e.getSource()==jB6) {
			if(jB6.getBackground().equals(new Color(185,204,237))) {			
			}else {
				jB6.setBackground(new Color(243,250,255));
			}	
		}

		if(e.getSource()==jB7) {
			if(jB7.getBackground().equals(new Color(185,204,237))) {			
			}else {
				jB7.setBackground(new Color(243,250,255));
			}	
		}

		if(e.getSource()==jB8) {
			if(jB8.getBackground().equals(new Color(185,204,237))) {			
			}else {
				jB8.setBackground(new Color(243,250,255));
			}	
		}

		if(e.getSource()==jB9) {
			if(jB9.getBackground().equals(new Color(185,204,237))) {			
			}else {
				jB9.setBackground(new Color(243,250,255));
			}	
		}

		if(e.getSource()==jB10) {
			if(jB10.getBackground().equals(new Color(185,204,237))) {			
			}else {
				jB10.setBackground(new Color(243,250,255));
			}	
		}
		
		if(e.getSource()==jB11) {
			if(jB11.getBackground().equals(new Color(185,204,237))) {			
			}else {
				jB11.setBackground(new Color(243,250,255));
			}	
		}
		if(e.getSource()==jB12) {
			if(jB12.getBackground().equals(new Color(185,204,237))) {			
			}else {
				jB12.setBackground(new Color(243,250,255));
			}	
		}

		if(e.getSource()==jB13) {
			if(jB13.getBackground().equals(new Color(185,204,237))) {			
			}else {
				jB13.setBackground(new Color(243,250,255));
			}	
		}

		if(e.getSource()==jB14) {
			if(jB14.getBackground().equals(new Color(185,204,237))) {			
			}else {
				jB14.setBackground(new Color(243,250,255));
			}	
		}

	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jB1) {
			setWhite();
		}
		if(e.getSource()==jB2) {
			setWhite();
		}
		if(e.getSource()==jB3) {
			setWhite();
		}
		if(e.getSource()==jB4) {
			setWhite();
		}
		if(e.getSource()==jB5) {
			setWhite();
		}
		if(e.getSource()==jB6) {
			setWhite();
		}
		if(e.getSource()==jB7) {
			setWhite();
		}
		if(e.getSource()==jB8) {
			setWhite();
		}
		if(e.getSource()==jB9) {
			setWhite();
		}
		if(e.getSource()==jB10) {
			setWhite();
		}
		if(e.getSource()==jB11) {
			setWhite();
		}
		if(e.getSource()==jB12) {
			setWhite();
		}
		if(e.getSource()==jB13) {
			setWhite();
		}
		if(e.getSource()==jB14) {
			setWhite();
		}
		
	}
}

