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
	private JButton btn_start, btn_close;//功能按钮
	private InfomanageServer info;
	public StartServer() {
		 Container c = this.getContentPane();
		 c.setLayout(new FlowLayout());
		 //服务器启动按钮
		btn_start = new JButton("启动服务器");
		btn_start.addActionListener(this);
		c.add(btn_start);
		//服务器关闭按钮
		btn_close = new JButton("关闭服务器");
		btn_close.addActionListener(this);
		c.add(btn_close);
		
		
		this.setResizable(false);//设置页面大小固定
		this.setSize(350, 100);//设置大小
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);//页面可见
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
