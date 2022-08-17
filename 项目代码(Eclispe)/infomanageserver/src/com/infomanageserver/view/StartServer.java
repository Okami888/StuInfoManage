package com.infomanageserver.view;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.infomanageserver.control.InfomanageServer;

public class StartServer extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JButton btn_start, btn_close;//���ܰ�ť
	private InfomanageServer info;
	public StartServer() {
		 Container c = this.getContentPane();
		 c.setLayout(new FlowLayout());
		 //������������ť
		btn_start = new JButton("����������");
		btn_start.addActionListener(this);
		c.add(btn_start);
		//�������رհ�ť
		btn_close = new JButton("�رշ�����");
		btn_close.addActionListener(this);
		c.add(btn_close);
		
		
		this.setResizable(false);//����ҳ���С�̶�
		this.setSize(350, 100);//���ô�С
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);//ҳ��ɼ�
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new StartServer();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 if(e.getSource() == btn_start) {
			 info=new InfomanageServer();
		 }
		 if(e.getSource() == btn_close) {
			 info.close(info.getServerS());
		 }
	}

}
