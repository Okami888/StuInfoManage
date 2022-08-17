package com.infomanage.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.infomanage.model.Message;

import com.infomanageclient.control.InfoManageConnection;

public class ClientLogin extends JFrame implements MouseListener,ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//���ڶ�λ���λ��
	private int mouseAtX=0;
	private int mouseAtY=0;
	
	private JButton btn_min,btn_exit;
	
	private JLabel backg1,backg2;
	private JLabel yonghu,mingzi,mima;
	private JTextField zhangh;
	private JPasswordField mim;
	private JButton denglu,wenhao;
	private JLabel fal;
	public ClientLogin() {
		Container container=this.getContentPane();
		container.setLayout(null);
		
		//���Ͻ���С����ť
		btn_min = new JButton(new ImageIcon("src/images/fmin.png"));
		btn_min.setBounds(885, 0, 28, 28);
		btn_min.setBorderPainted(false);
		btn_min.setContentAreaFilled(false);
		btn_min.addMouseListener(this);		
		//���Ͻ��˳���ť
		btn_exit = new JButton(new ImageIcon("src/images/fexit.png"));
		btn_exit.setBounds(913, 0, 28, 28);
		btn_exit.setBorderPainted(false);
		btn_exit.setContentAreaFilled(false);
		btn_exit.addMouseListener(this);
		
		backg1=new JLabel(new ImageIcon("src/images/bgtp.gif"));
		backg2=new JLabel(new ImageIcon("src/images/bgtp2.png"));
		
		yonghu=new JLabel("�û���¼");
		yonghu.setFont(new Font("����", Font.PLAIN, 25));
		mingzi=new JLabel("�û���:");
		mingzi.setFont(new Font("����", Font.PLAIN, 20));
		mima=new JLabel("����:");
		mima.setFont(new Font("����", Font.PLAIN, 20));
		
		zhangh=new JTextField(200);
		zhangh.setBorder(null);
		mim=new JPasswordField();
		mim.setBorder(null);
		
		denglu=new JButton(new ImageIcon("src/images/dlau.gif"));
		denglu.setContentAreaFilled(false);
		denglu.addActionListener(this);
		wenhao=new JButton(new ImageIcon("src/images/dlau1.gif"));
		wenhao.setContentAreaFilled(false);  
		
		fal=new JLabel("�û������������");
		fal.setVisible(false);
		fal.setFont(new Font("����", Font.PLAIN, 20));fal.setForeground(Color.red);
		
		//this.getLayeredPane().add(backg1,Integer.valueOf(Integer.MIN_VALUE));
		//JPanel panel=(JPanel)container;	
		//panel.setOpaque(false);���ò�͸����
	
		this.setSize(955, 387);
		
		//this.getLayeredPane().add(backg1);containerΪlayererpaneһ�֣�Ϊ��ײ㡣layeredpaneΪ���ϲ�
		backg1.setBounds(0,91,955,296);
		backg2.setBounds(0,0,955,91);
		
		yonghu.setBounds(550,95,166,63);
		mingzi.setBounds(560,162,88,53);
		mima.setBounds(560, 212, 88, 53);
		
		
		zhangh.setBounds(650, 175, 200, 30);
		mim.setBounds(650, 225, 200, 30);
		
		denglu.setBounds(780,275,45,45);
		wenhao.setBounds(840, 275, 45, 45);
		
		fal.setBounds(560, 260, 200, 53);
		
		container.add(btn_min);
		container.add(btn_exit);
		
		container.add(zhangh);
		container.add(mim);
		container.add(yonghu);
		
		container.add(mingzi);
		container.add(mima);
		
		container.add(denglu);
		container.add(wenhao);
		
		container.add(fal);
		
		//this.getLayeredPane().add(yonghu);
		container.add(backg1);
		//this.getLayeredPane().add(backg1);
		container.add(backg2);
		
		
		
		//ȥ���䶨��װ�ο�
	    this.setUndecorated(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		//ʵ�ִ��ڿ���ק
		this.addMouseListener(new MouseAdapter() {
			@Override
			public  void mousePressed(MouseEvent e) {
				mouseAtX = e.getPoint().x;
		        mouseAtY = e.getPoint().y;
			}
		});
		this.addMouseMotionListener(new MouseMotionAdapter()
		      {
		          public void mouseDragged(MouseEvent e) 
		          {
		              setLocation((e.getXOnScreen()-mouseAtX),(e.getYOnScreen()-mouseAtY));//������ק�󣬴��ڵ�λ��
		          }
		      });
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ClientLogin();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn_min) {
			setExtendedState(JFrame.ICONIFIED);
		}else if(e.getSource()==btn_exit) {
			this.dispose();
	        System.exit(0);
		}
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
		if(e.getSource()==btn_min) {
			btn_min.setContentAreaFilled(true);
			btn_min.setBackground(new Color(240,240,240));
		}else if(e.getSource()==btn_exit) {
			btn_exit.setContentAreaFilled(true);
			btn_exit.setBackground(new Color(247,93,67));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn_min) {
			btn_min.setContentAreaFilled(false);
		}else if(e.getSource()==btn_exit) {
			btn_exit.setContentAreaFilled(false);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==denglu) {
			String userName=zhangh.getText().toString().trim();
			String passWord=mim.getText().toString();

			Message ms=new Message();
			ms.setUserName(userName);
			ms.setPassWord(passWord);
			ms.setMessageType(Message.LOGIN_VALIDATE);
			Message ms2=new InfoManageConnection().loginValidate(ms);
			if(ms2.getMessageType().equals(Message.LOGIN_VALIDATE_SUCCESS)) {
				System.out.println("��¼�ɹ�");
				if(ms2.getUserType().equals("1")) {
					new StudentClient(ms2);
				}else {
					new TeacherClient(ms2);
				}		
				this.dispose();
			}else{
				fal.setVisible(true);
				zhangh.setText("");
				mim.setText("");
			}
			
		}
	}

}

